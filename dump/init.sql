create table roles
(
    id   integer auto_increment primary key,
    role varchar(50) unique not null
);

alter table roles
    add index (id);

alter table users
    add column login   varchar(250) unique,
    add column role_id integer,
    add foreign key (role_id) references roles (id);

insert into roles (role)
values ('ROLE_ADMIN'),
       ('ROLE_USER'),
       ('ROLE_GUEST');

insert into company(name, create_date)
VALUES ('DIV Academy', '1994-04-25'),
       ('Azercell LLC', '1995-11-04'),
       ('Bakcell LLC', '1991-10-19'),
       ('AzTelecom', '2001-05-01'),
       ('BakTelecom', '2008-06-11'),
       ('CityNet', '2010-12-09'),
       ('Connect TV', '2015-08-02');



insert into positions (name)
values ('office manager'),
       ('marketing manager'),
       ('HR manager'),
       ('merchandiser'),
       ('security'),
       ('CEO');

insert into users (first_name, last_name, login, password, role_id, birthdate, company_id, `e-mail`)
values ('Nadir', 'Nadirli', 'admin', '12345678', 1, '1991-04-04', 2, 'nanemodeveloper@gmail.com'),
       ('Elnur', 'Aliyev', 'userelnur', '12345678', 2, '1984-01-04', 1, 'elnur@gmail.com'),
       ('Anar', 'Ismayilov', 'useranar', '12345678', 2, '1990-08-15', 5, 'anar@gmail.com'),
       ('Adil', 'Qasimov', 'useradil', '12345678', 2, '1965-06-12', 2, 'adil@gmail.com'),
       ('Zakir', 'Aliyev', 'userzakir', '12345678', 2, '1995-12-14', 2, 'zakir@gmail.com');


insert into user_position (user_id, position_id)
VALUES (1, 1),
       (1, 5),
       (3, 5),
       (4, 4),
       (2, 1),
       (4, 6),
       (1, 1),
       (3, 4);
