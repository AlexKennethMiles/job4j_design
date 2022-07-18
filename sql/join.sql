create table departments(
    id serial primary key,
    name varchar(255)
);
create table employees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('HR');
insert into departments(name) values ('IT');
insert into departments(name) values ('Marketing');
insert into departments(name) values ('Sales');
insert into departments(name) values ('Idleness');

insert into employees(name, department_id) values ('Максим Комаров', 1);
insert into employees(name, department_id) values ('Виктория Смирнова', 1);
insert into employees(name, department_id) values ('Андрей Баранов', 1);
insert into employees(name, department_id) values ('Алиса Иванова', 2);
insert into employees(name, department_id) values ('Василиса Сергеева', 2);
insert into employees(name, department_id) values ('Яна Кузнецова', 2);
insert into employees(name, department_id) values ('Роман Алексеев', 3);
insert into employees(name, department_id) values ('Маргарита Полякова', 3);
insert into employees(name, department_id) values ('Роман Алексеев', 4);
insert into employees(name, department_id) values ('Милана Кириллова', 4);
insert into employees(name, department_id) values ('Вероника Исакова', 4);

select d.name, e.name
from departments d left join employees e
on d.id=e.department_id;

select d.name, e.name
from departments d right join employees e
on d.id=e.department_id;

select d.name, e.name
from departments d full join employees e
on d.id=e.department_id;

select d.name, e.name
from departments d cross join employees e;

select d.name, e.name
from departments d left join employees e
on d.id=e.department_id
where e.name is null;

select d.name, e.name
from departments d left join employees e
on d.id=e.department_id;
select d.name, e.name
from employees e right join departments d
on d.id=e.department_id;

create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) values ('Дарья Иванова', 'Female');
insert into teens(name, gender) values ('Даниил Васильев', 'Male');
insert into teens(name, gender) values ('Александр Львов', 'Male');
insert into teens(name, gender) values ('Ольга Ширяева', 'Female');
insert into teens(name, gender) values ('Евгений Егоров', 'Male');
insert into teens(name, gender) values ('Ирина Бирюкова', 'Female');

select t1.name, t2.name
from teens t1 cross join teens t2
where t1.gender!=t2.gender;
