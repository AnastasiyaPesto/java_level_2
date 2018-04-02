create database if not exists employees;
use employees;

drop table if exists employee_info;
drop table if exists employee;

create table if not exists employee (
	employee_id int primary key auto_increment,
    login varchar(6) not null unique,
    name varchar(30) not null,
    last_name varchar(30) not null,
    email varchar(40) not null
);

create table if not exists employee_info(
	-- em.ployee_info_id int primary key auto_increment,
    age int,
    position varchar(40) not null,
    sex boolean,
    internal_telephone varchar(40),
    employee_id int primary key,
    foreign key (employee_id) references employee(employee_id) 
);

insert into employee 
values 
	(1, "anapes", "Anastasiya", "Pestovnikova", "pestovnikova2013@gmail.com"),
    (2, "olvolo", "Vladimir", "Ivanov", "v.ivanov@mail.ru");
    
insert into employee_info 
values
	(45, "Уборщик", true, "3214", 2),
    (25, "Программист", true, "2341", 1);
    
select * from employee;
select * from employee_info; 
