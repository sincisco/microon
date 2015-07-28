create database microon;

use microon;

create table if not exists user (
id int(11) NOT NULL auto_increment,
name varchar(20),
password varchar(50),
email varchar(50),
birthday date,
primary key(id)
);

#文章
create table if not exists article (
id int(11) NOT NULL auto_increment,
title varchar(80),
outline TEXT,
content MEDIUMTEXT,
issueDate date,  #发布时间
authorNo int,
primary key(id)
);

#文章修改历史  文章修改前，对文章内容进行全量保存
create table if not exists article_edit_history (
id int(11) NOT NULL auto_increment,
title varchar(80),  
content MEDIUMTEXT,
reviseDate date,  #修改时间
modifierNo int,   #文章修改人  外键
primary key(id)
);

#文章分类
create table if not exists articleCategory (
id int(11) NOT NULL auto_increment,
name varchar(80) NOT NULL,  
parentId int(11),	  #父分类
createDateTime datetime,  #创建时间or修改时间
creator int,   #文章分类创建者  外键
primary key(id)
);