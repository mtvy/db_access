
proto:
	source ~/.bash_profile
	protoc -I ./api/proto --go_out=. --go-grpc_out=. ./api/proto/database.proto

cover:
	go test -short -count=1 -race -coverprofile=coverage.out ./test/utils_test/
	go tool cover -html=coverage.out
	rm coverage.out

database_test:
	go test -run= ./test/database_test

utils_test:
	go test -run= ./test/utils_test

git:
	git add .
	git commit -m "$(COMMIT)"
	git push


bench_db_conn:
	GOGC=off go test -bench=BechmarkConnections ./test/database_test -cpuprofile db_conn_cpu.out
	go tool pprof --edgefraction=0 --nodefraction=0 --nodecount=100000 database_test.test db_conn_cpu.out
	rm database_test.test db_conn_cpu.out


