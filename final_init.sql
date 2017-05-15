CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL,
  `picture` longblob,
  `attachment` longblob,
  `current_investment` int(11) NOT NULL,
  `nesessary_investment` int(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `category` varchar(70) NOT NULL,
  `author` varchar(20) NOT NULL,
  `valuation` int(11) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


CREATE TABLE `project_valuation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `project_valuation_project_id_fk` FOREIGN KEY (`id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_valuation_user_id_fk` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


  CREATE TABLE `right` (
  `id_right` int(11) NOT NULL AUTO_INCREMENT,
  `right_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id_right`),
  UNIQUE KEY `right_id_right_uindex` (`id_right`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


  CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


  CREATE TABLE `role_right` (
  `id_role` int(11) NOT NULL,
  `id_right` int(11) NOT NULL,
  KEY `role_right_role_id_role_fk` (`id_role`),
  KEY `role_right_right_id_right_fk` (`id_right`),
  CONSTRAINT `role_right_right_id_right_fk` FOREIGN KEY (`id_right`) REFERENCES `right` (`id_right`),
  CONSTRAINT `role_right_role_id_role_fk` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


  CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `role` varchar(20) NOT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `e-mail` varchar(40) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


  CREATE TABLE `user_project` (
  `id_user` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `data_start` date DEFAULT NULL,
  `data_end` date DEFAULT NULL,
  KEY `user_project_project_id_fk` (`id_project`),
  KEY `user_project_user_id_fk` (`id_user`),
  CONSTRAINT `user_project_project_id_fk` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`),
  CONSTRAINT `user_project_user_id_fk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


  CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
