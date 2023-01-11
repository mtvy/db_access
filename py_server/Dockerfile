FROM python:latest

WORKDIR /db_access

COPY . .

RUN pip3 install -r configs/requirements.txt
RUN pip3 install -r mProcDB/requirements.txt

CMD ["python3", "server.py", "--host=0.0.0.0:8080", "--db=postgres:5433"]
