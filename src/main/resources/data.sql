insert into user_model
VALUES(10001, sysdate(), 'Eraka');
insert into user_model
VALUES(10002, sysdate(), 'Huawe');
insert into user_model
VALUES(10003, sysdate(), 'Kumachi');
--------------------------------------------
insert into posts
values(11001, 'My First Post', 10001);
insert into posts
values(11002, 'My Second Post', 10001);