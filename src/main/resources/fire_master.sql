/*
 Navicat Premium Data Transfer

 Source Server         : dmysql
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : 192.168.1.99:3306
 Source Schema         : fire_master

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 12/02/2019 19:25:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pack_original
-- ----------------------------
DROP TABLE IF EXISTS `pack_original`;
CREATE TABLE `pack_original` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID、接收客户端',
  `host` char(64) NOT NULL COMMENT '客户端',
  `content` varchar(2128) DEFAULT NULL COMMENT '数据包内容',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `memo` varchar(255) DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接收客户端包存储';

-- ----------------------------
-- Records of pack_original
-- ----------------------------
BEGIN;
INSERT INTO `pack_original` VALUES (1, '192.168.1.100', 'Hello Sunny!', '2019-02-11 02:53:19', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `value` int(11) DEFAULT NULL COMMENT '代码值',
  `data_type` int(11) DEFAULT NULL COMMENT '数据类型',
  `definition` varchar(127) DEFAULT NULL COMMENT '定义',
  `depiction` varchar(255) DEFAULT NULL COMMENT '说明',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `memo` varchar(255) DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8 COMMENT='系统数据字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` VALUES (1, 1, NULL, '控制单元命令定义', '类型定义', '2019-02-11 11:03:31', '');
INSERT INTO `sys_dict` VALUES (2, 2, NULL, '数据单元类型标识', '类型定义', '2019-02-11 11:33:03', NULL);
INSERT INTO `sys_dict` VALUES (3, 3, NULL, '系统类型定义', '类型定义', '2019-02-11 11:33:39', NULL);
INSERT INTO `sys_dict` VALUES (4, 4, NULL, '建筑消防设施部件类型定义', '类型定义', '2019-02-11 11:35:57', NULL);
INSERT INTO `sys_dict` VALUES (5, 5, NULL, '模拟量定义', '类型定义', '2019-02-11 12:05:19', NULL);
INSERT INTO `sys_dict` VALUES (6, 0, 1, '预留', NULL, '2019-02-11 12:11:19', NULL);
INSERT INTO `sys_dict` VALUES (7, 1, 1, '控制命令', '时间同步', '2019-02-11 12:12:07', NULL);
INSERT INTO `sys_dict` VALUES (8, 2, 1, '发送数据', '发送火灾报警和建筑消防设施运行状态等信息', '2019-02-11 12:13:14', NULL);
INSERT INTO `sys_dict` VALUES (9, 3, 1, '确认', '对控制命令和发送信息的确认回答', '2019-02-11 12:13:44', NULL);
INSERT INTO `sys_dict` VALUES (10, 4, 1, '请求', '查询火灾报警和建筑消防设施运行等信息', '2019-02-11 12:14:26', NULL);
INSERT INTO `sys_dict` VALUES (11, 5, 1, '应答', '返回查询的信息', '2019-02-11 12:15:40', NULL);
INSERT INTO `sys_dict` VALUES (12, 6, 1, '否认', '对控制命令和发送信息的否认回答', '2019-02-11 12:16:50', NULL);
INSERT INTO `sys_dict` VALUES (13, 0, 2, '预留', '上行', '2019-02-11 12:18:42', NULL);
INSERT INTO `sys_dict` VALUES (14, 1, 2, '上传消防设施系统状态', '上行', '2019-02-11 12:19:48', NULL);
INSERT INTO `sys_dict` VALUES (15, 2, 2, '上传建筑消防设施部件运行状态', '上行', '2019-02-11 12:48:15', NULL);
INSERT INTO `sys_dict` VALUES (16, 3, 2, '上传建筑设施部件模拟量值', '上行', '2019-02-11 12:49:57', NULL);
INSERT INTO `sys_dict` VALUES (17, 4, 2, '上传建筑消防设施操作信息', '上行', '2019-02-11 12:51:57', NULL);
INSERT INTO `sys_dict` VALUES (18, 5, 2, '上传建筑消防设施软件版本', '上行', '2019-02-11 12:53:19', NULL);
INSERT INTO `sys_dict` VALUES (19, 6, 2, '上传建筑消防设施系统配置情况', '上行', '2019-02-11 12:56:32', NULL);
INSERT INTO `sys_dict` VALUES (20, 7, 2, '上传建筑消防设施部件配置情况', '上行', '2019-02-11 12:59:07', NULL);
INSERT INTO `sys_dict` VALUES (21, 8, 2, '上传建筑消防设施系统时间', '上行', '2019-02-11 12:58:59', NULL);
INSERT INTO `sys_dict` VALUES (22, 21, 2, '上传用户传输装置运行状态', '上行', '2019-02-11 13:23:21', NULL);
INSERT INTO `sys_dict` VALUES (23, 22, 2, '预留', '上行', '2019-02-11 13:23:56', NULL);
INSERT INTO `sys_dict` VALUES (24, 23, 2, '预留', '上行', '2019-02-11 13:24:11', NULL);
INSERT INTO `sys_dict` VALUES (25, 24, 2, '上传用户信息传输装置操作信息', '上行', '2019-02-11 13:25:51', NULL);
INSERT INTO `sys_dict` VALUES (26, 25, 2, '上传用户信息传输装置软件版本', '上行', '2019-02-11 13:26:57', NULL);
INSERT INTO `sys_dict` VALUES (27, 26, 2, '上传用户信息传输装置配置情况', '上行', '2019-02-11 21:28:27', NULL);
INSERT INTO `sys_dict` VALUES (28, 27, 2, '预留', '上行', '2019-02-11 13:29:13', NULL);
INSERT INTO `sys_dict` VALUES (29, 28, 2, '上传用户信息传输装置系统时间', '上行', '2019-02-11 13:30:32', NULL);
INSERT INTO `sys_dict` VALUES (31, 61, 2, '读建筑消防设施系统状态', '下行', '2019-02-12 06:18:17', NULL);
INSERT INTO `sys_dict` VALUES (32, 62, 2, '读建筑消防设施部件运行状态', '下行', '2019-02-12 06:19:10', NULL);
INSERT INTO `sys_dict` VALUES (33, 63, 2, '读建筑消防设施部件模拟量值', '下行', '2019-02-12 06:21:29', NULL);
INSERT INTO `sys_dict` VALUES (34, 64, 2, '读建筑消防设施操作信息', '下行', '2019-02-12 06:22:03', NULL);
INSERT INTO `sys_dict` VALUES (35, 65, 2, '读建筑消防设施软件版本', '下行', '2019-02-12 06:22:44', NULL);
INSERT INTO `sys_dict` VALUES (36, 66, 2, '读建筑消防设施系配置情况', '下行', '2019-02-12 06:23:51', NULL);
INSERT INTO `sys_dict` VALUES (37, 67, 2, '读建筑消防设施部件配置情况', '下行', '2019-02-12 06:24:43', NULL);
INSERT INTO `sys_dict` VALUES (38, 68, 2, '读建筑消防设施系统时间', '下行', '2019-02-12 06:25:10', NULL);
INSERT INTO `sys_dict` VALUES (39, 81, 2, '读用户信息传输装置运行状态', '下行', '2019-02-12 06:26:18', NULL);
INSERT INTO `sys_dict` VALUES (40, 82, 2, '预留', '下行', '2019-02-12 06:26:43', NULL);
INSERT INTO `sys_dict` VALUES (41, 83, 2, '预留', '下行', '2019-02-12 06:26:56', NULL);
INSERT INTO `sys_dict` VALUES (42, 84, 2, '读用户信息传输装置操作信息记录', '下行', '2019-02-12 06:27:53', NULL);
INSERT INTO `sys_dict` VALUES (43, 85, 2, '读用户信心传输装置软件版本', '下行', '2019-02-12 06:28:51', NULL);
INSERT INTO `sys_dict` VALUES (44, 86, 2, '读用户信息传输装置配置情况', '下行', '2019-02-12 06:29:58', NULL);
INSERT INTO `sys_dict` VALUES (45, 87, 2, '预留', '下行', '2019-02-12 06:30:17', NULL);
INSERT INTO `sys_dict` VALUES (46, 88, 2, '读用户信息传输装置系统时间', '下行', '2019-02-12 06:31:10', NULL);
INSERT INTO `sys_dict` VALUES (47, 89, 2, '初始化用户信息传输装置', '下行', '2019-02-12 06:31:54', NULL);
INSERT INTO `sys_dict` VALUES (48, 90, 2, '同步用户信息传输装置', '下行', '2019-02-12 06:32:34', NULL);
INSERT INTO `sys_dict` VALUES (49, 90, 2, '同步用户信息传输装置时钟', '下行', '2019-02-12 06:34:04', NULL);
INSERT INTO `sys_dict` VALUES (50, 91, 2, '查岗命令', '下行', '2019-02-12 06:34:54', NULL);
INSERT INTO `sys_dict` VALUES (51, 0, 3, '通用', '系统类型', '2019-02-12 06:35:56', NULL);
INSERT INTO `sys_dict` VALUES (52, 1, 3, '火灾报警系统', '系统类型', '2019-02-12 06:36:34', NULL);
INSERT INTO `sys_dict` VALUES (53, 10, 3, '消防联动控制器', '系统类型', '2019-02-12 06:37:46', NULL);
INSERT INTO `sys_dict` VALUES (54, 11, 3, '消火栓系统', '系统类型', '2019-02-12 06:38:17', NULL);
INSERT INTO `sys_dict` VALUES (55, 12, 3, '自动喷水灭火系统', '系统类型', '2019-02-12 06:39:46', NULL);
INSERT INTO `sys_dict` VALUES (56, 13, 3, '气体灭火系统', '系统类型', '2019-02-12 09:07:17', NULL);
INSERT INTO `sys_dict` VALUES (57, 14, 3, '水喷雾灭火系统(泵启动方式)', '系统类型', '2019-02-12 09:09:13', NULL);
INSERT INTO `sys_dict` VALUES (58, 15, 3, '水喷雾灭火系统(压力容器启动方式)', '系统类型', '2019-02-12 09:10:26', NULL);
INSERT INTO `sys_dict` VALUES (59, 16, 3, '泡沫灭火系统', '系统类型', '2019-02-12 09:13:54', NULL);
INSERT INTO `sys_dict` VALUES (60, 17, 3, '干粉灭火系统', '系统类型', '2019-02-12 09:13:54', NULL);
INSERT INTO `sys_dict` VALUES (61, 18, 3, '防烟排烟系统', '系统类型', '2019-02-12 09:16:16', NULL);
INSERT INTO `sys_dict` VALUES (62, 19, 3, '防火门及卷帘系统', '系统类型', '2019-02-12 09:16:18', NULL);
INSERT INTO `sys_dict` VALUES (63, 20, 3, '消防电梯', '系统类型', '2019-02-12 09:16:19', NULL);
INSERT INTO `sys_dict` VALUES (64, 21, 3, '消防应急广播', '系统类型', '2019-02-12 09:16:21', NULL);
INSERT INTO `sys_dict` VALUES (65, 22, 3, '消防应急照明和疏散指示系统', '系统类型', '2019-02-12 09:16:22', NULL);
INSERT INTO `sys_dict` VALUES (66, 23, 3, '消防电源', '系统类型', '2019-02-12 09:16:23', NULL);
INSERT INTO `sys_dict` VALUES (67, 24, 3, '消防电话', '系统类型', '2019-02-12 09:17:40', NULL);
INSERT INTO `sys_dict` VALUES (69, 0, 4, '通用', '部件类型', '2019-02-12 09:18:14', NULL);
INSERT INTO `sys_dict` VALUES (70, 1, 4, '火灾报警控制器', '部件类型', '2019-02-12 09:18:56', NULL);
INSERT INTO `sys_dict` VALUES (71, 10, 4, '可燃气体探测器', '部件类型', '2019-02-12 09:18:57', NULL);
INSERT INTO `sys_dict` VALUES (72, 11, 4, '点型可燃气体探测器', '部件类型', '2019-02-12 10:14:59', NULL);
INSERT INTO `sys_dict` VALUES (73, 12, 4, '独立式可燃气体探测器', '部件类型', '2019-02-12 10:15:02', NULL);
INSERT INTO `sys_dict` VALUES (74, 13, 4, '线性可燃气体探测器', '部件类型', '2019-02-12 10:15:04', NULL);
INSERT INTO `sys_dict` VALUES (75, 16, 4, '电气火灾监控报警器', '部件类型', '2019-02-12 10:15:10', NULL);
INSERT INTO `sys_dict` VALUES (76, 17, 4, '剩余电流式电气火灾监控探测器', '部件类型', '2019-02-12 10:15:14', NULL);
INSERT INTO `sys_dict` VALUES (77, 18, 4, '测温式电气火灾监控探测器', '部件类型', '2019-02-12 10:15:19', NULL);
INSERT INTO `sys_dict` VALUES (78, 21, 4, '探测回路', '部件类型', '2019-02-12 10:15:23', NULL);
INSERT INTO `sys_dict` VALUES (79, 22, 4, '火灾显示盘', '部件类型', '2019-02-12 10:15:39', NULL);
INSERT INTO `sys_dict` VALUES (80, 23, 4, '手动火灾报警按钮', '部件类型', '2019-02-12 10:15:50', NULL);
INSERT INTO `sys_dict` VALUES (81, 24, 4, '消火栓按钮', '部件类型', '2019-02-12 10:15:53', NULL);
INSERT INTO `sys_dict` VALUES (82, 25, 4, '火灾探测器', '部件类型', '2019-02-12 10:15:56', NULL);
INSERT INTO `sys_dict` VALUES (83, 30, 4, '感温火灾探测器', '部件类型', '2019-02-12 10:16:01', NULL);
INSERT INTO `sys_dict` VALUES (84, 31, 4, '点型感温火灾探测器', '部件类型', '2019-02-12 10:16:11', NULL);
INSERT INTO `sys_dict` VALUES (85, 32, 4, '点型感温火灾探测器(S型)', '部件类型', '2019-02-12 10:16:15', NULL);
INSERT INTO `sys_dict` VALUES (86, 33, 4, '点型感温火灾探测器(R型)', '部件类型', '2019-02-12 10:16:16', NULL);
INSERT INTO `sys_dict` VALUES (87, 34, 4, '线型感温火灾探测器', '部件类型', '2019-02-12 10:16:18', NULL);
INSERT INTO `sys_dict` VALUES (88, 35, 4, '线型感温火灾探测器(S型)', '部件类型', '2019-02-12 10:16:23', NULL);
INSERT INTO `sys_dict` VALUES (89, 36, 4, '线型感温火灾探测器(R型)', '部件类型', '2019-02-12 10:16:25', NULL);
INSERT INTO `sys_dict` VALUES (90, 37, 4, '光纤感温火灾探测器', '部件类型', '2019-02-12 10:16:28', NULL);
INSERT INTO `sys_dict` VALUES (91, 38, 4, '预留', '部件类型', '2019-02-12 10:16:33', NULL);
INSERT INTO `sys_dict` VALUES (92, 39, 4, '预留', '部件类型', '2019-02-12 10:16:43', NULL);
INSERT INTO `sys_dict` VALUES (93, 40, 4, '感烟火灾探测器', '部件类型', '2019-02-12 10:16:47', NULL);
INSERT INTO `sys_dict` VALUES (94, 41, 4, '点型离子感烟火灾探测器', '部件类型', '2019-02-12 10:23:23', NULL);
INSERT INTO `sys_dict` VALUES (95, 42, 4, '点型光电感烟火灾探测器', '部件类型', '2019-02-12 10:23:23', NULL);
INSERT INTO `sys_dict` VALUES (96, 43, 4, '线型光束感烟火灾探测器', '部件类型', '2019-02-12 10:23:31', NULL);
INSERT INTO `sys_dict` VALUES (97, 44, 4, '吸气式感烟火灾探测器', '部件类型', '2019-02-12 10:23:32', NULL);
INSERT INTO `sys_dict` VALUES (98, 50, 4, '复合式火灾探测器', '部件类型', '2019-02-12 10:23:40', NULL);
INSERT INTO `sys_dict` VALUES (99, 51, 4, '复合式感烟感温火灾探测器', '部件类型', '2019-02-12 10:23:42', NULL);
INSERT INTO `sys_dict` VALUES (100, 52, 4, '复合式感光感温火灾探测器', '部件类型', '2019-02-12 10:23:45', NULL);
INSERT INTO `sys_dict` VALUES (101, 53, 4, '复合式感光感烟火灾探测器', '部件类型', '2019-02-12 10:23:47', NULL);
INSERT INTO `sys_dict` VALUES (102, 60, 4, '预留', '部件类型', '2019-02-12 10:24:01', NULL);
INSERT INTO `sys_dict` VALUES (103, 61, 4, '紫外火焰探测器', '部件类型', '2019-02-12 10:24:07', NULL);
INSERT INTO `sys_dict` VALUES (104, 62, 4, '红外火焰探测器', '部件类型', '2019-02-12 10:24:09', NULL);
INSERT INTO `sys_dict` VALUES (105, 69, 4, '感光火灾探测器', '部件类型', '2019-02-12 10:24:19', NULL);
INSERT INTO `sys_dict` VALUES (106, 74, 4, '气体探测器', '部件类型', '2019-02-12 10:24:28', NULL);
INSERT INTO `sys_dict` VALUES (107, 78, 4, '图像摄像方式火灾探测器', '部件类型', '2019-02-12 10:24:38', NULL);
INSERT INTO `sys_dict` VALUES (108, 79, 4, '感声火灾探测器', '部件类型', '2019-02-12 10:24:39', NULL);
INSERT INTO `sys_dict` VALUES (109, 80, 4, '预留', '部件类型', '2019-02-12 10:24:42', NULL);
INSERT INTO `sys_dict` VALUES (110, 81, 4, '气体灭火控制器', '部件类型', '2019-02-12 10:24:45', NULL);
INSERT INTO `sys_dict` VALUES (111, 82, 4, '消防电气控制装置', '部件类型', '2019-02-12 10:24:47', NULL);
INSERT INTO `sys_dict` VALUES (112, 83, 4, '消防控制室图形显示装置', '部件类型', '2019-02-12 10:24:54', NULL);
INSERT INTO `sys_dict` VALUES (113, 84, 4, '模块', '部件类型', '2019-02-12 10:24:59', NULL);
INSERT INTO `sys_dict` VALUES (114, 85, 4, '输入模块', '部件类型', '2019-02-12 10:25:01', NULL);
INSERT INTO `sys_dict` VALUES (115, 86, 4, '输出模块', '部件类型', '2019-02-12 10:25:02', NULL);
INSERT INTO `sys_dict` VALUES (116, 87, 4, '输入/输出模块', '部件类型', '2019-02-12 10:25:04', NULL);
INSERT INTO `sys_dict` VALUES (117, 88, 4, '中继模块', '部件类型', '2019-02-12 10:25:07', NULL);
INSERT INTO `sys_dict` VALUES (118, 91, 4, '消防水泵', '部件类型', '2019-02-12 10:25:11', NULL);
INSERT INTO `sys_dict` VALUES (119, 92, 4, '消防水箱', '部件类型', '2019-02-12 10:25:14', NULL);
INSERT INTO `sys_dict` VALUES (120, 95, 4, '喷淋泵', '部件类型', '2019-02-12 10:25:23', NULL);
INSERT INTO `sys_dict` VALUES (121, 96, 4, '水流指示器', '部件类型', '2019-02-12 10:25:27', NULL);
INSERT INTO `sys_dict` VALUES (122, 97, 4, '信号阀', '部件类型', '2019-02-12 10:25:31', NULL);
INSERT INTO `sys_dict` VALUES (123, 98, 4, '报警阀', '部件类型', '2019-02-12 10:25:35', NULL);
INSERT INTO `sys_dict` VALUES (124, 99, 4, '压力开关', '部件类型', '2019-02-12 10:25:38', NULL);
INSERT INTO `sys_dict` VALUES (125, 100, 4, '预留', '部件类型', '2019-02-12 10:25:40', NULL);
INSERT INTO `sys_dict` VALUES (126, 101, 4, '阀驱动装置', '部件类型', '2019-02-12 10:25:50', NULL);
INSERT INTO `sys_dict` VALUES (127, 102, 4, '防火门', '部件类型', '2019-02-12 10:25:55', NULL);
INSERT INTO `sys_dict` VALUES (128, 103, 4, '防火阀', '部件类型', '2019-02-12 10:25:58', NULL);
INSERT INTO `sys_dict` VALUES (129, 104, 4, '通风空调', '部件类型', '2019-02-12 10:26:01', NULL);
INSERT INTO `sys_dict` VALUES (130, 105, 4, '泡沫液泵', '部件类型', '2019-02-12 10:26:04', NULL);
INSERT INTO `sys_dict` VALUES (131, 106, 4, '管网电磁阀', '部件类型', '2019-02-12 10:26:09', NULL);
INSERT INTO `sys_dict` VALUES (132, 111, 4, '防烟排烟风机', '部件类型', '2019-02-12 10:26:17', NULL);
INSERT INTO `sys_dict` VALUES (133, 112, 4, '预留', '部件类型', '2019-02-12 10:26:20', NULL);
INSERT INTO `sys_dict` VALUES (134, 113, 4, '排烟防火阀', '部件类型', '2019-02-12 10:26:24', NULL);
INSERT INTO `sys_dict` VALUES (135, 114, 4, '常闭送风口', '部件类型', '2019-02-12 10:26:27', NULL);
INSERT INTO `sys_dict` VALUES (136, 115, 4, '排烟口', '部件类型', '2019-02-12 10:26:31', NULL);
INSERT INTO `sys_dict` VALUES (137, 116, 4, '电控挡烟垂壁', '部件类型', '2019-02-12 10:26:40', NULL);
INSERT INTO `sys_dict` VALUES (138, 117, 4, '防火卷帘控制器', '部件类型', '2019-02-12 10:26:46', NULL);
INSERT INTO `sys_dict` VALUES (139, 118, 4, '防火监控器', '部件类型', '2019-02-12 10:26:51', NULL);
INSERT INTO `sys_dict` VALUES (140, 121, 4, '警报装置', '部件类型', '2019-02-12 10:26:54', NULL);
INSERT INTO `sys_dict` VALUES (142, 0, 5, '未用', NULL, '2019-02-12 10:35:21', NULL);
INSERT INTO `sys_dict` VALUES (143, 1, 5, '事件计数', '件', '2019-02-12 11:06:10', '0～32000');
INSERT INTO `sys_dict` VALUES (144, 2, 5, '高度', 'm', '2019-02-12 11:06:02', '0～320');
INSERT INTO `sys_dict` VALUES (145, 3, 5, '温度', '°C', '2019-02-12 11:05:52', '-273～+273');
INSERT INTO `sys_dict` VALUES (146, 4, 5, '压力', 'MPa(兆帕)', '2019-02-12 11:07:04', '0～3200');
INSERT INTO `sys_dict` VALUES (147, 5, 5, '压力', 'kPa(千帕)', '2019-02-12 11:09:28', '0～3200');
INSERT INTO `sys_dict` VALUES (148, 6, 5, '气体浓度', '%LEL', '2019-02-12 11:09:48', '0-100');
INSERT INTO `sys_dict` VALUES (149, 7, 5, '时间', 's', '2019-02-12 11:10:26', '0～32000');
INSERT INTO `sys_dict` VALUES (150, 8, 5, '电压', 'V', '2019-02-12 11:11:05', '0～3200');
INSERT INTO `sys_dict` VALUES (151, 9, 5, '电流', 'A', '2019-02-12 11:11:23', '0～3200');
INSERT INTO `sys_dict` VALUES (152, 10, 5, '流量', 'L/s', '2019-02-12 11:11:51', '0～3200');
INSERT INTO `sys_dict` VALUES (153, 11, 5, '风量', 'm³/min', '2019-02-12 11:20:01', '0～3200');
INSERT INTO `sys_dict` VALUES (154, 12, 5, '风速', 'm/s', '2019-02-12 11:21:07', '0～20');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
