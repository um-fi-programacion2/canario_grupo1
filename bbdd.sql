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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

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
 (56,128,52),
 (56,137,53),
 (56,138,54),
 (56,149,55),
 (56,150,56),
 (56,158,57),
 (56,159,58),
 (57,171,59),
 (57,172,60),
 (57,190,61),
 (56,191,62),
 (56,196,63);
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
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relaciones`
--

/*!40000 ALTER TABLE `relaciones` DISABLE KEYS */;
INSERT INTO `relaciones` (`followed`,`follower`,`id`) VALUES 
 (56,57,42),
 (56,58,43),
 (57,58,44),
 (58,59,45),
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
 (63,56,68),
 (60,59,69),
 (56,59,70),
 (57,59,71),
 (61,59,72),
 (62,59,73),
 (63,59,74),
 (64,59,75),
 (65,59,76),
 (59,57,77),
 (63,57,78),
 (63,66,79),
 (65,63,80),
 (60,58,81),
 (61,58,82),
 (66,56,83),
 (60,56,84),
 (61,56,85),
 (62,56,86),
 (64,56,87),
 (65,56,88),
 (57,56,89),
 (56,67,90),
 (57,67,91),
 (58,67,92),
 (60,67,93),
 (61,67,94),
 (63,67,95);
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

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
 (28,'UM',121),
 (29,'CFK',137),
 (30,'CFK',138),
 (31,'CFK',140),
 (32,'UM',141),
 (33,'CKF',142),
 (34,'CKF',142),
 (35,'CKF',143),
 (36,'CKF',143),
 (37,'CKF',144),
 (38,'CKF',144),
 (39,'CKF',144),
 (40,'CKF',144),
 (41,'CKF',144),
 (42,'CKF',144),
 (43,'CKF',144),
 (44,'CKF',144),
 (45,'CKF',144),
 (46,'CKF',144),
 (47,'CKF',144),
 (48,'CKF',144),
 (49,'CKF',145),
 (50,'reply',172),
 (51,'mention',172),
 (52,'tweet',172),
 (53,'crack',172),
 (54,'reply',174),
 (55,'canarioProyect',190);
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
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=latin1;

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
 (129,'Hola @borjaabad ',56,'2012-12-18 00:58:31','joy'),
 (130,'como andas @borjaabad ',56,'2012-12-18 01:03:10','eduardotomassi'),
 (131,'@borjaabad como andas',56,'2012-12-18 01:04:38','eduardotomassi'),
 (132,'como andas @borjaabad ',56,'2012-12-18 01:05:05','eduardotomassi'),
 (133,'Este es mi primer tweet desde un webservices',56,'2012-12-18 16:24:56','0'),
 (134,'Este es mi segundo tweet desde un webservices!!',56,'2012-12-18 16:25:21','0'),
 (135,'heyyyy',56,'2012-12-18 16:53:35','0'),
 (136,'Debería aparecer en el timeline ;)',56,'2012-12-18 18:16:35','0'),
 (137,'que paso con #CFK @borjaabad',57,'2012-12-18 18:19:26','0'),
 (138,'que paso con #CFK @borjaabad',57,'2012-12-18 18:19:30','0'),
 (139,'dale gato termina de una vez.....',57,'2012-12-18 18:24:05','0'),
 (140,'#CFK',56,'2012-12-18 18:50:09','0'),
 (141,' LA #UM ES LA MEJOR',56,'2012-12-18 18:50:47','0'),
 (142,'#CKF #CKF#CKF#CKF#CKF#CKF#CKF#CKF#CKF#CKF#CKF',56,'2012-12-18 19:10:34','0'),
 (143,'#CKF #CKF#CKF#CKF#CKF#CKF#CKF#CKF#CKF#CKF#CKF',56,'2012-12-18 19:12:06','0'),
 (144,'#CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF',56,'2012-12-18 19:13:02','0'),
 (145,'y VA GANANDO #CKF',59,'2012-12-18 20:24:29','0'),
 (146,'El @borjaabad el novio de @eduardotomassi',59,'2012-12-18 20:27:01','0'),
 (147,'Como estás @eduardotomassi ? sigues pensando que #CFK es la solución?',59,'2012-12-18 20:27:59','ger932'),
 (148,'Hola @borjaabad !',57,'2012-12-18 20:45:40','joy'),
 (149,'che esta noche nos rajamos @borjaabad',57,'2012-12-18 20:51:53','0'),
 (150,'esta noche q onda @borjaabad',57,'2012-12-18 21:02:41','0'),
 (151,' LA #UM ES LA MEJOR',57,'2012-12-18 22:24:51','borjaabad'),
 (152,'y VA GANANDO #CKF',57,'2012-12-19 00:13:47','jp'),
 (153,'y VA GANANDO #CKF',56,'2012-12-19 00:14:19','jp'),
 (154,'Hola a todos!!!!!!',56,'2012-12-19 00:15:19','0'),
 (155,'Hola @borjaabad !',66,'2012-12-19 00:20:20','joy'),
 (156,'Ahora si funciona joder!!!',56,'2012-12-19 00:27:27','0'),
 (157,'che esta noche nos rajamos @borjaabad',63,'2012-12-19 00:28:29','eduardotomassi'),
 (158,'Quiero estar más arriba en el top @borjaabad #top10',56,'2012-12-19 00:31:23','0'),
 (159,'Quiero estar más arriba en el top @borjaabad #top10',63,'2012-12-19 00:31:51','0'),
 (160,'Ahora si funciona joder!!!',63,'2012-12-19 00:32:12','borjaabad'),
 (161,'esta noche q onda @borjaabad',63,'2012-12-19 00:32:27','eduardotomassi'),
 (162,'Quiero estar más arriba en el top @borjaabad #top10',63,'2012-12-19 00:32:34','joy'),
 (163,'#CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF #CKF',63,'2012-12-19 00:32:42','borjaabad'),
 (164,'123',63,'2012-12-19 00:32:52','0'),
 (165,'123123',63,'2012-12-19 00:32:57','0'),
 (166,'123',63,'2012-12-19 00:33:04','0'),
 (167,'asd',63,'2012-12-19 00:33:14','0'),
 (168,'Desde aquÃ­ puedo enviar un tweet  @borjaabad',63,'2012-12-19 00:33:58','0'),
 (169,'que paso con #CFK @borjaabad',58,'2012-12-19 12:25:13','eduardotomassi'),
 (170,'Hola borja como andas',58,'2012-12-19 12:31:14','0'),
 (171,'@eduardotomassi me hice un #reply y un #mention en el mismo #tweet jajajs soy un #crack!!',56,'2012-12-19 16:36:11','0'),
 (172,'@eduardotomassi me hice un #reply y un #mention en el mismo #tweet jajajs soy un #crack!!',56,'2012-12-19 17:14:27','0'),
 (173,'@eduardotomassi me hice un #reply y un #mention en el mismo #tweet jajajs soy un #crack!!',56,'2012-12-19 20:20:16','borjaabad'),
 (174,'#reply',56,'2012-12-19 21:10:40','0'),
 (175,'Pribando top10',66,'2012-12-19 21:11:36','0'),
 (176,'mas...',66,'2012-12-19 21:11:41','0'),
 (177,'hollaaaaa',66,'2012-12-19 21:11:49','0'),
 (178,'cuatro',66,'2012-12-19 21:12:57','0'),
 (179,'cinco',66,'2012-12-19 21:13:02','0'),
 (180,'seis',66,'2012-12-19 21:13:06','0'),
 (181,'siete',66,'2012-12-19 21:13:10','0'),
 (182,'ocho',66,'2012-12-19 21:13:14','0'),
 (183,'nueve',66,'2012-12-19 21:13:17','0'),
 (184,'diez',66,'2012-12-19 21:13:21','0'),
 (185,'once',66,'2012-12-19 21:13:33','0'),
 (186,'doce',66,'2012-12-19 21:13:37','0'),
 (187,'trece...',66,'2012-12-19 21:13:42','0'),
 (188,'catorce',66,'2012-12-19 21:13:47','0'),
 (189,'hey chicos @eduardotomassi @borjaabad @jp como van con el proyecto de #canarioProyect',66,'2012-12-19 21:31:49','villano'),
 (190,'hey chicos @eduardotomassi @borjaabad @jp como van con el proyecto de #canarioProyect',56,'2012-12-19 21:34:59','villano'),
 (191,'@borjaabad como andas?',56,'2012-12-19 22:16:23','eduardotomassi'),
 (192,'diez',56,'2012-12-19 22:33:59','prueba'),
 (193,'Hola!',56,'2012-12-20 00:38:39','0'),
 (194,'Probando...',56,'2012-12-20 02:49:16','0'),
 (195,'Hola!',56,'2012-12-20 03:10:02','borjaabad'),
 (196,'hola @borjaabad',57,'2012-12-20 11:44:26','0'),
 (197,'nueve',56,'2012-12-20 13:27:28','prueba'),
 (198,'Me tire un pedito :)',56,'2012-12-20 13:39:14','0'),
 (199,'probando...',56,'2012-12-20 15:03:52','0');
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
 (57,0,0,1),
 (58,1,1,1),
 (59,1,1,1),
 (60,1,1,1),
 (61,1,1,1),
 (62,1,1,1),
 (63,1,1,1),
 (64,1,1,1),
 (65,1,1,1),
 (66,1,1,1),
 (67,1,1,1),
 (68,1,1,1);
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
  `clave` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `email` (`email`),
  KEY `key` (`clave`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`,`nombre`,`email`,`imagen`,`password`,`localidad`,`biografia`,`clave`) VALUES 
 (56,'borjaabad','borja@cibeles.net','56.png','123123','Carrodilla','Más tarde la edito...','a06062dc426cbac2dfcf7ed0d916a77e39276853'),
 (57,'eduardotomassi','eduardotomassi@gmail.com','57.jpeg','123','GodoyCruz','Pues esta es mi biografía, la verdad no se que poner, <br />\r\nmás tarde veo ahora me estoy yendo a depilar las piernas.','fdedbcd34b43b6344e7d9668f2c5b1e44ff71f03'),
 (58,'ger932','c.germanmoyano@gmail.com ','58.png','123','Maipu','Esta es mi bio blablabla','9b049b766898cbe8b98c116a6ce5e7aac86dea1b'),
 (59,'jp','juampi.gnr@gmail.com','user.png','123','GodoyCruz','Que pasa loco!!!','0f41a0b3b760b54df703e860e40fef1c388ed2c5'),
 (60,'villano','villano@um.edu.ar','60.jpg','123','Malargue','soy profesor de la UM','e67661e1353e0d2b76a4e9111107245b0d528003'),
 (61,'danielquinteros','daniel@um.edu.ar','user.png','123','SanCarlos','Love C pointers','aef66456697e11d41344f5210947081d8fb31bde'),
 (62,'nicolasdonna','nico@donna.com.ar','62.jpg','123','Palmira','me encanta comer porotos','dbb4015227ebe6728bf9e694b93a2c539c954064'),
 (63,'joy','joyirusta.ji@gmail.com','63.png','123','Carrodilla','Soy una pesada blablabla','c7d56fc0723a766824f554c4d00f28ea16c2c36b'),
 (64,'jose','marcelo@cibeles.net','user.png','123','Carrodilla','holaaaaaa','4a3487e57d90e2084654b6d23937e75af5c8ee55'),
 (65,'julia','julia@cibeles.net','user.png','123','Ciudad','123','b43b0ad1e8108e7ab870d7a54feac93ae8b8600e'),
 (66,'prueba','prueba@cibeles.net','user.png','123','Ciudad','asdasd','711383a59fda05336fd2ccf70c8059d1523eb41a'),
 (67,'pogui','poveda@gmail.com','user.png','123456','GodoyCruz','Esta es mi Bio....','19a63bc9cab1fd5377e451fef199cc73a5e70ee0'),
 (68,'pepes','pepe@gmail.com','user.png','12345','Carrodilla','nacda','e977936d4be5868badce7042bddedfc0c6573b5c');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
