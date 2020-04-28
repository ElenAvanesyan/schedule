CREATE TABLE course (
    id integer(20) NOT NULL AUTO_INCREMENT,
    course_number varchar(10) NOT NULL,
    title varchar(100) NOT NULL,
    credit integer NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_course_number (course_number),
    UNIQUE KEY UK_title (title)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE course_section (
    id integer(20) NOT NULL AUTO_INCREMENT,
    course_id integer(20) NOT NULL,
    section_name varchar(5) NOT NULL,
    term varchar(10) NOT NULL,
    instructor_name varchar(30),
    week_days varchar(3),
    start_time TIME,
    end_time TIME,
    PRIMARY KEY (id, course_id, section_name),
    CONSTRAINT chk_term CHECK (term IN ('Fall', 'Spring', 'Summer')),
    CONSTRAINT chk_week_days CHECK (week_days IN ('MWF', 'TH'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE course_section ADD CONSTRAINT FOREIGN KEY (course_id) REFERENCES course(id);

CREATE TABLE completion (
    student_id integer(20) NOT NULL,
    course_id integer(20) NOT NULL,
    grade double precision,
    PRIMARY KEY (student_id, course_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE completion ADD CONSTRAINT FOREIGN KEY (student_id) REFERENCES student(id);
ALTER TABLE completion ADD CONSTRAINT FOREIGN KEY (course_id) REFERENCES course(id);
