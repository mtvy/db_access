FROM python:latest

WORKDIR /app

COPY . .

RUN pip3 install -r configs/requirements.txt
RUN pip3 install -r mProcDB/requirements.txt

CMD ["flask", "--app=server.py", "run", "--host=0.0.0.0"]