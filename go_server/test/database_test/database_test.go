package database_test

import (
	"os"
	"sync"
	"testing"

	"go_server/internal/service/database"

	log "github.com/sirupsen/logrus"
	"github.com/stretchr/testify/assert"
)

func TestDatabase(t *testing.T) {

	f, err := os.OpenFile("test.log", os.O_WRONLY|os.O_CREATE, 0755)
	if err != nil {
		log.Fatal(err)
	}
	log.SetOutput(f)

	testCase := []struct {
		tb string

		get_columns   string
		get_condition string
		get_want      []interface{}
		err           error

		insert_columns string
		insert_values  string

		del_condition string
	}{
		{
			tb:  "qrcodes_tb",
			err: nil,

			get_columns:   "*",
			get_condition: "WHERE url='Hello'",
			get_want:      []interface{}{[]interface{}{279, "sanya-privet", nil, nil, nil, nil, nil, nil, nil}},

			insert_columns: "url, name",
			insert_values:  "'Hello', 'World'",

			del_condition: "WHERE url='Hello'",
		},
		{
			tb: "qrcodes_tb",

			get_columns:   "*",
			get_condition: "",
			err:           nil,

			insert_columns: "url, name",
			insert_values:  "'Hello', 'World'",
		},
	}
	// "postgres://username:password@localhost:5432/database_name"
	db := database.Database{Host: "postgres://postgres:postgres@0.0.0.0:5432/postgres"}

	for ind, tc := range testCase {
		log.WithFields(log.Fields{
			"caseIndex": ind + 1,
		}).Warn("[START]")

		t.Run("GET", func(t *testing.T) {

			get, err := db.Get("*", tc.tb, "")

			log.WithFields(log.Fields{
				"len": len(get),
				"err": err,
			}).Warn("[GET Return Value]")

			assert.Equal(t, tc.err, err)

		})

		t.Run("INSERT", func(t *testing.T) {
			insert, err := db.Insert(tc.tb, tc.insert_columns, tc.insert_values)

			log.WithFields(log.Fields{
				"got": insert,
				"err": err,
			}).Warn("[INSERT Return Value]")

			assert.Equal(t, tc.err, err)
		})
		t.Run("GET", func(t *testing.T) {

			get, err := db.Get(tc.get_columns, tc.tb, tc.get_condition)

			log.WithFields(log.Fields{
				"len": len(get),
				"err": err,
			}).Warn("[GET Return Value]")

			//if tc.get_want != nil {
			//	assert.Equal(t, len(tc.get_want), len(get))
			//}
			assert.Equal(t, tc.err, err)

		})

		t.Run("DELETE", func(t *testing.T) {
			delete, err := db.Delete(tc.tb, tc.del_condition)

			log.WithFields(log.Fields{
				"len": delete,
				"err": err,
			}).Warn("[DELETE Return Value]")

			assert.Equal(t, tc.err, err)
		})

		t.Run("GET", func(t *testing.T) {

			get, err := db.Get("*", tc.tb, "")

			log.WithFields(log.Fields{
				"len": len(get),
				"err": err,
			}).Warn("[GET Return Value]")

			assert.Equal(t, tc.err, err)

		})

		log.Info("[DONE]")
	}
	var wg sync.WaitGroup
	t.Run("GOROUTINS", func(t *testing.T) {
		for i := 0; i < 1000; i++ {
			wg.Add(1)
			go func(wg *sync.WaitGroup, i int) {
				defer wg.Done()
				go db.Insert("qrcodes_tb", "url, name", "'Hello', 'World'")
				go db.Get("*", "qrcodes_tb", "")
				go db.Delete("qrcodes_tb", "WHERE url='Hello'")
				log.WithFields(log.Fields{
					"i": i + 1,
				}).Info("[INSERT GET DELETE]")
			}(&wg, i)
		}
		wg.Wait()

		get, _ := db.Get("*", "qrcodes_tb", "")
		log.WithFields(log.Fields{
			"get": len(get),
		}).Info("[DONE]")
	})
}
