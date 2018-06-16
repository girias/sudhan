DROP TABLE IF EXISTS 'invoice';

CREATE TABLE 'invoice'
(
'id' int(11) NOT NULL AUTO_INCREMENT,
'customer_name' varchar(30) DEFAULT NULL,
'payment_attempts' int(11) DEFAULT NULL,
'total_amount' double NULL,
'balance' double DEFAULT NULL,
'status' varchar(30) DEFAULT NULL,
PRIMARY KEY ('id')
);

insert into invoice(customer_name,payment_attempts,total_amount,balance,status)values
('Shravan',1,45000.0,30000.00,'Pending'),
('Rafael',0,5000.0,5000.0,'Pending'),
('Tori',1,800.0,200.0,'Pending'),
('John',0,15000.2,10000.0,'Pending'),
('jack',0,900.0,900.0,'Pending'),
('Rosy',1,1000.0,500.0,'Pending'),
('Roger',2,3000.0,2000.0,'Pending'),
('Steffi',1,1000.0,500.0,'Pending'),
('Nadal',1,2000.0,1000.0,'Pending'),
('Federer',0,1000.0,1000.0,'Pending');