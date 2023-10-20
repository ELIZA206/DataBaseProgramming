insert into users (user_id, username, email, age, experience, password)
values (1,'Andrey','Andrey@mail.ru',18,2,'123'),
       (2,'Dima','Dima@mail.ru',19,0,'345'),
       (3,'Danil','Danil@mail.ru',30,3,'567'),
       (4,'Airat','Airat@mail.ru',20,1,'789'),
       (5,'Liza','Liza@mail.ru',35,5,'123');
insert into programs(program_name, program_date, description)
values ('C++',DATE '2023-12-18','program of C++'),
       ('Art',DATE '2023-05-18','program of Art'),
       ('PostgreSQL',DATE '2023-07-18','program of PostgreSQL');

insert into categories(category_id, category_name)
values (1,'information technology'),
       (2,'media');
insert into users_programs(program, userk)
values (1,5),
       (2,4),
       (3,3),
       (1,2),
       (2,1);
insert into programs_categories(category, programs)
values (1,1),
       (2,2),
       (1,3);


select from users where >=20;