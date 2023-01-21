show databases;
create database project;
use project;
show tables;

create table BookInfo(
bookNumber int primary key auto_increment,
bookTime datetime default now(),
bookImg text,

bookName text,
bookWriter text,
bookPublishing text,
bookPublisher text,

bookColum text,
bookField text,

infoBook text,
infoWriter text,
infoContents text
);

select * from BookInfo;
delete from BookInfo where bookNumber=5;
delete from BookInfo;
alter table childBook add column bookImg text;

create table member(
id text,
pw text,
name text,
birthday text,
phone_first text,
phone_last text,

email text,
resident_first text,
resident_last text,

postCode int,
roadAddress text,
jibunAddress text,
detailAddress text,
extraAddress text);

desc member;
alter table member add column overdue boolean default true;

drop table member;
select * from member;

delete  from member;

create table bookPersonal(
id text,
bookNumber int,
bookOverdue boolean default false,
bookSubmit boolean default false,
startTime text default (current_date()),
stopTime text default (current_date()+14)
);

drop  table bookPersonal;
desc bookPersonal;
delete from bookPersonal;
select * from bookPersonal;
update bookPersonal set bookOverdue=true where id="dobie" and bookNumber=8;
create table bookOrganization(
bookNumber int,
bookName text,
bookColum text,
bookBorrow boolean default false,
countBorrow int default 0
);

drop table bookOrganization;
desc bookOrganization;
select * from bookOrganization;
delete from bookOrganization;
select * from member;




delete from bookpersonal;

select * from bookpersonal;

select * from bookOrganization;

select * from bookpersonal p inner join bookOrganization o on p.bookNumber = o.bookNumber where p.id="아" and bookSubmit=false;

create table bookingPersonal(
id text,
bookNumber int,
stemp int,
endTime text
);