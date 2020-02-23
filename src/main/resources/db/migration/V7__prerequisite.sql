CREATE TABLE course_prerequisite (
    course_id bigint(20) NOT NULL,
    prerequisite_course_id bigint(20) NOT NULL,
    PRIMARY KEY (course_id, prerequisite_course_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE course_prerequisite ADD CONSTRAINT FOREIGN KEY (course_id) REFERENCES course(id);
ALTER TABLE course_prerequisite ADD CONSTRAINT FOREIGN KEY (prerequisite_course_id) REFERENCES course(id);