CREATE SCHEMA IF NOT EXISTS gamesfun; 

USE gamesfun;


CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(20) NOT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `verifications` (
  `id` bigint NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user` int(1) DEFAULT NULL,
  `expire` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(20) NOT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT  INTO hibernate_sequence VALUES (4);

CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_category_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `news_page` (
 `id` bigint NOT NULL,
 `image_url` varchar(255) DEFAULT NULL,
 `subject` MEDIUMTEXT,
 `body` TEXT,
 `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `category_newspage` (
  `category_id` bigint NOT NULL,
  `newspage_id` bigint NOT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`,`newspage_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `category_newspage_ibfk_1`
  FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `category_newspage_ibfk_2` 
  FOREIGN KEY (`newspage_id`) REFERENCES `news_page` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT  INTO category (id, name, created_date) VALUES 
(1,"PC",current_timestamp()),
(2,"PS5",current_timestamp()),
(3,"XBOX Series X",current_timestamp()),
(4,"Switch",current_timestamp());


INSERT  INTO news_page (id,subject, body,  image_url,created_date, lastupdated_date )  VALUES
('2','sniper elite 5','<p>Sniper elite 5 is released and graphics is amazing</p>','image url',current_date(),current_timestamp()),
('3','Resident evil vilage','<p>Resident evil vilage is amazing</p>','image url',current_timestamp(),current_timestamp()),
('1','image_news_page_1024','<p>this si eyad blog</p>','image url',current_timestamp(),current_timestamp());


INSERT  INTO category_newspage VALUES
('1','1',current_timestamp()),
('1','2',current_timestamp()),
('2','1',current_timestamp());


SELECT * FROM category_newspage;
SELECT * FROM category;
SELECT * FROM news_page;
SELECT * FROM users;


SELECT * FROM blogs;
SELECT * FROM profile;
SELECT * FROM profile_blogs;
SELECT * FROM verification;
DELETE  FROM verification;
DELETE  FROM users;

DROP TABLE profile_blogs; 
DROP TABLE profile; 
DROP TABLE verification; 
DROP TABLE news_page; 
DROP TABLE category; 
DROP TABLE category_newspage;

