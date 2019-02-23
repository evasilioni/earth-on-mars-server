BEGIN;

INSERT INTO USERS (user_name, PASSWORD, first_name, last_name)
VALUES ('admin', '$2a$10$LN6OSa7ROaGKJtJS0cOBIucQgNEVm8uRmwDchM2N9C1RwWMAcbgbm', 'admin', 'admin');
INSERT INTO USERS (user_name, PASSWORD, first_name, last_name)
VALUES ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user');
INSERT INTO USERS (user_name, PASSWORD, first_name, last_name)
VALUES ('disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user');

--insert into USERS (user_name, first_name, last_name, password) values ('esilioni', 'Evi', 'Silioni',
--'$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi');
--insert into USERS (user_name, first_name, last_name, password) values ('admin', 'Admin', 'NumberOne', 'P@ssword1');
--insert into USERS (user_name, first_name, last_name, password) values ('user2', 'User2', 'NumberTwo', 'P@ssword2');
--insert into USERS (user_name, first_name, last_name, password) values ('user3', 'User3', 'NumberThree', 'P@ssword3');
--insert into USERS (user_name, first_name, last_name, password) values ('user4', 'User4', 'NumberFour', 'P@ssword4');
--insert into USERS (user_name, first_name, last_name, password) values ('user5', 'User5', 'NumberFive', 'P@ssword5');
--insert into USERS (user_name, first_name, last_name, password) values ('user6', 'User6', 'NumberSix', 'P@ssword6');
--insert into USERS (user_name, first_name, last_name, password) values ('user7', 'User7', 'NumberSev', 'P@ssword7');

--INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE)
--VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));
--INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE)
--VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
--INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE)
--VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));


insert into USER_ROLES (user_id, user_role) values (1, 'ROLE_ADMIN');
insert into USER_ROLES (user_id, user_role) values (1, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (2, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (3, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (4, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (5, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (6, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (7, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (8, 'ROLE_USER');
--insert into USER_ROLES (user_id, user_role) values (8, 'ROLE_ADMIN');
COMMIT;