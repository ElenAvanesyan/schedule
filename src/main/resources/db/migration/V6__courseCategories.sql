CREATE TABLE course_category (
    id integer(20) NOT NULL AUTO_INCREMENT,
    course_id integer(20) NOT NULL,
    category_id integer(20) NOT NULL,
    PRIMARY KEY (id, course_id, category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE course_category ADD CONSTRAINT FOREIGN KEY (course_id) REFERENCES course(id);
ALTER TABLE course_category ADD CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id);

CREATE TABLE course_cluster (
    id integer(20) NOT NULL AUTO_INCREMENT,
    course_id integer(20) NOT NULL,
    cluster_id integer(20) NOT NULL,
    PRIMARY KEY (id, course_id, cluster_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE course_cluster ADD CONSTRAINT FOREIGN KEY (course_id) REFERENCES course(id);
ALTER TABLE course_cluster ADD CONSTRAINT FOREIGN KEY (cluster_id) REFERENCES cluster(id);

INSERT INTO cluster(id, cluster_alias)
VALUES (1, 'AH'),
       (2, 'AH'),
       (3, 'AH'),
       (4, 'SS'),
       (5, 'SS'),
       (6, 'SS'),
       (7, 'QS'),
       (8, 'QS'),
       (9, 'QS');

INSERT INTO category(id, category_alias)
VALUES (1, 'CS_CORE'),
       (2, 'CS_ELECTIVE'),
       (3, 'CS_REQUIRED'),
       (4, 'MM_ELECTIVE'),
       (5, 'MM_REQUIRED'),
       (6, 'GENED'),
       (7, 'FND');