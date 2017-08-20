show processlist;
set global event_scheduler = on;
drop event if exists one_time_event_now;
drop event if exists one_time_event_1minutelater;
drop event if exists recuring_event;


use mysqljdbc;
create table if not exists message(
    message_id int auto_increment primary key not null,
    message_text varchar(255) not null,
    create_time timestamp not null default current_timestamp
);

create event if not exists one_time_event_now 
on schedule at current_timestamp
# keep the event in the system after its execution
on completion preserve
do 
    insert into message(message_text, create_time) values("one_time_event_now generated message", now());

create event if not exists one_time_event_1minutelater 
on schedule at current_timestamp + interval 1 minute
on completion preserve
do 
    insert into message(message_text, create_time) values("one_time_event_1minutelater generated message", now());

create event if not exists recuring_event 
on schedule every 1 minute 
# notice that 2 minute and 30 minutes instead of minutes
starts current_timestamp + interval 2 minute
ends current_time + interval 30 minute
do 
    insert into message(message_text, create_time) values("recuring_event generated message", now());

show processlist;
# show all the events associated with a database
show events from mysqljdbc;
select * from message;
alter event one_time_event_now
disable;

alter event recuring_event
on schedule every 5 minute
starts current_timestamp
ends current_timestamp + interval 1 hour
on completion not preserve;

alter event one_time_event_1minutelater
rename to one_time_event_one_minute_later;


