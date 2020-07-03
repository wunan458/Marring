/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 58.87.119.229:8306
 Source Schema         : marring_test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 03/07/2020 16:46:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_marring_user
-- ----------------------------
DROP TABLE IF EXISTS `t_marring_user`;
CREATE TABLE `t_marring_user` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `open_id` varchar(255) NOT NULL UNIQUE,
                                  `user_name` varchar(255) DEFAULT NULL,
                                  `state` int(11) DEFAULT NULL,
                                  `description` varchar(255) DEFAULT NULL,
                                  `phone` varchar(255) DEFAULT NULL,
                                  `email` varchar(255) DEFAULT NULL,
                                  `create_time` datetime DEFAULT NULL,
                                  `update_time` datetime DEFAULT NULL,
                                  `created_by` int(4) DEFAULT NULL,
                                  `updated_by` int(4) DEFAULT NULL,
                                  `user_type` int(4) DEFAULT NULL,
                                  `expire_time` datetime DEFAULT NULL,
                                  `nickname` varchar(255) DEFAULT NULL,
                                  `avatar_url` varchar(255) DEFAULT NULL,
                                  `gender` int(4) DEFAULT NULL,
                                  `last_login_time` datetime DEFAULT NULL,
                                  `deleted` int(4) DEFAULT NULL,
                                  `language` varchar(255) DEFAULT NULL,
                                  `city` varchar(255) DEFAULT NULL,
                                  `country` varchar(255) DEFAULT NULL,
                                  `active_join_id` varchar(255) DEFAULT NULL,
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
