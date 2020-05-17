CREATE TABLE professor (
    id integer(20) NOT NULL AUTO_INCREMENT,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into professor
    (id, first_name, last_name, username, password)
    values (11, 'Linda', 'Martirosyan', 'linda_m', 'linda111');


