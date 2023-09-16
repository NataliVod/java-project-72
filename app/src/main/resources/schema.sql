DROP TABLE IF EXISTS urls;

CREATE TABLE urls (
    id                         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name                       VARCHAR(255) NOT NULL,
    created_at                 TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS urls_checks;

CREATE TABLE url_checks (
  id                            BIGINT PRIMARY KEY AUTO_INCREMENT,
  status_code                   INTEGER NOT NULL,
  title                         VARCHAR(255),
  h1                            VARCHAR(255),
  description                   TEXT,
  url_id                        BIGINT REFERENCES urls (id),
  created_at                    TIMESTAMP NOT NULL
);