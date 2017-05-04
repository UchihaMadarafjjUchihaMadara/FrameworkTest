/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : ssm2

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-04-27 15:55:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `gender` varchar(10) DEFAULT NULL COMMENT '用户性别',
  `birthday` varchar(64) DEFAULT NULL COMMENT '用户生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_user
-- ----------------------------
INSERT INTO `demo_user` VALUES ('1', 'fujiajun', '20', '男', '1996-06-17');
