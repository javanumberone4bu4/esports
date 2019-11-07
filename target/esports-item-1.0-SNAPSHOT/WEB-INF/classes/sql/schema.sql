drop database if exists esports;
create database esports default character set utf8 collate utf8_general_ci;
use esports;
drop table if exists esports.user;
create table esports.user
(
    user_id    int          not null auto_increment comment 'ID',
    user_tel   varchar(20)  not null comment '手机号作用户名',
    password   varchar(200) not null comment '密码',
    user_money decimal(10, 2) default 0 comment '用户钱包余额',
    openId     varchar(255)    default null comment '微信唯一标识',
    unique key (user_tel),
    unique key (openId),
    primary key (user_id)
) engine = InnoDB comment '用户表';


drop table if exists esports.sm;
create table esports.sm
(
    sm_id         int          not null auto_increment comment 'ID',
    sm_name       varchar(20)  not null comment '昵称',
    sm_realName   varchar(20)  not null comment '真实姓名',
    sm_email      varchar(20)  not null comment '邮箱',
    sm_sex        varchar(20)  not null comment '性别',
    sm_age        int          not null comment '年龄',
    sm_job        varchar(50)  not null comment '工作',
    sm_hobby      varchar(50)  not null comment '兴趣爱好',
    sm_address    varchar(50)  not null comment '地址',
    sm_image      varchar(255) not null comment '头像',
    sm_mark       int          not null comment '信誉积分',
    user_tel      varchar(20)  not null comment '手机号',
    concernedUser varchar(20)  not null comment '关注的用户',
    fans          int default 0 comment '粉丝数',
    unique key (sm_name),
    primary key (sm_id)
) engine = InnoDB comment '用户个人信息表';


drop table if exists esports.brand;
create table esports.brand
(
    brand_id   int          not null auto_increment comment 'ID',
    brand_name varchar(20)  not null comment '品牌名称',
    brand_logo varchar(255) not null comment '品牌图标',
    primary key (brand_id)
) engine = InnoDB comment '品牌表';


drop table if exists esports.goods;
create table esports.goods
(
    goods_id          int          not null auto_increment comment 'ID',
    goods_source      varchar(20)  not null comment '来源用户',
    goods_name        varchar(50)  not null comment '商品名称',
    goods_photo       varchar(255) not null comment '商品图片',
    goods_price       double       not null comment '商品价格',
    brand_id          int          not null comment '品牌ID',
    goods_classify    varchar(255) not null comment '商品分类路径',
    goods_showTime    varchar(50)  not null comment '发布时间',
    goods_description varchar(255) not null comment '商品描述',
    goods_upTime      varchar(50)  not null comment '上架时间',
    goods_location    varchar(50)  not null comment '单位',
    primary key (goods_id)
) engine = InnoDB comment '商品表';



drop table if exists esports.shop;
create table esports.shop
(
    shop_id       int         not null auto_increment comment 'ID',
    user_tel      varchar(20) not null comment '用户名',
    shop_choose   varchar(20) not null comment '是否选中',
    goods_id      int         not null comment '商品ID',
    shop_goodsNum int         not null comment '商品数量',
    primary key (shop_id)
) engine = InnoDB comment '购物车表';


drop table if exists esports.orders;
create table esports.orders
(
    orders_id         int            not null auto_increment comment 'ID',
    user_tel          varchar(20)    not null comment '用户名',
    orders_num        varchar(50)    not null comment '订单编号',
    orders_time       varchar(50)    not null comment '下单时间',
    orders_sum        decimal(10, 2) not null comment '总金额',
    orders_status     varchar(20)    not null comment '订单状态',
    orders_getMethod  varchar(20)    not null comment '收货方式',
    orders_money      decimal(10, 2) not null comment '运费',
    orders_pay        varchar(20)    not null comment '是否支付',
    orders_getName    varchar(20)    not null comment '收货人名称',
    orders_getAddress varchar(50)    not null comment '收货人地址',
    orders_getPhone   varchar(20)    not null comment '收件人手机',
    orders_getScore   int            not null comment '所得积分',
    orders_expressNum varchar(50)    not null comment '快递号',
    orders_getTime    varchar(50)    not null comment '发货时间',
    primary key (orders_id)
) engine = InnoDB comment '订单表';


drop table if exists esports.mark;
create table esports.mark
(
    mark_id     int         not null auto_increment comment 'ID',
    user_tel    varchar(20) not null comment '用户名',
    mark_score  int         not null comment '积分数',
    mark_source varchar(50) not null comment '来源',
    primary key (mark_id)
) engine = InnoDB comment '积分表';


drop table if exists esports.client;
create table esports.client
(
    client_id         int          not null auto_increment comment 'ID',
    user_tel          varchar(20)  not null comment '用户名',
    password          varchar(200) not null comment '密码',
    sm_name           varchar(20)  not null comment '昵称',
    client_connMethod varchar(255) not null comment '其他联系方式',
    client_publicNum  varchar(20)  not null comment '公众号',
    primary key (client_id)
) engine = InnoDB comment '客服表';

drop table if exists esports.community;
create table esports.community
(
    community_id int         not null auto_increment comment 'ID',
    hot          varchar(20) not null comment '热门',
    commonCity   varchar(20) not null comment '同城',
    primary key (community_id)
) engine = InnoDB comment '社区表';

drop table if exists esports.hot;
create table esports.hot
(
    hot_id        int          not null auto_increment comment 'ID',
    hot_userImage varchar(255) not null comment '用户头像',
    sm_name       varchar(20)  not null comment '用户名字',
    hot_time      varchar(20)  not null comment '时间',
    hot_content   varchar(255) not null comment '内容',
    hot_picture   varchar(255) not null comment '图片',
    location      varchar(50)  not null comment '地区',
    primary key (hot_id)
) engine = InnoDB comment '热门表';

drop table if exists esports.commonCity;
create table esports.commonCity
(
    commonCity_id        int          not null auto_increment comment 'ID',
    commonCity_userImage varchar(255) not null comment '用户头像',
    commonCity_name       varchar(20)  not null comment '用户名字',
    commonCity_time      varchar(20)  not null comment '时间',
    commonCity_content   varchar(255) not null comment '内容',
    commonCity_picture   varchar(255) not null comment '图片',
    commonCity_location      varchar(50)  not null comment '地区',
    primary key (commonCity_id)
)engine=InnoDB comment '同城表';

drop table if exists esports.meCode;
create table esports.meCode(
  meCode_id int not null auto_increment comment 'ID',
  userTel varchar(20) not null comment '电话号码',
  number varchar(50) default null comment '验证码',
  primary key(meCode_id)
)engine=InnoDB comment '验证码表';
