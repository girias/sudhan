drop table if exists order_line;

drop table if exists item;
create table item(id int(11) auto_increment primary key,
name varchar(26) not null,
available_quantity int(11) not null,
price double);

drop table if exists purchase_order;
create table purchase_order(id int(11) auto_increment primary key,
order_date date not null,
created_date date not null,
number_of_items int(11) not null,
total_amount double not null,
customer_name varchar(26) not null,
mobile_number varchar(20) not null);

create table order_line(id int(11) auto_increment primary key,
price double not null,
quantity int(11) not null,
item_id int(11) not null,
purchase_order_id int(11) not null,
foreign key(item_id) references item(id),
foreign key(purchase_order_id)references purchase_order(id));

insert into item(name,available_quantity,price)values
('Hp Computer',10,22000.0),
('Laptops',15,32000.0),
('Air Conditioner',12,40000.0),
('Mouse',10,700),
('Sense Monitor',20,10000),
('Wireless Mouse',25,1500),
('Hp Charger',10,4000),
('Television',12,24000),
('Led Monitor',5,30000),
('Glass',12,4000);
