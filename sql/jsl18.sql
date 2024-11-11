create database jsl18 default character set utf8mb4 collate utf8mb4_general_ci;
show databases;

use jsl18;
show tables;

create user 'user18'@'localhost' identified by '1234';

grant all on jsl18.* to 'user18'@'localhost';
flush privileges;