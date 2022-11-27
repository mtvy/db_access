
import mProcDB, sys

from flask import Flask
from flask import request
app = Flask(__name__)
    
W_CON = {
    'dbname'   : 'items_db', 
    'user'     : 'items_user', 
    'password' : 'items',
    'host'     : 'postgres',
    'port'     : '5433'
}

TB = 'items_tb'

@app.route('/get_db')
def __get_db():
    """
        Example: http://localhost:5000/get_db?tb=items_tb
    """
    data = mProcDB.get_db(request.args.get('tb'), W_CON)
    if data:
        return {'error' : 'false', 'data' : data}
    return {'error' : 'true'}

@app.route('/insert')
def __insert():
    """
        Example: http://localhost:5000/insert?tb=items_tb&url=https://rutubeto.ru&name=shit
    """
    _set = ['url', 'name']
    _vls = [request.args.get('url'), request.args.get('name')]
    data = mProcDB.insert_db(request.args.get('tb'), _set, _vls, W_CON)
    if data:
        return {'error' : 'false', 'data' : data}
    return {'error' : 'true'}

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

@app.route('/create')
def __create():
    data = mProcDB.cr_tables(mProcDB._fprint, request.args.get('ctbs'), W_CON)
    if data:
        return {'error' : 'false', 'data' : data}
    return {'error' : 'true'}
