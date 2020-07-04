/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : smbms

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-07-03 10:16:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill` (
  `bid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `billCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单编码',
  `productName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `productDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
  `productUnit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位',
  `productCount` decimal(20,2) DEFAULT NULL COMMENT '商品数量',
  `totalPrice` decimal(20,2) DEFAULT NULL COMMENT '账单总金额',
  `isPayment` int(10) DEFAULT NULL COMMENT '是否付款（1 未支付 2 已支付）',
  `providerId` bigint(20) DEFAULT NULL COMMENT '供应商ID',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_bill
-- ----------------------------
INSERT INTO `smbms_bill` VALUES ('4', ' 12312', '111', '北京市粮油总公司', '111', '111.00', '111.00', '2', '4', '2016-10-28 20:38:31', '6', '2020-07-02 13:18:02', null);
INSERT INTO `smbms_bill` VALUES ('9', '23', '321', '邯郸市五得利面粉厂', null, '88.00', '67867.00', '1', '5', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('10', '231', '231', '顺义燕京啤酒批发3部', null, '99.00', '6767.00', '2', '6', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('11', '231', '213', '北京市粮油总公司', null, '88.00', '7678.00', '1', '7', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('12', '231', '32', '顺义燕京啤酒批发3部', null, '88.00', '6786.00', '1', '8', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('13', '231', '123', '北京市粮油总公司', null, '88.00', '4564.00', '2', '9', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('14', '321', '231', '邯郸市五得利面粉厂', null, '55.00', '74867.00', '1', '10', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('15', '1323', '132', '顺义燕京啤酒批发3部', null, '55.00', '468.00', '2', '11', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('16', '123', '213', '北京市粮油总公司', null, '55.00', '468.00', '2', '12', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('17', '312', '312', '顺义燕京啤酒批发3部', null, '64.00', '4687.00', '2', '13', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('18', '12', '23', '北京市粮油总公司', null, '486.00', '46857.00', '1', '14', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('19', '12', '123', '邯郸市五得利面粉厂', null, '464.00', '48967.00', '2', '15', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('20', '15', '132', '北京市粮油总公司', null, '688.00', '876.00', '2', '16', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('21', '21', '132', '顺义燕京啤酒批发3部', null, '654.00', '867.00', '1', '17', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('22', '34', null, '北京市粮油总公司', null, '6456.00', '867.00', '2', '18', null, null, null, null);
INSERT INTO `smbms_bill` VALUES ('23', '125445', '我发送给', '顺义燕京啤酒批发3部', '安抚', '55.00', '66.00', '2', '19', '2020-07-01 12:25:14', '2', null, null);
INSERT INTO `smbms_bill` VALUES ('24', null, '我发送给', '北京市粮油总公司', '安抚', '55.00', '66.00', '2', '20', '2020-07-02 12:23:23', '0', '2020-07-02 12:23:23', '0');
INSERT INTO `smbms_bill` VALUES ('25', null, '王道', '邯郸市五得利面粉厂', '无极', '88.00', '999.00', '2', '20', '2020-07-02 12:26:05', '0', '2020-07-02 12:26:05', '0');
INSERT INTO `smbms_bill` VALUES ('26', null, 'aghahk', '顺义燕京啤酒批发3部', '撒旦给', '55.00', '66.00', '1', '20', '2020-07-02 12:27:59', '0', '2020-07-02 12:27:59', '0');
INSERT INTO `smbms_bill` VALUES ('27', null, 'dfgd', '邯郸市五得利面粉厂', '安抚', '55.00', '66.00', '2', '11', '2020-07-02 12:37:09', '0', '2020-07-02 12:37:09', '0');
INSERT INTO `smbms_bill` VALUES ('28', '225', '使用体验和', '邯郸市五得利面粉厂', '撒旦给', '55.00', '66.00', '2', '2', '2020-07-02 12:40:06', '0', '2020-07-02 12:40:06', '0');

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `proCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商编码',
  `proName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `proDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商描述信息',
  `proContact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商联系人',
  `proPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `proAddress` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `proFax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_provider
-- ----------------------------
INSERT INTO `smbms_provider` VALUES ('2', '22', '武汉', '23', '萨达', '1212312', '华中科技大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('3', '111', '上海', '222', 'HAOha', '13212345611', '湖北工业大学', '2222', '1', '2014-02-12 00:00:00', '6', '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES ('4', '22', '武汉', '23', '萨达', '1212312', '湖北工业大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('5', '111', '上海', '222', 'HAOha', '13212345611', '湖北工业大学', '2222', '1', '2014-02-12 00:00:00', '6', '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES ('6', '22', '武汉', '23', '萨达', '1212312', '武汉轻工大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('7', '111', '北京', '222', 'HAOha', '13212345611', '华中科技大学', '2222', '1', '2014-02-12 00:00:00', '6', '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES ('8', '22', '上海', '23', '萨达', '1212312', '湖北工业大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('9', '111', '北京', '222', 'HAOha', '13212345611', '华中科技大学', '2222', '1', '2014-02-12 00:00:00', '6', '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES ('10', '22', '武汉', '23', '萨达', '1212312', '武汉轻工大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('11', '111', '北京', '222', 'HAOha', '13212345611', '湖北工业大学', '2222', '1', '2014-02-12 00:00:00', '6', '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES ('12', '22', '武汉', '23', '萨达', '1212312', '武汉轻工大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('13', '111', '北京', '222', 'HAOha', '13212345611', '湖北工业大学', '2222', '1', '2014-02-12 00:00:00', '6', '2016-10-28 22:54:36');
INSERT INTO `smbms_provider` VALUES ('14', '22', '武汉', '23', '萨达', '1212312', '武汉轻工大学', '213', '3', '2014-02-12 00:00:00', null, null);
INSERT INTO `smbms_provider` VALUES ('16', null, 'atggt', '454', 'wowowoo', '13088888888', '454545', '4544', null, '2020-07-01 23:55:19', null, '2020-07-01 23:55:19');
INSERT INTO `smbms_provider` VALUES ('17', null, 'asdfgh', '454', 'sdfhsdhs', '5663', '454545', '4544', null, '2020-07-02 00:00:35', null, '2020-07-02 00:00:35');
INSERT INTO `smbms_provider` VALUES ('18', null, '我们', '1566', 'gkd', '13088888888', '武汉光谷', '1800', null, '2020-07-02 09:28:37', null, '2020-07-02 09:28:37');
INSERT INTO `smbms_provider` VALUES ('19', null, '155,hshsa', '454', 'adfhjdf', '13088888888', '无啊海南吗', '4544', null, '2020-07-02 09:34:29', null, '2020-07-02 09:34:29');
INSERT INTO `smbms_provider` VALUES ('20', null, '4553,投入商业和', '', '实施', '13088888888', '454545', '4544', null, '2020-07-02 09:35:09', null, '2020-07-02 09:35:09');
INSERT INTO `smbms_provider` VALUES ('22', '555', 'd\'f\'g\'j\'ddfgjd', '', 'sh\'j', '5663', '454545', '', null, '2020-07-02 09:38:41', null, '2020-07-02 09:38:41');

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) DEFAULT NULL COMMENT '性别（1 男 2 女）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `userType` int(10) DEFAULT NULL COMMENT '用户类型（1 系统管理员 2 经理 3 普通员工 ）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT '创建者（userId）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT '更新者（userId）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES ('2', '2', '测试2', '2', '1', '1988-08-02', '666666666', '那是的是第四代卡', '2', '0', '2016-10-17 19:33:02', '0', null);
INSERT INTO `smbms_user` VALUES ('6', '1', '人生大事', '1', '1', '2016-10-04', '13523456789', '', '2', '2', '2016-10-17 20:39:15', null, null);
INSERT INTO `smbms_user` VALUES ('9', '4', '123', '123', '2', '2013-10-15', '13123456789', '3216549887', '2', '6', '2016-10-18 23:06:25', '6', '2016-10-18 23:08:38');
INSERT INTO `smbms_user` VALUES ('10', '22', '121212', '323213', '2', '2013-10-15', '13123456789', null, '1', '2', '2016-10-18 23:06:25', null, null);
INSERT INTO `smbms_user` VALUES ('11', '2345', '2231', null, '2', '2013-10-15', '13123456789', null, '2', '6', '2016-10-18 23:06:25', null, null);
INSERT INTO `smbms_user` VALUES ('12', '213', '3213', null, '1', '2013-10-15', null, null, '2', '6', '2016-10-18 23:06:25', null, null);
