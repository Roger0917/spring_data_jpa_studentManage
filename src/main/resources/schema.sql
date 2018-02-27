/*
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sid` INT(10) NOT NULL,
  `name` varchar(200) NOT NULL,
  `photo` VARCHAR (200) DEFAULT NULL ,
  `sex` INT NOT NULL,
  `birthday` DATE DEFAULT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;*/
/*
CREATE TABLE `grade` (
  `gid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `maxsize` int (50) DEFAULT 0 ,
  `avgscore` DOUBLE DEFAULT 0,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
CREATE TABLE `subject` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `maxsize` int (50) DEFAULT 0 ,
  `avgscore` DOUBLE DEFAULT 0,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
*/
