create table country(
    id serial primary key,
    name varchar(255)
);
create table city(
    id serial primary key,
    name varchar(255),
    country_id int references country(id)
);

insert into country(name) values ('Russia');
insert into country(name) values ('USA');
insert into country(name) values ('Japan');

insert into city(name, country_id) values ('Saint-Petersburg', 1);
insert into city(name, country_id) values ('Moscow', 1);
insert into city(name, country_id) values ('Norilsk', 1);
insert into city(name, country_id) values ('Massachusetts', 2);
insert into city(name, country_id) values ('Texas', 2);
insert into city(name, country_id) values ('Detroid', 2);
insert into city(name, country_id) values ('Tokyo', 3);
insert into city(name, country_id) values ('Kyoto', 3);
insert into city(name, country_id) values ('Yokosuka', 3);

select co.name, c.name
from country as co inner join city as c on c.country_id=co.id;
select co.name as Страна, c.name as Город
from country as co inner join city as c on c.country_id=co.id;
select co.name Страна, c.name "Место базирования"
from country co join city c on c.country_id=co.id;