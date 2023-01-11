
import mProcDB
    


from concurrent import futures

import grpc, api, sys
import mProcDB

'''
@app.route('/delete')
def __delete():
    """
        cnd -> delete condition.
        Example: http://localhost:5000/delete?tb=items_tb&cnd=name=%27shoe%27
    """
    data = mProcDB.delete_db(request.args.get('cnd'), request.args.get('tb'), w_con)
    if data:
        return {'error' : 'false', 'data' : data}
    return {'error' : 'true'}
'''
class DatabaseServicer(api.DatabaseServicer):
    def __init__(self, con) -> None:
        super().__init__()
        self.con = con
        print(self.con)

    def GetDb(self, request, _):
        print(f"[REQUEST][GETDB]\n│--> {request}│")
        data = mProcDB.get_db(request.tb, self.con)
        data, status = (str([it for it in data[0]]), 200) if data else ("[]", 500)    
        return api.GetDbResponse(data=data, status=status)

    def InsertDb(self, request, _):
        print(f"[REQUEST][INSERTDB]\n│--> {request}│")
        _set = request.colums; _vls = request.values
        status = 200 if mProcDB.insert_db(request.tb, _set, _vls, self.con) else 500
        return api.InsertDbResponse(status=status)

    def DeleteDb(self, request, _):
        print(f"[REQUEST][DELETEDB]\n│--> {request}│")
        status = 200 if mProcDB.delete_db(request.where, request.tb, self.con) else 500
        return api.DeleteDbResponse(status=status)


def serve():
    host = sys.argv[1].split('=')[1] # localhost:808...
    db_host, db_port = sys.argv[2].split('=')[1].split(':')

    print(host, db_port)
    w_con = {
        'dbname'   : 'postgres', 
        'user'     : 'postgres', 
        'password' : 'postgres',
        'host'     : db_host,
        'port'     : db_port
    }

    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    api.add_DatabaseServicer_to_server(DatabaseServicer(w_con), server)
    server.add_insecure_port(host)
    server.start()
    print("Server started!")
    server.wait_for_termination()

if __name__ == "__main__":
    serve()