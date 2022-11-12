DROP DATABASE IF EXISTS book_demo;
CREATE DATABASE IF NOT EXISTS book_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE book_demo;
CREATE TABLE IF NOT EXISTS book (
	id      INT UNSIGNED UNIQUE NOT NULL,
    name    VARCHAR(50) NOT NULL,
    author  VARCHAR(20),
    price   INT,
    type ENUM('adventure','comedy','technology','romance'),
    published_at DATE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY(id)
);

INSERT INTO book (id, name, author, price, type, published_at, created_at, updated_at)
VALUES
	(1,'Climbing Mt.Everest', 'Lucy',15000, 'adventure', '2020-12-01','2021-05-13 04:56:11', null),
	(2,'Adam Family', 'John',25000, 'comedy', '2020-12-02', '2021-05-13 04:56:11', null),
	(3,'Cyber Security', 'Thomas', 5000, 'technology','2020-12-03', '2021-05-13 04:56:11', null),
	(4,'John & Sue','Li Li', 15000, 'romance','2020-12-04','2021-05-13 04:56:11', null),
	(5,'test','Sam', 15000, 'adventure','2020-12-01','2021-05-13 04:56:11', null)
;