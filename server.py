
import mProcDB, sys

from flask import Flask
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
    data = mProcDB.get_db(TB, W_CON)
    if data:
        return {'error' : 'false', 'data' : data}

    return {'error' : 'true'}

@app.route('/insert')
def __insert():
    data = mProcDB.insert_db(TB, ['name'], ['shoe'], W_CON)
    if data:
        return {'error' : 'false', 'data' : data}

    return {'error' : 'true'}