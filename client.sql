use client;
create table `user` (
    `id` varchar(40) not null primary key,
    `username` varchar(40),
    `password` varchar(40),
    `name` varchar(40),
    `phone` varchar(40),
    `job` varchar(40)
);



create table `chance` (
    `id` int(4) not null primary key auto_increment,
    `clientname` varchar(40),
    `outline` varchar(40),
    `person` varchar(40),
    `phone` varchar(40),
    `createperson` varchar(40),
    `createtime` datetime,
    `source` varchar(40),
    `success` varchar(40)
);



create table `plan` (
    `clientname` varchar(40),
    `date` datetime,
    `item` varchar(40)
);


create table `client` (
    `id` int(4) not null primary key auto_increment,
    `name` varchar(40),
    `contribution` varchar(40),
    `level` varchar(40),
    `location` varchar(40),
    `manager` varchar(40),
    `phone` varchar(40)

);




create table `service` (
    `id` int(4) not null primary key auto_increment,
    `clientname` varchar(40),
    `type` varchar(40),
    `outline` varchar(40),
    `status` varchar(40),
    `createperson` varchar(40),
    `createtime` datetime,
    `request` varchar(40),
    `dealperson` varchar(40)
);



INSERT INTO `chance` VALUES (1,'太阳药业','下个月的销售计划', '李三','17326078989','林子洋','2020-1-5 21:00:54', '偶然发现', '40');
INSERT INTO `chance` VALUES (2,'华为','上市计划', '牧之','17234678989','林子洋','2020-1-7 22:00:54', '电话联系', '80');
insert into `plan` values ('华为', '2020-3-7 12:00:54', '与老板开会');
insert into `plan` values ('太阳药业', '2020-2-17 7:00:54', '电话交流');
INSERT INTO `client` VALUES (1,'华为','50000', '重点开发对象','深圳','王五','13907822321');
INSERT INTO `client` VALUES (2,'太阳药业','30000', '大客户','上海','李四','189072389321');

INSERT INTO newservice VALUES (1,'大白兔奶糖集团','维修', '产品出了故障','新建','王五','2020-2-17 7:00:54', '尽快来维修','张经理');