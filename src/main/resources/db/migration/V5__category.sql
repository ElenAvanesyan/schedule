CREATE TABLE category (
    id integer(20) NOT NULL AUTO_INCREMENT,
    category_alias varchar(15) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT chk_category_alias CHECK (category_alias IN ('CS_CORE', 'CS_ELECTIVE', 'CS_REQUIRED', 'MM_ELECTIVE', 'MM_REQUIRED', 'GENED', 'FND'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cluster (
    id integer(20) NOT NULL AUTO_INCREMENT,
    cluster_alias varchar(15) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT chk_cluster_alias CHECK (cluster_alias IN ('AH', 'SS', 'QS'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;