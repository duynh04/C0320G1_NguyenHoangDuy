create table contacts (
 contact_id int1(11) not null auto_increment primary key,
 last_name varchar(30) not null,
 first_name varchar(25),
 birthday date
 #constraint contacts_pk primary key (contact_id)
);

create table suppliers (
supplier_id int(11) not null auto_increment,
supplier_name varchar(255) not null, 
account_rep varchar(30) not null default 'TDB',
constraint suppliers_pk primary key (supplier_id)
);
alter table contacts
	modify last_name varchar(255),
	add email varchar(40) not null after contact_id,
	add phone varchar(35) null after last_name,
    add address varchar(255) null,
    drop column first_name,
    change column birthday birth_day date not null,
    rename people;
    
drop table contacts;
drop table suppliers;



