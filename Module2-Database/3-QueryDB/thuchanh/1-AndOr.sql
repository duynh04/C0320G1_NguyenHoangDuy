#select productCode, productName, buyprice, quantityInStock from products
#where buyprice > 56.76 and quantityInStock > 10

#select products.productCode, products.productName, products.buyprice, productlines.textDescription 
#from products
#left join productlines
#on products.productLine = productlines.productLine
#where buyprice > 56.76 and buyprice < 95.59
#order by buyprice desc

select productCode, productName, buyprice, quantityInStock, productVendor, productLine 
from products 
where productLine = 'Classic Cars' or productVendor = 'Min Lin Diecast'
