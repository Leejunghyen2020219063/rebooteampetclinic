CREATE DATABASE IF NOT EXISTS petclinic;

ALTER DATABASE petclinic
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE TABLE users (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     username VARCHAR(50) NOT NULL UNIQUE,
                     password VARCHAR(100) NOT NULL,
                     enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           username VARCHAR(50) NOT NULL,
                           authority VARCHAR(50) NOT NULL,
                           CONSTRAINT fk_authority_user FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

GRANT ALL PRIVILEGES ON petclinic.* TO 'petclinic'@'%' IDENTIFIED BY 'petclinic';



