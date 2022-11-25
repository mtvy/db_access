
docker: docker-build docker-run

docker-run:
	docker run --name=db_access_cont -dp 5000:5000 db_access

docker-build:
	docker build -t db_access .