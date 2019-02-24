BEGIN;

insert into REVIEWS (unit_id, user_id, number_of_star, comment)
values (12, 1, 3, 'great opportunity and experience');

--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 2, 'good opportunity and experience', 2);
--
--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 2, 'good opportunity and experience', 8);
--
--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 4, 'fantastic opportunity and experience', 3);
--
--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 1, 'ok opportunity and experience', 4);
--
--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 3, 'great opportunity and experience', 5);
--
--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 3, 'great opportunity and experience', 6);
--
--insert into REVIEWS (unit_id, number_of_star, comment, user_id)
--values (12, 3, 'great opportunity and experience', 7);
--
--update UNITS set score = 2 where id = 12;
update UNITS set score = 1 where id = 12;

COMMIT;