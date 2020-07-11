/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : 
 Source Schema         : hotel

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 12/07/2020 03:22:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` int(10) NOT NULL,
  `is_evaluate` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consumption` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, 'tom', 123456, 'y', 1493);
INSERT INTO `user` VALUES (9, 'tim', 1234, 'y', 654);
INSERT INTO `user` VALUES (10, 'alice', 1234567, 'y', 0);

SET FOREIGN_KEY_CHECKS = 1;
