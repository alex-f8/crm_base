create table users(
id serial primary key,
full_name varchar(80),
email varchar(80) not null unique,
password varchar(40)
);

create table if not exists clients(
id serial primary key,
name varchar(30) not null,
surname varchar(30) not null,
birth_date date,
gender char(1),
email varchar(30),
phone varchar(20) not null
);