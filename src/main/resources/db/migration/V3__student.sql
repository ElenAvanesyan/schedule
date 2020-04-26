DROP TABLE users;

CREATE TABLE student (
    id integer(20) NOT NULL AUTO_INCREMENT,
    id_number varchar(10) NOT NULL,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_username (username),
    UNIQUE KEY UK_id_number (id_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


