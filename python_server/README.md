# Python Server for database accessing

## Docker Build
* Opening database at docker postgres:5433
* 
  ```bash
  docker-compose up -d --build
  ```

## Terminal Build
* Use  `--db=<host>`  param to set postgres host
* Use  `--host=<host>`  param to set server host 
- ### Proto Build and main setup
    ```bash
    pip3 install -r configs/requirements.txt
    pip3 install -r mProcDB/requirements.txt
    cd python_server
    python3 -m grpc_tools.protoc -I ./proto/ --python_out=./api --pyi_out=./api --grpc_python_out=./api ./proto/database.proto
    ```
- ### Run Server
    ```bash
    pip3 install -r configs/requirements.txt
    pip3 install -r mProcDB/requirements.txt
    cd python_server
    python3 -m grpc_tools.protoc -I ./proto/ --python_out=./api --pyi_out=./api --grpc_python_out=./api ./proto/database.proto
    python3 server.py --host=0.0.0.0:8080 --db=0.0.0.0:5432
    ```
## Server Get Request Example
 ```bash
Server started!
[REQUEST][GETDB]
│--> tb: "qrcodes_tb"
│
[REQUEST][INSERTDB]
│--> tb: "qrcodes_tb"
     colums: "url"
     colums: "initer"
     values: "hello.ru"
     values: "me"
│
[REQUEST][DELETEDB]
│--> tb: "qrcodes_tb"
     where: "url=\'hello.ru\'"
│
```
