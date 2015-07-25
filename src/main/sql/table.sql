create database microon;

use microon;

create table if not exists user (
id int(11) NOT NULL auto_increment,
name varchar(20),
password varchar(50),
birthday date,
primary key(id)
);

#文章
create table if not exists article (
id int(11) NOT NULL auto_increment,
title varchar(80),
content MEDIUMTEXT,
issueDate date,
primary key(id)
);