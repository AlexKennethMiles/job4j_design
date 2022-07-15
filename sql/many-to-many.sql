create table employees(
    id serial primary key,
    name varchar(255),
    age int
);
create table vehicles(
    id serial primary key,
    title varchar(255),
    type varchar(255)
);
create table employee_vehicle(
    id serial primary key,
    employee_id int references employees(id),
    vehicle_id int references vehicles(id)
);

insert into employees(name, age) values ('Liam', 25);
insert into employees(name, age) values ('Mason', 27);
insert into employees(name, age) values ('William', 19);

insert into vehicles(title, type) values ('tractor', 'agriculture');
insert into vehicles(title, type) values ('bus', 'public transport');
insert into vehicles(title, type) values ('atv', 'entertainment');

insert into employee_vehicle(employee_id, vehicle_id) values (1, 2);
insert into employee_vehicle(employee_id, vehicle_id) values (2, 1);
insert into employee_vehicle(employee_id, vehicle_id) values (3, 3);

select * from employees;
select * from vehicles;
select * from employee_vehicle;
