
import mProcDB, os

from decouple import config
from flask import Flask
app = Flask(__name__)
    

@app.route('/get_db')
def hello_world():

    denv = mProcDB.get_env()
    return mProcDB.get_db(config('MDB_W_TBS'), denv['_w_con'])