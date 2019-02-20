-- Table: EARTH_ON_MARS_DB."USERS"

CREATE TABLE UNITS
(
    id IDENTITY  PRIMARY KEY NOT NULL,
    image_url varchar(1000) NOT NULL,
    title varchar(500) NOT NULL,
    region varchar(250) NOT NULL,
    description text null,
    cancellation_policy text null,
    price integer not null,
    score smallint not null DEFAULT 0
);
