/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-04-21 16:51:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bargain`
-- ----------------------------
DROP TABLE IF EXISTS `bargain`;
CREATE TABLE `bargain` (
  `bargainId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL,
  `bookNewPrice` double(10,2) NOT NULL,
  PRIMARY KEY (`bargainId`),
  KEY `FKEC1F8612F7272BF8` (`bookId`),
  CONSTRAINT `FKEC1F8612F7272BF8` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bargain
-- ----------------------------
INSERT INTO `bargain` VALUES ('1', '1', '10.00');
INSERT INTO `bargain` VALUES ('2', '6', '12.00');
INSERT INTO `bargain` VALUES ('3', '5', '11.00');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookNumber` varchar(21) DEFAULT NULL,
  `bookName` varchar(20) NOT NULL,
  `bookAuthor` varchar(20) NOT NULL,
  `bookPress` varchar(20) NOT NULL,
  `bookPicture` varchar(100) NOT NULL,
  `bookAmount` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `bookShelveTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bookPrice` double(10,2) NOT NULL,
  `bookRemark` varchar(200) DEFAULT NULL,
  `bookSales` int(11) NOT NULL,
  PRIMARY KEY (`bookId`),
  KEY `FK2E3AE91674045A` (`typeId`),
  CONSTRAINT `FK2E3AE91674045A` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '12345678912345678', '红楼梦', '曹雪芹', 'XXX出版社', '12042116275879835.gif', '123', '1', '2009-03-25 14:42:22', '15.00', '披阅十年，增删五次', '2');
INSERT INTO `book` VALUES ('5', '12345612345612345', '西游记', '吴承恩', 'XXX出版社', 'xyj001.jpg', '32', '1', '2009-03-05 15:09:00', '12.00', '漫漫取经路', '3');
INSERT INTO `book` VALUES ('6', '12345612345612345', '水浒传', '施耐庵', 'XXX出版社', 'shz001.jpg', '325', '1', '2009-03-05 15:16:24', '23.00', '替天行道', '1');
INSERT INTO `book` VALUES ('7', '12345612345612345', '三国演义', '罗贯中', 'XXX出版社', 'sgyy001.jpg', '666', '1', '2009-03-05 15:24:05', '20.00', '天下三分', '5');
INSERT INTO `book` VALUES ('9', '12345612345612345', '红楼梦之史湘云', '小起', '汇智出版社', 'hlm003.jpg', '65', '1', '2009-03-16 15:36:05', '30.00', '其实没有这本书', '0');
INSERT INTO `book` VALUES ('12', '12345612345612345', '史记', '司马迁', 'XXX出版社', 'sj.jpg', '123', '2', '2009-03-16 15:36:05', '23.00', '史家之绝唱，无韵之离骚', '0');
INSERT INTO `book` VALUES ('13', 'TSBH12042116081014924', '岁月如歌', '小七', '汇智出版社', '12042116080980442.gif', '1', '1', '2012-04-21 16:08:10', '52.00', '岁月如歌', '0');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(11) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(16) NOT NULL,
  `managerPassword` varchar(12) NOT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `ordersTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeal` char(1) NOT NULL,
  `ordersNumber` varchar(21) DEFAULT NULL,
  `totalMoney` double(10,2) NOT NULL,
  PRIMARY KEY (`ordersId`),
  KEY `FKC3DF62E517CFDD3C` (`userId`),
  CONSTRAINT `FKC3DF62E517CFDD3C` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('5', '1', '2009-03-16 11:01:53', '1', 'DDBH09031310105125045', '21.00');
INSERT INTO `orders` VALUES ('6', '1', '2009-03-16 11:01:53', '1', 'DDBH09031316034936676', '20.00');
INSERT INTO `orders` VALUES ('7', '1', '2009-03-13 16:04:09', '0', 'DDBH09031316040936406', '31.00');
INSERT INTO `orders` VALUES ('8', '1', '2009-03-13 16:04:20', '0', 'DDBH09031316042081836', '41.00');
INSERT INTO `orders` VALUES ('9', '1', '2009-03-16 11:01:53', '0', 'DDBH09031316042681842', '53.00');
INSERT INTO `orders` VALUES ('10', '1', '2009-03-16 11:01:53', '1', 'DDBH09031316043280000', '73.00');
INSERT INTO `orders` VALUES ('11', '1', '2009-03-16 11:01:53', '1', 'DDBH09031316045277898', '84.00');
INSERT INTO `orders` VALUES ('12', '1', '2009-03-16 11:01:53', '0', 'DDBH09031316061638196', '104.00');
INSERT INTO `orders` VALUES ('13', '1', '2009-03-16 11:01:53', '0', 'DDBH09031316064167108', '20.00');
INSERT INTO `orders` VALUES ('14', '1', '2009-03-13 16:06:46', '1', 'DDBH09031316064632612', '20.00');
INSERT INTO `orders` VALUES ('15', '1', '2009-03-13 16:06:51', '0', 'DDBH09031316065131785', '11.00');
INSERT INTO `orders` VALUES ('16', '1', '2009-03-13 16:06:58', '1', 'DDBH09031316065881351', '10.00');
INSERT INTO `orders` VALUES ('17', '1', '2009-03-16 17:19:49', '1', 'DDBH09031617194991827', '83.00');
INSERT INTO `orders` VALUES ('18', '1', '2012-04-20 10:53:41', '0', 'DDBH12042010534140375', '10.00');

-- ----------------------------
-- Table structure for `ordersbook`
-- ----------------------------
DROP TABLE IF EXISTS `ordersbook`;
CREATE TABLE `ordersbook` (
  `ordersBookId` int(11) NOT NULL AUTO_INCREMENT,
  `ordersId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `bookAmount` int(11) NOT NULL,
  PRIMARY KEY (`ordersBookId`),
  KEY `FK2E27A34EF7272BF8` (`bookId`),
  CONSTRAINT `FK2E27A34EF7272BF8` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of ordersbook
-- ----------------------------
INSERT INTO `ordersbook` VALUES ('5', '2', '12', '1');
INSERT INTO `ordersbook` VALUES ('6', '2', '7', '1');
INSERT INTO `ordersbook` VALUES ('7', '3', '7', '1');
INSERT INTO `ordersbook` VALUES ('8', '3', '5', '1');
INSERT INTO `ordersbook` VALUES ('9', '4', '1', '1');
INSERT INTO `ordersbook` VALUES ('10', '5', '5', '1');
INSERT INTO `ordersbook` VALUES ('11', '5', '1', '1');
INSERT INTO `ordersbook` VALUES ('12', '6', '7', '1');
INSERT INTO `ordersbook` VALUES ('13', '7', '5', '1');
INSERT INTO `ordersbook` VALUES ('14', '8', '1', '1');
INSERT INTO `ordersbook` VALUES ('15', '9', '6', '1');
INSERT INTO `ordersbook` VALUES ('16', '10', '7', '1');
INSERT INTO `ordersbook` VALUES ('17', '11', '5', '1');
INSERT INTO `ordersbook` VALUES ('18', '12', '7', '1');
INSERT INTO `ordersbook` VALUES ('19', '13', '7', '1');
INSERT INTO `ordersbook` VALUES ('20', '14', '7', '1');
INSERT INTO `ordersbook` VALUES ('21', '15', '5', '1');
INSERT INTO `ordersbook` VALUES ('22', '16', '1', '1');
INSERT INTO `ordersbook` VALUES ('23', '17', '1', '1');
INSERT INTO `ordersbook` VALUES ('24', '17', '5', '1');
INSERT INTO `ordersbook` VALUES ('25', '17', '7', '1');
INSERT INTO `ordersbook` VALUES ('26', '17', '6', '1');
INSERT INTO `ordersbook` VALUES ('27', '17', '9', '1');
INSERT INTO `ordersbook` VALUES ('28', '18', '1', '1');

-- ----------------------------
-- Table structure for `recommended`
-- ----------------------------
DROP TABLE IF EXISTS `recommended`;
CREATE TABLE `recommended` (
  `recommendedId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL,
  PRIMARY KEY (`recommendedId`),
  KEY `FK55B4DE5BF7272BF8` (`bookId`),
  CONSTRAINT `FK55B4DE5BF7272BF8` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of recommended
-- ----------------------------
INSERT INTO `recommended` VALUES ('1', '1');
INSERT INTO `recommended` VALUES ('3', '5');
INSERT INTO `recommended` VALUES ('2', '7');

-- ----------------------------
-- Table structure for `sex`
-- ----------------------------
DROP TABLE IF EXISTS `sex`;
CREATE TABLE `sex` (
  `sexId` int(11) NOT NULL AUTO_INCREMENT,
  `sexType` varchar(4) NOT NULL,
  PRIMARY KEY (`sexId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of sex
-- ----------------------------
INSERT INTO `sex` VALUES ('1', '男');
INSERT INTO `sex` VALUES ('2', '女');
INSERT INTO `sex` VALUES ('3', '未知');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(16) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '文学');
INSERT INTO `type` VALUES ('2', '历史');
INSERT INTO `type` VALUES ('3', '天文');
INSERT INTO `type` VALUES ('4', '地理');
INSERT INTO `type` VALUES ('5', '其他');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(16) NOT NULL,
  `userPassword` varchar(12) NOT NULL,
  `userEmail` varchar(100) NOT NULL,
  `userNickname` varchar(10) DEFAULT NULL,
  `sexId` int(11) NOT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  `userPhone` varchar(24) DEFAULT NULL,
  `userRemark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK36EBCBAE0DAFBC` (`sexId`),
  CONSTRAINT `FK36EBCBAE0DAFBC` FOREIGN KEY (`sexId`) REFERENCES `sex` (`sexId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaoqi', 'xiaoqi0101', 'xiaoqi@163.com.cn', '小起', '1', 'fdsfdfdfdf', '123456789123', 'adasdasdasd');
INSERT INTO `user` VALUES ('2', 'candy', 'candy0101', 'candy@163.com', null, '3', null, null, null);
INSERT INTO `user` VALUES ('3', 'asdasd', 'asdasd', 'asdasd', null, '3', null, null, null);
INSERT INTO `user` VALUES ('4', 'maxianglin', 'maxianglin', 'maxianglin@qq.com', null, '3', null, null, null);
