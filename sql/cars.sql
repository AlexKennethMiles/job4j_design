create table car_bodies(
    id serial primary key,
    name varchar(255)
);
create table car_engines(
    id serial primary key,
    name varchar(255)
);
create table car_transmissions(
    id serial primary key,
    name varchar(255)
);
create table cars(
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('кроссовер');
insert into car_bodies(name) values ('внедорожник');
insert into car_bodies(name) values ('пикап');
insert into car_bodies(name) values ('хетчбэк');
insert into car_bodies(name) values ('седан');
insert into car_bodies(name) values ('минивен');
insert into car_bodies(name) values ('родстер');
insert into car_bodies(name) values ('кабриолет');
insert into car_bodies(name) values ('купе');
insert into car_bodies(name) values ('лимузин');

insert into car_engines(name) values ('бензиновый');
insert into car_engines(name) values ('дизельный');
insert into car_engines(name) values ('гибридный');
insert into car_engines(name) values ('электродвигатель');

insert into car_transmissions (name) values ('механическая');
insert into car_transmissions (name) values ('автоматическая');
insert into car_transmissions (name) values ('роботизированная');
insert into car_transmissions (name) values ('бесступенчатая');

insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто A', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто B', 2, 1, 2);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто C', 3, 2, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто D', 4, 2, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто E', 5, 3, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто F', 6, 3, 2);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто G', 7, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто H', 8, 1, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Авто I', 9, 2, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Разобранная машина', 9, null, 3);
insert into cars(name, body_id, engine_id, transmission_id)
values ('Сломанная машина', 9, null, null);

select c.name "Название машины", b.name Кузов,
e.name Двигатель, t.name Трансмиссия
from cars c left join car_bodies b on c.body_id=b.id
left join car_engines e on c.engine_id=e.id
left join car_transmissions t on c.transmission_id=t.id;

select b.name
from car_bodies b
left join cars c on b.id=c.body_id
where c.body_id is null;

select e.name
from car_engines e
left join cars c on e.id=c.engine_id
where c.engine_id is null;

select t.name
from car_transmissions t
left join cars c on t.id=c.transmission_id
where c.transmission_id is null;
