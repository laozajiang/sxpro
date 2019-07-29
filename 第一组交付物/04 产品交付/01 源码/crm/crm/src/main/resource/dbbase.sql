/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : dbbase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-01 10:25:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_name` varchar(20) NOT NULL,
  `department_info` varchar(50) NOT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('hh', 'hh', '1');
INSERT INTO `department` VALUES ('kk', 'kk', '2');
INSERT INTO `department` VALUES ('hh', 'hh', '3');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(20) DEFAULT NULL,
  `employee_job` varchar(20) DEFAULT NULL,
  `employee_phone` varchar(20) DEFAULT NULL,
  `employee_department` varchar(20) DEFAULT NULL,
  `employee_sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'hh', 'hh', 'hh', 'hh', null);
INSERT INTO `employee` VALUES ('3', '1', 'Jar', '1322022084x', 'Jar', '1');
INSERT INTO `employee` VALUES ('4', 'q', 'q', 'q', 'q', '1');

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(20) NOT NULL,
  `file_content` varchar(50) NOT NULL,
  `file_url` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '会议1', '明天14点组织开会', '管理部');
INSERT INTO `file` VALUES ('2', '会议2', '组织部集中', '管理部');

-- ----------------------------
-- Table structure for `first_menu`
-- ----------------------------
DROP TABLE IF EXISTS `first_menu`;
CREATE TABLE `first_menu` (
  `fid` int(10) NOT NULL,
  `fname` varchar(20) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of first_menu
-- ----------------------------
INSERT INTO `first_menu` VALUES ('1', '用户管理');
INSERT INTO `first_menu` VALUES ('2', '部门管理');
INSERT INTO `first_menu` VALUES ('3', '职位管理');
INSERT INTO `first_menu` VALUES ('4', '员工管理');
INSERT INTO `first_menu` VALUES ('5', '公告管理');

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(20) NOT NULL,
  `job_info` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('3', 'jj', 'jj');
INSERT INTO `job` VALUES ('4', 'hh', 'hh');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_name` varchar(20) NOT NULL,
  `notice_info` varchar(500) NOT NULL,
  `notice_user` varchar(20) NOT NULL,
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('11', '11', '11', '1');
INSERT INTO `notice` VALUES ('22', '222', '222', '2');
INSERT INTO `notice` VALUES ('11', '111', '111', '3');

-- ----------------------------
-- Table structure for `notice1`
-- ----------------------------
DROP TABLE IF EXISTS `notice1`;
CREATE TABLE `notice1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `gg_name` varchar(255) DEFAULT NULL,
  `gg_content` varchar(255) DEFAULT NULL,
  `gg_time` varchar(255) DEFAULT NULL,
  `gg_person` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice1
-- ----------------------------
INSERT INTO `notice1` VALUES ('5', '1', '1', '1', 'null');
INSERT INTO `notice1` VALUES ('6', '2', '2', '2019-5-30', 'null');
INSERT INTO `notice1` VALUES ('7', 'gg', 'gg', 'gg', 'null');
INSERT INTO `notice1` VALUES ('8', 'gg', 'gg', 'gg', 'null');

-- ----------------------------
-- Table structure for `second_menu`
-- ----------------------------
DROP TABLE IF EXISTS `second_menu`;
CREATE TABLE `second_menu` (
  `sid` int(10) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `spath` varchar(20) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_menu
-- ----------------------------
INSERT INTO `second_menu` VALUES ('1', '用户查询', 'yhcx.jsp', '1');
INSERT INTO `second_menu` VALUES ('2', '添加用户', 'tjyh.jsp', '1');
INSERT INTO `second_menu` VALUES ('3', '部门查询', 'bmcx.jsp', '2');
INSERT INTO `second_menu` VALUES ('4', '添加部门', 'tjbm.jsp', '2');
INSERT INTO `second_menu` VALUES ('5', '职位查询', 'zwcx.jsp', '3');
INSERT INTO `second_menu` VALUES ('6', '添加职位', 'tjzw.jsp', '3');
INSERT INTO `second_menu` VALUES ('7', '员工查询', 'ygcx.jsp', '4');
INSERT INTO `second_menu` VALUES ('8', '添加员工', 'tjyg.jsp', '4');
INSERT INTO `second_menu` VALUES ('9', '公告查询', 'ggcx.jsp', '5');
INSERT INTO `second_menu` VALUES ('10', '添加公告', 'tjgg.jsp', '5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('47', 'admin', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('48', '123', '123', '123', '2');
INSERT INTO `user` VALUES ('49', '123456', '123456', '123456', '2');
