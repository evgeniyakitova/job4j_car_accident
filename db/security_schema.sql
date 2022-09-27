CREATE TABLE authorities (
     id serial primary key,
     authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users (
     id serial primary key,
     username VARCHAR(50) NOT NULL unique,
     password VARCHAR(100) NOT NULL,
     enabled boolean default true,
     authority_id int not null references authorities(id)
);

insert into authorities (authority) values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id) values
('root', true, '{bcrypt}$2a$10$bgIKuLIt0W0LB9W/9TFZDukXi62oHYnMt4MBoTpGKXVzo2mS4S8.6',
(select id from authorities where authority = 'ROLE_ADMIN'));