create table table1.countries(country_id char(10), country_name char(20), region_id char(10));
create table if not exists table1.countries(country_id char(10), country_name char(20), region_id char(10));
create table if not exists table1.dup_countries like table1.countries; #create a duplicate with same structure
desc table1.countries;
desc table1.country;
show tables;
drop table dup_contries;
desc  table1.dup_countries;
insert into table1.countries values("001","China","1");
insert into table1.countries values("002","India","1");
insert into table1.countries(country_name,region_id)values("Canada","2");
select * from table1.countries;
create table if not exists table1.same_contents_as_countries as select * from table1.countries; #create a duplicate with same contents
create table if not exists table1.country(
country_id char(10) not null, 
country_name char(20) not null, 
region_id char(10) not null
);
insert into table1.country(country_name,region_id)values("Italy","3");
drop table table1.jobs;
create table table1.jobs(
job_id char(10) primary key not null,
job_title varchar(30) not null,
min_salary decimal(10,1),
max_salary decimal(10,1) check(max_salary<=1000000.0) #Check actually are not enforced
);

insert into table1.jobs values("1001", "accountant", 200, 1250000);
insert into table1.jobs values("1002", "security", 100, 50000);

select * from table1.jobs;
create table if not exists table1.range_country(
country_id char(10) not null,
country_name enum('China','Japan', 'Korea'),
region_id char(10) check (region_id in ("001", "002"))
);
desc table1.range_country;
insert into table1.range_country values("001","China","003"); #check has no effect
insert into table1.range_country values("001",2,"003"); # Japan
create table table1.job_history(
employee_id char(10) primary key,
start_date datetime,
end_date datetime check(end_date like "--/--/----"),
job_id varchar(30),
department_id varchar(30)
);
desc job_history;
insert into table1.job_history values("1001","2017/07/02","2017/07/22","001","2001");
insert into table1.job_history values("1002","2017/07/06","2017/07/29","002","2008");

create table table1.nodup(
id char(10) unique,
name char(10)
#unique(id)
);
desc table1.nodup;
insert into table1.nodup values("1111", "Helen");
insert into table1.nodup values("1111", "Alex");

create table table1.default(
job_id int(16) not null,
job_title varchar(20) default "",
min_salary decimal(8,2) default 8000,
max_salary decimal(8,2) default null
);

desc table1.default;
insert into table1.default(job_id)values(65531);
select * from table1.default;

create table table1.student(
student_id int(16) auto_increment primary key,
student_name char(20)
);

insert into table1.student(student_name)values("shaofeng zhang");
insert into table1.student(student_name)values("xuelian yang");
insert into table1.student(student_name)values("qiang shu");
select * from table1.student;

create table table1.combination(
comb1 int(6) unique, 
comb2 char(20), 
title varchar(20),
primary key(comb1, comb2)
);

insert into table1.combination values(2, "test","what");
insert into table1.combination values(1, "test","what");
insert into table1.combination values(2, "why","what"); #This will result error, because comb1 requires unique.
desc table1.combination;

show tables;
select * from jobs;
drop  table job_history;
create table table1.job_history(
employee_id char(10) primary key,
start_date datetime,
end_date datetime check(end_date like "--/--/----"),
job_id varchar(30),
department_id varchar(30),
foreign key (job_id) references jobs(job_id) #in order to create foreign key, this job_id must be the primary key in jobs table
);

insert into table1.job_history values("001","2007-04-08", "2009-06-15", "1008", "dept111"); # this will fail because 1008 is not a existing job_id in jobs table.
insert into table1.job_history values("001","2007-04-08", "2009-06-15", "1001", "dept111");
insert into table1.job_history(employee_id, start_date, end_date, department_id) values("002","2017-03-08", "2017-06-15", "dept222"); # this one works, a null job_id is set as default, but null does not exist in jobs
select * from table1.job_history;
desc table1.job_history;
desc table1.jobs;

select * from table1.job_history;
create table if not exists table1.department(
department_id char(10) not null,
department_name varchar(20),
manager_id char(10) not null,
location_id char(10),
primary key(department_id,manager_id)
);
insert into table1.department values("1111", "marketing", "008", "9000");
insert into table1.department values("2222", "human resources", "004", "9000");
insert into table1.department values("1111", "R&D", "009", "9000");
insert into table1.department values("2222", "sales", "003", "9000");

select * from table1.department;
desc table1.department;

create table table1.employees (
employee_id char(10) primary key not null, 
first_name varchar(20), 
last_name varchar(20), 
email varchar(40), 
phone_number varchar(15),
hire_date date, 
job_id char(10), 
salary decimal(6,2), 
commission varchar(30), 
manager_id char(10), 
department_id char(10),
foreign key(department_id, manager_id) references department(department_id, manager_id)
);

desc table1.employees;
insert into table1.employees values("0046", "Alex", "Zhang","andy.ledway3@gmail.com", "6477715321", "2017-5-23","1234",5000,"nothing", "007", "1111");
insert into table1.employees values("0046", "Alex", "Zhang","andy.ledway3@gmail.com", "6477715321", "2017-5-23","1234",5000,"nothing", "009", "4444");
insert into table1.employees values("0046", "Alex", "Zhang","andy.ledway3@gmail.com", "6477715321", "2017-5-23","1234",5000,"nothing", "004", "2222"); # this works because manager_id and department_id is a valid combination in department table

desc table1.employees;
create table if not exists table1.city(
city_id char(10) primary key not null,
city_name char(30)
);

drop table table1.country;
create table if not exists table1.country(
country_id char(10) primary key not null,
country_name char(30)
);

insert into table1.country values("555", "German");
insert into table1.country values("556", "Ethiopia");
insert into table1.country values("557", "Cambodia");

insert into table1.city values("666", "Berlin");
insert into table1.city values("667", "Tokyo");
insert into table1.city values("668", "Lisbon");

desc city;
desc country;

create table table1.staff(
staff_id char(10) primary key,
city_id char(10),
country_id char(10),
foreign key(city_id) references table1.city(city_id),
foreign key(country_id) references table1.country(country_id)
);

insert into table1.staff values("333", "666", "551"); # fails, 551 is not a valid country_id in country table

create view employee_view as select * from employees where last_name = "zhang";
select * from employee_view;
alter view employee_view as select * from employees where last_name = "yang";
alter table employees change column commission duties varchar(100) null; #when you change a table structure, the views may be affected
drop view employee_view;
alter table city rename to cities;
show tables;
desc jobs;
insert into jobs values
("5785","sysadmin",2000,70000),
("5748","programmer",20000,79000),
("5485","carpenter",5000,40000),
("8751","fisher",3100,10000);

# instead of using values(), you can use set to insert data to tables;
insert into jobs 
set job_id = "15558",
    job_title = "dba",
    min_salary = 2500,
    max_salary = 50000;
    
select * from jobs where job_id = "15558";


select * from jobs where job_title like "%er";
select * from department;
desc department;
select a.last_name, a.first_name, b.department_name from employees a, department b where a.department_id = b.department_id;
update jobs set job_id="9999", min_salary=1000 where job_title="fisher";
desc jobs;
desc job_history;
select * from job_history;


create table if not exists orders(
order_id char(10) primary key not null,
order_total decimal(6,2),
customer_id char(10),
foreign key(customer_id) references customers(customer_id)
);

insert into orders values("111",100,"002");
insert into orders values("222",100,"002");
insert into orders values("333",100,"002");
insert into orders values("444",100,"004");
insert into orders values("555",100,"005");
insert into orders values("666",100,"009");
insert into orders values("777",100,"002");
insert into orders values("888",100,"008");
insert into orders values("1000",100,"001");
insert into orders values("1111",100,"001");
insert into orders values("2222",100,"009");
insert into orders values("3333",100,"009");
insert into orders values("4444",100,"001");

select * from orders;

create table if not exists customers(
customer_id char(10) primary key not null,
customer_name varchar(30),
customer_address varchar(50),
customer_sexuality char(10)
);

insert into customers values("001", "Shaofeng Zhang", "55 Oakmount Rd.", "Male");
insert into customers values("002", "Xuelian Yang", "65 Oakmount Rd.", "Female");
insert into customers values("003", "Qiang Zhang", "55 Bremer Rd.", "Male");
insert into customers values("004", "Xiaoliang Zhang", "113 Midtown Dr.", "Female");
insert into customers values("005", "Bing Zhang", "12 Fullmoon Cr.", "Male");
insert into customers values("006", "Zhe Zhang", "Oakmount Rd.", "Male");
insert into customers values("007", "Qiang Zhang", "Spadina Ave.", "Male");
insert into customers values("008", "Jun Liang", "Bathurst Blv.", "Male");
insert into customers values("009", "Shaoming Cui", "Jameson Ave.", "Female");

select * from customers;

select orders.order_id, customers.customer_name, customers.customer_address 
from customers inner join orders on customers.customer_id = orders.customer_id;

select orders.order_id, customers.customer_name, customers.customer_address 
from customers left join orders on customers.customer_id = orders.customer_id;

select orders.order_id, customers.customer_name, customers.customer_address 
from customers right join orders on customers.customer_id = orders.customer_id;
# mysql does not support full join. use union all
select orders.order_id, customers.customer_name, customers.customer_address 
from customers full join orders on customers.customer_id = orders.customer_id;

select orders.order_id, customers.customer_name, customers.customer_address 
from customers left join orders on customers.customer_id = orders.customer_id
union all
select orders.order_id, customers.customer_name, customers.customer_address 
from customers right join orders on customers.customer_id = orders.customer_id;

select distinct customer_sexuality from customers;
select distinct customer_name, customer_sexuality from customers;

select * from customers order by customer_id;
select customer_id, sum(order_total) as paid from orders;
select customer_id,sum(order_total) as total from orders group by customer_id; 

# having is operated on vitual columns, while where is operated on columns to filter
select customer_id,sum(order_total) as total from orders group by customer_id having sum(order_total) >= 300; 
# select customer_id,sum(order_total) as total from orders where (sum(order_total) > 300) group by customer_id ; 
select * from customers where customer_name not like "%zhang%";
select * from customers where customer_name like "%zhang%";
# you can not use sum here, because customer_sexuality is not numeric data.
select customer_sexuality, sum(customer_sexuality) as total from customers group by customer_sexuality;
# the following will give number of females and males whose name has "zhang"
select customer_sexuality, count(customer_sexuality) as total from customers where customer_name like "%zhang%" group by customer_sexuality;

# A REGEXP pattern match succeeds if the pattern matches anywhere in the value being tested.
# This differs from a LIKE pattern match, which succeeds only if the pattern matches the entire value.
#
#

# address ends with blv + any character
select * from customers where customer_address like "%Blv_";
# name contains 15 characters
select * from customers where customer_name regexp "^.{15}$";
# name contains 'z'
select * from customers where customer_name regexp "z";
# name does not contain 'z'
select * from customers where customer_name not regexp "z";
# name contains uppercase 'Z'
select * from customers where customer_name regexp binary "Z";
# name ends with 'ng'
select * from customers where customer_name regexp "ng$";





select * from customers where customer_address regexp "^.*Blv.$";
select * from customers where customer_address regexp ".*Blv.";
select * from customers where customer_address rlike ".*Blv.";
#  the following 3 will give the same result, which match Blv + literal '.'
select * from customers where customer_address like "%Blv\.";
select * from customers where customer_address like "%Blv." escape ".";
select * from customers where customer_address like "%Blv." escape '.';

select current_date() as 日期,current_time() as 时间,current_timestamp() 时间戳,current_user() 用户,now() as 现在;
# the following will display the next 3 high salaries in jobs table aka(4th, 5th, 6th).
 select distinct max_salary from jobs order by max_salary desc limit 3,3;


# on duplicate key update , set something.
create table t1 (id int primary key, name varchar(255) not null);
insert into t1 values (1, "one"), (2, "two"), (3, "three");
insert into t1 values (3, "four") on duplicate key update name= "somebody inserted the same key";
select * from t1;

use northwind;
prepare stement from 'select companyname, address from customers where address like ?';
set @pattern = '%blv%';
execute stement using @pattern;
deallocate prepare stement;

use table1;
create table if not exists `binary`(
id int auto_increment primary key,
name varchar(30),
schedule bit(7));

insert into `binary`(name, schedule) values("alex", b'1101110');
insert into `binary`(name, schedule) values("david", b'0111110');
insert into `binary`(name, schedule) values("james", b'1111001');

# get those people who is off on wendesday and sunday.
select name, schedule from `binary` where schedule & b'0010001' = 0;

# show schedule as binary
select name, bin(schedule) as schedule from `binary` where schedule & b'0010001' = 0;
alter table `binary` add column fulltime boolean;
insert into `binary` (name, schedule, fulltime) values("helen", b'1100111', 2);
insert into `binary` (name, schedule, fulltime) values("nova", b'0011111', false);
insert into `binary` (name, schedule, fulltime) values("kevin", b'1111101', 5);
insert into `binary` (name, schedule, fulltime) values("raymond", b'1111101', 1);
insert into `binary` (name, schedule, fulltime) values("kyle", b'1111111', true);
insert into `binary` (name, schedule, fulltime) values("michael", b'0000000', 1);
select * from `binary`;
# tests fulltime = 1
select * from `binary` where fulltime = true;
select * from `binary` where fulltime is true;
select * from `binary` where fulltime is not true;

select week(date(now())) week,
weekday("2017-09-06") as weekday,
weekofyear("2017-08-31") as weekofyear;

select day("2017-08-31") as day,
month("2017-08-31") as month,
quarter("2017-08-31") as quarter,
year("2017-08-31") as year;

select date_add("2017-09-07", interval 1 day) as 1_day_later,
date_sub("2017-09-08", interval 1 week) as 1_week_later,
datediff("2017-05-21", "2014-05-21") as days_between,
date_format("2014-05-09", "%Y/%m/%d") as new_date;

create table if not exists tickets(
id int auto_increment primary key,
generate_time time
);

insert into tickets (generate_time) values("05:23:32");
insert into tickets (generate_time) values("5:3:2");
insert into tickets (generate_time) values("221127");
insert into tickets (generate_time) values(055332);

select current_time(), utc_time();
select time_format(generate_time, "%h:%i %p") as time from tickets;
select current_time() as string_format_time, current_time()+0 as numerical_format_time;

select generate_time, hour(generate_time) h, minute(generate_time) m, second(generate_time) s from tickets;
select timediff("23:11:28", "02:04:09") as time_gap;

