use northwind;

# method 1:
alter table orders add fulltext(shipname);
# note the single quote, coma means orstudents`PRIMARY`
select orderid, shipname from orders where match(shipname) against('world, chinese');

# method 2:
drop table if exists students;
create table students(
    studentid int(11) primary key not null,
    studentname varchar(40) not null,
    studentdescription varchar(255) default null,
    studentskill varchar(255),
    age smallint not null,
    fulltext(studentdescription, studentskill)
);

insert into students values
(100, "Alexander Keith Zhang", "He is a very good guy, gentle, friendly, always helpful", "c++, python, java, mysql", 18),
(101, "Shaofeng Zhang", "a shy guy with excellent math skills and good at tabletennis and soccer","javascript, php, linux, perl, scala", 19),
(102, "Novadisky Zhang Fang", "nickname machine, energetic and enthusiastic, always has passion for things that he loves", "ansible, python, postgre, tcp/ip", 20),
(103, "Stipolov Akilis Enrique", " a secret guy, very quiet sometimes, not social, have few friends in our class", "golang, vim, vmware, office",21),
(104, "Ronaldo Luis Naralio De Lima", "He is a big fan of Ronaldo and Rivaldo, a brazilian, very skilled at beach soccer", "excel, eclipse, netbeans, css, html",23);

select studentname, studentdescription from students where match(studentdescription, studentskill) against('good');

# method 3:
create fulltext index sname on students(studentname);
select studentname, age from students where match(studentname) against('zhang');

# The minimum length of the search term defined in MySQL full-text search engine is 4. 
# It means that if you search for the keyword whose length is less than 4 e.g., car, cat, etc.,
# you will not get any results.
select studentname, age from students where match(studentname) against('zha');

create fulltext index sskill on students(studentskill);
select studentname, studentskill from students where match(studentskill) against('java');
select studentname, studentskill from students where match(studentskill) against('java' with query expansion);

# with query expansion only works for short words, not parts of words
select studentname, studentskill from students where match(studentskill) against('pyth');
select studentname, studentskill from students where match(studentskill) against('pyth' with query expansion);



# by default, full text is in natural language mode, you can explore boolean mode.
select * from customers;
select * from employees;
select * from orders;