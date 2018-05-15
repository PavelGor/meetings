create database meetings;

use meetings;

create table meeting (
id BIGINT primary key auto_increment,
name varchar(255) not null,
firstName varchar(50) not null,
lastName varchar(50) not null,
dateFrom datetime not null,
dateTo datetime not null,
room varchar(50)
);

insert into meeting (name, firstName, lastName, dateFrom, dateTo, room) values ("First meeting", "Tolik", "Trubin", "2018-01-25 10-00-00", "2018-01-25 12-00-00", "Heifa");
insert into meeting (name, firstName, lastName, dateFrom, dateTo, room) values ("First meeting", "Mariya", "Noa", "2018-01-25 13-00-00", "2018-01-25 15-00-00", "Heifa");
insert into meeting (name, firstName, lastName, dateFrom, dateTo) values ("First meeting", "Ivan", "Next", "2018-01-25 16-00-00", "2018-01-25 18-00-00");