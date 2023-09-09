DROP TABLE IF EXISTS urls;

CREATE TABLE urls (
    id INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);