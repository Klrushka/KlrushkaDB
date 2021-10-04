-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eyeofgod
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_actions`
--

DROP TABLE IF EXISTS `user_actions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_actions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `secondname` varchar(45) NOT NULL,
  `action` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_actions`
--

LOCK TABLES `user_actions` WRITE;
/*!40000 ALTER TABLE `user_actions` DISABLE KEYS */;
INSERT INTO `user_actions` VALUES (1,'qq','w','Valetov','create history file'),(2,'qq','w','Valetov','login'),(3,'qq','w','Valetov','login'),(4,'qq','w','Valetov','Display Table'),(5,'qq','w','Valetov','login'),(6,'qq','w','Valetov','login'),(7,'qq','w','Valetov','DISPLAY_HISTORY'),(8,'qq','w','Valetov','login'),(9,'qq','w','Valetov','DISPLAY_HISTORY'),(10,'qq','w','Valetov','create history file'),(11,'qq','w','Valetov','login'),(12,'qq','w','Valetov','Display Table'),(13,'qq','w','Valetov','login'),(14,'qq','w','Valetov','logout'),(15,'Klrushka','Kiryl','Sleaptsou','create history file'),(16,'Klrushka','Kiryl','Sleaptsou','login'),(17,'Klrushka','Kiryl','Sleaptsou','Display Table'),(18,'Klrushka','Kiryl','Sleaptsou','login'),(19,'Klrushka','Kiryl','Sleaptsou','login'),(20,'Klrushka','Kiryl','Sleaptsou','DISPLAY_HISTORY'),(21,'Klrushka','Kiryl','Sleaptsou','Clear history'),(22,'qq','w','Valetov','create history file'),(23,'qq','w','Valetov','login');
/*!40000 ALTER TABLE `user_actions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-28  8:50:09
