drop database if exists furama;
create database furama;
use furama;

create table positions (
position_id int auto_increment primary key,
position_name enum('Lễ Tân', 'Phục Vụ', 'Chuyên Viên', 'Giám Sát', 'Quản Lý', 'Giám Đốc')
);
insert into positions values (1, 'Lễ Tân'), (2, 'Phục Vụ'), (3, 'Chuyên Viên'), (4, 'Giám Sát'), (5, 'Quản Lý'), (6, 'Giám Đốc');
create table eduBackgrounds (
edu_bg_id int auto_increment primary key,
edu_degree enum('Trung Cấp', 'Đại Học', 'Cao Đẳng', 'Sau Đại Học')
);
insert into eduBackgrounds values (1, 'Trung Cấp'), (2, 'Cao Đẳng'), (3, 'Đại Học'), (4, 'Sau Đại Học');
create table divisions (
division_id int auto_increment primary key,
division_name enum('Sale-marketing', 'Hành Chính', 'Phục vụ', 'Quản Lý')
);
insert into divisions values (1, 'Sale-marketing'), (2, 'Hành Chính'), (3, 'Phục vụ'), (4, 'Quản Lý');

create table employees (
employee_id int auto_increment primary key,
employee_name nvarchar(45) not null,
employee_birthday date not null,
employee_idcard nvarchar(45) not null,
employee_salary nvarchar(45) not null,
employee_phone nvarchar(45) not null,
employee_email nvarchar(45),
employee_address nvarchar(45),
position_id int not null,
edu_bg_id int not null,
division_id int not null,
foreign key (position_id) references positions(position_id),
foreign key (edu_bg_id) references eduBackgrounds(edu_bg_id),
foreign key (division_id) references divisions(division_id)
);

insert into employees values (1, 'Margalo', '1982-08-29', '337-201-659', '2500', '8216852520', 'Margalo@yahoo.com', 'Quảng Trị', 5, 1, 2);
insert into employees values (2, 'Wells', '1990-06-07', '776-176-401', '1200', '2163152417', 'Wells@yahoo.com', 'Quảng Trị', 1, 1, 3);
insert into employees values (3, 'Libbie', '1984-09-25', '075-092-098', '1200', '2983300613', 'Libbie@facebook.com', 'Huế', 5, 3, 4);
insert into employees values (4, 'Merla', '1979-04-26', '267-895-910', '1200', '4680526140', 'Merla@yahoo.com', 'Quảng Bình', 3, 3, 4);
insert into employees values (5, 'Everard', '1980-05-30', '509-784-356', '1200', '1049308370', 'Everard@facebook.com', 'Quảng Nam', 5, 3, 3);
insert into employees values (6, 'Barbette', '1972-03-10', '785-906-613', '400', '9143938663', 'Barbette@gmail.com', 'Sài Gòn', 5, 3, 4);
insert into employees values (7, 'Tori', '1991-06-09', '578-152-094', '1200', '2682913418', 'Tori@gmail.com', 'Sài Gòn', 2, 1, 2);
insert into employees values (8, 'Angie', '1982-11-10', '309-677-185', '2000', '3574363341', 'Angie@facebook.com', 'Quảng Nam', 2, 1, 3);
insert into employees values (9, 'Almire', '1987-01-03', '676-621-239', '400', '9875037494', 'Almire@facebook.com', 'Quảng Trị', 4, 2, 4);
insert into employees values (10, 'Lion', '1984-09-19', '218-461-559', '1200', '2124703839', 'Lion@facebook.com', 'Quảng Trị', 1, 3, 1);
insert into employees values (11, 'Barty', '1986-01-12', '296-385-742', '400', '8944142139', 'Barty@yahoo.com', 'Quảng Bình', 3, 2, 3);
insert into employees values (12, 'Lindon', '1975-01-20', '491-953-059', '2500', '2507081348', 'Lindon@yahoo.com', 'Quảng Bình', 1, 3, 3);
insert into employees values (13, 'Theresita', '1974-02-28', '462-592-452', '1200', '3498856146', 'Theresita@facebook.com', 'Đà Nẵng', 4, 4, 3);
insert into employees values (14, 'Persis', '1997-03-25', '291-543-720', '1200', '6577700115', 'Persis@yahoo.com', 'Sài Gòn', 5, 3, 4);
insert into employees values (15, 'Zitella', '1972-11-09', '239-064-036', '1200', '6491368164', 'Zitella@facebook.com', 'Đà Nẵng', 3, 3, 3);
insert into employees values (16, 'Hanny', '1983-12-16', '997-896-341', '1200', '5127073194', 'Hanny@yahoo.com', 'Sài Gòn', 1, 1, 4);
insert into employees values (17, 'Libby', '2000-09-21', '451-865-562', '400', '1917111389', 'Libby@yahoo.com', 'Quảng Bình', 5, 3, 4);
insert into employees values (18, 'Lezley', '1997-01-07', '187-178-345', '1200', '3447169372', 'Lezley@yahoo.com', 'Huế', 2, 1, 2);
insert into employees values (19, 'Ase', '1992-05-10', '233-906-204', '400', '2089284381', 'Ase@facebook.com', 'Sài Gòn', 4, 4, 1);
insert into employees values (20, 'Jeffry', '1997-01-29', '492-519-500', '1200', '9529551056', 'Jeffry@yahoo.com', 'Quảng Nam', 5, 2, 2);
insert into employees values (21, 'Duy', '1996-04-15', '312-277-832', '5000', '9529551056', 'nguyenduy@yahoo.com', 'Sài Gòn', 6, 4, 4);

create table customerTypes (
customer_type_id int auto_increment primary key,
customer_type_name enum('Diamond', 'Platinium', 'Gold', 'Silver', 'Member')
);

insert into customerTypes values (1, 'Diamond'), (2, 'Platinium'), (3, 'Gold'), (4, 'Silver'), (5, 'Member');

create table customers (
customer_id int auto_increment primary key,
customer_type_id int not null,
foreign key(customer_type_id) references customerTypes(customer_type_id),
customer_name nvarchar(45) not null,
customer_birthday date not null,
customer_idcard nvarchar(45) not null,
customer_phone nvarchar(45) not null,
customer_email nvarchar(45),
customer_address nvarchar(45)
);

insert into customers values (1, 5, 'Ulysses', '1979-09-17', '123-456-987', '5576786287', 'Ulysses@gmail.com.vn', 'Vinh');
insert into customers values (2, 2, 'Lemuel', '1972-01-27', '333-444-333', '8153115769', 'Lemuel@gmail.com.vn', 'Đà Nẵng');
insert into customers values (3, 4, 'Alwyn', '1997-12-10', '888-666-444', '0009725571', 'Alwyn@fb.com.vn', 'Đà Nẵng');
insert into customers values (4, 1, 'Kathrine', '1974-11-18', '123-555-757', '0286460721', 'Kathrine@fb.com.vn', 'Vinh');
insert into customers values (5, 3, 'Hasty', '1996-10-08', '356-756-888', '0121392590', 'Hasty@codegym.com.vn', 'Đà Nẵng');
insert into customers values (6, 2, 'Sigismundo', '1988-02-17', '111-888-123', '2089432337', 'Sigismundo@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (7, 1, 'Shannon', '1970-04-30', '222-777-123', '1304598628', 'Shannon@codegym.com.vn', 'Quảng Nam');
insert into customers values (8, 5, 'Anica', '1995-01-27', '666-666-123', '8624729054', 'Anica@fb.com.vn', 'Quảng Ngãi');
insert into customers values (9, 2, 'Rita', '1994-12-02', '777-555-123', '0035377505', 'Rita@gmail.com.vn', 'Vinh');
insert into customers values (10, 5, 'Florence', '1982-09-26', '888-455-111', '5842276839', 'Florence@gmail.com.vn', 'Vinh');
insert into customers values (11, 1, 'Van', '1992-01-23', '234-111-167', '9272198917', 'Van@fb.com.vn', 'Quảng Trị');
insert into customers values (12, 1, 'Martelle', '1991-01-28', '345-111-767', '0713312304', 'Martelle@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (13, 4, 'Laurie', '1971-02-19', '456-222-634', '6495947446', 'Laurie@codegym.com.vn', 'Vinh');
insert into customers values (14, 5, 'Pearla', '1975-03-09', '567-222-452', '1223517090', 'Pearla@codegym.com.vn', 'Quảng Trị');
insert into customers values (15, 3, 'Christy', '1986-03-05', '678-333-521', '9156344226', 'Christy@codegym.com.vn', 'Quảng Nam');
insert into customers values (16, 5, 'Sterne', '1980-06-15', '098-456-111', '2923972935', 'Sterne@gmail.com.vn', 'Đà Nẵng');
insert into customers values (17, 1, 'Markos', '2000-08-12', '000-456-657', '8774327558', 'Markos@fb.com.vn', 'Quảng Ngãi');
insert into customers values (18, 4, 'Etta', '1992-04-29', '120-362-946', '3594759386', 'Etta@codegym.com.vn', 'Quảng Nam');
insert into customers values (19, 4, 'Mag', '1990-01-04', '140-625-783', '7638896098', 'Mag@gmail.com.vn', 'Vinh');
insert into customers values (20, 4, 'Cam', '1971-06-04', '340-652-853', '6978254789', 'Cam@fb.com.vn', 'Quảng Ngãi');
insert into customers values (21, 1, 'Queenie', '1970-02-14', '740-345-673', '5825912773', 'Queenie@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (22, 5, 'Carena', '1997-08-13', '970-783-682', '2912678636', 'Carena@fb.com.vn', 'Vinh');
insert into customers values (23, 2, 'Betty', '1970-11-24', '988-456-112', '4966468821', 'Betty@gmail.com.vn', 'Đà Nẵng');
insert into customers values (24, 5, 'Karoly', '1974-12-10', '250-222-346', '1066860689', 'Karoly@codegym.com.vn', 'Quảng Ngãi');
insert into customers values (25, 5, 'Marsh', '1986-03-02', '290-111-068', '2400293966', 'Marsh@fb.com.vn', 'Huế');
insert into customers values (26, 5, 'Clarinda', '1974-04-28', '100-095-000', '8076709705', 'Clarinda@gmail.com.vn', 'Quảng Nam');
insert into customers values (27, 2, 'Paulie', '1977-09-14', '900-648-008', '9525119915', 'Paulie@fb.com.vn', 'Quảng Trị');
insert into customers values (28, 5, 'Doralia', '1976-04-03', '950-735-088', '9239912774', 'Doralia@fb.com.vn', 'Vinh');
insert into customers values (29, 1, 'Sybil', '1988-10-07', '450-726-976', '8400714804', 'Sybil@gmail.com.vn', 'Quảng Ngãi');
insert into customers values (30, 5, 'Raleigh', '1993-03-29', '330-562-456', '1785140910', 'Raleigh@fb.com.vn', 'Huế');
insert into customers values (31, 1, 'Sybil', '1990-09-17', '423-726-999', '4562794678', 'Sybil1990@gmail.com.vn', 'Quảng Ngãi');
insert into customers values (32, 3, 'Raleigh', '1980-07-29', '330-762-006', '0987234516', 'Raleigh1980@fb.com.vn', 'Đà Nẵng');



create table rentTypes (
rent_type_id int auto_increment primary key,
rent_type_name enum('year', 'month', 'day', 'hour'),
rent_type_price int
);
insert into rentTypes values (1, 'year', 399000), (2, 'month', 29000), (3, 'day', 1000), (4, 'hour', 50);

create table serviceTypes (
service_type_id int auto_increment primary key,
service_type_name enum('Villa', 'House', 'Room')
);

insert into serviceTypes values (1, 'Villa'), (2, 'House'), (3, 'Room');

create table services (
service_id int auto_increment primary key,
service_name varchar(45) not null,
service_area int,
check(service_area > 30),
service_floor int,
check(service_floor > 0),
service_max_people int,
check(service_max_people between 1 and 20),
rent_type_id int not null,
service_type_id int not null,
service_price int not null,
service_status enum ('available', 'unavailable') default 'available',
foreign key (rent_type_id) references rentTypes(rent_type_id),
foreign key (service_type_id) references serviceTypes(service_type_id)
);

insert into services values (1, 'Villa01', 72, 2, 14, 1, 1, 399000,'available');
insert into services values (2, 'Villa02', 50, 4, 8, 2, 1, 29000,'available');
insert into services values (3, 'Villa03', 49, 1, 11, 3, 1, 1000,'unavailable');
insert into services values (4, 'Villa04', 51, 2, 8, 4, 1, 150,'unavailable');
insert into services values (5, 'Villa05', 41, 3, 6, 1, 1, 349000,'available');
insert into services values (6, 'Villa06', 80, 2, 9, 2, 1, 21000,'unavailable');
insert into services values (7, 'Villa07', 71, 1, 12, 3, 1, 1100,'available');
insert into services values (8, 'Villa08', 85, 2, 9, 4, 1, 100,'available');
insert into services values (9, 'Villa09', 70, 3, 12, 3, 1, 999,'available');
insert into services values (10, 'Villa10', 87, 2, 9, 4, 1, 150,'available');
insert into services values (11, 'Room11', 81, 4, 9, 1, 3, 299000,'available');
insert into services values (12, 'Room12', 74, 1, 8, 2, 3, 10000,'available');
insert into services values (13, 'Room13', 84, 3, 19, 3, 3, 300,'unavailable');
insert into services values (14, 'Room14', 93, 1, 9, 4, 3, 50,'available');
insert into services values (15, 'Room15', 87, 2, 8, 1, 3, 250000,'available');
insert into services values (16, 'Room16', 89, 3, 5, 2, 3, 12000,'available');
insert into services values (17, 'Room17', 77, 1, 11, 3, 3, 350,'unavailable');
insert into services values (18, 'Room18', 56, 2, 17, 4, 3, 75,'available');
insert into services values (19, 'Room19', 55, 2, 4, 3, 3, 250,'available');
insert into services values (20, 'Room20', 33, 2, 4, 4, 3, 40,'available');
insert into services values (21, 'House01', 81, 3, 4, 1, 2, 349000,'unavailable');
insert into services values (22, 'House02', 57, 4, 13, 2, 2, 19000,'available');
insert into services values (23, 'House03', 58, 4, 16, 3, 2, 600,'unavailable');
insert into services values (24, 'House04', 62, 2, 11, 4, 2, 80,'available');
insert into services values (25, 'House05', 50, 4, 15, 3, 2, 700,'unavailable');
insert into services values (26, 'House06', 60, 2, 10, 4, 2, 100,'available');



create table attachServices (
attach_service_id int auto_increment primary key,
attach_service_name nvarchar(45) not null,
attach_service_price int not null,
attach_service_unit int not null,
attach_service_status nvarchar(45)
);

insert into attachServices values (1, 'No service', 0, 0,'unavailable');
insert into attachServices values (2, 'karaoke01', 100, 0,'available');
insert into attachServices values (3, 'karaoke02', 150, 0,'available');
insert into attachServices values (4, 'karaoke03', 150, 0,'available');
insert into attachServices values (5, 'massage01', 200, 0,'available');
insert into attachServices values (6, 'massage02', 250, 0,'available');
insert into attachServices values (7, 'massage03', 299, 0,'available');
insert into attachServices values (8, 'massage04', 349, 0,'available');
insert into attachServices values (9, 'car01', 50, 0,'available');
insert into attachServices values (10, 'car02', 100, 0,'available');
insert into attachServices values (11, 'car03', 150, 0,'available');
insert into attachServices values (12, 'car04', 200, 0,'available');
insert into attachServices values (13, 'food01', 50, 0,'available');
insert into attachServices values (14, 'food02', 100, 0,'available');
insert into attachServices values (15, 'food03', 150, 0,'available');
insert into attachServices values (16, 'food04', 200, 0,'available');
insert into attachServices values (17, 'drink01', 50, 0,'available');
insert into attachServices values (18, 'drink02', 100, 0,'available');
insert into attachServices values (19, 'drink03', 150, 0,'available');
insert into attachServices values (20, 'drink04', 200, 0,'available');


create table contracts (
contract_id int auto_increment primary key,
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit int not null,
contract_price int not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references employees(employee_id) ON DELETE CASCADE,
foreign key (customer_id) references customers(customer_id)  ON DELETE CASCADE,
foreign key (service_id) references services(service_id) ON DELETE CASCADE
);
# service_id: hour: 4,8,10,14,18,20,24,26 : 50
#			  day: 3,7,9,13,17,19,23,25 : 1000
#			  month: 2,6,12,16,22 : 29000
#			  year: 1,5,11,15,21 : 399000

#2016
insert into contracts values (26, '2016-06-09', '2016-06-10', 200, 350, 18, 8, 17);
insert into contracts values (27, '2016-06-10', '2016-06-12', 500, 2200, 13, 9, 7);
insert into contractDetails values (44, 26, 6, 1);
insert into contractDetails values (45, 27, 10, 1);

#2017


#2018
insert into contracts values (1, '2018-02-01', '2018-03-01', 15000, 29000, 1, 1, 2);
insert into contracts values (2, '2018-04-01 08:00:00', '2018-04-01 18:00:00', 200, 1500, 4, 4, 4);
insert into contracts values (3, '2018-06-01', '2018-06-05', 500, 1200, 3, 27, 13);
insert into contracts values (4, '2018-08-01', '2019-08-01', 100000, 349000, 2, 21, 5);
insert into contracts values (5, '2018-09-10', '2018-09-12', 800, 2200, 5, 14, 7);
insert into contracts values (6, '2018-12-01', '2018-12-04', 500, 750, 6, 30, 19);


#2019

insert into contracts values (7, '2019-01-01', '2019-03-01', 10000, 42000, 1, 2, 6);
insert into contracts values (8, '2019-02-01', '2019-03-01', 5000, 29000, 3, 4, 2);
insert into contracts values (9, '2019-03-01', '2019-03-15', 5000, 15000, 6, 29, 3);
insert into contracts values (10, '2019-06-01', '2019-06-07', 2000, 6000, 5, 11, 3);
insert into contracts values (11, '2019-06-10', '2019-06-15', 1000, 3000, 4, 10, 23);
insert into contracts values (12, '2019-08-10', '2019-08-20', 3000, 3500, 9, 5, 17);
insert into contracts values (13, '2019-08-19', '2019-08-23', 250, 1000, 8, 12, 19);
insert into contracts values (14, '2019-10-01', '2019-10-04', 2000, 3000, 7, 25, 3);
insert into contracts values (15, '2019-11-02', '2019-11-05', 1000, 1800, 11, 16, 23);
insert into contracts values (16, '2019-11-22', '2019-11-27', 800, 3500, 10, 31, 25);
insert into contracts values (17, '2019-12-01', '2020-01-01', 5000, 19000, 12, 32, 22);
insert into contracts values (18, '2019-12-10', '2020-12-15', 995, 4995, 14, 5, 9);

#2020

insert into contracts values (19, '2020-01-01', '2021-01-01', 50000, 299000, 1, 20, 11);
insert into contracts values (20, '2020-05-01', '2021-05-01', 100000, 349000, 8, 1, 21);
insert into contracts values (21, '2020-05-01', '2020-07-01', 29000, 58000, 16, 2, 2);
insert into contracts values (22, '2020-06-01', '2020-09-01', 29000, 63000, 21, 4, 6);
insert into contracts values (23, '2020-06-07', '2020-06-15', 3000, 8000, 17, 7, 3);
insert into contracts values (24, '2020-06-09', '2020-06-10', 200, 350, 2, 18, 17);
insert into contracts values (25, '2020-06-10', '2020-06-12', 500, 2200, 3, 15, 7);




create table contractDetails (
contract_detail_id int auto_increment primary key,
contract_id int not null,
attach_service_id int not null,
quantity int not null,
foreign key (contract_id) references contracts(contract_id) ON DELETE CASCADE,
foreign key (attach_service_id) references attachServices(attach_service_id) ON DELETE CASCADE
);

insert into contractDetails values (1, 1, 9, 2);
insert into contractDetails values (2, 1, 13, 1);
insert into contractDetails values (3, 1, 17, 1);
insert into contractDetails values (4, 2, 10, 2);
insert into contractDetails values (5, 3, 2, 1);
insert into contractDetails values (6, 3, 5, 1);
insert into contractDetails values (7, 3, 12, 2);
insert into contractDetails values (8, 4, 4, 1);
insert into contractDetails values (9, 4, 8, 2);
insert into contractDetails values (10, 4, 12, 2);
insert into contractDetails values (11, 4, 16, 2);
insert into contractDetails values (12, 4, 20, 2);
insert into contractDetails values (13, 5, 10, 4);
insert into contractDetails values (14, 6, 11, 5);
insert into contractDetails values (15, 7, 10, 2);
insert into contractDetails values (16, 7, 13, 2);
insert into contractDetails values (17, 8, 12, 1);
insert into contractDetails values (18, 8, 16, 1);
insert into contractDetails values (19, 9, 15, 5);
insert into contractDetails values (20, 10, 20, 2);
insert into contractDetails values (21, 11, 4, 1);
insert into contractDetails values (22, 11, 11, 2);
insert into contractDetails values (23, 11, 8, 1);
insert into contractDetails values (24, 12, 4, 1);
insert into contractDetails values (25, 13, 8, 2);
insert into contractDetails values (26, 13, 11, 1);
insert into contractDetails values (27, 14, 16, 1);
insert into contractDetails values (28, 14, 17, 5);
insert into contractDetails values (29, 15, 20, 2);
insert into contractDetails values (30, 16, 4, 1);
insert into contractDetails values (31, 17, 5, 2);
insert into contractDetails values (32, 17, 9, 1);
insert into contractDetails values (33, 17, 14, 2);
insert into contractDetails values (34, 17, 20, 1);
insert into contractDetails values (35, 18, 20, 1);
insert into contractDetails values (36, 19, 5, 2);
insert into contractDetails values (37, 19, 16, 2);
insert into contractDetails values (38, 20, 9, 1);
insert into contractDetails values (39, 21, 16, 2);
insert into contractDetails values (40, 22, 17, 1);
insert into contractDetails values (41, 23, 18, 2);
insert into contractDetails values (42, 24, 6, 1);
insert into contractDetails values (43, 25, 10, 1);

set sql_safe_updates = 0;