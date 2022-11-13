-- 创建库
create database if not exists dev_shop;

-- 切换库
use dev_shop;

-- 用户表信息
# 在创建时间字段的时候
# ① DEFAULT CURRENT_TIMESTAMP
# 表示当插入数据的时候，该字段默认值为当前时间
# ② ON UPDATE CURRENT_TIMESTAMP
# 表示每次更新这条数据的时候，该字段都会更新成当前时间
#
# 这两个操作是mysql数据库本身在维护，所以可以根据这个特性来生成【创建时间】和【更新时间】两个字段，且不需要代码来维护。
create table if not exists dev_shop.`user`
(
    `id` bigint not null auto_increment comment '用户id' primary key,
    `email` varchar(255) not null unique comment '邮箱(唯一)',
    `username` varchar(255) not null comment '用户名',
    `password` varchar(255) not null comment '密码',
    `address` varchar(255) null comment '地址',
    `phone` varchar(255) null comment '手机号',
    `role` tinyint(1) default 0 not null comment '角色(0-普通用户, 1-付费用户, 2-商家, 3-客服, 4-管理员, 5-全局管理员)',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间(自动)',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间(自动)',
    `is_deleted` tinyint(1) default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户表信息';

-- 订单表
create table if not exists dev_shop.`order`
(
    `id` bigint not null auto_increment comment '订单id' primary key,
    `order_no` bigint not null comment '订单编号',
    `user_id` bigint not null comment '用户id',
    `order_item_id` bigint not null comment '订单明细id',
    `payment` double not null comment '实际付款金额,单位是元,保留两位小数',
    `postage` int not null comment '运费,单位是元',
    `status` tinyint not null comment '订单状态:0-已取消,10-未付款,20-已付款,40-已发货,50-交易成功,60-交易关闭',
    `payment_time` datetime comment '支付时间',
    `send_time` datetime comment '发货时间',
    `end_time` datetime comment '交易完成时间',
    `close_time` datetime comment '交易关闭时间',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '订单表';

-- 订单明细表
create table if not exists dev_shop.`order_item`
(
    `id` bigint not null auto_increment comment '订单明细id' primary key,
    `order_no` bigint not null comment '订单编号',
    `user_id` bigint not null comment '用户id',
    `product_id` bigint not null comment '商品id',
    `current_unit_price` double not null comment '生成订单时的商品单价,单位是元,保留两位小数',
    `quantity` int not null comment '商品数量',
    `total_price` double not null comment '商品总价,单位是元,保留两位小数',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '订单明细表';

-- 购物车表
create table if not exists dev_shop.`shopping_cart`
(
    `id` bigint not null auto_increment comment '购物车id' primary key,
    `user_id` bigint not null comment '用户id',
    `product_id` bigint not null comment '商品id',
    `quantity` int not null comment '商品数量',
    `checked` tinyint not null comment '是否勾选,1-已勾选,0-未勾选',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '购物车表';

-- 支付信息表
create table if not exists dev_shop.`payment`
(
    `id` bigint not null auto_increment comment '支付信息id' primary key,
    `user_id` bigint not null comment '用户id',
    `order_no` bigint not null comment '订单号',
    `platform` tinyint not null comment '支付平台:1-支付宝,2-微信',
    `platform_number` varchar(100) not null comment '支付宝支付流水号',
    `platform_status` varchar(20) not null comment '支付宝支付状态',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '支付信息表';

-- 商品表
create table if not exists dev_shop.`product`
(
    `id` bigint not null auto_increment comment '商品id' primary key,
    `category` varchar(20) not null comment '商品分类',
    `name` varchar(100) not null comment '商品名称',
    `image` varchar(500) not null comment '商品主图',
    `detail` text not null comment '商品详情',
    `price` double not null comment '商品价格,单位是元,保留两位小数',
    `stock` int not null comment '商品库存',
    `status` tinyint not null comment '商品状态,1-在售,2-下架,3-删除',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '商品表';
