-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.16


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema canario
--

CREATE DATABASE IF NOT EXISTS canario;
USE canario;

--
-- Definition of table `menciones`
--

DROP TABLE IF EXISTS `menciones`;
CREATE TABLE `menciones` (
  `id_usuario` int(11) NOT NULL,
  `id_tweet` int(11) NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menciones`
--

/*!40000 ALTER TABLE `menciones` DISABLE KEYS */;
INSERT INTO `menciones` (`id_usuario`,`id_tweet`,`id`) VALUES 
 (56,100,31),
 (56,101,32),
 (56,102,33),
 (56,103,34),
 (56,104,35),
 (56,105,36),
 (56,106,37),
 (57,107,38),
 (56,108,39),
 (56,109,40),
 (56,110,41),
 (57,111,42),
 (58,112,43),
 (56,113,44),
 (59,114,45),
 (59,115,46),
 (59,117,47),
 (56,118,48),
 (60,119,49),
 (57,120,50),
 (61,121,51),
 (56,128,52);
/*!40000 ALTER TABLE `menciones` ENABLE KEYS */;


--
-- Definition of table `relaciones`
--

DROP TABLE IF EXISTS `relaciones`;
CREATE TABLE `relaciones` (
  `followed` int(10) unsigned NOT NULL,
  `follower` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relaciones`
--

/*!40000 ALTER TABLE `relaciones` DISABLE KEYS */;
INSERT INTO `relaciones` (`followed`,`follower`,`id`) VALUES 
 (56,57,42),
 (56,58,43),
 (57,58,44),
 (58,59,45),
 (57,59,46),
 (56,59,47),
 (57,56,48),
 (58,56,49),
 (59,56,50),
 (57,60,53),
 (56,60,54),
 (59,60,55),
 (56,62,56),
 (60,62,57),
 (61,62,58),
 (57,62,59),
 (58,62,60),
 (62,57,63),
 (58,57,64),
 (56,63,65),
 (57,63,66),
 (58,63,67),
 (63,56,68);
/*!40000 ALTER TABLE `relaciones` ENABLE KEYS */;


--
-- Definition of table `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(200) NOT NULL,
  `idTweet` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tag` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tags`
--

/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` (`id`,`tag`,`idTweet`) VALUES 
 (22,'CFK',111),
 (23,'CFK',112),
 (24,'CFK',113),
 (25,'CKF',114),
 (26,'CFK',115),
 (27,'canarioProyect',120),
 (28,'UM',121);
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;


--
-- Definition of table `tweets`
--

DROP TABLE IF EXISTS `tweets`;
CREATE TABLE `tweets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tweet` varchar(140) NOT NULL,
  `id_usuario` int(10) unsigned NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `autor` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tweets`
--

/*!40000 ALTER TABLE `tweets` DISABLE KEYS */;
INSERT INTO `tweets` (`id`,`tweet`,`id_usuario`,`fecha`,`autor`) VALUES 
 (100,'como andas @borjaabad =?',57,'2012-12-17 13:52:12','0'),
 (101,'@borjaabad',57,'2012-12-17 13:54:42','0'),
 (102,'como estas @borjaabad',57,'2012-12-17 13:59:05','0'),
 (103,'@borjaabad como andas?',57,'2012-12-17 14:03:39','0'),
 (104,'@borjaabad como andas?',57,'2012-12-17 14:05:55','0'),
 (105,'estas? @borjaabad',56,'2012-12-17 14:34:34','0'),
 (106,'hola @borjaabad',57,'2012-12-17 14:35:16','0'),
 (107,'como andas @eduardotomassi',57,'2012-12-17 14:37:25','0'),
 (108,'@borjaabad',57,'2012-12-17 14:41:43','0'),
 (109,'como andas @borjaabad ?',57,'2012-12-17 14:55:19','0'),
 (110,'bien @borjaabad ?',57,'2012-12-17 14:55:57','0'),
 (111,'Como estás @eduardotomassi ? sigues pensando que #CFK es la solución?',58,'2012-12-17 17:14:12','0'),
 (112,'Que te pasa? @ger932 #CFK aguante loco!!',57,'2012-12-17 17:14:45','0'),
 (113,'#CFK le gusta a @borjaabad jajaja',59,'2012-12-17 17:20:18','0'),
 (114,'La democracía debería de ser cada semana por internet así nunca pasaría #CKF @jp @eduardotomassi @ger932',56,'2012-12-17 17:21:57','0'),
 (115,'La democracía debería de ser cada semana por internet así nunca pasaría #CFK @jp @eduardotomassi @ger932',56,'2012-12-17 17:22:59','0'),
 (116,'Pues esta es mi biografía, la verdad no se que poner, más tarde veo ahora me estoy yendo a depilar las piernas',57,'2012-12-17 17:34:49','0'),
 (117,'@jp como andas?',57,'2012-12-17 17:58:54','0'),
 (118,'hola soy nuevo aqui.... @borjaabad que tal tu?',62,'2012-12-17 18:29:50','0'),
 (119,'oye @villano para cuando un porron???',62,'2012-12-17 18:30:56','0'),
 (120,'hey chicos @eduardotomassi @borjaabad @jp como van con el proyecto de #canarioProyect',60,'2012-12-17 18:32:30','0'),
 (121,'che @danielquinteros cuando es la mesa de prog2 de la #UM',60,'2012-12-17 18:33:19','0'),
 (122,'La democracía debería de ser cada semana por internet así nunca pasaría #CFK @jp @eduardotomassi @ger932',57,'2012-12-17 17:22:59','borjaabad'),
 (123,'che @danielquinteros cuando es la mesa de prog2 de la #UM',57,'2012-12-17 18:33:19','villano'),
 (124,'Como estás @eduardotomassi ? sigues pensando que #CFK es la solución?',57,'2012-12-17 21:58:22','ger932'),
 (125,'hola soy nuevo aqui.... @borjaabad que tal tu?',57,'2012-12-17 22:07:39','nicolasdonna'),
 (126,'che @danielquinteros cuando es la mesa de prog2 de la #UM',57,'2012-12-18 00:31:26','villano'),
 (127,'hola soy nuevo aqui.... @borjaabad que tal tu?',56,'2012-12-18 00:32:04','nicolasdonna'),
 (128,'Hola @borjaabad !',63,'2012-12-18 00:57:35','0'),
 (129,'Hola @borjaabad !',56,'2012-12-18 00:58:31','joy'),
 (130,'como andas @borjaabad =?',56,'2012-12-18 01:03:10','eduardotomassi'),
 (131,'@borjaabad como andas?',56,'2012-12-18 01:04:38','eduardotomassi'),
 (132,'como andas @borjaabad =?',56,'2012-12-18 01:05:05','eduardotomassi');
/*!40000 ALTER TABLE `tweets` ENABLE KEYS */;


--
-- Definition of table `userconfig`
--

DROP TABLE IF EXISTS `userconfig`;
CREATE TABLE `userconfig` (
  `id_usuario` int(10) unsigned NOT NULL,
  `notificaciones_mentions` tinyint(1) DEFAULT '1',
  `notificaciones_follow` tinyint(1) DEFAULT '1',
  `notificaciones_retweet` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userconfig`
--

/*!40000 ALTER TABLE `userconfig` DISABLE KEYS */;
INSERT INTO `userconfig` (`id_usuario`,`notificaciones_mentions`,`notificaciones_follow`,`notificaciones_retweet`) VALUES 
 (56,1,1,1),
 (57,1,1,1),
 (58,1,1,1),
 (59,1,1,1),
 (60,1,1,1),
 (61,1,1,1),
 (62,1,1,1),
 (63,1,1,1);
/*!40000 ALTER TABLE `userconfig` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `imagen` varchar(50) NOT NULL DEFAULT 'user.png',
  `password` varchar(50) DEFAULT NULL,
  `localidad` varchar(50) DEFAULT NULL,
  `biografia` varchar(200) DEFAULT NULL,
  `key` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `email` (`email`),
  KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`,`nombre`,`email`,`imagen`,`password`,`localidad`,`biografia`,`key`) VALUES 
 (56,'borjaabad','borja@cibeles.net','56.png','123','Ciudad','Más tarde la edito...',NULL),
 (57,'eduardotomassi','eduardotomassi@gmail.com','57.jpeg','123','Godoy Cruz','Pues esta es mi biografía, la verdad no se que poner, <br />\r\nmás tarde veo ahora me estoy yendo a depilar las piernas.',NULL),
 (58,'ger932','c.germanmoyano@gmail.com ','58.png','123','Maipu','Esta es mi bio blablabla',NULL),
 (59,'jp','juampi.gnr@gmail.com','59.jpg','123','Godoy Cruz','Que pasa loco!!!',NULL),
 (60,'villano','villano@um.edu.ar','60.jpg','123','Malargue','soy profesor de la UM',NULL),
 (61,'danielquinteros','daniel@um.edu.ar','user.png','123','San Carlos','Love C pointers',NULL),
 (62,'nicolasdonna','nico@donna.com.ar','62.jpg','123','Palmira','me encanta comer porotos',NULL),
 (63,'joy','joyirusta.ji@gmail.com','63.png','123','Carrodilla','Soy una pesada blablabla',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
