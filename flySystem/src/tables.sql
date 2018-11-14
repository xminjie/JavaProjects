-- 创建数据库
create database fly charset utf8;
创建数据库管理员
create user flyroot;
set password for xmj = password('flyrootpass');
grant all on fly.* to flyroot;
-- 创建用户表
create table user(
  account varchar (20) primary key,
  password varchar (50) not null ,
  name varchar (10)not null ,
  identityId varchar (18) not null,
  sex varchar (1) not null,
  tel varchar (12),
  email varchar (20),
  address varchar(50)
) charset = utf8 ;
-- 创建管理员表

create table adminUser(
  account varchar (20) primary key,
  password varchar (50) not null ,
  name varchar (10)not null ,
  identityId varchar (18) not null
) charset = utf8 ;

-- 创建航班表
-- time时间用分钟为单位
create table flight(
  flightId varchar (20) primary key,
  beginAddress varchar (20),
  endAddress varchar (20),
  beginTime datetime ,
  time  int,
  avaliableTikects int,
  price float
) charset = utf8 ;
-- 创建订单记录
-- account和user表中的account形成外键约束
-- flightId和flight表中的filghtId形成外键约束
create table recorder (
  recorderId int,
  flightId  varchar (20) ,
  account varchar (20),
  status varchar(10),
  foreign key (flightId) references flight (flightId),
  foreign key (account) references user (account)
) charset = utf8 ;
