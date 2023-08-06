insert into company(name, create_date)
VALUES ('DIV Academy', '1994-04-25'),
       ('Azercell LLC', '1995-11-04'),
       ('Bakcell LLC', '1991-10-19'),
       ('AzTelecom', '2001-05-01'),
       ('BakTelecom', '2008-06-11'),
       ('CityNet', '2010-12-09'),
       ('Connect TV', '2015-08-02');

alter table users
    add column login varchar(250) unique;

insert into positions (name)
values ('office manager'),
       ('marketing manager'),
       ('HR manager'),
       ('merchandiser'),
       ('security'),
       ('CEO');

insert into users (first_name, last_name, login, password, birthdate, company_id, `e-mail`)
values ('Nadir', 'Nadirli', 'admin', '12345678', '1991-04-04', 8, 'nanemodeveloper@gmail.com'),
       ('Elnur', 'Aliyev', 'userelnur','12345678', '1984-01-04', 10, 'elnur@gmail.com'),
       ('Anar', 'Ismayilov', 'useranar','12345678', '1990-08-15', 11, 'anar@gmail.com'),
       ('Adil', 'Qasimov', 'useradil','12345678', '1965-06-12', 8, 'adil@gmail.com'),
       ('Zakir', 'Aliyev', 'userzakir','12345678', '1995-12-14', 8, 'zakir@gmail.com');


insert into user_position (user_id, position_id)
VALUES (11, 1),
       (12, 5),
       (13, 5),
       (14, 4),
       (12, 1),
       (14, 6),
       (11, 1),
       (13, 4);
