use employees;

insert into department
values
 (1, "Dev", "SPb"),
 (2, "Law", "Moscow"),
 (3, "Cleaners", "SPb"),
 (4, "Marketing", "Voronezh");

insert into employee 
values 
	(1, "anapes", "Anastasiya", "Pestovnikova", "pestovnikova2013@gmail.com", 1)
  , (2, "olvolo", "Vladimir", "Ivanov", "v.ivanov@mail.ru", 3)
  , (3, "qwerty", "Irina", "Tatarins", "tatir@yandex.ru", 4)
  , (4, "vollog", "Vova", "Log", "log.vov@gmail.com", 1)
  , (5, "ivaxen", "Ivan", "Zentsov", "zenit@yandex.ru", 2)
  , (6, "vasuso", "Vasya", "Usov", "vasil@mail.ru", 1);
  
insert into employee_info 
values
	(45, "Уборщик", true, "3214", 3)
  , (25, "Программист", true, "2341", 1)
  , (54, "Маркетолог", false, "6548", 4)
  , (27, "Юрист", false, "5964", 2);
    
insert into groups
values
    (1, "Admin")
  , (2, "All")
  , (3, "Laws")
  , (4, "Cleaners");

insert into employee_group
values
	(1, 1)
  , (1, 2)
  , (2, 2)
  , (2, 4)
  , (3, 2)
  , (4, 2)
  , (5, 2)
  , (6, 2);

select * from employee;
select * from employee_info; 
select * from employee_group;
select * from department;
select * from groups;
