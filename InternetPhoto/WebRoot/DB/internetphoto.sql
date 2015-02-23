/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : internetphoto

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-04-18 17:28:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photoid` int(11) NOT NULL,
  `folderid` int(11) NOT NULL,
  `friendid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  `commentTime` varchar(30) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('13', '79', '30', '16', '18', '帅哦', '2012-04-18 05:12:22', '1');
INSERT INTO `t_comment` VALUES ('14', '113', '29', '18', '16', '哦，好啊', '2012-04-18 08:05:54', '1');
INSERT INTO `t_comment` VALUES ('15', '112', '29', '18', '16', '呵呵。。。', '2012-04-18 11:05:09', '0');

-- ----------------------------
-- Table structure for `t_folder`
-- ----------------------------
DROP TABLE IF EXISTS `t_folder`;
CREATE TABLE `t_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folderName` varchar(50) NOT NULL,
  `folderInfo` varchar(200) DEFAULT NULL,
  `limitid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_t_folder_userid` (`userid`),
  CONSTRAINT `t_folder_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_folder
-- ----------------------------
INSERT INTO `t_folder` VALUES ('28', '聚会', '-玩-', '1', '16');
INSERT INTO `t_folder` VALUES ('29', '月亮之神', '珍藏版哦', '1', '16');
INSERT INTO `t_folder` VALUES ('30', '人物传记', '收藏', '1', '18');
INSERT INTO `t_folder` VALUES ('31', 'happy', '快乐。。。。', '1', '18');

-- ----------------------------
-- Table structure for `t_friend`
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `friendid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_t_friend_userid` (`userid`),
  KEY `foreign_t_friend_friend` (`friendid`),
  CONSTRAINT `t_friend_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_friend_ibfk_2` FOREIGN KEY (`friendid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES ('13', '16', '18');
INSERT INTO `t_friend` VALUES ('14', '18', '19');

-- ----------------------------
-- Table structure for `t_photo`
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photoName` varchar(50) NOT NULL,
  `photoPath` varchar(100) NOT NULL,
  `photoInfo` varchar(100) NOT NULL,
  `createTime` varchar(50) NOT NULL,
  `folderid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `t_photo_folderid` (`folderid`),
  CONSTRAINT `t_photo_folderid` FOREIGN KEY (`folderid`) REFERENCES `t_folder` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_photo
-- ----------------------------
INSERT INTO `t_photo` VALUES ('114', 'role_1', '201204181718055583.jpg', 'role_1', '2012-04-18 18:05:06', '30');
INSERT INTO `t_photo` VALUES ('115', 'role_2', '201204181718245913.jpg', 'role_2', '2012-04-18 18:05:24', '30');
INSERT INTO `t_photo` VALUES ('116', 'role_3', '201204181718573611.jpg', 'role_3', '2012-04-18 18:05:57', '30');
INSERT INTO `t_photo` VALUES ('117', 'role_4', '201204181719306308.jpg', 'role_4', '2012-04-18 19:05:30', '30');
INSERT INTO `t_photo` VALUES ('118', 'role_5', '201204181720002745.jpg', 'role_5', '2012-04-18 20:05:00', '30');
INSERT INTO `t_photo` VALUES ('119', 'play_1', '201204181720224079.jpg', 'play_1', '2012-04-18 20:05:22', '31');
INSERT INTO `t_photo` VALUES ('120', 'play_2', '201204181720445054.jpg', 'play_2', '2012-04-18 20:05:44', '31');
INSERT INTO `t_photo` VALUES ('121', 'play_3', '201204181721036903.jpg', 'play_3', '2012-04-18 21:05:03', '31');
INSERT INTO `t_photo` VALUES ('122', 'play_4', '201204181721282994.jpg', 'play_4', '2012-04-18 21:05:28', '31');
INSERT INTO `t_photo` VALUES ('123', 'moongirl_1', '201204181722098250.png', 'moongirl_1', '2012-04-18 22:05:09', '29');
INSERT INTO `t_photo` VALUES ('124', 'moongirl_2', '20120418172230246.png', 'moongirl_2', '2012-04-18 22:05:30', '29');
INSERT INTO `t_photo` VALUES ('125', 'moongirl_3', '201204181722586658.png', 'moongirl_3', '2012-04-18 22:05:58', '29');
INSERT INTO `t_photo` VALUES ('126', 'moongirl_4', '201204181723286797.png', 'moongirl_4', '2012-04-18 23:05:28', '29');
INSERT INTO `t_photo` VALUES ('127', 'le...', '201204181724116234.jpg', 'haha', '2012-04-18 24:05:11', '28');
INSERT INTO `t_photo` VALUES ('128', 'xixi', '201204181724378833.jpg', 'wu....', '2012-04-18 24:05:37', '28');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `userPassword` varchar(30) NOT NULL,
  `sex` varchar(4) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('16', '沙漠狂舞', 's123456', '男', '2012-04-18 00:00:00', '13569366417', '564660837@qq.com', 'earth....', '失落的世界');
INSERT INTO `t_user` VALUES ('17', '风中沙', 'f123456', '男', '2012-04-18 00:00:00', '1389398109', '1258872637@qq.com', 'moon...', '走四方');
INSERT INTO `t_user` VALUES ('18', '小樱', 'x123456', '女', '2012-04-18 00:00:00', '13981025407', '48954620324@qq.com', '忍者村', 'on the way....');
INSERT INTO `t_user` VALUES ('19', '魔衣', 'm123456', '女', '2012-04-18 00:00:00', '135625801436', '584920324@qq.com', 'where?', '呵呵呵。。。。');
