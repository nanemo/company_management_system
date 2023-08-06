insert into positions (name)
values ('office manager'),
       ('marketing manager'),
       ('HR manager'),
       ('merchandiser'),
       ('security'),
       ('CEO');

insert into users (first_name, last_name, password, birthdate, company_id, `e-mail`)
values ('Nadir', 'Nadirli', '12345678', '1991-04-04', 2, 'nanemodeveloper@gmail.com'),
       ('Elnur', 'Aliyev', '12345678', '1984-01-04', 6, 'elnur@gmail.com'),
       ('Anar', 'Ismayilov', '12345678', '1990-08-15', 7, 'anar@gmail.com'),
       ('Adil', 'Qasimov', '12345678', '1965-06-12', 2, 'adil@gmail.com'),
       ('Zakir', 'Aliyev', '12345678', '1995-12-14', 2, 'zakir@gmail.com');

insert into user_position (user_id, position_id)
VALUES (1, 6),
       (2, 2),
       (3, 5),
       (4, 3),
       (5, 2),
       (4, 4),
       (1, 2),
       (3, 1);

select * from users left join user_position up on users.id = up.user_id right join positions p on p.id = up.position_id where p.name='marketing manager';