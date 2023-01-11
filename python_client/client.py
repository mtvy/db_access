
import grpc, sys

import api.grpc as api


TB = 'qrcodes_tb'
DB_HOST = 'postgres://postgres:postgres@postgres:5433/postgres'



def run(host):

    conn = grpc.insecure_channel(host)
    
    stub = api.DatabaseStub(conn)

    req = api.InsertDbRequest(table=TB, columns="url, name", values="'Hello', 'World'", db_host=DB_HOST)
    res = stub.InsertDb(req)

    print(res)
        
    req = api.GetDbRequest(columns="*", table=TB, condition="WHERE url='Hello'", db_host=DB_HOST)
    res = stub.GetDb(req)

    print(res)

    req = api.DeleteDbRequest(table=TB, condition="WHERE url='Hello'", db_host=DB_HOST)
    res = stub.DeleteDb(req)

    print(res)

    #conn.close()


if __name__ == "__main__":
    host = sys.argv[1].split('=')[1] # localhost:808...
    print(host)
    run(host)