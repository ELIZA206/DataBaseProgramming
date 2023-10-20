create table users (
  user_id serial primary key,
  username varchar(50),
  email varchar(50) UNIQUE,
  age integer,
  experience integer,
  password varchar(50) NOT NULL
);
create table programs (
    programs_id serial primary key,
    program_name varchar(50) NOT NULL,
    program_date date,
    description varchar(50)

);
create table users_programs (
    program integer references programs(programs_id),
    userk integer references users(user_id)
);

create table categories (
    category_id serial primary key,
    category_name varchar(50) not null
);

create table programs_categories(
    category integer references categories(category_id),
    programs integer references programs(programs_id)
)