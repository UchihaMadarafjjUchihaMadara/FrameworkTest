/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : sbm2s

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-05-05 17:09:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_permission
-- ----------------------------
DROP TABLE IF EXISTS `demo_permission`;
CREATE TABLE `demo_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `parent_id` int(11) DEFAULT NULL COMMENT '资源父id',
  `name` varchar(100) NOT NULL COMMENT '资源名称',
  `key` varchar(100) NOT NULL COMMENT '资源唯一标识',
  `type` smallint(2) NOT NULL COMMENT '资源类型,0:目录;1:菜单;2:按钮',
  `source_url` varchar(500) DEFAULT NULL COMMENT '资源url',
  `icon` varchar(100) DEFAULT '' COMMENT '图标',
  `hide` tinyint(1) DEFAULT '0' COMMENT '是否隐藏',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of demo_permission
-- ----------------------------
INSERT INTO `demo_permission` VALUES ('1', null, '系统基础管理', 'system', '0', '', 'am-icon-list', '0', '系统基础管理', '2016-01-05 12:11:12', '2016-02-25 14:07:46');
INSERT INTO `demo_permission` VALUES ('2', '1', '用户管理', 'system:user', '1', 'user/listUI', '', '0', '用户管理', '2016-01-08 12:37:10', '2016-01-22 11:06:59');
INSERT INTO `demo_permission` VALUES ('3', '1', '角色管理', 'system:role', '1', 'role/listUI', '', '0', '角色管理', '2016-01-11 22:51:07', '2016-01-22 11:07:04');
INSERT INTO `demo_permission` VALUES ('4', '1', '资源管理', 'system:resource', '1', 'resource/listUI', '', '0', '资源管理', '2016-01-11 22:51:55', '2016-01-22 11:07:10');
INSERT INTO `demo_permission` VALUES ('5', null, '系统监控管理', 'monitor', '0', '', 'am-icon-pencil', '0', '系统监控管理', '2016-01-05 12:11:12', '2016-02-25 14:07:48');
INSERT INTO `demo_permission` VALUES ('6', '5', 'Druid监控', 'monitor:druid', '1', 'druid', '', '0', 'Druid监控', '2016-01-11 22:45:27', '2016-03-20 15:00:53');
INSERT INTO `demo_permission` VALUES ('7', '2', '添加', 'user:add', '2', '', '', '0', '添加用户', '2016-01-22 00:18:40', '2016-01-22 11:06:13');
INSERT INTO `demo_permission` VALUES ('8', '2', '编辑', 'user:edit', '2', '', '', '0', '编辑用户', '2016-01-22 00:18:40', '2016-01-22 11:06:22');
INSERT INTO `demo_permission` VALUES ('9', '2', '删除', 'user:delete', '2', '', null, '0', '删除用户', '2016-02-05 15:26:32', '2016-02-25 15:27:51');
INSERT INTO `demo_permission` VALUES ('10', '2', '重置密码', 'user:resetPassword', '2', '', null, '0', '重置密码', '2016-02-27 23:55:13', null);
INSERT INTO `demo_permission` VALUES ('11', '3', '添加', 'role:add', '2', '', null, '0', '添加', '2016-02-27 23:56:52', null);
INSERT INTO `demo_permission` VALUES ('12', '3', '编辑', 'role:edit', '2', '', null, '0', '编辑', '2016-02-27 23:57:35', null);
INSERT INTO `demo_permission` VALUES ('13', '3', '删除', 'role:delete', '2', '', null, '0', '删除', '2016-02-27 23:58:02', null);
INSERT INTO `demo_permission` VALUES ('14', '3', '分配权限', 'role:permission', '2', '', null, '0', '分配权限', '2016-02-27 23:59:20', null);
INSERT INTO `demo_permission` VALUES ('15', '4', '添加', 'resource:add', '2', '', null, '0', '添加', '2016-02-28 00:01:15', null);
INSERT INTO `demo_permission` VALUES ('16', '4', '编辑', 'resource:edit', '2', '', null, '0', '编辑', '2016-02-28 00:02:01', null);
INSERT INTO `demo_permission` VALUES ('17', '4', '删除', 'resource:delete', '2', '', null, '0', '删除', '2016-02-28 00:03:03', null);
INSERT INTO `demo_permission` VALUES ('21', null, '日志管理', 'logininfo', '0', null, 'am-icon-tag', '0', '日志管理', '2017-01-04 17:54:59', '2017-01-04 17:54:59');
INSERT INTO `demo_permission` VALUES ('22', '21', '用户登录日志', 'logininfo:userLogin', '1', 'loginlog/listUI', '', '0', null, '2017-01-04 17:55:52', '2017-01-04 17:55:52');
INSERT INTO `demo_permission` VALUES ('23', null, 'CMS管理', 'cms', '0', null, 'am-icon-newspaper-o', '0', null, '2017-01-05 18:20:00', '2017-01-05 18:20:00');
INSERT INTO `demo_permission` VALUES ('24', '23', '新闻管理', 'cms:news', '1', 'news/listUI', '', '0', null, '2017-01-05 18:20:27', '2017-01-05 18:20:27');

-- ----------------------------
-- Table structure for demo_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `demo_permission_role`;
CREATE TABLE `demo_permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL COMMENT '资源id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_r_resource_role` (`permission_id`),
  KEY `FK_r_role_resource` (`role_id`),
  CONSTRAINT `demo_permission_role_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `demo_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';

-- ----------------------------
-- Records of demo_permission_role
-- ----------------------------
INSERT INTO `demo_permission_role` VALUES ('30', '1', '1', '2017-05-05 15:05:07', '2017-05-05 15:05:11');
INSERT INTO `demo_permission_role` VALUES ('31', '2', '1', '2017-05-05 15:05:12', '2017-05-05 15:05:14');
INSERT INTO `demo_permission_role` VALUES ('32', '3', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:20');
INSERT INTO `demo_permission_role` VALUES ('33', '4', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:22');
INSERT INTO `demo_permission_role` VALUES ('34', '5', '1', '0000-00-00 00:00:00', '2017-05-05 15:05:23');
INSERT INTO `demo_permission_role` VALUES ('35', '8', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:23');
INSERT INTO `demo_permission_role` VALUES ('36', '9', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:24');
INSERT INTO `demo_permission_role` VALUES ('37', '10', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:25');
INSERT INTO `demo_permission_role` VALUES ('38', '11', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:25');
INSERT INTO `demo_permission_role` VALUES ('39', '12', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:26');
INSERT INTO `demo_permission_role` VALUES ('40', '13', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:26');
INSERT INTO `demo_permission_role` VALUES ('41', '14', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:27');
INSERT INTO `demo_permission_role` VALUES ('42', '15', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:27');
INSERT INTO `demo_permission_role` VALUES ('43', '16', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:28');
INSERT INTO `demo_permission_role` VALUES ('44', '17', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:29');
INSERT INTO `demo_permission_role` VALUES ('45', '6', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:29');
INSERT INTO `demo_permission_role` VALUES ('46', '7', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:30');
INSERT INTO `demo_permission_role` VALUES ('47', '1', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:31');
INSERT INTO `demo_permission_role` VALUES ('48', '2', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:31');
INSERT INTO `demo_permission_role` VALUES ('49', '3', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:32');
INSERT INTO `demo_permission_role` VALUES ('50', '4', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:32');
INSERT INTO `demo_permission_role` VALUES ('51', '7', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:33');
INSERT INTO `demo_permission_role` VALUES ('52', '11', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:37');
INSERT INTO `demo_permission_role` VALUES ('53', '15', '2', '2017-05-05 15:05:15', '2017-05-05 15:05:40');
INSERT INTO `demo_permission_role` VALUES ('54', '21', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:40');
INSERT INTO `demo_permission_role` VALUES ('55', '22', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:41');
INSERT INTO `demo_permission_role` VALUES ('56', '23', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:41');
INSERT INTO `demo_permission_role` VALUES ('57', '24', '1', '2017-05-05 15:05:15', '2017-05-05 15:05:42');

-- ----------------------------
-- Table structure for demo_role
-- ----------------------------
DROP TABLE IF EXISTS `demo_role`;
CREATE TABLE `demo_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `key` varchar(100) DEFAULT NULL,
  `status` int(1) unsigned zerofill DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_role
-- ----------------------------
INSERT INTO `demo_role` VALUES ('1', '超级管理员', 'administrator', '0', '2017-05-04 13:39:00', '2017-05-04 13:39:00');
INSERT INTO `demo_role` VALUES ('2', '管理员', 'admin', '0', '2017-05-04 13:39:23', '2017-05-04 13:39:27');
INSERT INTO `demo_role` VALUES ('3', '普通用户', 'customer', '0', '2017-05-04 13:39:43', '2017-05-04 13:39:45');

-- ----------------------------
-- Table structure for demo_role_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_role_user`;
CREATE TABLE `demo_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_role_user
-- ----------------------------
INSERT INTO `demo_role_user` VALUES ('1', '1', '23', '2017-05-04 13:40:09', '2017-05-05 11:41:34');
INSERT INTO `demo_role_user` VALUES ('2', '2', '24', '2017-05-04 13:40:35', '2017-05-05 11:41:38');

-- ----------------------------
-- Table structure for demo_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `locked` tinyint(1) unsigned zerofill DEFAULT NULL COMMENT '1——没锁，0——已锁',
  `name` varchar(32) DEFAULT NULL,
  `age` smallint(3) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_user
-- ----------------------------
INSERT INTO `demo_user` VALUES ('23', 'admin', 'AMZLJB4PIgSlmoqRpYvwWuAmR5CUyoFwif1Na+YHm8rwXw3k+kmilQyhENvSVg3uW1zYGKiK5eWxqMkqM7+hHW4=', '8X6sQufdGrZcXLiQlI0H3/Vc3NQ4EkV+M1Ia8/ziCos=', '1', '傅嘉俊', '21', '男', '1996-06-17 00:00:00', '2017-05-04 13:41:09', '2017-05-05 14:40:40');
