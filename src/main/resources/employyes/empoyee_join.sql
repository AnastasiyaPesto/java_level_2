use employees;

select * from department;
 
select * from department where department_id = 2; ;
 
select * from employee emp, employee_info empi
where emp.employee_id = empi.employee_id;

select * from employee 
inner join employee_info on employee.employee_id = employee_info.employee_id
order by login desc;

select * from employee
left join employee_info on employee.employee_id = employee_info.employee_id;

select * from employee_info
right join employee on employee.employee_id = employee_info.employee_id;