ALTER table consumer
    add column consumer_surname varchar(50) NOT NULL,
    add column consumer_patronymic varchar(50),
    add column date_of_birth varchar(50) NOT NULL,
    add column job varchar(50),
    add column nationality varchar(50) NOT NULL,
    add column phonenumber varchar(50) NOT NULL,
    add column email varchar(50),
    add UNIQUE (phonenumber);
insert into owner (owner_name, money)
values ('Vadim',1),
       ('Dominikano',12),
       ('Mariko',1111),
       ('Rasim',10000);
insert into car_saloon (saloon_name, owner)
values ('Lamborgini',1),
       ('Ferrari',3),
       ('Lada',2),
       ('BMW',4),
       ('Toyota',2);
