DROP TABLE IF EXISTS invoice;

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
id int(11) NOT NULL AUTO_INCREMENT,
username varchar(100) DEFAULT NULL,
password varchar(100) DEFAULT NULL,
address varchar(45) DEFAULT NULL,
role varchar(100) DEFAULT NULL,
PRIMARY KEY (id)
);

CREATE TABLE invoice
(
id int(11) NOT NULL AUTO_INCREMENT,
invoice_number varchar(45) DEFAULT NULL,
status varchar(45) DEFAULT NULL,
amount int(11) DEFAULT NULL,
created_date date DEFAULT NULL,
user_id int(11) DEFAULT NULL,
PRIMARY KEY (id),
KEY user_id (user_id),
CONSTRAINT invoice_ibfk_1 FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO 'user' VALUES (1,'maddy','Boston', 'Clerk'),(2,'johnsmith','Buffalo','Payment Releaser')

INSERT INTO 'invoice' VALUES (1,'INV744','Approved',45000,'2017-05-12',3),(2,'INV112','Paid',12000,'2017-04-01',10)