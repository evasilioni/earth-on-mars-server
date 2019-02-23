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

CREATE TABLE USER_ROLES
(
    user_id INT NOT NULL,
    user_role varchar(255) NOT NULL
);
CREATE UNIQUE INDEX user_role_idx ON USER_ROLES (user_id, user_role);

