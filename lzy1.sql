/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : lzy

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2020-04-19 13:08:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `administrators`
-- ----------------------------
DROP TABLE IF EXISTS `administrators`;
CREATE TABLE `administrators` (
  `adminID` varchar(12) NOT NULL,
  `name` varchar(12) NOT NULL,
  `phone` varchar(20) default NULL,
  `address` varchar(255) default NULL,
  PRIMARY KEY  (`adminID`),
  CONSTRAINT `idKEY` FOREIGN KEY (`adminID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrators
-- ----------------------------
INSERT INTO administrators VALUES ('2', '管理员', '18887888', '地址1');

-- ----------------------------
-- Table structure for `notices`
-- ----------------------------
DROP TABLE IF EXISTS `notices`;
CREATE TABLE `notices` (
  `noticeID` int(6) unsigned zerofill NOT NULL auto_increment,
  `detail` varchar(1024) NOT NULL,
  `date` datetime NOT NULL,
  `headline` varchar(512) NOT NULL,
  PRIMARY KEY  (`noticeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notices
-- ----------------------------
INSERT INTO notices VALUES ('000001', '11111', '2020-03-21 11:06:39', '标题1');
INSERT INTO notices VALUES ('000002', '222222', '2020-03-21 11:06:39', '标题2');
INSERT INTO notices VALUES ('000003', '3333as33', '2020-03-21 11:21:22', '通知3');
INSERT INTO notices VALUES ('000004', '444444', '2020-03-21 11:06:39', '标题4');
INSERT INTO notices VALUES ('000005', '555555', '2020-03-21 11:06:39', '标题5');
INSERT INTO notices VALUES ('000007', '77777', '2020-03-21 11:06:39', '标题7');
INSERT INTO notices VALUES ('000008', 'ss', '2020-03-23 21:55:43', '标题8');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pID` int(4) NOT NULL,
  `pName` varchar(12) NOT NULL,
  PRIMARY KEY  (`pID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO permission VALUES ('0', '学生');
INSERT INTO permission VALUES ('1', '老师');
INSERT INTO permission VALUES ('2', '管理员');
INSERT INTO permission VALUES ('3', '专业负责人');
INSERT INTO permission VALUES ('4', '院长');

-- ----------------------------
-- Table structure for `projects`
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `projectID` int(9) unsigned zerofill NOT NULL auto_increment,
  `title` varchar(64) NOT NULL,
  `detail` varchar(1024) NOT NULL,
  `date` date NOT NULL,
  `teacherID` varchar(12) default NULL,
  `studentID` varchar(12) default NULL,
  `status` int(11) NOT NULL default '0',
  `hasSelected` int(2) unsigned NOT NULL default '0',
  PRIMARY KEY  (`projectID`),
  UNIQUE KEY `title` (`title`),
  KEY `stuKEY` (`studentID`),
  KEY `teaKEY` (`teacherID`),
  CONSTRAINT `stuKEY` FOREIGN KEY (`studentID`) REFERENCES `students` (`stuID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `teaKEY` FOREIGN KEY (`teacherID`) REFERENCES `teachers` (`teaID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO projects VALUES ('000000002', '基于xxx的课设2', '毕设内容22', '2020-03-23', '1', null, '5', '0');
INSERT INTO projects VALUES ('000000003', '基于xxx的课设3', '毕设内容3', '2020-03-23', '3', null, '0', '0');
INSERT INTO projects VALUES ('000000004', '基于xxx的课设5', 'asda', '2020-04-04', '4', null, '0', '0');
INSERT INTO projects VALUES ('000000007', '基于xxx的课设8', 'ssss', '2020-04-05', '1', null, '1', '0');
INSERT INTO projects VALUES ('000000008', '审核流程测试课题', '222', '2020-04-06', '1', '0', '5', '0');
INSERT INTO projects VALUES ('000000009', '院长课题', 'sss', '2020-04-06', '4', '10', '5', '1');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stuID` varchar(12) NOT NULL,
  `name` varchar(12) NOT NULL,
  `gender` varchar(12) NOT NULL,
  `subject` varchar(12) default NULL,
  `department` varchar(64) default NULL,
  `age` varchar(12) NOT NULL,
  `address` varchar(255) default NULL,
  `phone` varchar(32) default NULL,
  `projectID` int(9) unsigned default NULL,
  `yearClass` int(9) unsigned default NULL,
  PRIMARY KEY  (`stuID`),
  KEY `pidKEY` (`projectID`),
  CONSTRAINT `pidKEY` FOREIGN KEY (`projectID`) REFERENCES `projects` (`projectID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `userKEY` FOREIGN KEY (`stuID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 4096 kB; (`stuID`) REFER `lzy/users`(`userID`) ';

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO students VALUES ('0', 'jerry lv', '男', '专业2', '学院2', '32', '无', '18878102370', '8', '2016');
INSERT INTO students VALUES ('10', 'jerry lv2', '女', '专业2', '学院2', '222', '无', '18878102370', '9', '2016');

-- ----------------------------
-- Table structure for `teachers`
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `teaID` varchar(12) NOT NULL,
  `name` varchar(12) NOT NULL,
  `gender` varchar(12) NOT NULL,
  `age` varchar(12) NOT NULL,
  `position` varchar(64) default NULL,
  `department` varchar(64) default NULL,
  `address` varchar(255) default NULL,
  `phone` varchar(32) default NULL,
  PRIMARY KEY  (`teaID`),
  CONSTRAINT `teaIDKEY` FOREIGN KEY (`teaID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO teachers VALUES ('1', '教师', '女', '23', '教师', null, null, null);
INSERT INTO teachers VALUES ('3', '专业负责人', '女', '33', '专业负责人', null, null, null);
INSERT INTO teachers VALUES ('4', '院长', '男', '44', '院长', 'Ince', 'addre', '13232');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userID` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `permission` int(4) default NULL,
  PRIMARY KEY  (`userID`),
  KEY `pKEY` (`permission`),
  CONSTRAINT `pKEY` FOREIGN KEY (`permission`) REFERENCES `permission` (`pID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO users VALUES ('0', '123', '0');
INSERT INTO users VALUES ('1', '123', '1');
INSERT INTO users VALUES ('10', '123', '0');
INSERT INTO users VALUES ('2', '123', '2');
INSERT INTO users VALUES ('3', '123', '3');
INSERT INTO users VALUES ('4', '123', '4');
