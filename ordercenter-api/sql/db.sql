CREATE TABLE `big_customer_basic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_no` varchar(12) DEFAULT NULL COMMENT '客户编码',
  `customer_name` varchar(12) DEFAULT NULL COMMENT '客户名称',
  `customer_contact` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `province` varchar(10) DEFAULT NULL COMMENT '省份',
  `city` varchar(10) DEFAULT NULL COMMENT '市',
  `county` varchar(10) DEFAULT NULL COMMENT '区县',
  `shipping_address` varchar(255) DEFAULT NULL COMMENT '收货详细地址',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='大客户资料';

