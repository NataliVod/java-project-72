DROP TABLE IF EXISTS urls;

CREATE TABLE urls (
    id  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_url PRIMARY KEY (id)
);