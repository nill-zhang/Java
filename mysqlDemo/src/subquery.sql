use northwind;
# use subquery for comparison
# return productids that have total payment larger than the average
select productid from orderdetails where unitprice * quantity > (select avg(unitprice*quantity) from orderdetails);


# use subquery for comparison
# choose the orderid and productid with the highest payment.
select orderid, productid from orderdetails where (unitprice * quantity) = (select max(unitprice * quantity) from orderdetails);


# use subquery for set membership test.
# return those companies who ordered more than 15800 worth of products.
select companyname from customers where customerid in (
select distinct(customerid) from orders o inner join orderdetails d on o.orderid = d.orderid 
where (d.unitprice*d.quantity) > 15800);

# use subquery for set  membership test.
# return those employees whose city is in region 2.
select concat(firstname, lastname) as name, city  from employees where city in (
select territoryDescription from territories where regionid = 2);


# use subquery for set membership test.
# return those customers who havn't place any orders.
select companyname from customers where customerid not in (select distinct(customerid) from orders);

# use subquery for inner query.
# A correlated subquery is evaluated once for each row in the outer query.
# return each order's maximum-total product id, one orderid can have multiple different products.
select orderid, productid from orderdetails o 
where (unitprice*quantity) = (select max(unitprice*quantity) from orderdetails where orderid = o.orderid);


# return those company's information that has ordered total value over 15800 worth of products.
select companyname, address, fax from customers
where exists(
select orderid, sum(unitprice* quantity) as total 
from orders inner join orderdetails using(orderid) 
where customerid = customers.customerid group by orderid having total > 15800
);

select orderid, sum(unitprice* quantity) as total 
from orderdetails group by orderid having total > 15000;

select * from employees;
select * from territories;
select * from region;
select * from orders where customerid = "HANAR";
select * from orderdetails d where d.orderid = 10643;