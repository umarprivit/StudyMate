-- MySQL dump 10.17  Distrib 10.3.24-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: studentdata
-- ------------------------------------------------------
-- Server version	10.3.24-MariaDB-2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Usamaevent`
--

DROP TABLE IF EXISTS `Usamaevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usamaevent` (
  `event` varchar(250) DEFAULT NULL,
  `eventday` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usamaevent`
--

LOCK TABLES `Usamaevent` WRITE;
/*!40000 ALTER TABLE `Usamaevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usamaevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usamascore`
--

DROP TABLE IF EXISTS `Usamascore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usamascore` (
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usamascore`
--

LOCK TABLES `Usamascore` WRITE;
/*!40000 ALTER TABLE `Usamascore` DISABLE KEYS */;
INSERT INTO `Usamascore` VALUES (5),(0),(0),(0),(5),(5),(0),(0),(0),(0),(0),(0),(0);
/*!40000 ALTER TABLE `Usamascore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usamatask`
--

DROP TABLE IF EXISTS `Usamatask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usamatask` (
  `taskdate` date DEFAULT NULL,
  `task` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usamatask`
--

LOCK TABLES `Usamatask` WRITE;
/*!40000 ALTER TABLE `Usamatask` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usamatask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usamatodo`
--

DROP TABLE IF EXISTS `Usamatodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usamatodo` (
  `todo` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usamatodo`
--

LOCK TABLES `Usamatodo` WRITE;
/*!40000 ALTER TABLE `Usamatodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usamatodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geetaKhuranaevent`
--

DROP TABLE IF EXISTS `geetaKhuranaevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geetaKhuranaevent` (
  `event` varchar(250) DEFAULT NULL,
  `eventday` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geetaKhuranaevent`
--

LOCK TABLES `geetaKhuranaevent` WRITE;
/*!40000 ALTER TABLE `geetaKhuranaevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `geetaKhuranaevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geetaKhuranascore`
--

DROP TABLE IF EXISTS `geetaKhuranascore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geetaKhuranascore` (
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geetaKhuranascore`
--

LOCK TABLES `geetaKhuranascore` WRITE;
/*!40000 ALTER TABLE `geetaKhuranascore` DISABLE KEYS */;
INSERT INTO `geetaKhuranascore` VALUES (5);
/*!40000 ALTER TABLE `geetaKhuranascore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geetaKhuranatask`
--

DROP TABLE IF EXISTS `geetaKhuranatask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geetaKhuranatask` (
  `taskdate` date DEFAULT NULL,
  `task` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geetaKhuranatask`
--

LOCK TABLES `geetaKhuranatask` WRITE;
/*!40000 ALTER TABLE `geetaKhuranatask` DISABLE KEYS */;
/*!40000 ALTER TABLE `geetaKhuranatask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geetaKhuranatodo`
--

DROP TABLE IF EXISTS `geetaKhuranatodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geetaKhuranatodo` (
  `todo` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geetaKhuranatodo`
--

LOCK TABLES `geetaKhuranatodo` WRITE;
/*!40000 ALTER TABLE `geetaKhuranatodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `geetaKhuranatodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'usamabuddy','usamajatoi','riogadi'),(2,'geetaKhurana','geet123','12345'),(3,'Usama','usama@','usama@@');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `theme` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1);
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usamabuddyevent`
--

DROP TABLE IF EXISTS `usamabuddyevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usamabuddyevent` (
  `event` varchar(250) DEFAULT NULL,
  `eventday` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usamabuddyevent`
--

LOCK TABLES `usamabuddyevent` WRITE;
/*!40000 ALTER TABLE `usamabuddyevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `usamabuddyevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usamabuddyscore`
--

DROP TABLE IF EXISTS `usamabuddyscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usamabuddyscore` (
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usamabuddyscore`
--

LOCK TABLES `usamabuddyscore` WRITE;
/*!40000 ALTER TABLE `usamabuddyscore` DISABLE KEYS */;
INSERT INTO `usamabuddyscore` VALUES (5),(0),(0),(0),(5),(0),(0),(0),(5),(0),(0),(5),(0),(0),(0),(0),(0);
/*!40000 ALTER TABLE `usamabuddyscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usamabuddytask`
--

DROP TABLE IF EXISTS `usamabuddytask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usamabuddytask` (
  `taskdate` date DEFAULT NULL,
  `task` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usamabuddytask`
--

LOCK TABLES `usamabuddytask` WRITE;
/*!40000 ALTER TABLE `usamabuddytask` DISABLE KEYS */;
/*!40000 ALTER TABLE `usamabuddytask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usamabuddytodo`
--

DROP TABLE IF EXISTS `usamabuddytodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usamabuddytodo` (
  `todo` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usamabuddytodo`
--

LOCK TABLES `usamabuddytodo` WRITE;
/*!40000 ALTER TABLE `usamabuddytodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `usamabuddytodo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17  6:25:13
