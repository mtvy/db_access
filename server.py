
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
def hello_world():
    print(W_CON, file=sys.stderr)
    data = mProcDB.get_db(TB, W_CON)
    if data:
        return {'error' : 'false', 'data' : data}

    return {'error' : 'true'}