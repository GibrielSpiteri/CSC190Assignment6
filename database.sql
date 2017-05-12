# To run it:
# mysql -u root -p < database.sql
# enter pwd: goodyear123!@#

DROP DATABASE IF EXISTS emp_db;
CREATE DATABASE emp_db;
USE emp_db;
CREATE TABLE employees(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	emplist TEXT
);
INSERT INTO employees (name, emplist) VALUES ("name", "INVALIDVAL");
