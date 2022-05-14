/*CREATE TABLE users
(
    userid          bigint auto_increment PRIMARY KEY,
    username        varchar(80)   NOT NULL,
    password varchar(80) NOT NULL,
    role varchar(250) NOT NULL,
    enabled      boolean       NOT NULL
);
*/
INSERT INTO users (username, password, enabled, role) VALUES ('user', 'password', true, 'USER');
INSERT INTO users (username, password, enabled, role) VALUES ('admin', 'password', true, 'ADMIN');
INSERT INTO users (username, password, enabled, role) VALUES ('ravi', 'password', true, 'USER');