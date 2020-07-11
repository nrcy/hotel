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

 Date: 12/07/2020 03:22:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `num` int(2) NOT NULL COMMENT '房间号',
  `size` int(2) NOT NULL COMMENT '面积',
  `floor` int(1) NOT NULL COMMENT '楼层',
  `type` int(1) NOT NULL COMMENT '房间类型',
  `price` int(3) NOT NULL COMMENT '价钱',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '状态，0空，1有',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, 1, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (2, 2, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (3, 3, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (4, 4, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (5, 5, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (6, 6, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (7, 7, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (8, 8, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (9, 9, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (10, 10, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (11, 11, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (12, 12, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (13, 13, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (14, 14, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (15, 15, 35, 1, 2, 317, 0);
INSERT INTO `room` VALUES (31, 1, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (32, 2, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (33, 3, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (34, 4, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (35, 5, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (36, 6, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (37, 7, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (38, 8, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (39, 9, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (40, 10, 15, 2, 1, 246, 0);
INSERT INTO `room` VALUES (41, 11, 15, 2, 1, 246, 0);

SET FOREIGN_KEY_CHECKS = 1;
