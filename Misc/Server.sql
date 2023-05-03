-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(15) DEFAULT NULL,
  `publishedDate` date DEFAULT NULL,
  `bookName` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `lentDate` date DEFAULT NULL,
  `lentMember` varchar(255) DEFAULT NULL,
  `isReturned` tinyint(1) DEFAULT '1',
  `genre` varchar(255) DEFAULT NULL,
  `borrowerID` int DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'678901235','2023-03-01','Harry Potter and the Half-Blood Prince','J.K. Rowling',NULL,NULL,NULL,1,'Fantasy',NULL),(2,'567890124','2023-02-01','Harry Potter and the Order of Phoenix','J.K. Rowling',NULL,NULL,NULL,1,'Fantasy',NULL),(3,'123456789','2022-01-01','The Catcher in the Rye','J.D. Salinger',NULL,NULL,NULL,1,'Fiction',NULL),(4,'234567890','2022-02-01','The Great Gatsby','F. Scott Fitzgerald',NULL,NULL,NULL,1,'Fiction',NULL),(5,'345678901','2022-03-01','To Kill a Mockingbird','Harper Lee',NULL,NULL,NULL,1,'Fiction',NULL),(6,'456789012','2022-04-01','1984','George Orwell',NULL,NULL,NULL,1,'Fiction',NULL),(7,'567890123','2022-05-01','Animal Farm','George Orwell',NULL,NULL,NULL,1,'Fiction',NULL),(8,'678901234','2022-06-01','Brave New World','Aldous Huxley',NULL,NULL,NULL,1,'Fiction',NULL),(9,'789012345','2022-07-01','Lord of the Flies','William Golding',NULL,NULL,NULL,1,'Fiction',NULL),(10,'890123456','2022-08-01','The Hobbit','J.R.R. Tolkien',NULL,NULL,NULL,1,'Fantasy',NULL),(11,'901234567','2022-09-01','The Lord of the Rings','J.R.R. Tolkien',NULL,NULL,NULL,1,'Fantasy',NULL),(12,'123456780','2022-10-01','Harry Potter and the Philosopher\'s Stone','J.K. Rowling',NULL,NULL,NULL,1,'Fantasy',NULL),(13,'234567891','2022-11-01','Harry Potter and the Chamber of Secrets','J.K. Rowling',NULL,NULL,NULL,1,'Fantasy',NULL),(14,'345678902','2022-12-01','Harry Potter and the Prisoner of Azkaban','J.K. Rowling',NULL,NULL,NULL,1,'Fantasy',NULL),(15,'456789013','2023-01-01','Harry Potter and the Goblet of Fire','J.K. Rowling',NULL,NULL,NULL,1,'Fantasy',NULL),(18,'9780804169127','2022-06-01','The Midnight Library','Matt Haig',NULL,NULL,NULL,1,'Fiction',NULL),(19,'9780735219443','2021-09-07','Beautiful World, Where Are You','Sally Rooney',NULL,NULL,NULL,1,'Fiction',NULL),(20,'9780593231024','2021-09-14','Cloud Cuckoo Land','Anthony Doerr',NULL,NULL,NULL,1,'Fiction',NULL),(21,'9780063030623','2021-10-05','The Lincoln Highway','Amor Towles',NULL,NULL,NULL,1,'Fiction',NULL),(22,'9780593452975','2021-10-12','A Slow Fire Burning','Paula Hawkins',NULL,NULL,NULL,1,'Mystery',NULL),(23,'9780385547680','2021-10-26','The Judge’s List','John Grisham',NULL,NULL,NULL,1,'Mystery',NULL),(24,'9780593419756','2021-11-02','The Four Winds','Kristin Hannah',NULL,NULL,NULL,1,'Historical Fiction',NULL),(25,'9781250273500','2021-11-23','The Becoming','Nora Roberts',NULL,NULL,NULL,1,'Fiction',NULL),(26,'9781982173619','2021-12-07','The Russian','James Patterson',NULL,NULL,NULL,1,'Mystery',NULL),(27,'9780525659710','2021-12-07','The Book of Magic','Alice Hoffman',NULL,NULL,NULL,1,'Fantasy',NULL),(28,'9781524711792','2022-01-04','The Children’s Blizzard','Melanie Benjamin',NULL,NULL,NULL,1,'Historical Fiction',NULL),(29,'9780063047393','2022-01-18','The Rose Code','Kate Quinn',NULL,NULL,NULL,1,'Historical Fiction',NULL),(30,'9780316450748','2022-01-25','The Hour of the Witch','Chris Bohjalian',NULL,NULL,NULL,1,'Historical Fiction',NULL),(31,'9780385547116','2022-02-01','The Power of the Dog','Don Winslow',NULL,NULL,NULL,1,'Thriller',NULL),(32,'9780525536972','2022-02-15','The Kitchen Front','Jennifer Ryan',NULL,NULL,NULL,1,'Historical Fiction',NULL),(35,'123456','2000-09-10','testbook','mr tester',NULL,NULL,NULL,1,'programming',NULL),(36,'12345678','1989-08-09','over the rainbow','james',NULL,NULL,NULL,1,'fantasy',NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarian` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'admin','$2a$10$KgWdaBOL9EiCpArEieZhAeOME81FqBIXrJbTCKZrdRd.BKTX8Z5DW'),(13,'Amanda','$2a$10$Z4G5ED8PnESlKPpfEQoGBeDseUo5N/VPMeNOL9VdLcs6e8HiAoWDm'),(14,'Amanda','$2a$10$O2Vme6D.Si5eNJSQj8YGKeO0CDkunVBcNMLrYxYc1bR2qdp6ym4ji');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'john','$2a$10$bXYX/euP3Dm7P1K5rqdGkOsNEXU3tBM.J2IEwW7v/TofvUsC4BblC'),(2,'Amanda','$2a$10$fSm.Qg/hPAT3fiwxQ12NUOskw7MeEUDXeh5tuPvv//3/TMwH/k9c2'),(3,'kiseki','$2a$10$w3ZI31w4a0FPWvsHLd6gceBo2nmA9qzmiSwRGnicxA9YYp/eGGZc2'),(4,'KhunShine','$2a$10$cb9JhpaTSoZ4dxnfVpL6veBfIMJSIysUp4GFDUgDw25NPgjh9QnYO');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-03 13:02:26
