/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : sbm2

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-05-08 07:43:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` smallint(3) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_user
-- ----------------------------
INSERT INTO `demo_user` VALUES ('1', 'admin', 'AEYoLhA31iaNlEoX2ByvTtlc0eNfmhttCDnHHSX4TTQ///nYLP7X2R0OViYOgNZtIZMuBM/LufL/A6WFWRrDPM0=', 'vDXbJ6/qDOjbImkkPdX0rPuKlMflBzT0Sy3hM95HgcY=', '傅嘉俊', '21', '男', '1996-06-17 00:00:00', '2017-05-04 13:41:09', '2017-05-05 11:26:38');
