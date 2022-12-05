
import mProcDB
    
W_CON = {
    'dbname'   : 'postgres', 
    'user'     : 'postgres', 
    'password' : 'postgres',
    'host'     : 'localhost',
    'port'     : '5432'
}

from concurrent import futures

import grpc, api
import mProcDB

'''
@app.route('/delete')
def __delete():
    """
        cnd -> delete condition.
        Example: http://localhost:5000/delete?tb=items_tb&cnd=name=%27shoe%27
    """
    data = mProcDB.delete_db(request.args.get('cnd'), request.args.get('tb'), W_CON)
    if data:
        return {'error' : 'false', 'data' : data}
    return {'error' : 'true'}
'''
class DatabaseServicer(api.DatabaseServicer):
    def GetDb(self, request, _):
        print(f"[REQUEST][GETDB]\n│--> {request}│")
        data = mProcDB.get_db(request.tb, W_CON)
        data, status = (str([it for it in data[0]]), 200) if data else ("[]", 500)    
        return api.GetDbResponse(data=data, status=status)

    def InsertDb(self, request, _):
        print(f"[REQUEST][INSERTDB]\n│--> {request}│")
        _set = request.colums; _vls = request.values
        status = 200 if mProcDB.insert_db(request.tb, _set, _vls, W_CON) else 500
        return api.InsertDbResponse(status=status)

    def DeleteDb(self, request, _):
        print(f"[REQUEST][DELETEDB]\n│--> {request}│")
        status = 200 if mProcDB.delete_db(request.where, request.tb, W_CON) else 500
        return api.DeleteDbResponse(status=status)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    api.add_DatabaseServicer_to_server(DatabaseServicer(), server)
    server.add_insecure_port("localhost:8081")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    serve()