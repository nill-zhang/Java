use mysqljdbc;
drop procedure if exists getAllSkills;
drop procedure if exists getAvailableSkills;
drop procedure if exists getCandidateSkills;
drop procedure if exists getCandidateSkillsCount;
drop procedure if exists increaseAverageSalary;
drop procedure if exists getCandidateRanking;
drop procedure if exists countGmailUser;
drop procedure if exists insertDuplicateKeys;
drop procedure if exists signalDemo;
drop function if exists getCandidateBirthSeason;

desc mysqljdbc.candidates;
select * from mysqljdbc.candidates;


# if you don't initialize a variable, it will get a null default value, any operations on this variable will
# get null, null can only evaluated by is.
select sum(null+1+1+1+1) is null;
select * from mysqljdbc.candidates;

select "andy.ledway3@gmail.com" like "%gmail.com";

select avg(min_salary) from table1.jobs;
delimiter %

# notes that it is returns not return 
create function getCandidateBirthSeason(cid int(8)) returns varchar(255) deterministic
    begin
         declare birth_date date;
         declare season varchar(255) default "";
         select dob into birth_date from candidates where id = cid;
         if birth_date >= 1980-03-31 then set season = "spring"; end if;
         if birth_date >= 1980-06-30  and birth_date < 1980-03-31 then set season = "summer"; end if;
         if birth_date >= 1980-09-30 and birth_date < 1980-06-30 then set season = "autumn"; end if;
         if birth_date < 1980-09-30 then set season = "winter"; end if;
         return (season);
    
    
    end%

# drop procedure if exists getAvailableSkills%
create procedure getAvailableSkills()
    begin
        select name from skills;
    end %
# drop procedure if exists getCandidateSkills%
create procedure getCandidateSkills(in cid int(4))
    begin
        select c.first_name, c.last_name, s.name from candidates c 
        join candidate_skills cs on c.id = cs.candidate_id
        join skills s on cs.skill_id = s.id
        where c.id = cid;
	end %
    
create procedure getCandidateSkillsCount(in cid int(4), out count int(4))
    begin
        select count(*) into count from candidate_skills where candidate_id = cid;
    end %

create procedure countGmailUser(inout count int(4))
    begin
        # variable declaration must before cursor or handler declaration

        declare done int(4) default 0;
        declare email varchar(255) default "";
        declare email_cursor cursor for select email from mysqljdbc.candidates;
        declare continue handler for not found set done = 1;
        open email_cursor;
        repeat 
            fetch email_cursor into email;
            if email like '%gmail.com' then set count = count + 1;
            end if;
        until done = 1
        end repeat;
        
	    # count_email: loop
			
            ## if cursor has more than one columns, you can fetch it into multiple destinations
            # fetch email_cursor into email;
            # if done then leave count_email;
            # end if;
            
			# if email like '%gmail.com' then set count = count + 1;
            # end if;
            
       #  end loop;
        
        close email_cursor;
    end %


create procedure insertDuplicateKeys(in id int(11))
    begin
        # a readable alias for your error code
        # note that, condition declaration must be ahead of handler or cursor
        # otherwise, you will get Error Code: 1337. Variable or condition declaration after cursor or handler declaration
        declare duplicate_keys condition for 1062;
        
        declare exit handler for sqlexception 
            begin
				rollback;
                select "an exception has occured";
			end;
        declare continue handler for sqlstate "23000" select "sql state 23000 has occured!";
        
        
        declare continue handler for duplicate_keys select concat("a  key ",id," already exists, pls check") as 'error info';
        
        # this will invoke error code:1054-->Unknown column 'cid' in 'field list'
        # select cid from candidates;
        
        # this will invoke the 1062 error code action
		insert into candidates values(id, "Bingo", "Leung", "1982-03-01", "647-524-5987", "bingo.w@ciktel.com");
        
        # this will invoke an exception
        # insert into candidates values();
    end%

create procedure signalDemo()
    begin
        declare flag int(4) default 0;
        declare duplicate_key condition for sqlstate '23000';
        declare continue handler  for duplicate_key 
        # You must use the RESIGNAL  statement within an error or warning handler
        # otherwise, you will get an error message saying that “RESIGNAL when handler is not active”. 
        # Notice that you can use SIGNAL  statement anywhere inside a stored procedure.
        resignal set message_text = 'a message from resignal';
        
        
        # Notice that the SIGNAL statement must always specify a SQLSTATE value 
        # or a named condition that defined with an  SQLSTATE value.
        # this means that signal is always involved with sqlstate.
        set flag = 1;
        if flag = 1 then signal duplicate_key; end if;
    end%


create procedure getCandidateRanking(in cid int(4), out ranking varchar(200))
    begin
         declare skills_count smallint(4) default 0;
         select count(*)  into skills_count from candidate_skills where candidate_id = cid;
		
        # search-case
		case
		when   skills_count >= 3      then set ranking = "senior";
		when   skills_count >= 2      then set ranking = "junior";
		else                          set ranking = "entry";
		end case;
		
        # the following  2 blocks will do the same thing
	
		# case skills_count
		# when 0 then set ranking = "entry";
		# when 1 then set ranking = "entry";
		# when 2 then set ranking = "junior";
		# else set ranking = "senior";
		# end case;
	
		
        # if       skills_count >= 3      then set ranking = "senior";
		# elseif   skills_count >= 2      then set ranking = "junior";
		# else                            set ranking = "entry";
		# end if;
    
    end %


delimiter ;

# add a stored procedure to table1
use table1;
drop procedure if exists increaseAverageSalary;
delimiter %
create procedure increaseAverageSalary(inout amount float)
begin
		declare originalAvg decimal(6,2);
        set originalAvg = 0;
        select avg(min_salary) into originalAvg from jobs;  
        set amount = amount + originalAvg;
end%

delimiter ;
#call getAvailableSkills();
call mysqljdbc.getCandidateSkills(133);
# inside the procedure, everytime you assign a new value to a variable or out parameter
# you have to use set. or you can just use select into like i did in getCandidateSkillsCount
# when use out or inout parameter outside the procedure 
# you have to add a @ before that parameter whenever you use that parameter.
call mysqljdbc.getCandidateSkillsCount(133, @count);
select @count;

call mysqljdbc.getCandidateRanking(133, @level);
select @level;

call mysqljdbc.insertDuplicateKeys(133);

set @c = 0;
call mysqljdbc.countGmailUser(@c);
select @c as 'number Of Gmail Users';

call mysqljdbc.signalDemo();

set @inc = 500;
call table1.increaseAverageSalary(@inc);
select @inc;


# call the function wherever a expression fits.
select concat("133 was born at ", mysqljdbc.getCandidateBirthSeason(133));
select * from mysqljdbc.candidates;
select first_name, last_name, mysqljdbc.getCandidateBirthSeason(id)  from mysqljdbc.candidates;

show procedure status;
show procedure status where db = "table1";
show procedure status where db = "hr";
show procedure status where name like '%count%';

# get the source code of the procedure
show create procedure mysqljdbc.countGmailUser;