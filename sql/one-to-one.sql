create table dna(
    id serial primary key,
    dna_code bigint
);
create table persons(
    id serial primary key,
    name varchar(255),
    dna_id int references dna(id) unique
);

insert into dna(dna_code) values (6906547584516019);
insert into dna(dna_code) values (9610621281292597);
insert into dna(dna_code) values (3583916398085795);
insert into dna(dna_code) values (2944870170601598);

insert into persons(name, dna_id) values ('Mark', 3);
insert into persons(name, dna_id) values ('Ivan', 1);
insert into persons(name, dna_id) values ('Henry', 2);

select * from persons;
select * from dna where id in (select dna_id from persons);
