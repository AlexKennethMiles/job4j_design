create table vehicle(
    id serial primary key,
    type varchar(255),
    weight float4,
    cost money
);
select * from vehicle;
insert into vehicle(type, weight, cost) values('truck', 17.5, 390000);
insert into vehicle(type, weight, cost) values('truck', 17.5, 390000);
select * from vehicle;
update vehicle set weight=20.0, cost=395500 where id=1;
update vehicle set weight=16.5, cost=370000 where id=2;
select * from vehicle;
delete from vehicle;
select * from vehicle;