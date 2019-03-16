/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : ssm_hotel

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2019-03-16 12:35:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(2) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(10) NOT NULL COMMENT '管理员登录名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `emp_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `emp_name` char(20) NOT NULL COMMENT '员工名字',
  `sex` char(2) NOT NULL COMMENT '性别',
  `age` int(2) unsigned NOT NULL COMMENT '年龄',
  `phone` char(11) NOT NULL COMMENT '电话',
  `duty` varchar(10) NOT NULL COMMENT '职责',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_name` (`emp_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------

-- ----------------------------
-- Table structure for t_housing
-- ----------------------------
DROP TABLE IF EXISTS `t_housing`;
CREATE TABLE `t_housing` (
  `housing_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '入住id 自增',
  `room_id` int(11) unsigned NOT NULL COMMENT '房间id',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `start_time` timestamp NOT NULL DEFAULT '1978-12-31 16:00:00' COMMENT '开始时间',
  `end_time` timestamp NOT NULL DEFAULT '1978-12-31 16:00:00' COMMENT '结束时间',
  `cost_money` double NOT NULL COMMENT '支付',
  PRIMARY KEY (`housing_id`),
  KEY `roomid` (`room_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_housing
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_info
-- ----------------------------
DROP TABLE IF EXISTS `t_order_info`;
CREATE TABLE `t_order_info` (
  `order_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `room_id` int(11) unsigned NOT NULL COMMENT '房间id',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `order_status` int(2) unsigned NOT NULL COMMENT '订单状态',
  `introduce` text NOT NULL COMMENT '备注',
  `emp_id` int(10) unsigned DEFAULT NULL COMMENT '操作员工id',
  PRIMARY KEY (`order_id`),
  KEY `order_id` (`order_id`,`room_id`,`user_id`,`order_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(10) NOT NULL COMMENT '房间号',
  `type` int(2) unsigned NOT NULL COMMENT '房间类型',
  `price` double NOT NULL COMMENT '房间价格',
  `status` smallint(5) unsigned zerofill NOT NULL COMMENT '房间状态',
  `picture` varchar(50) NOT NULL COMMENT '照片地址',
  `introduce` text NOT NULL COMMENT '房间简介',
  PRIMARY KEY (`room_id`),
  KEY `room_number` (`room_number`,`type`,`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES ('1', '101', '1', '150', '00003', '/images/76be09ee-19d2-477e-96b7-358e49b9f90c.jpg', '1');
INSERT INTO `t_room` VALUES ('2', '102', '1', '150', '00003', '/images/fae5f587-797e-4bff-8b92-55d80c5a2741.jpg', '1111');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id 自增',
  `user_name` varchar(10) NOT NULL COMMENT '用户名 ',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `sex` char(2) NOT NULL COMMENT '性别',
  `phone` varchar(50) NOT NULL COMMENT '电话',
  `mail` varchar(50) NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`user_id`),
  KEY `user_id` (`user_id`,`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'kongtao', '123456', '男', '15797694133', '1351808875@qq.com');

-- ----------------------------
-- Table structure for t_user_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_user_comment`;
CREATE TABLE `t_user_comment` (
  `comment_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id  自增',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '评论人id',
  `room_id` int(11) NOT NULL COMMENT '房间id',
  `level` int(5) unsigned NOT NULL DEFAULT '1' COMMENT '评级等级',
  `comment` text NOT NULL COMMENT '评论',
  `create_time` timestamp NOT NULL DEFAULT '1978-12-31 16:00:00' COMMENT '评论时间',
  `last_modify_time` timestamp NOT NULL DEFAULT '1978-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`,`room_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_comment
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
