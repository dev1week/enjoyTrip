use enjoytrip;

create table board
(
	article_no INT NOT NULL AUTO_INCREMENT primary key,
	user_id VARCHAR(16) NULL DEFAULT NULL,
    subject VARCHAR(100) NULL DEFAULT NULL,
    content VARCHAR(2000) NULL DEFAULT NULL,
    register_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    hit INT DEFAULT 0 NOT NULL
);

select * from board;

create table members(
user_id varchar(20) not null primary key, 
user_name varchar(20) not null, 
user_pass varchar(20) not null, 
joinDate varchar(20) not null);

select * from members;

