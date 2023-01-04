
CREATE extension IF NOT EXISTS pg_stat_statements;

CREATE TABLE IF NOT EXISTS items_tb (
  id      serial primary key,
  url     VARCHAR(64),
  name    VARCHAR(32)
);
