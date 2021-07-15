/* 

DROP TABLE IF EXISTS `shortening`;
CREATE SCHEMA `musinsa`;


CREATE TABLE `shortening` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `originUrl` varchar(100) DEFAULT NULL,
  `regDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci; */