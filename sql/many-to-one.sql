create table locations(
    id serial primary key,
    country varchar(255),
    city varchar(255)
);
create table persons(
    id serial primary key,
    name varchar(255),
    location_id int references locations(id)
);

insert into locations(country, city) values ('USA', 'Washington');
insert into locations(country, city) values ('Russia', 'Moscow');
insert into locations(country, city) values ('France', 'Paris');
insert into locations(country, city) values ('Japan', 'Tokyo');

insert into persons(name, location_id) values ('Nick', 1);
insert into persons(name, location_id) values ('Mark', 1);
insert into persons(name, location_id) values ('Alexey', 2);
insert into persons(name, location_id) values ('Dmitry', 2);
insert into persons(name, location_id) values ('Louise', 3);

select * from persons;
select * from locations where id in (select location_id from persons);
