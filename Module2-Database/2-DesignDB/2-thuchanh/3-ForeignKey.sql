CREATE TABLE customers(
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE orders(
   orderid INT AUTO_INCREMENT,
   staff VARCHAR(50),
   customer_id int,
   PRIMARY KEY (orderid),
   FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE orders(
   orderid INT AUTO_INCREMENT PRIMARY KEY,
   staff VARCHAR(50),
   customer_id INT REFERENCES customers(id)
);