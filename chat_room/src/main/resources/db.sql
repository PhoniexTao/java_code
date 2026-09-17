create database if not exists java_chatroom charset utf8;

use java_chatroom;

drop table if exists user;
create table user(
    userId int primary key auto_increment,
    username varchar(20) unique,
    password varchar(20)
);
insert into user values(null,"phoniex_tao","1433223");
insert into user values(null,"moriarty","233233");

