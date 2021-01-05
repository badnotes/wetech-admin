DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `app_key` varchar(100) DEFAULT NULL COMMENT '应用Key',
  `type` tinyint(1) NOT NULL COMMENT '资源类型(1.菜单 2.按钮或文本块)',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父编号列表',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限字符串',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `config` json DEFAULT NULL COMMENT '权限配置',
  PRIMARY KEY (`id`),
  KEY `idx_sys_permission_parent_id` (`parent_id`),
  KEY `idx_sys_permission_parent_ids` (`parent_ids`)
) COMMENT='资源表';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role` varchar(100) NOT NULL COMMENT '唯一标识',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `app_key` varchar(100) DEFAULT NULL COMMENT '应用Key',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态 1.正常 0.禁用',
  `permission_ids` varchar(500) DEFAULT NULL COMMENT '资源编号列表',
  PRIMARY KEY (`id`),
  KEY `idx_sys_role_resource_ids` (`permission_ids`)
) COMMENT='角色表';

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `role_ids` varchar(100) DEFAULT NULL COMMENT '角色列表',
  `locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  `group_id` bigint(20) DEFAULT NULL COMMENT '分组ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`)
) COMMENT='用户表';

drop table if exists `sys_app`;
create table `sys_app` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `app_key` varchar(100) DEFAULT NULL COMMENT '应用Key',
    `app_name` varchar(100) DEFAULT NULL COMMENT '应用名',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_sys_app_name` (`app_name`)
) comment='应用表';

drop table if exists `sys_group`;
create table `sys_group` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `group_name` varchar(100) DEFAULT NULL COMMENT '分组名',
    `group_level` tinyint(4) DEFAULT NULL COMMENT '等级',
    `parent_id` bigint(20) DEFAULT NULL COMMENT '上一级ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_sys_user_group_name` (`group_name`)
) comment='用户分组表';
