set names gbk;

drop database if exists card;
create database if not exists card;
use card;
/**院系**/
drop table if exists college;
create table if not exists college(
	college_id int not null primary key auto_increment,
	college_name varchar(20) not null
);
insert into college(college_name) values('软件工程系');
insert into college(college_name) values('网络工程系');
insert into college(college_name) values('数学系');
/**学生**/
drop table if exists student;
create table if not exists student(
	stu_id int not null primary key auto_increment,
	stu_no char(12) not null,
	stu_name varchar(16) not null,
	stu_login varchar(16) not null unique,
	stu_passwd char(32) not null,
	stu_phone char(11),
	stu_limit int default 1,
	stu_remain int,
	stu_note varchar(100),
	college_id int
);
insert into student(stu_no,stu_name,stu_login,stu_passwd,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806001','张三','zhangsansan7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',666,'1班学生',1);
insert into student(stu_no,stu_name,stu_login,stu_passwd,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806002','李四','lisisi7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',66,'1班学生',1);
insert into student(stu_no,stu_name,stu_login,stu_passwd,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806004','陈六','chenliuliu7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282814',600,'3班学生',3);
insert into student(stu_no,stu_name,stu_login,stu_passwd,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806001','张三','zhangsa7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',666,'1班学生',1);
insert into student(stu_no,stu_name,stu_login,stu_passwd,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806002','李四','lis7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',66,'1班学生',1);
insert into student(stu_no,stu_name,stu_login,stu_passwd,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806004','陈六','chenli6','8C7E1F3B1B787EC9F24FCC01E243E072','13812282814',600,'3班学生',3);

/**用户**/
drop table if exists userinfo;
create table if not exists userinfo (
  user_id int(11) NOT NULL AUTO_INCREMENT primary key,
  user_name varchar(30),
  user_login varchar(30),
  user_passwd char(32) DEFAULT '8C7E1F3B1B787EC9F24FCC01E243E072'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into userinfo(user_name,user_login) values('张三','zhangsan');

/*商品表*/
drop table if exists goods;
create table if not exists goods (
  goods_id smallint NOT NULL AUTO_INCREMENT primary key,
  goods_name varchar(30) NOT NULL,
  goods_price double default 0,
  goods_left smallint DEFAULT 0,
  goods_detail varchar(255) DEFAULT '无',
  goods_picture varchar(255) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into goods (goods_name,goods_price,goods_left) values ('乐扣杯',40,100);
insert into goods (goods_name,goods_price,goods_left) values ('罗技k120',55,200);
insert into goods (goods_name,goods_price,goods_left) values ('脆司令',2,600);

/*购物车订单表*/
drop table if exists orders;
create table if not exists orders (
  order_id int NOT NULL AUTO_INCREMENT primary key,
  stu_id int not null,
  goods_id int not null,
  goods_count int not null,
  create_time timestamp default now()
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into orders (stu_id,goods_id,goods_count) values (1,1,10);
insert into orders (stu_id,goods_id,goods_count) values (1,2,5);
insert into orders (stu_id,goods_id,goods_count) values (2,2,5);


drop table if exists dingdan;
CREATE TABLE dingdan (
      dingdan_id int primary key auto_increment,
      dingdan_no varchar(20) not null COMMENT '订单号',
      dingdan_amount varchar(11) not null COMMENT '订单金额',
      buy_counts int not null COMMENT '产品购买的个数',
      create_time datetime not null COMMENT '订单创建时间',
      pay_time timestamp DEFAULT now() COMMENT '支付时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';






























drop table if exists detailtype; 

/**费用类型**/
create table if not exists detailtype(
	type_id int not null primary key auto_increment,
	type_name varchar(20) not null
);
insert into detailtype(type_name) values('充值');
insert into detailtype(type_name) values('消费');

/**费用**/
drop table if exists detail;
create table if not exists detail(
	detail_id int not null primary key auto_increment,
	detail_stuserial char(36) unique not null,
	detail_time datetime,
	detail_money int,
	detail_title varchar(60),
	stu_id int,
	type_id int
);

insert into detail(detail_stuserial,detail_time,detail_money,detail_title,stu_id,type_id)
	values('ea986ed0-f523-4bca-bedb-9b4357253e20',now(),10,'饮食',1,2);
insert into detail(detail_stuserial,detail_time,detail_money,detail_title,stu_id,type_id)
	values('8598cdd0-611d-48f7-b338-64defbb60011',now(),20,'娱乐',1,2);
	
