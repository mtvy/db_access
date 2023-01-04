
import grpc, sys

import api


TB = 'qrcodes_tb'

def run():
    host = sys.argv[1].split('=')[1] # localhost:808...

    with grpc.insecure_channel(host) as conn:
        stub = api.DatabaseStub(conn)
        
        req = api.GetDbRequest(tb=TB)
        res = stub.GetDb(req)

        print(res)

        req = api.InsertDbRequest(tb=TB, colums=['url', 'initer'], values=['hello.ru', 'me'])
        res = stub.InsertDb(req)

        print(res)

        req = api.DeleteDbRequest(tb=TB, where="url='hello.ru'")
        res = stub.DeleteDb(req)

        print(res)


if __name__ == "__main__":
    run()