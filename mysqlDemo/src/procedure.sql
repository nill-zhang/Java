use mysqljdbc;
drop procedure if exists getAllSkills;
drop procedure if exists getAvailableSkills;
drop procedure if exists getCandidateSkills;
drop procedure if exists getCandidateSkillsCount;
drop procedure if exists increaseAverageSalary;
drop procedure if exists getCandidateRanking;

select * from mysqljdbc.candidate_skills;

select avg(min_salary) from table1.jobs;
delimiter %
create procedure getAvailableSkills()
    begin
        select name from skills;
    end %
    
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

create procedure getCandidateRanking(in cid int(4), out ranking varchar(200))
    begin
         declare skills_count smallint(4) default 0;
         select count(*)  into skills_count from candidate_skills where candidate_id = cid;
         
         case skills_count
         when 0 then set ranking = "entry";
		 when 1 then set ranking = "entry";
		 when 2 then set ranking = "junior";
		 else set ranking = "senior";
		 end case;
         
		# the following will do the same thing
        
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


set @inc = 500;
call table1.increaseAverageSalary(@inc);
select @inc;