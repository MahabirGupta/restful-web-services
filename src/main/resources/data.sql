insert into user_details(id,birth_date,user_Name)
values(10001, current_date(), 'Mahabir');

insert into user_details(id,birth_date,user_Name)
values(10002, current_date(), 'Ravi');

insert into user_details(id,birth_date,user_Name)
values(10003, current_date(), 'Sathish');

insert into post(id,description,user_id)
values(20001, 'Learn to be Java Developer', 10003);

insert into post(id,description,user_id)
values(20002, 'Learn to be Phyton Developer', 10001);

insert into post(id,description,user_id)
values(20003, 'Learn AWS', 10002);

insert into post(id,description,user_id)
values(20004, 'Learn Kotlin', 10002);