create table car (
    car_id serial primary key,
    car_name varchar(20),
    release integer,
    horsepower integer,
    price integer
);
create table owner (
    owner_id serial primary key,
    owner_name varchar(20),
    money integer
);
create table car_saloon (
    saloon_id serial primary key,
    saloon_name varchar(20),
    owner integer references owner(owner_id)
);


create table producer (
    producer_id serial primary key,
    producer_name varchar(20),
    car integer references car(car_id),
    car_price_prod integer
);

create table consumer (
    consumer_id serial primary key,
    consumer_name varchar(20),
    money integer,
    car_saloon integer references car_saloon(saloon_id)
);
create table saloon_car_producer (
    producer integer references producer(producer_id) ,
    car_saloon integer references car_saloon(saloon_id)
)