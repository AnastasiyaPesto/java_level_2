use employees;
 
select * from employee emp, employee_info empi
where emp.employee_id = empi.employee_id;

select * from employee 
inner join employee_info on employee.employee_id = employee_info.employee_id
order by login desc;