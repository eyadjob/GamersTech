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


CREATE TABLE  IF NOT EXISTS `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `text` varchar(250) NOT NULL,
  `blog_id` bigint DEFAULT NULL,
  `comment_id` bigint DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9aakob3a7aghrm94k9kmbrjqd` (`blog_id`),
  KEY `FKe2dbs56lhmp8fucafi3xvhjyd` (`comment_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK9aakob3a7aghrm94k9kmbrjqd` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`id`),
  CONSTRAINT `FKe2dbs56lhmp8fucafi3xvhjyd` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

SELECT * FROM category_newspage;
SELECT * FROM category;
SELECT * FROM news_page;
SELECT * FROM users;

SELECT * FROM blogs;
SELECT * FROM profile;
SELECT * FROM profile_blogs;
SELECT * FROM verification;