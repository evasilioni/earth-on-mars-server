-- Table: EARTH_ON_MARS_DB."USERS"

CREATE TABLE USERS
(
    id IDENTITY  PRIMARY KEY NOT NULL,
    user_name varchar(250) NOT NULL,
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL,
    password varchar(250) NOT NULL
);

CREATE UNIQUE INDEX user_name_idx ON USERS (user_name);