drop table if exists department;
drop table if exists employee;

create table department
(
    id   varchar(50) not null,
    name varchar(50) not null,

    primary key (id)
);

create table employee
(
    id   varchar(50) not null,
    name varchar(50) not null,

    primary key (id)
);

insert into department
values ('L1001', 'backend-1');

insert into department
values ('L1002', 'backend-2');

insert into department
values ('L1003', 'backend-3');

insert into department
values ('L1004', 'backend-4');

insert into department
values ('L1005', 'backend-5');

insert into employee
values ('20202201', 'Kim');

insert into employee
values ('20202202', 'Kim');

commit;