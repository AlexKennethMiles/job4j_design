create table type(
    id serial primary key,
    name varchar(255)
);
create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price float4
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('КАШИ');
insert into type(name) values ('МОРОЖЕНОЕ');

insert into product(name, type_id, expired_date, price)
values ('Сыр российский', 1, '23-09-2022', 149.99);
insert into product(name, type_id, expired_date, price)
values ('Сыр плавленный ', 1, '09-10-2022', 204.99);
insert into product(name, type_id, expired_date, price)
values ('Сыр моцарелла', 1, '15-08-2022', 165.00);

insert into product(name, type_id, expired_date, price)
values ('Молоко вологодское 3,2%', 2, '20-08-2022', 94.00);
insert into product(name, type_id, expired_date, price)
values ('Молоко 3,2% в бутылке', 2, '01-01-2023', 85.00);
insert into product(name, type_id, expired_date, price)
values ('Молоко 1,5% безлактозное', 2, '01-02-2023', 130.00);
insert into product(name, type_id, expired_date, price)
values ('Молоко невкусное', 2, '01-02-2022', 40.00);

insert into product(name, type_id, expired_date, price)
values ('Каша рисовая', 3, '01-08-2023', 165.99);
insert into product(name, type_id, expired_date, price)
values ('Каша овсяная', 3, '01-05-2023', 95.00);
insert into product(name, type_id, expired_date, price)
values ('Каша пшённая', 3, '01-03-2023', 148.00);
insert into product(name, type_id, expired_date, price)
values ('Каша странная', 3, '31-12-2021', 35.00);

insert into product(name, type_id, expired_date, price)
values ('Советское мороженое', 4, '01-01-2023', 289.99);
insert into product(name, type_id, expired_date, price)
values ('Молекулярное мороженое', 4, '01-01-2030', 1500.00);
insert into product(name, type_id, expired_date, price)
values ('Японское мороженое', 4, '01-01-2025', 650.75);
insert into product(name, type_id, expired_date, price)
values ('Прошлогоднее мороженое', 4, '01-01-2021', 100.0);

select t.name Тип, p.name Название, p.price Цена, p.expired_date "Годен до"
from product p inner join type t on p.type_id=t.id
where t.name='СЫР';

select p.name Название, p.price Цена, p.expired_date "Годен до"
from product p where p.name like '%мороженое%';

select p.name Название, p.price Цена, p.expired_date "Годен до"
from product p where p.expired_date<current_date;

select p.name Название, p.price Цена, p.expired_date "Годен до"
from product p where p.price=(select max(product.price) from product);

select t.name "Тип продукта", count(*) Количество
from product p inner join type t on p.type_id=t.id
group by t.name;

select t.name Тип, p.name Название, p.price Цена, p.expired_date "Годен до"
from product p inner join type t on p.type_id=t.id
where t.name='СЫР' OR t.name='МОЛОКО';

select t.name Тип, count(*) Количество
from product p inner join type t on p.type_id=t.id
group by t.name
having count(*)<10;

select t.name Тип, p.name Название, p.price Цена, p.expired_date "Годен до"
from product p inner join type t on p.type_id=t.id;
