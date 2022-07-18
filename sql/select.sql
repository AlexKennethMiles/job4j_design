create table fauna(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('dog', 4383, null);
insert into fauna(name, avg_age, discovery_date) values ('fish', 2191, null);
insert into fauna(name, avg_age, discovery_date) values ('dog', 5479, null);
insert into fauna(name, avg_age, discovery_date) values ('human', 25567, '01.01.1829');
insert into fauna(name, avg_age, discovery_date) values ('panda', 7304, '01.01.1869');
insert into fauna(name, avg_age, discovery_date) values ('alligator', 14610, '01.01.1801');

select * from fauna where name like '%fish%';
select * from fauna where avg_age>=10000 and avg_age<=21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date<'01-01-1950';
