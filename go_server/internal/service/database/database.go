package database

import (
	"context"
	"sync"

	"github.com/jackc/pgx/v4"
	"github.com/jackc/pgx/v4/pgxpool"
	log "github.com/sirupsen/logrus"
)

const (
	INSERT = "INSERT INTO qrcodes_tb (url, code_id, folder, name, path, initer, img_b) VALUES($1, $2, $3, $4, $5, $6, $7)"
	DELETE = "DELETE FROM qrcodes_tb WHERE initer=$1"
	GET    = "SELECT * FROM qrcodes_tb"
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
	Host   string
	pool   *pgxpool.Pool
	rows   pgx.Rows
	data   []interface{}
	locker sync.RWMutex
	stat   error
}

func (db *Database) createConn() error {
	//dbUrl := os.Getenv("DB_URL")
	db.pool, db.stat = pgxpool.Connect(context.Background(), db.Host)
	if db.stat != nil {
		log.WithFields(log.Fields{
			"Host": db.Host,
			"stat": db.stat,
			"rows": db.rows,
			"data": db.data,
		}).Error("Connection error.")
		return db.stat
	}

	return nil
}

func (db *Database) sendReq(msg string, args ...any) ([]interface{}, error) {

	db.locker.RLock()
	defer db.locker.RUnlock()

	if db.createConn() != nil {
		log.WithFields(log.Fields{
			"Host": db.Host,
			"stat": db.stat,
			"data": db.data,
			"args": args,
			"msg":  msg,
		}).Error("Fail while was getting connection.")
		return nil, db.stat
	}

	db.rows, db.stat = db.pool.Query(context.Background(), msg, args...)
	if db.stat != nil {
		log.WithFields(log.Fields{
			"stat": db.stat,
			"data": db.data,
			"args": args,
			"msg":  msg,
		}).Error("Rows get error.")
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
		//"Host":      db.Host,
		//"columns":   columns,
		//"table":     table,
		//"condition": condition,
		"insert": insert,
	}).Infoln("[New Request]")

	return db.sendReq(insert)
}

func (db *Database) Delete(table string, condition string) ([]interface{}, error) {

	delete := "DELETE FROM " + table + " " + condition

	log.WithFields(log.Fields{
		//"Host":      db.Host,
		//"table":     table,
		//"condition": condition,
		"delete": delete,
	}).Infoln("[New Request]")

	return db.sendReq(delete)
}

func (db *Database) Get(columns string, table string, condition string) ([]interface{}, error) {

	get := "SELECT " + columns + " FROM " + table + " " + condition

	log.WithFields(log.Fields{
		//"Host":      db.Host,
		//"columns":   columns,
		//"table":     table,
		//"condition": condition,
		"get": get,
	}).Infoln("[New Request]")

	return db.sendReq(get)
}
