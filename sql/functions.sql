create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Smartphone', 599.99);
insert into devices(name, price) values ('Lawnmover', 1068.50);
insert into devices(name, price) values ('Air conditioning', 1200.00);
insert into devices(name, price) values ('Humidifier', 69.95);

insert into people(name) values ('Alexandr');
insert into people(name) values ('Dmitry');
insert into people(name) values ('Artyom');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (3, 1);
insert into devices_people(device_id, people_id) values (4, 1);
insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (1, 3);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (4, 3);

select avg(price) from devices;

select p.name, avg(price) from devices_people dp
inner join people p on dp.people_id=p.id
inner join devices d on dp.device_id=d.id
group by p.name;

select p.name, avg(price) from devices_people dp
inner join people p on dp.people_id=p.id
inner join devices d on dp.device_id=d.id
group by p.name
having avg(price)>650;
