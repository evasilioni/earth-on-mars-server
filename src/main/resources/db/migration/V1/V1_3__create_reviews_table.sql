
CREATE TABLE REVIEWS
(
    id IDENTITY  PRIMARY KEY NOT NULL,
    unit_id INT NOT NULL,
    number_of_star INT NOT NULL,
    comment text null,
    user_id INT NOT NULL,
    created_date DATE DEFAULT GETDATE(),
    FOREIGN KEY (unit_id) REFERENCES units (id)
);
