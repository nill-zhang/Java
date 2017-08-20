# in this script, we create multiple triggers on products
# one trigger will populate change_log once an update happens to products
# one trigger will populate user_log once an update happens to products
# change_log  get updated before user_log

use northwind;
# triggers are associated with database,not table, therefore products.products_before_update_1 is not valid
drop trigger if exists northwind.products_before_update_1;
drop trigger if exists northwind.products_before_update_2;

delimiter %

create table if not exists products_change_log(
    changeid int auto_increment primary key not null,
    product_id int(11) not null,
    old_price decimal(10,4) not null,
    change_time timestamp default current_timestamp  not null,
    foreign key (product_id) references products (ProductID)
    on update cascade
    on delete cascade
)%

create table if not exists products_change_user_log(
    
    changeid int auto_increment primary key not null,
    product_id int(11) not null,
    change_time timestamp default current_timestamp not null,
    changed_by varchar(50) not null,
    foreign key (product_id) references products (productid)
    on update cascade
    on delete cascade


)%

create trigger products_before_update_1 before update on products for each row
    begin
        insert into products_change_log (product_id, old_price)values(old.productid, old.unitprice);
    end %
    
# follows or precedes determine the execute sequence
create trigger products_before_update_2 before update on products for each row follows products_before_update_1
    begin
        insert into products_change_user_log (product_id, changed_by) values(old.productid, user());
    end %

select * from northwind.products;
update products set unitprice = 2000.00 where productname = "Tofu";
update products set unitprice = 1111.00 where productname = "Tofu";
select * from products_change_log;
select * from products_change_user_log;

# you need to have the super privilege to execute show triggers;
show triggers;
show triggers from northwind;
show triggers from mysqljdbc;
# note that a back stick is used here to avoid conflicts with reserved sql keyword.
show triggers from northwind where `trigger` = "products_before_update_1";
show triggers from mysqljdbc where `table` = "candidates";

select * from information_schema.triggers;
select trigger_name, action_order from information_schema.triggers where trigger_schema = "northwind";
# select all the triggers from a specific database;
select * from information_schema.triggers where trigger_schema = 'northwind'

# select triggers based on the trigger_name
select * from information_schema.triggers where trigger_schema = 'northwind' and trigger_name = 'products_before_update_1';

# select triggers based on the table on which triggers operate
select trigger_name from information_schema.triggers where event_object_table='products';

delimiter ;