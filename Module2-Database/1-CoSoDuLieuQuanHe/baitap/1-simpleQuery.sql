#select * from classicmodels.customers;
#select customerName, phone, city, country from classicmodels.customers; 
#select customerName, phone, city, country from classicmodels.customers where customerName = 'Atelier Graphique';
select customerName, phone, city, country from classicmodels.customers where customerName like '_a%';
#SELECT * FROM customers WHERE city IN ('Nantes',' Las Vegas',' Warszawa','NYC');
