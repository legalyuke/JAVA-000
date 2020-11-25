/*
 Navicat Premium Data Transfer

 Source Server         : con
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3308
 Source Schema         : e_shop

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 25/11/2020 21:52:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_goods_list
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_list`;
CREATE TABLE `t_goods_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `goods_picture_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品图片链接',
  `goods_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品简介',
  `price` decimal(15, 6) NULL DEFAULT NULL COMMENT '价格',
  `goods_type` int(0) NULL DEFAULT 0 COMMENT '商品分类',
  `stock_number_sum` int(0) NULL DEFAULT 0 COMMENT '总计库存数量',
  `stock_number_rest` int(0) NULL DEFAULT 0 COMMENT '剩余库存数量',
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌',
  `quality_guarantee_period` bigint(0) NULL DEFAULT NULL COMMENT '保质期（天）',
  `create_time` bigint(0) NOT NULL COMMENT '创建时间ms',
  `update_time` bigint(0) NOT NULL COMMENT '更新时间ms',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL COMMENT '下单用户id',
  `order_number` int(0) NOT NULL COMMENT '外部订单id',
  `goods_id` int(0) NOT NULL COMMENT '商品id',
  `price` decimal(15, 6) NOT NULL COMMENT '价格',
  `order_state` int(0) NOT NULL COMMENT '订单状态 0-新建 1-待付款 2-已付款 3-已取消 4-已退货 5-已完成 6-申诉中 7-订单失败',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_picture_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品图片url',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除 0-未删除 1-已删除',
  `create_time` bigint(0) NOT NULL COMMENT '创建时间ms',
  `update_time` bigint(0) NOT NULL COMMENT '更新时间ms',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `head_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `is_frozen` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户是否被冻结 0-未冻结 1-已冻结',
  `frozen_time` bigint(0) NULL DEFAULT NULL COMMENT '冻结时间ms',
  `melt_time` bigint(0) NULL DEFAULT NULL COMMENT '解冻时间ms',
  `create_time` bigint(0) NOT NULL COMMENT '创建时间ms',
  `update_time` bigint(0) NOT NULL COMMENT '更新时间ms',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
