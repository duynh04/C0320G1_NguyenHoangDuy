create table customers (
customer_id int(11) not null auto_increment primary key,
full_name varchar(255) not null,
address varchar(255) not null,
email varchar(255) unique not null,
phone varchar(10) null
);


create table accounts (
account_id int(11) not null auto_increment primary key,
customer_number int(11) not null unique,
account_type enum('vip', 'normal', 'bussiness'),
date_open date,
balance int(20),
foreign key(customer_number) references customers(customer_id)
);


create table transitions (
transition_id int(11) not null auto_increment primary key,
account_number int(11) not null,
transition_date date,
amount int(20),
descriptions varchar(255) not null,
foreign key(account_number) references accounts(account_id)
);
