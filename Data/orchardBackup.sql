-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.53-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema orchard3
--

CREATE DATABASE IF NOT EXISTS orchard3;
USE orchard3;

--
-- Definition of table `campusminds`
--

DROP TABLE IF EXISTS `campusminds`;
CREATE TABLE `campusminds` (
  `MID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `leadId` int(11) DEFAULT NULL,
  PRIMARY KEY (`MID`),
  KEY `FK_2ntx7etj2wjkddxenq13aoa8p` (`leadId`),
  CONSTRAINT `FK_2ntx7etj2wjkddxenq13aoa8p` FOREIGN KEY (`leadId`) REFERENCES `leads` (`leadsId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `campusminds`
--

/*!40000 ALTER TABLE `campusminds` DISABLE KEYS */;
INSERT INTO `campusminds` (`MID`,`name`,`leadId`) VALUES 
 (1,'Suraj',1),
 (2,'Shubham',1),
 (3,'Navneet',1),
 (4,'Aman',2),
 (5,'Bhagwat',2),
 (6,'Gaurob',2),
 (7,'Vinay Annanya',2),
 (8,'SabyaSachi Thakur',9),
 (9,'Hemant kumar',9),
 (10,'Lionel Messi',2),
 (11,'Ronaldo',11),
 (12,'Zlatan',13),
 (13,'Hazard',9),
 (14,'Annay Vinay',9),
 (15,'Aman Singh',9),
 (16,'Higuain',13),
 (17,'Drogba',2),
 (18,'Not Drogba',2),
 (19,'Dybala',2),
 (20,'Chellani',2),
 (21,'Ronaldinho',2),
 (22,'Chaudhary',2),
 (23,'Bale',2),
 (24,'Dybala',2),
 (25,'Morata',2),
 (26,'Dybala',2);
/*!40000 ALTER TABLE `campusminds` ENABLE KEYS */;


--
-- Definition of table `leads`
--

DROP TABLE IF EXISTS `leads`;
CREATE TABLE `leads` (
  `leadsId` int(11) NOT NULL AUTO_INCREMENT,
  `mId` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `trackId` int(11) DEFAULT NULL,
  PRIMARY KEY (`leadsId`),
  KEY `FK_rj9fjvi4k2j1v5b2fql2hrs49` (`trackId`),
  CONSTRAINT `FK_rj9fjvi4k2j1v5b2fql2hrs49` FOREIGN KEY (`trackId`) REFERENCES `tracks` (`trackId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leads`
--

/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
INSERT INTO `leads` (`leadsId`,`mId`,`name`,`trackId`) VALUES 
 (1,1,'Prem',1),
 (2,5,'Smruti',2),
 (9,3,'Vivek Kumar Singh',10),
 (10,4,'SAP',12),
 (11,15,'Sri vidya',13),
 (13,8,'Smruti Singh',13);
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;


--
-- Definition of table `tracks`
--

DROP TABLE IF EXISTS `tracks`;
CREATE TABLE `tracks` (
  `trackId` int(11) NOT NULL AUTO_INCREMENT,
  `trackName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`trackId`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tracks`
--

/*!40000 ALTER TABLE `tracks` DISABLE KEYS */;
INSERT INTO `tracks` (`trackId`,`trackName`) VALUES 
 (1,'EAI'),
 (2,'Java'),
 (8,'Data Science'),
 (9,'.NET'),
 (10,'.NET'),
 (11,'Data analytics'),
 (12,'Sitecore'),
 (13,'SDET'),
 (39,'Linkin Park'),
 (81,'CheckTrack');
/*!40000 ALTER TABLE `tracks` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
