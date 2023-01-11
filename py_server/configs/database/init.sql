
CREATE extension IF NOT EXISTS pg_stat_statements;

CREATE TABLE IF NOT EXISTS qrcodes_tb (
  id      serial primary key,
  url     VARCHAR(64),
  code_id VARCHAR(64),
  folder  VARCHAR(64),
  name    VARCHAR(32),
  path    VARCHAR(64), 
  initer  VARCHAR(64),
  img_b   VARCHAR(64),
  test    VARCHAR(64)
);

INSERT INTO qrcodes_tb (url) 
VALUES ('sanya-privet');