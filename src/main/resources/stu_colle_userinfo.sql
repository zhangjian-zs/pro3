-- MySQL dump 10.13  Distrib 5.5.20, for Win32 (x86)
--
-- Host: localhost    Database: card
-- ------------------------------------------------------
-- Server version	5.5.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(20) NOT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1,'软件工程系'),(2,'网络工程系'),(3,'数学系');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_no` char(12) NOT NULL,
  `stu_name` varchar(16) NOT NULL,
  `stu_login` varchar(16) NOT NULL,
  `stu_passwd` char(32) NOT NULL,
  `stu_phone` char(11) DEFAULT NULL,
  `stu_limit` int(11) DEFAULT '1',
  `stu_remain` int(11) DEFAULT NULL,
  `stu_note` varchar(100) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `stu_login` (`stu_login`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'STU201806001','张三','zhangsan','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',1,666,'1班学生',1),(2,'STU201806002','李四','lisi','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(3,'STU201806003','张三1','zhangsan1','8C7E1F3B1B787EC9F24FCC01E243E072','13812282813',1,606,'2班学生',2),(4,'STU201806004','陈六','chenliu','','13812282814',0,600,'3班学生',3),(5,'STU201806001','张三','zhangsan2','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',1,666,'1班学生',1),(6,'STU201806002','李四','lisi2','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(8,'STU201806004','陈六','chenliu2','8C7E1F3B1B787EC9F24FCC01E243E072','13812282814',1,600,'3班学生',3),(9,'STU201806001','张三','zhangsan3','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',1,666,'1班学生',1),(10,'STU201806002','李四','lisi3','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(11,'STU201806004','陈六','chenliu3','','13812282814',1,600,'3班学生',3),(12,'STU201806001','张三','zhangsan4','','13812282811',1,555,'1班学生',1),(13,'STU201806002','李四','lisi4','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(14,'STU201806004','陈六','chenliu4','8C7E1F3B1B787EC9F24FCC01E243E072','13812282814',1,600,'3班学生',3),(15,'STU201806001','张三','zhangsansan5','','13812282811',1,666,'1班学生',2),(16,'STU201806002','李四','lisisi5','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(18,'STU201806001','张三','zhangsa6','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',1,666,'1班学生',1),(19,'STU201806002','李四','lis6','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(20,'STU201806004','陈六','chenli6','8C7E1F3B1B787EC9F24FCC01E243E072','13812282814',1,600,'3班学生',3),(21,'STU201806001','张三','zhangsansan7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282811',1,666,'1班学生',1),(22,'STU201806002','李四','lisisi7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282812',1,66,'1班学生',1),(23,'STU201806004','陈六','chenliuliu7','8C7E1F3B1B787EC9F24FCC01E243E072','13812282814',1,600,'3班学生',3),(24,'STU201806001','张三','zhangsa7','','13812282811',1,666,'1班学生',1),(25,'STU201806002','李四','lis7','','13812282812',1,66,'1班学生',1),(27,'STU201806033','李猜猜','lcc','','18660480135',0,88888,'有钱',2),(28,'STU201806023','张不猜','zbc','','18829038639',1,2,'穷',3),(29,'STU201806024','阿萨德','asd','','12332112312',1,222,'2',2),(37,'STU201806025','阿萨德','assa','','12312312312',1,223,NULL,2),(46,'STU201806026','阿萨德','asddsa','','12312312312',1,224,NULL,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_login` varchar(30) DEFAULT NULL,
  `user_passwd` char(32) DEFAULT '8C7E1F3B1B787EC9F24FCC01E243E072',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'张三','zhangsan','8C7E1F3B1B787EC9F24FCC01E243E072');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-18 20:38:10
