CREATE DATABASE  IF NOT EXISTS `jrquiz` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jrquiz`;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '0',  
  `email` varchar(45),
  `firstname` varchar(45),
  `lastname` varchar(45),
  `createdDate` timestamp,
  `updatetime` timestamp,
  `emailtoken` varchar(45),
  `birthday` timestamp,
  `aboutme` varchar(150),
  `socialnetworktoken` varchar(45),
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
INSERT INTO `users` (`id`,`username`,`password`, `enabled`) VALUES (1,'user','user',1),(2,'admin','admin',1);
UNLOCK TABLES;

DROP TABLE IF EXISTS `authorities`;
create table authorities (
    username varchar(45) not null,
    userID int(11),
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(userID) references users(ID)
);
create unique index ix_auth_username on authorities (userID,authority);


LOCK TABLES `authorities` WRITE;
INSERT INTO `authorities` VALUES ('admin',2,'ROLE_ADMIN'),('admin',2,'ROLE_USER'),('user',1,'ROLE_USER');
UNLOCK TABLES;
