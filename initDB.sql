-- Schema creation: "startup_projects_db"
DROP SCHEMA IF EXISTS 'startup_projects_db';

CREATE SCHEMA IF NOT EXISTS 'startup_projects_db'
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
;

-- Table: Projects
CREATE TABLE `projects` (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL,
  picture blob,
  attachment longblob,
  current_investment int(11) NOT NULL,
  nesessary_investment int(11) NOT NULL,
  comment varchar(50) DEFAULT NULL,
  rating int(11) DEFAULT NULL,
  category varchar(30) NOT NULL,
  author varchar(20) NOT NULL,
  valuation int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table: Users
CREATE TABLE users(
  id int(11) NOT NULL AUTO_INCREMENT,
  firstName varchar(20) NOT NULL,
  lastName varchar(25) NOT NULL,
  phoneNumber int(11) DEFAULT NULL,
  email varchar(30) NOT NULL,
  country varchar(20) DEFAULT NULL,
  city varchar(20) DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `User_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Table: Roles
DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE InnoDB;

-- Table for mapping user and roles: user_roles
DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE InnoDB;

-- Table: Status
CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `dataChange` int(11) NOT NULL,
  KEY `status_project_id_fk` (`id_project`),
  KEY `status_status_schema_id_status_fk` (`id_status`),
  CONSTRAINT `status_project_id_fk` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id`),
  CONSTRAINT `status_status_schema_id_status_fk` FOREIGN KEY (`id_status`) REFERENCES `status_schema` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Table: User_projects

CREATE TABLE `user_project` (
  `id_user` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `dataStart` date DEFAULT NULL,
  `dataEnd` date DEFAULT NULL,
  KEY `user_project_project_id_fk` (`id_project`),
  KEY `user_project_user_id_fk` (`id_user`),
  CONSTRAINT `user_project_project_id_fk` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id`),
  CONSTRAINT `user_project_user_id_fk` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Table: Status_schema

CREATE TABLE `status_schema` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `statusName` varchar(20) NOT NULL,
  PRIMARY KEY (`id_status`),
  UNIQUE KEY `status_schema_id_uindex` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

