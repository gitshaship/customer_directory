CREATE DATABASE IF NOT EXISTS piexchange;
USE piexchange;
CREATE TABLE IF NOT EXISTS customer (
    customer_id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    contact_no varchar(255) NOT NULL,
    PRIMARY KEY(customer_id)
);