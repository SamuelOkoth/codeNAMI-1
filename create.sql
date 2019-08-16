CREATE DATABASE codenami;
\c codenami;

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR,
    email VARCHAR,
    password VARCHAR,
    bio VARCHAR,
    profilePic VARCHAR
);

CREATE TABLE challenges(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    code VARCHAR,
    details VARCHAR,
    userId INTEGER,
    vote int
);

CREATE TABLE contributions(
    id SERIAL PRIMARY KEY,
    code VARCHAR,
    description VARCHAR,
    challengeId INTEGER,
    vote int
);

CREATE DATABASE codenami_test WITH TEMPLATE codenami;