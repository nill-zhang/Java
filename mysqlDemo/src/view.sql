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

select `table_name`, is_updatable from information_schema.views where table_schema="northwind";
select * from information_schema.views where table_schema="mysqljdbc";


# create a table by copying existing table;
# but you will lose all the constraints, like foreign keys, triggers, primary keys
# that is what I need here, otherwise, when I delete the entry in the view, it will cause ErrorCode 1451
# which is cannot delete or update a parent(on delete cascade on update cascade not set).
drop table if exists employee_dup;
create table Employee_Dup as select * from employees;
desc employee_dup;
# simple views are updatable
# simple views are created by no following things in Select Clause.
# MIN, MAX, SUM, AVG, COUNT, etc.
# DISTINCT
# GROUP BY clause.
# HAVING clause.
# UNION or UNION ALL clause.
# Left join or outer join.
# Subquery in the SELECT clause or in the WHERE clause that refers to the table appeared in the FROM clause.
# Reference to non-updatable view in the FROM clause.
# Reference only to literal values.
# Multiple references to any column of the base table.
drop view if exists northwind.londonemployees;
create view  LondonEmployees as 
select employeeid, concat(firstname, " ", lastname) as name, salary from employee_dup
where city = "london";

select * from londonemployees;
select employeeid, firstname, lastname, salary from employee_dup where city = "london";

# update the simple view
update londonEmployees set salary = salary + 5000;
select employeeid, firstname, lastname, salary from employee_dup where city = "london";
# effective in the base table
select * from londonemployees;

# delete the simple view
delete from londonemployees where name like "%michael%";
select * from londonemployees;
# effective in the base table
select employeeid, firstname, lastname, salary from employee_dup where city = "london";

# this will cause error, because view use name, base table has tow columns firstname and lastname
# this insert statemetn will cause Error Code: 1348. Column 'name' is not updatable
insert into londonemployees values(100,"Shaofeng Zhang", 9999);

drop table if exists staff;
create table staff(
 staffid int(11) primary key,
 fname varchar(50) default "",
 lname varchar(50) default "",
 city varchar(50) default "",
 salary float default 0
);


insert into staff values
(1, 'Nancy', 'Davolio', 'Seattle', 1234.55),
(2, 'Andrew', 'Fuller', 'Tacoma', 2254.49),
(3, 'Janet', 'Leverling', 'Kirkland', 3119.15),
(4, 'Margaret', 'Peacock', 'Redmond', 1861.08),
(5, 'Steven', 'Buchanan', 'London', 11744.2),
(7, 'Robert', 'King', 'London', 11991.5),
(8, 'Laura', 'Callahan', 'Seattle', 2100.5);

# create or repalce view = alter view
create or replace view SeattleEmployees as 
select staffid, fname, lname, city from staff
where city = "Seattle";

select * from seattleemployees;
select * from staff where city = "seattle";
# insert one record into seattleemployees table
insert into seattleemployees values(109,"Shaofeng","Zhang", "Vancouver");
# the record is not there
select * from seattleemployees;
select * from staff;

alter view  SeattleEmployees as 
select staffid, fname, lname, city from staff
where city = "Seattle" with check option;

select * from seattleemployees;
select * from staff where city = "seattle";
# when you add with check option to the original view
# it will check the city with the where condition in the view
# so that you can only insert or update a record with city = "Seattle"
insert into seattleemployees values(107,"Xuelian","Yang", "Beijing");
update seattleemployees  set city = "Hefei" where fname = "Laura";
# the records are not there
select * from seattleemployees;
select * from staff;

# show view definition
show create view seattleemployees;

