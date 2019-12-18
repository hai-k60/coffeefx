CREATE DATABASE  IF NOT EXISTS `coffeeshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `coffeeshop`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: coffeeshop
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietdonhang` (
  `id_donhang` int(11) DEFAULT NULL,
  `id_douong` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonhang`
--

LOCK TABLES `chitietdonhang` WRITE;
/*!40000 ALTER TABLE `chitietdonhang` DISABLE KEYS */;
INSERT INTO `chitietdonhang` VALUES (1,1,1,1000),(1,2,1,20000),(24,1,1,22000),(25,1,1,22000),(25,1,1,22000),(25,1,1,22000),(26,1,1,22000),(27,1,2,22000),(28,1,2,22000),(1,2,1,20000),(2,2,1,20000),(2,2,1,20000),(2,2,1,20000),(3,1,1,20000),(3,2,1,22000),(3,3,2,35000),(32,1,1,22000),(32,2,1,22000),(32,3,2,35000),(33,1,1,22000),(33,2,3,22000),(34,1,2,22000),(34,2,3,22000),(34,3,1,35000),(35,1,1,22000),(35,2,3,22000),(35,1,1,22000),(35,1,1,22000),(35,1,1,22000),(37,1,1,22000),(37,2,1,22000),(37,1,2,22000),(38,1,1,22000),(38,2,2,22000),(39,1,1,22000),(39,2,3,22000),(40,1,1,22000),(41,1,1,22000),(41,2,1,22000),(41,4,1,15000);
/*!40000 ALTER TABLE `chitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietdonnhap`
--

DROP TABLE IF EXISTS `chitietdonnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietdonnhap` (
  `id_donnhapnguyenlieu` int(11) NOT NULL,
  `id_nguyenlieu` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_donnhapnguyenlieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonnhap`
--

LOCK TABLES `chitietdonnhap` WRITE;
/*!40000 ALTER TABLE `chitietdonnhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietdonnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donhang` (
  `id_donhang` int(11) NOT NULL AUTO_INCREMENT,
  `id_khachhang` int(11) DEFAULT NULL,
  `id_nhanvien` int(11) DEFAULT NULL,
  `thoigian` datetime DEFAULT NULL,
  `uudai` int(11) DEFAULT NULL,
  `soban` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `tongtien` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_donhang`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES (1,1,1,'2019-11-04 00:00:00',0,'1',NULL),(2,2,1,'2019-11-04 00:00:00',0,'2',NULL),(3,2,1,'2019-11-06 11:15:28',0,'2',NULL),(4,2,1,'2019-11-06 11:24:40',0,'2',NULL),(5,2,1,'2019-11-06 11:26:20',0,'2',NULL),(6,2,1,'2019-11-06 11:28:39',0,'2',NULL),(7,2,1,'2019-11-06 11:31:07',0,'2',NULL),(8,2,1,'2019-11-06 11:33:31',0,'2',NULL),(9,2,1,'2019-11-06 11:35:05',0,'2',NULL),(10,2,1,'2019-11-06 11:36:09',0,'2',NULL),(11,2,1,'2019-11-06 11:36:14',0,'2',NULL),(12,2,1,'2019-11-06 11:36:15',0,'2',NULL),(13,2,1,'2019-11-06 11:37:46',0,'2',NULL),(14,2,1,'2019-11-06 11:37:48',0,'2',NULL),(15,2,1,'2019-11-06 11:39:52',0,'2',NULL),(16,2,1,'2019-11-06 11:45:01',0,'2',NULL),(17,2,1,'2019-11-06 11:47:48',0,'2',NULL),(18,2,1,'2019-11-06 11:47:50',0,'2',NULL),(19,2,1,'2019-11-06 11:51:08',0,'2',NULL),(20,2,1,'2019-11-06 11:51:10',0,'2',NULL),(21,2,1,'2019-11-06 11:52:32',0,'2',NULL),(22,2,1,'2019-11-06 11:57:38',0,'2',NULL),(23,2,1,'2019-11-06 12:01:24',0,'2',NULL),(24,2,1,'2019-11-06 14:38:43',0,'2',NULL),(25,2,1,'2019-11-06 14:51:33',0,'2',NULL),(26,2,1,'2019-11-06 14:56:53',0,'2',NULL),(27,2,1,'2019-11-06 14:58:50',0,'2',NULL),(28,2,1,'2019-11-06 14:59:52',0,'2',NULL),(29,2,1,'2019-12-16 10:33:03',0,'2',NULL),(30,2,1,'2019-12-16 10:36:40',0,'2',NULL),(31,2,1,'2019-12-16 10:39:12',0,'2',NULL),(32,2,1,'2019-12-16 10:46:01',0,'2',NULL),(33,2,1,'2019-12-16 10:55:13',0,'2',NULL),(34,1,1,'2019-12-16 12:49:58',10,'1',NULL),(35,1,1,'2019-12-16 17:29:21',10,'2',NULL),(36,1,1,'2019-11-04 00:00:00',1,'1',NULL),(37,1,1,'2019-11-04 00:00:00',1,'1',NULL),(38,2,1,'2019-12-18 13:32:29',0,'2',NULL),(39,2,1,'2019-12-18 13:36:16',0,'2',NULL),(40,2,1,'2019-12-18 13:42:08',0,'2',NULL),(41,2,1,'2019-12-18 13:58:10',0,'2',NULL);
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donnhapnguyenlieu`
--

DROP TABLE IF EXISTS `donnhapnguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donnhapnguyenlieu` (
  `id_donnhapnguyenlieu` int(11) NOT NULL AUTO_INCREMENT,
  `id_nhanvien` int(11) DEFAULT NULL,
  `thoigian` datetime DEFAULT NULL,
  `nhaphanphoi` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `tongtien` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_donnhapnguyenlieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donnhapnguyenlieu`
--

LOCK TABLES `donnhapnguyenlieu` WRITE;
/*!40000 ALTER TABLE `donnhapnguyenlieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `donnhapnguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `douong`
--

DROP TABLE IF EXISTS `douong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `douong` (
  `id_douong` int(11) NOT NULL AUTO_INCREMENT,
  `tendouong` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `loaidouong` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `gia` int(11) DEFAULT NULL,
  `donvi` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id_douong`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `douong`
--

LOCK TABLES `douong` WRITE;
/*!40000 ALTER TABLE `douong` DISABLE KEYS */;
INSERT INTO `douong` VALUES (1,'Cà phê đen','Cà phê',22000,'Cốc'),(2,'Cà phê nâu','Cà phê',22000,'Cốc'),(3,'Cà phê cốt dừa','Cà phê',35000,'Cốc'),(4,'Trà chanh','Trà',15000,'Cốc'),(5,'Trà đào cam xả','Trà',45000,'Cốc'),(6,'Nước cam','Sinh tố',45000,'Cốc'),(7,'Bạc xỉu','Cà Phê',25000,'Cốc');
/*!40000 ALTER TABLE `douong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachhang` (
  `id_khachhang` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `sodienthoai` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `diemtichluy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_khachhang`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Nguyễn Danh Nghĩa','0123123123',100),(2,'Nguyễn Văn Duy','0123456789',200),(3,'Nguyễn Văn Duy','0123456789',300),(4,'Nguyễn Văn Duy','0123456789',0),(5,'Nguyễn Duy','0123456780',0),(6,'Hiển','999999999',400),(7,'Đình Hải','08363636',0),(8,'Lê Lan','00000',0),(9,'Lê Lệ','111',400),(10,'Lê NAm','33333',0),(11,'Lê Văn Hoàng','9999999',0),(12,'Đào Phương Bắc','0896252323',0);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguyenlieu`
--

DROP TABLE IF EXISTS `nguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nguyenlieu` (
  `id_nguyenlieu` int(11) NOT NULL AUTO_INCREMENT,
  `tennguyenlieu` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `luong` int(11) DEFAULT NULL,
  `donvi` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id_nguyenlieu`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES (1,'Bột cà phê',3220,'g'),(3,'Đường',6225,'gam'),(4,'Bột cà phê 2',4000,'gam'),(7,'Sữa',1000,'gam'),(8,'Bột trà',2000,'gam');
/*!40000 ALTER TABLE `nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `id_nhanvien` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `chucvu` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sodienthoai` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id_nhanvien`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (2,'Lê Văn Hải','Hà Nội','admin','admin','admin','0123625423'),(3,'Nguyễn Danh Nghĩa','Ha noi','admin','b','b','0123000000');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhphandouong`
--

DROP TABLE IF EXISTS `thanhphandouong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thanhphandouong` (
  `id_douong` int(11) DEFAULT NULL,
  `id_nguyenlieu` int(11) DEFAULT NULL,
  `luong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhphandouong`
--

LOCK TABLES `thanhphandouong` WRITE;
/*!40000 ALTER TABLE `thanhphandouong` DISABLE KEYS */;
INSERT INTO `thanhphandouong` VALUES (0,0,100),(1,1,1),(1,3,1),(2,3,100),(2,1,100),(2,0,100);
/*!40000 ALTER TABLE `thanhphandouong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'coffeeshop'
--

--
-- Dumping routines for database 'coffeeshop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-18 14:16:44
