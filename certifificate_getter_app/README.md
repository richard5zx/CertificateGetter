# CertificateGetter


Postgres username: postgres
Postgres password: 111

How to setup
    -Install Driver


Create user table manually

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username text UNIQUE NOT NULL,
	password text NOT NULL,
    date_created date DEFAULT CURRENT_DATE
); 