drop trigger if exists mysqljdbc.candidates_before_update;

delimiter %

create table if not exists candidates_update_audit(
    cid int primary key not null,
    old_name varchar(255),
    new_name varchar(255),
    timeofchange date,
    operation varchar(255)
)%

create trigger candidates_before_update before update on candidates
    for each row
    begin
	    insert into candidates_update_audit 
        set cid = old.id, 
		new_name = concat(new.first_name," ",new.last_name),
        old_name = concat(old.first_name," ",old.last_name),
        timeofchange = now(), 
        operation = "update";
    end %

update candidates set first_name = "Alexander",
                  last_name = "Keith", 
                  dob = "1952-02-05", 
                  phone = "647-779-5321",
                  email = "alexander.k@ciktel.com"
                  where id = 133 %

select * from mysqljdbc.candidates_update_audit;
show triggers;

delimiter ;