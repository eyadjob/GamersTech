USE gamesfun;

INSERT INTO gamesfun.users (id, email, enabled, password, role, user_name) VALUES
('2', 'eyadjob2@yahoo.com', 1, '$2a$10$eIoVV1Mq/PAVZ.VlC9qSzeWgeBVLEcIzxoVYNeCrtM0tqjuMcSrEi', 'ROLE_USER', 'eyadjob2@yahoo.com'),
('3', 'eyadjob3@yahoo.com', 1, '$2a$10$eIoVV1Mq/PAVZ.VlC9qSzeWgeBVLEcIzxoVYNeCrtM0tqjuMcSrEi', 'ROLE_USER', 'eyadjob3@yahoo.com'),
('4', 'eyadjob4@yahoo.com', 1, '$2a$10$eIoVV1Mq/PAVZ.VlC9qSzeWgeBVLEcIzxoVYNeCrtM0tqjuMcSrEi', 'ROLE_USER', 'eyadjob4@yahoo.com')

INSERT  INTO category (id, name, created_date) VALUES 
(1,"PC",current_timestamp()),
(2,"PS5",current_timestamp()),
(3,"XBOX Series X",current_timestamp()),
(4,"Switch",current_timestamp());

INSERT  INTO news_page (id,subject, body,  image_url,created_date, lastupdated_date )  VALUES
('2','sniper elite 5','<p>Sniper elite 5 is released and graphics is amazing</p>','image url',current_timestamp(),current_timestamp()),
('3','Resident evil vilage','<p>Resident evil vilage is amazing</p>','image url',current_timestamp(),current_timestamp()),
('1','image_news_page_1024','<p>this si eyad blog</p>','image url',current_timestamp(),current_timestamp());

INSERT  INTO category_newspage VALUES
('1','1',current_timestamp()),
('1','2',current_timestamp()),
('2','1',current_timestamp());
