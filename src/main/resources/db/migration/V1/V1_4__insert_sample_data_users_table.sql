BEGIN;

insert into USERS (user_name, first_name, last_name, password) values ('esilioni', 'Evi', 'Silioni',
'P@ssword');
insert into USERS (user_name, first_name, last_name, password) values ('user2', 'User2', 'NumberTwo', 'P@ssword2');
insert into USERS (user_name, first_name, last_name, password) values ('user3', 'User3', 'NumberThree', 'P@ssword3');
insert into USERS (user_name, first_name, last_name, password) values ('user4', 'User4', 'NumberFour', 'P@ssword4');
insert into USERS (user_name, first_name, last_name, password) values ('user5', 'User5', 'NumberFive', 'P@ssword5');
insert into USERS (user_name, first_name, last_name, password) values ('user6', 'User6', 'NumberSix', 'P@ssword6');
insert into USERS (user_name, first_name, last_name, password) values ('user7', 'User7', 'NumberSev', 'P@ssword7');
insert into USERS (user_name, first_name, last_name, password) values ('admin', 'Admin', 'NumberOne', 'P@ssword1');

insert into USER_ROLES (user_id, user_role) values (1, 'ROLE_ADMIN');
insert into USER_ROLES (user_id, user_role) values (1, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (2, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (3, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (4, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (5, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (6, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (7, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (8, 'ROLE_USER');
insert into USER_ROLES (user_id, user_role) values (8, 'ROLE_ADMIN');
COMMIT;