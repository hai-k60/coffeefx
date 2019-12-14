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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `douong`
--

LOCK TABLES `douong` WRITE;
/*!40000 ALTER TABLE `douong` DISABLE KEYS */;
INSERT INTO `douong` VALUES (1,'Cà phê đen','Cà phê',22000,'Cốc');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES (1,'Bột cà phê',1000,'g'),(2,'duong trang',1000,'g');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'le HAi','a','a','a','a','0123'),(2,'Lê Văn Hải','Hà Nội','admin','admin','admin','0123625423');
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

-- Dump completed on 2019-11-06  0:47:57
