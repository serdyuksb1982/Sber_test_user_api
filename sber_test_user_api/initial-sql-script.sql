create database users_management;

\c users_management;

create table users_table
(
id int auto_increment not null primary key,
name varchar(50),
login varchar(50),
email varchar(50),
birthday varchar(15)
);