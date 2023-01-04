# db_access

## Java Client 
- Build
  - build and run maven package
- Import
  ```java
  import java_client.src.main.java.database_client.Client
  ```

## Python Server
### Terminal
- build proto
  ```bash
  pip3 install -r configs/requirements.txt
  pip3 install -r mProcDB/requirements.txt
  cd python_server
  python3 -m grpc_tools.protoc -I ./proto/ --python_out=./api --pyi_out=./api --grpc_python_out=./api ./proto/database.proto
  ```
- run
  ```bash
  python3 server.py
  ```
