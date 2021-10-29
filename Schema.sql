CREATE DATABASE  IF NOT EXISTS `exam` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `exam`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: exam
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
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hall` (
  `id_hall` bigint NOT NULL AUTO_INCREMENT,
  `capacity_hall` int DEFAULT NULL,
  `name_hall` varchar(255) DEFAULT NULL,
  `theatre_id` bigint NOT NULL,
  PRIMARY KEY (`id_hall`),
  KEY `FKrec44284isyq7riq9u6dbdsje` (`theatre_id`),
  CONSTRAINT `FKrec44284isyq7riq9u6dbdsje` FOREIGN KEY (`theatre_id`) REFERENCES `theatre` (`id_theatre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (1,100,'sala 1',1),(2,150,'sala 2',1),(3,3,'sala 3',1);
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id_movie` bigint NOT NULL AUTO_INCREMENT,
  `age_movie` int DEFAULT NULL,
  `name_movie` varchar(255) DEFAULT NULL,
  `price_movie` double DEFAULT NULL,
  `author_movie` varchar(255) DEFAULT NULL,
  `category_movie` varchar(255) DEFAULT NULL,
  `length_movie` int DEFAULT NULL,
  `producer_movie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_movie`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,18,'Pirati dei cosi',10,NULL,NULL,NULL,NULL),(2,23,'Alla ricerca di Budler',15,NULL,NULL,NULL,NULL),(3,3,'Le avventure di Peter Vin',25,NULL,NULL,NULL,NULL),(4,NULL,'Giuda intergalattica per Autobus',42,NULL,'ACTION',123,NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projection`
--

DROP TABLE IF EXISTS `projection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projection` (
  `id_show` bigint NOT NULL AUTO_INCREMENT,
  `time_show` date DEFAULT NULL,
  `hall_id` bigint NOT NULL,
  `movie_id` bigint NOT NULL,
  PRIMARY KEY (`id_show`),
  KEY `FK4f9tu5v6o6fikxpytbn4gomc` (`hall_id`),
  KEY `FKfq7qvxymc33m8307wc5qfpci1` (`movie_id`),
  CONSTRAINT `FK4f9tu5v6o6fikxpytbn4gomc` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id_hall`),
  CONSTRAINT `FKfq7qvxymc33m8307wc5qfpci1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id_movie`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projection`
--

LOCK TABLES `projection` WRITE;
/*!40000 ALTER TABLE `projection` DISABLE KEYS */;
INSERT INTO `projection` VALUES (1,'2021-12-12',1,1),(2,'2021-12-12',1,2),(3,'2021-12-12',3,4);
/*!40000 ALTER TABLE `projection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatre`
--

DROP TABLE IF EXISTS `theatre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theatre` (
  `id_theatre` bigint NOT NULL AUTO_INCREMENT,
  `name_theatre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_theatre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre`
--

LOCK TABLES `theatre` WRITE;
/*!40000 ALTER TABLE `theatre` DISABLE KEYS */;
INSERT INTO `theatre` VALUES (1,'Cinema nome 1'),(2,'Cinema nome 2');
/*!40000 ALTER TABLE `theatre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id_ticket` bigint NOT NULL AUTO_INCREMENT,
  `price_ticket` double DEFAULT NULL,
  `seat_ticket` varchar(255) DEFAULT NULL,
  `show_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `FKdvt57mcco3ogsosi97odw563o` (`user_id`),
  KEY `FKcx78fjslt6x14gy9ji0phee3p` (`show_id`),
  CONSTRAINT `FKcx78fjslt6x14gy9ji0phee3p` FOREIGN KEY (`show_id`) REFERENCES `projection` (`id_show`),
  CONSTRAINT `FKdvt57mcco3ogsosi97odw563o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (10,42,'12',3,1);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` bigint NOT NULL AUTO_INCREMENT,
  `age_user` date DEFAULT NULL,
  `name_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2009-10-12','Maggiorenne non anziano'),(2,'2017-10-12','Minorenne 4 anni'),(3,'1900-10-12','Vecchissimo'),(4,'2020-10-12','Neonato'),(5,'2014-10-12','Minorenne'),(6,'2014-10-12','Minorenne 7 anni');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'exam'
--

--
-- Dumping routines for database 'exam'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:30:18
