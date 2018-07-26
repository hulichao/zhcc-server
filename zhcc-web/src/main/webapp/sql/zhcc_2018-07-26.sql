# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: zhcc
# Generation Time: 2018-07-26 08:51:31 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table sys_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  `permission` varchar(200) NOT NULL,
  `is_locked` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `router_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;

INSERT INTO `sys_resource` (`id`, `name`, `code`, `url`, `permission`, `is_locked`, `router_id`)
VALUES
	(1,'查询用户','users','/users','users:read',0,2),
	(2,'添加用户','users','/users','users:create',0,2),
	(3,'修改用户','users','/users','users:update',0,2),
	(4,'删除用户','users','/users','users:delete',0,2),
	(5,'查询路由','routers','/routers','routers:read',0,5),
	(6,'添加路由','routers','/routers','routers:create',0,5),
	(7,'修改路由','routers','/routers','routers:update',0,5),
	(8,'删除路由','routers','/routers','routers:delete',0,5),
	(9,'查询角色','roles','/roles','roles:read',0,4),
	(10,'修改角色','roles','/roles','roles:update',0,4),
	(11,'添加角色','roles','/roles','roles:create',0,4),
	(12,'resources','resources','/resources','resources:update',0,3),
	(13,'添加资源','resources','/resources','resources:create',0,3),
	(14,'删除资源','resources','/resources','resources:delete',0,3),
	(15,'查询资源','resources','/resources','resources:read',0,3),
	(16,'删除角色','roles','/roles','roles:delete',0,4);

/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_resource_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_resource_permission`;

CREATE TABLE `sys_resource_permission` (
  `role_id` smallint(6) unsigned NOT NULL,
  `resource_id` smallint(6) unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_resource_permission` WRITE;
/*!40000 ALTER TABLE `sys_resource_permission` DISABLE KEYS */;

INSERT INTO `sys_resource_permission` (`role_id`, `resource_id`)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(1,4),
	(1,5),
	(1,6),
	(1,7),
	(1,8),
	(1,9),
	(1,10),
	(1,11),
	(1,12),
	(1,13),
	(1,14),
	(1,15),
	(1,16),
	(2,1),
	(2,2),
	(2,3),
	(2,4);

/*!40000 ALTER TABLE `sys_resource_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `is_locked` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;

INSERT INTO `sys_role` (`id`, `code`, `name`, `is_locked`)
VALUES
	(1,'admin','超级管理员',0),
	(2,'bus','业务管理员',0),
	(3,'customer','过往游客',0),
	(9,'role5','role5',0),
	(10,'role6','role6',0),
	(11,'role7','role7',0),
	(12,'role8','role8',0),
	(13,'role9','role9',0),
	(14,'role10','role10',0),
	(15,'role11 ','role11',0),
	(16,'role12','role12',0),
	(17,'role13','role13',0),
	(18,'role14','role14',0);

/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_router
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_router`;

CREATE TABLE `sys_router` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `parent_id` smallint(5) unsigned NOT NULL,
  `level` tinyint(3) unsigned NOT NULL,
  `is_locked` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `display_order` smallint(5) unsigned NOT NULL DEFAULT '0',
  `properties` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_url_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_router` WRITE;
/*!40000 ALTER TABLE `sys_router` DISABLE KEYS */;

INSERT INTO `sys_router` (`id`, `name`, `code`, `url`, `parent_id`, `level`, `is_locked`, `display_order`, `properties`)
VALUES
	(1,'系统管理',NULL,NULL,0,1,0,1,X'7B226D657461223A207B22726571756972657341757468223A2066616C73657D2C2022637373436C617373223A2022656C2D69636F6E2D73657474696E67222C20226E616D6546756C6C50617468223A2022E7B3BBE7BB9FE7AEA1E79086227D'),
	(2,'用户管理','user','userList',1,2,0,5,X'7B226D657461223A207B22726571756972657341757468223A20747275657D2C2022637373436C617373223A2022656C2D69636F6E2D6D656E75222C2022636F6D706F6E656E74223A20225573657256696577222C20226E616D6546756C6C50617468223A2022E7B3BBE7BB9FE7AEA1E790862FE794A8E688B7E7AEA1E79086227D'),
	(3,'资源管理','resource','resourceList',1,2,0,2,X'7B226D657461223A207B22726571756972657341757468223A20747275657D2C2022637373436C617373223A2022656C2D69636F6E2D6D656E75222C2022636F6D706F6E656E74223A20225265736F7572636556696577222C20226E616D6546756C6C50617468223A2022E7B3BBE7BB9FE7AEA1E790862FE8B584E6BA90E7AEA1E79086227D'),
	(4,'角色管理','role','roleList',1,2,0,4,X'7B226D657461223A207B22726571756972657341757468223A20747275657D2C2022637373436C617373223A2022656C2D69636F6E2D6D656E75222C2022636F6D706F6E656E74223A2022526F6C6556696577222C20226E616D6546756C6C50617468223A2022E7B3BBE7BB9FE7AEA1E790862FE8A792E889B2E7AEA1E79086227D'),
	(5,'路由管理','router','routerList',1,2,0,1,X'7B226D657461223A207B22726571756972657341757468223A20747275657D2C2022637373436C617373223A2022656C2D69636F6E2D6D656E75222C2022636F6D706F6E656E74223A2022526F7574657256696577222C20226E616D6546756C6C50617468223A2022E7B3BBE7BB9FE7AEA1E790862FE8B7AFE794B1E7AEA1E79086227D');

/*!40000 ALTER TABLE `sys_router` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_router_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_router_permission`;

CREATE TABLE `sys_router_permission` (
  `role_id` smallint(6) unsigned NOT NULL,
  `router_id` smallint(6) unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`router_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_router_permission` WRITE;
/*!40000 ALTER TABLE `sys_router_permission` DISABLE KEYS */;

INSERT INTO `sys_router_permission` (`role_id`, `router_id`)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(1,4),
	(1,5),
	(2,1),
	(2,2);

/*!40000 ALTER TABLE `sys_router_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `login_name` varchar(32) NOT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `login_password` varchar(64) NOT NULL,
  `is_locked` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` smallint(5) unsigned NOT NULL,
  `deleted_at` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;

INSERT INTO `sys_user` (`id`, `name`, `login_name`, `salt`, `login_password`, `is_locked`, `created_at`, `created_by`, `deleted_at`)
VALUES
	(1,'超级管理员小小虎b','admin','fe2a97db9c82b74400cdcdf48e8988f2','fe0de4353a8b7a05a9111a8505108a31',0,'2018-04-01 10:26:28',1,0),
	(2,'业务管理员路人甲','user1','cf7389fbeae819e97cb893738cbcd6a9','c77d38deb0e6f4192123195cad7c3c3f',0,'2018-04-01 10:26:28',1,0),
	(3,'业务小能手bigbang','user2','1f0b5c815553885af26c7eba10315079','7c27db969fe08288f115595618dba65f',0,'2018-04-01 10:26:28',1,0),
	(15,'admin1','admin1','56c6cbbd80483a5a18fdf865e6af1125','51d833ea84f5d10c353542cfa0fc03c3',0,'2018-07-21 15:34:59',1,0);

/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` smallint(5) unsigned NOT NULL,
  `role_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;

INSERT INTO `sys_user_role` (`user_id`, `role_id`)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(1,9),
	(1,10),
	(1,11),
	(1,12),
	(1,13),
	(1,14),
	(1,15),
	(1,16),
	(1,17),
	(1,18),
	(2,2),
	(3,3);

/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
