BEGIN;

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150/dog', 'DogTitle', 'DogRegion', 'Dogs (Canis lupus familiaris) are domesticated mammals, not natural wild animals. They were originally bred from wolves. They have been bred by humans for a long time, and were the first animals ever to be domesticated.', 'Doggy Cancellation Policy', 15000, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/paris', 'ParisTitle', 'Paris', 'For centuries Paris has been one of the world’s most important and attractive cities.', 'Paris Cancellation Policy', 35000, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/brazil,rio','Brazil Mission', 'Rio', 'Rio de Janeiro or simply Rio, is the second-most populous municipality in Brazil and the sixth-most populous in the Americas', 'Rio Cancellation Policy', 85421, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/brazil,rio','Brazil Mission', 'Brasilia', 'Brasilia is the capital of Brazil, with a population of 2,282,049 inhabitants. Located in the Federal District, the city is famous for its modern and bold architecture and the rapid growth of its population', 'Brasilia Cancellation Policy', 74512, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/brazil,rio','Brazil Mission', 'Sao Paolo', 'Sao Paulo, more accurately Sao Paulo, is the capital of Sao Paulo state in southeastern Brazil. ', 'Sao Paolo Cancellation Policy', 54123, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/mars', 'Title Of Mars', 'Mars Region', 'A human mission to Mars has been the subject of science fiction, aerospace engineering, and scientific proposals since the 19th century.','Mars Cancellation Policy', 451271, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/mars', 'Mission Possible', 'Mars Region', 'A human mission to Mars has been the subject of science fiction, aerospace engineering, and scientific proposals since the 19th century.','Mars Cancellation Policy', 71584, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/g/150/150/mars', 'Great Expectation', 'Mars Region', 'A human mission to Mars has been the subject of science fiction, aerospace engineering, and scientific proposals since the 19th century.','Mars Cancellation Policy', 54215, 0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150?random=1', 'Random Title 1', 'Random Region 1', 'Random Description 1',
'Random Canc Policy 1', 12400,0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150?random=2', 'Random Title 2', 'Random Region 2', 'Random Description 2',
'Random Canc Policy 2', 22400,0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150?random=3', 'Random Title 3', 'Random Region 3', 'Random Description 3',
'Random Canc Policy 3', 32400,0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150?random=4', 'Random Title 4', 'Random Region 4', 'Random Description 4',
'Random Canc Policy 4', 34400,0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150?random=4', 'Random Title 4', 'Random Region 4', 'Random Description New one for Number 4',
'Random Canc Policy New one for Number 4', 84215,0);

insert into UNITS (image_url, title ,region ,description ,cancellation_policy ,price ,score)
values ('https://loremflickr.com/150/150?random=4', 'Random Title 4', 'Random Region 4', 'Random Description Cheaper for Number 4',
'Random Canc Policy Cheaper for Number 4', 12574,0);

COMMIT;