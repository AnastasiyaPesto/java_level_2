create database if not exists employees;
use employees;

drop table if exists employee_group;
drop table if exists  groups;
drop table if exists employee_info;
drop table if exists employee;
drop table if exists department;

create table if not exists department (
	department_id int primary key auto_increment,
    name varchar(100) not null,
	city varchar(50)
);

create table if not exists employee (
	employee_id int primary key auto_increment,
    login varchar(6) not null unique,
    name varchar(30) not null,
    last_name varchar(30) not null,
    email varchar(40) not null,
    department_id int not null,
    foreign key (department_id) references department(department_id)    
);

create table if not exists groups(
	group_id int primary key auto_increment,
    name varchar(60) not null unique
); 

create table if not exists employee_group(
	employee_id int not null,
    group_id int not null,
    constraint emp_group_pk primary key(employee_id, group_id),
    foreign key (employee_id) references employee(employee_id),
	foreign key (group_id) references groups(group_id)
);

create table if not exists employee_info(
	-- em1ployee_info_id int primary key auto_increment,
    age int,
    position varchar(40) not null,
    sex boolean,
    internal_telephone varchar(40),
    employee_id int primary key,
    foreign key (employee_id) references employee(employee_id) 
);

