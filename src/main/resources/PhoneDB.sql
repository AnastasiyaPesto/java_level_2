/* Удалить базу, если она существует*/
drop database if exists myTelephoneContacts;

/*Создать базу, если такой ещё не существует*/
create database if not exists myTelephoneContacts;

/*show databases;*/

/*Чтобы начать ползоваться БД нужно прописать через use*/
use myTelephoneContacts;
create table contacts(
/*Перечисление полей*/
	contact_id int primary key auto_increment,
    name varchar(40) not null,
    last_name varchar(40),
    phone varchar(20) not null unique,
    email varchar(30) unique
);

insert into mytelephonecontacts.contacts value 
	(1, "Дмитрий", "Процко", "+7-921-925-68-18", "dmitr.prot@gmail.com");
insert into mytelephonecontacts.contacts (name, phone) value 
	("Бабушка", "+7-911-410-80-14");

insert into mytelephonecontacts.contacts (name, last_name, phone) values
	("Иван", "Зенцов", "+7-951-658-52-74"),
    ("Олег", "Пестовников", "+7-909-571-48-38"),
    ("Наталья", "Пестовникова", "+7-960-211-20-10");

/*Получить все данные из таблицы*/
select * from mytelephonecontacts.contacts;

/*update mytelephonecontacts.contacts set last_name = "ПроцкоД" where last_name = "Процко";*/

select name, last_name from mytelephonecontacts.contacts;
select phone from mytelephonecontacts.contacts where name = "Дмитрий" or name = "Иван";
select phone from mytelephonecontacts.contacts where name in ("Дмитрий", "Иван");

delete from mytelephonecontacts.contacts where last_name = "Процко";
select * from mytelephonecontacts.contacts;
