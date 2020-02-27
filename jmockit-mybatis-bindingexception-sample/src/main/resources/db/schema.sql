CREATE TABLE users (
  id int primary key auto_increment,
  first_name varchar(20) not null,
  last_name varchar(20) not null,
  address varchar(60) not null
);