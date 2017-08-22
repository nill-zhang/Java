use mysqljdbc;
drop view if exists mysqljdbc.candiates_using_gmail;
create view candiates_using_gmail as
select id, first_name fname, last_name as lname from candidates where email like "%gmail.com%";

# use this one instead of show tables, this one will give you info about which is which
show full tables;
# the following does not work, because for views you have to specify the database
# even though, you specified use mysqljdbc
# that only works for tables
select * from candidates_using_gmail;
select * from mysqljdbc.candiates_using_gmail;

# create another view based on a view
create view candidates_using_gmail_with_short_name as
select * from mysqljdbc.candiates_using_gmail where character_length(concat(fname,lname)) < 10;

select * from candidates_using_gmail_with_short_name;

use northwind;
drop view if exists northwind.customerorders;
select * from orders where orderid = 10692;
select * from customers;
select * from orderdetails where orderid = 10692;
select * from products where productid = 63;
select distinct(orderid) from orderdetails ;
#create a view with join
create view CustomerOrders as select
o.orderid, c.companyname, p.productname, d.unitprice*quantity as total
from orderdetails d inner join orders o on d.orderid = o.orderid
inner join products p on d.productid = p.productid
inner join customers c on o.customerid = c.customerid;


select * from northwind.customerorders;

#create a view with subquery
drop view if exists northwind.Products_Price_More_than_Average;
create view Products_Price_More_than_Average as 
select productname, unitprice from products 
where unitprice >= (select avg(unitprice) from products);
select * from Products_Price_More_than_Average;


