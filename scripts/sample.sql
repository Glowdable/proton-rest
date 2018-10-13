
-- Host: 127.0.0.1    Database: arch_proton
-- ------------------------------------------------------
--
-- Table structure for table `health_package`
-- refer https://blog.csdn.net/zengqiang1/article/details/79338660
-- refer https://blog.csdn.net/zengqiang1/article/details/80714254

DROP DATABASE IF EXISTS `arch_proton`;
CREATE DATABASE `arch_proton`;
use `arch_proton`;

DROP TABLE IF EXISTS `health_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `health_package` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '序号',
  `package_id` int unsigned NOT NULL COMMENT '套系 id',
  `module_id`  int unsigned NOT NULL COMMENT '模块 id',
  `is_delete` tinyint unsigned NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-删除，默认为0',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time, common column by DB rules',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Modified time,common column by DB rules ',
  PRIMARY KEY (`id`)
) COMMENT='This table stores module and package of health for ...';
