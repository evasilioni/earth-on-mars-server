-- Table: EARTH_ON_MARS_DB."USERS"

CREATE TABLE REVIEWS
(
    id IDENTITY  primary key not null,
    unit_id integer NOT NULL,
    number_of_star integer NOT NULL,
    comment text null,
    user_name varchar(250) NOT NULL,
    created_date date not null default now(),
    FOREIGN KEY (unit_id) REFERENCES units (id)
);
