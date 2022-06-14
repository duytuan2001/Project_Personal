drop database sprint_3;
create database sprint_3;
use sprint_3;

create table `account` (
account_id int primary key auto_increment,
email varchar(255),
`password` varchar(255)
);

create table `role` (
role_id int primary key auto_increment,
`role` varchar(255)
);

create table account_user (
account_id int,
role_id int,
foreign key (account_id) references `account` (account_id),
foreign key (role_id) references `role` (role_id)
);

create table customer (
customer_id int primary key auto_increment,
`name` varchar(255),
phone varchar(255),
email varchar(255),
address varchar(255),
`password` varchar(255),
account_id int,
foreign key (account_id) references `account` (account_id)
);


create table category (
category_id int primary key auto_increment,
category_name varchar(255)
);

create table book (
book_id int primary key auto_increment,
`code` varchar(255),
`date` DATE,
`page` int,
price double,
producer varchar(255),
promotion int,
quality int,
rest int,
size varchar(255),
translator varchar(255),
writer varchar(255),
category_id int,
foreign key (category_id) references `category` (category_id)
);

create table oder_book (
customer_id int,
book_id int,
number_of_book int,
total_price_book int,
date_book date,
foreign key (book_id) references `book` (book_id),
foreign key (customer_id) references `customer` (customer_id)
);

-- insert into account_user (account_id, role_id) value (1,1),(1,2),(2,2);
