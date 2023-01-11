
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

