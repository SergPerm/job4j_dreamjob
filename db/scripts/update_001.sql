CREATE TABLE IF NOT EXISTS posts (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS candidates (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name varchar,
    email varchar UNIQUE,
    password varchar
);

ALTER TABLE users ADD CONSTRAINT email_unique UNIQUE (email);
