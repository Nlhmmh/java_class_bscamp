DROP DATABASE IF EXISTS employeedb;
CREATE DATABASE employeedb;

-- For relation with employee
USE employeedb;
CREATE TABLE department (
	id   INT UNSIGNED NOT NULL,
    department_res  VARCHAR(50) NOT NULL,
    created_at      DATE,
    PRIMARY KEY (id)
);
INSERT INTO department (id,created_at,department_res) VALUES 
(1,CURRENT_DATE(),'Administration'),
(2,CURRENT_DATE(),'Techinal Support'),
(3,CURRENT_DATE(),'Design'),
(4,CURRENT_DATE(),'Coding'),
(5,CURRENT_DATE(),'Testing')
;