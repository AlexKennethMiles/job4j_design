insert into role(name) values ('Admin');
insert into role(name) values ('Owner');
insert into role(name) values ('Editor');
insert into role(name) values ('Viewer');

insert into users(name, role_id) values ('Nick', 2);
insert into users(name, role_id) values ('Marco', 3);
insert into users(name, role_id) values ('Artyom', 1);
insert into users(name, role_id) values ('Minato', 2);
insert into users(name, role_id) values ('Alexey', 2);
insert into users(name, role_id) values ('Joseph', 4);
insert into users(name, role_id) values ('Christopher', 4);
insert into users(name, role_id) values ('Anthony', 4);
insert into users(name, role_id) values ('Ryan', 4);

insert into rules(access_level) values (0);
insert into rules(access_level) values (1);
insert into rules(access_level) values (2);
insert into rules(access_level) values (3);

insert into role_rules(role_id, rule_id) values (1, 1);
insert into role_rules(role_id, rule_id) values (1, 2);
insert into role_rules(role_id, rule_id) values (1, 3);
insert into role_rules(role_id, rule_id) values (1, 4);
insert into role_rules(role_id, rule_id) values (2, 2);
insert into role_rules(role_id, rule_id) values (2, 3);
insert into role_rules(role_id, rule_id) values (2, 4);
insert into role_rules(role_id, rule_id) values (3, 3);
insert into role_rules(role_id, rule_id) values (3, 4);
insert into role_rules(role_id, rule_id) values (4, 4);

insert into category(name) values ('Purchase');
insert into category(name) values ('Repair');
insert into category(name) values ('Rent');
insert into category(name) values ('Consultation');

insert into state(type) values ('In processing');
insert into state(type) values ('Approval');
insert into state(type) values ('Rejected');

insert into item(content, user_id, category_id, state_id) values ('Motocycle', 1, 1, 1);
insert into item(content, user_id, category_id, state_id) values ('TV', 2, 1, 1);
insert into item(content, user_id, category_id, state_id) values ('Car', 3, 2, 1);
insert into item(content, user_id, category_id, state_id) values ('Car', 3, 4, 2);
insert into item(content, user_id, category_id, state_id) values ('Apartment', 4, 3, 2);
insert into item(content, user_id, category_id, state_id) values ('Bicycle', 5, 3, 2);
insert into item(content, user_id, category_id, state_id) values ('Powerbank', 6, 3, 2);
insert into item(content, user_id, category_id, state_id) values ('Physics', 7, 4, 1);
insert into item(content, user_id, category_id, state_id) values ('Mathematics', 8, 4, 3);
insert into item(content, user_id, category_id, state_id) values ('Smartphone', 9, 2, 3);

insert into comments(content, item_id) values ('A great birthday gift', 1);
insert into comments(content, item_id) values ('A problem has been identified, repairs are being carried out', 3);
insert into comments(content, item_id) values ('Convenient bicycle', 6);
insert into comments(content, item_id) values ('Very complex subject', 8);
insert into comments(content, item_id) values ('Accidentally fell and began to brake', 10);

insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9PI', 1);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P1', 2);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P2', 3);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P2', 4);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P3', 5);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P4', 6);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P5', 7);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9P7', 8);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9OJ', 9);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9OV', 9);
insert into attachs(link_to_file, item_id) values ('https://pastenow.ru/HO9PF', 10);
