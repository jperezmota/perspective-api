insert into users
values 
('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1);

insert into authorities 
values 
('admin', 'ROLE_ADMIN');

insert into authors 
(name, created_by, created_date)
values
('Brendon Burchard', 'admin', curdate()),
('Jim Rohn', 'admin', curdate());

insert into categories 
(name, created_by, created_date)
values
('Leadership', 'admin', curdate()),
('Business', 'admin', curdate()),
('Self-Help', 'admin', curdate()),
('Team Work', 'admin', curdate()),
('Relationship', 'admin', curdate());

insert into perspectives 
(perspective, author_id, category_id, created_by, created_date) 
values 
("You didn't lose your motivation. You stopped focusing on what you are fighting for.", 1, 3, 'admin', curdate()),
("Is not what you want, is what you deserve by giving.", 2, 3, 'admin', curdate());