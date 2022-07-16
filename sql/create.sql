create table role(
    id serial primary key,
    name varchar(255)
);
create table users(
    id serial primary key,
    name varchar(255),
    role_id int references role(id)
);
create table rules(
    id serial primary key,
    access_level int4
);
create table role_rules(
    id serial primary key,
    role_id int4 references role(id),
    rule_id int4 references rules(id)
);
create table category(
    id serial primary key,
    name varchar(255)
);
create table state(
    id serial primary key,
    type varchar(255)
);
create table item(
    id serial primary key,
    content varchar(255),
    user_id int4 references users(id),
    category_id int4 references category(id),
    state_id int4 references state(id)
);
create table comments(
    id serial primary key,
    content varchar(255),
    item_id int4 references item(id)
);
create table attachs(
    id serial primary key,
    link_to_file varchar(255),
    item_id int4 references item(id)
);
