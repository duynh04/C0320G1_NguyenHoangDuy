#02--------------------------------------------------------------------------------------------------------------
select * from employees
where (employee_name like 'H%' or employee_name like 'K%' or employee_name like 'T%') and length(employee_name) <= 15
;

#03--------------------------------------------------------------------------------------------------------------

select * from customers
where timestampdiff(year, customer_birthday, curdate()) between 18 and  50 and customer_address in ('Đà Nẵng', 'Quảng Trị')
;
#04--------------------------------------------------------------------------------------------------------------
select customers.customer_id, customers.customer_name, customers.customer_idcard, count(*) as NoBooking
from customers
join customertypes using (customer_type_id)
join contracts on customers.customer_id = contracts.customer_id
where customertypes.customer_type_name = 'Diamond'
group by customers.customer_name
order by noBooking desc
;

#05--------------------------------------------------------------------------------------------------------------
drop temporary table customerpercontract;
create temporary table customerpercontract
	select customers.customer_id, contracts.contract_id, services.service_name, contracts.contract_start_date, contracts.contract_end_date,
	(contract_price + sum(quantity * attachservices.attach_service_price)) as Tong
	from customers
	join contracts using (customer_id)
	join services using (service_id)
	join contractdetails using (contract_id)
	join attachservices using (attach_service_id)
	group by contracts.contract_id
    order by customer_id
;

select customers.customer_id, customers.customer_name, customertypes.customer_type_name, customerpercontract.*
from customers
left join customertypes using(customer_type_id)
left join customerpercontract using(customer_id)
order by customerpercontract.contract_id
;

#06--------------------------------------------------------------------------------------------------------------

select services.service_id, services.service_name, services.service_area, services.service_price, servicetypes.service_type_name
from services
join servicetypes on services.service_type_id = servicetypes.service_type_id
join renttypes on services.rent_type_id = renttypes.rent_type_id
where service_id not in (
	select distinct contracts.service_id
	from contracts
	join services on contracts.service_id = services.service_id
	where contract_start_date > '2019-03-31')
order by service_id
;

#07--------------------------------------------------------------------------------------------------------------
select contracts.contract_id, services.service_id, services.service_name, services.service_area, services.service_max_people, services.service_price, servicetypes.service_type_name
from services
join servicetypes using(service_type_id)
join contracts using(service_id)
where year(contracts.contract_start_date) = 2018 and service_id not in
(
	select service_id
    from contracts
    where year(contracts.contract_start_date) = 2019
)
;

#08--------------------------------------------------------------------------------------------------------------
#08.1
select distinct customers.customer_name
from customers
;

#08.2
select customers.customer_name
from customers
group by 1
;

#08.3
select customers.customer_name from customers
union
select customers.customer_name from customers
;

#09--------------------------------------------------------------------------------------------------------------
drop temporary table if exists statistics;
create temporary table statistics (
	statistics_id int auto_increment primary key,
    month varchar(10) not null unique
);
insert into statistics values (1, 'Jan'),(2, 'Feb'),(3, 'Mar'),(4, 'Apr'),(5, 'May'),(6, 'Jun'),(7, 'Jul'),(8, 'Aug'),(9, 'Sep'),(10, 'Oct'),(11, 'Nov'),(12, 'Dec');

select statistics.month, ifnull(temp.contract_id, 0) as contract_id, ifnull(temp.NoOfCustomers, 0) as NoOfCustomers, ifnull(temp.revenue, 0) as `revenue`
from statistics
left join (
	select date_format(contracts.contract_start_date, '%b') as month, contracts.contract_id, count(contracts.customer_id) as `NoOfCustomers`, sum(Tong) as `revenue`
	from contracts
	join customers on contracts.customer_id = customers.customer_id
    join customerpercontract using(contract_id)
	where year(contracts.contract_start_date) = 2019
	group by month) as temp
using(month)
order by statistics_id
;

#10--------------------------------------------------------------------------------------------------------------
select contract_id, contract_start_date, contract_end_date, contract_deposit, count(*) as `NoOfAttachService`
from contracts
join contractdetails using(contract_id)
group by contract_id
order by contract_id
;

#11--------------------------------------------------------------------------------------------------------------

select attach_service_name, contract_id
from attachservices
join contractdetails using(attach_service_id)
join contracts using(contract_id)
join customers using(customer_id)
join customertypes using(customer_type_id)
where attach_service_id <> 1 and customer_type_name = 'Diamond' and customer_address in ('Vinh', 'Quảng Ngãi')
;

#12--------------------------------------------------------------------------------------------------------------
select contract_id, contract_start_date, employee_name, customer_name, customer_phone, service_name, quantity, contract_deposit
from contracts
join employees using(employee_id)
join customers using(customer_id)
join services using(service_id)
join contractdetails using(contract_id)
join attachservices using(attach_service_id)
where contract_start_date between '2019-10-01' and '2019-12-31' and contracts.service_id not in 
(
	select service_id
    from contracts
    where contracts.contract_start_date between '2019-01-01' and '2019-06-30'
)
group by contract_id
;

#13--------------------------------------------------------------------------------------------------------------
create table if not exists mostused
	select contract_id, attach_service_name, attach_service_id, count(*) as amount
	from attachservices
	join contractdetails using(attach_service_id)
    join contracts using(contract_id)
	group by attach_service_name;

select attach_service_name, amount
from mostused
where amount in (select max(amount) from mostused);
#drop table mostused
;

#14--------------------------------------------------------------------------------------------------------------

select contract_id, service_type_name, attach_service_name, amount
from contracts
join services using(service_id)
join servicetypes using(service_type_id)
join mostused using (contract_id) 
where mostused.amount = 1;
#drop table mostused
;

#15--------------------------------------------------------------------------------------------------------------

select employee_id, contract_id, employee_name, edu_degree, division_name, employee_phone, employee_address
from employees
join divisions using(division_id)
join positions using(position_id)
join edubackgrounds using(edu_bg_id)
join contracts using (employee_id)
where year(contract_start_date) between 2018 and 2019
group by employee_id
having count(contract_id) <= 3
order by employee_id
;

#16--------------------------------------------------------------------------------------------------------------

delete from employees where employee_id not in (
	select employee_id
	from (
		select distinct employee_id
		from employees
		join contracts using(employee_id)
		where year(contract_start_date) between 2017 and 2020
        order by employee_id
    ) as tmp
)
;


#17--------------------------------------------------------------------------------------------------------------

update customers set customers.customer_type_id = 1 where customer_id in (
	select customer_id
	from 
    (
		select contracts.customer_id, contract_start_date, contract_price + sum(attach_service_price * quantity) as total_pay
        from contracts
        join customers using (customer_id)
        join contractdetails on contracts.contract_id = contractdetails.contract_id
        join attachservices on contractdetails.attach_service_id = attachservices.attach_service_id
        where customers.customer_type_id = 2  and year(contracts.contract_start_date) = 2019
        group by contracts.contract_id
        having total_pay > 5000
    )  as temp
)
;

#18--------------------------------------------------------------------------------------------------------------
delete from customers where customer_id not in 
(
	select distinct customer_id
	from contracts
	where year(contract_start_date) > 2016
    order by customer_id
)
;

#19--------------------------------------------------------------------------------------------------------------
update attachservices set attach_service_price = attach_service_price * 2 where attach_service_id in 
(
	select attach_service_id
    from (
    	select contract_id, attach_service_name, attach_service_id, count(*) as amount
		from attachservices
		join contractdetails using(attach_service_id)
		join contracts using(contract_id)
        where year(contract_start_date) = 2019
		group by attach_service_id
    ) as temp
)

;
#20--------------------------------------------------------------------------------------------------------------

select customer_id as id, customer_name as name, customer_email as email, customer_phone as phone, customer_birthday as birthday, customer_address as address
from customers 
union all
select employee_id, employee_name, employee_email, employee_phone, employee_birthday, employee_address 
from employees
;


