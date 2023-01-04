# Python Server for database accessing

## Docker Build
* Open database at docker postgres:5433
* 
  ```bash
  docker-compose up -d --build
  ```

## Terminal Build
* Use  `--db=<host>`  param to set postgres host
* Use  `--host=<host>`  param to set server host
* 
  ```bash
  python3 server.py --host=0.0.0.0:8080 --db=0.0.0.0:5432
  ```
## Server Request Example
<img width="200" src="https://user-images.githubusercontent.com/44533918/210666513-652a70fa-b9e4-4ef6-a9a5-71e8416cbaad.png">
