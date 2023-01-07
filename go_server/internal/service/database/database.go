package database

import (
	"context"
	"errors"
	"sync"

	"github.com/jackc/pgx/v4"
	"github.com/jackc/pgx/v4/pgxpool"
	log "github.com/sirupsen/logrus"
)

type ProcDb interface {
	Insert(args ...any) ([]interface{}, error)
	Delete(args ...any) ([]interface{}, error)
	Get(args ...any) ([]interface{}, error)
}

type Databaser interface {
	createConn() error
	sendReq(msg string, args ...any) ([]interface{}, error)
}

type Database struct {
	Host string

	sync.RWMutex
	pool *pgxpool.Pool
	rows pgx.Rows
	data []interface{}
	stat error
}

var ErrToManyClients = errors.New("FATAL: sorry, too many clients already (SQLSTATE 53300)")

func (db *Database) createConn() error {
	db.pool, db.stat = pgxpool.Connect(context.Background(), db.Host)
	if db.stat != nil {
		if errors.Unwrap(db.stat).Error() == ErrToManyClients.Error() {
			log.Warn("Too many connections!")
			return db.stat
		}

		log.WithFields(log.Fields{
			"Host": db.Host,
			"stat": db.stat,
			"rows": db.rows,
			"data": db.data,
		}).Fatal("Connection error.")
		return db.stat
	}

	return nil
}

func (db *Database) sendReq(msg string, args ...any) ([]interface{}, error) {

	db.Lock()
	defer db.Unlock()
	log.Info("[LOCKED]")

	if db.createConn() != nil {
		if errors.Unwrap(db.stat).Error() == ErrToManyClients.Error() {
			log.Warn("Too many connections!")
			return nil, db.stat
		}

		log.WithFields(log.Fields{
			"Host": db.Host,
			"stat": db.stat,
			"data": db.data,
			"args": args,
			"msg":  msg,
		}).Fatal("Fail while was getting connection.")
		return nil, db.stat
	}

	defer db.pool.Close()

	db.rows, db.stat = db.pool.Query(context.Background(), msg, args...)
	if db.stat != nil {
		if errors.Unwrap(db.stat).Error() == ErrToManyClients.Error() {
			log.Warn("Too many connections!")
			return nil, db.stat
		}

		log.WithFields(log.Fields{
			"stat": db.stat,
			"data": db.data,
			"args": args,
			"msg":  msg,
		}).Fatal("Rows get error.")
		return nil, db.stat
	}
	var data []interface{}
	db.data = nil
	for db.rows.Next() {
		data, db.stat = db.rows.Values()
		db.data = append(db.data, data)
	}

	return db.data, db.stat
}

func (db *Database) Insert(table string, columns string, values string) ([]interface{}, error) {
	insert := "INSERT INTO " + table + " (" + columns + ") VALUES ( " + values + ")"

	log.WithFields(log.Fields{
		"insert": insert,
	}).Infoln("[New Request]")

	return db.sendReq(insert)
}

func (db *Database) Delete(table string, condition string) ([]interface{}, error) {

	delete := "DELETE FROM " + table + " " + condition

	log.WithFields(log.Fields{
		"delete": delete,
	}).Infoln("[New Request]")

	return db.sendReq(delete)
}

func (db *Database) Get(columns string, table string, condition string) ([]interface{}, error) {

	get := "SELECT " + columns + " FROM " + table + " " + condition

	log.WithFields(log.Fields{
		"get": get,
	}).Infoln("[New Request]")

	return db.sendReq(get)
}
