# add division column

ALTER TABLE course ADD division varchar(10);
ALTER TABLE course ADD CONSTRAINT chk_division CHECK (division IN ('LOWER', 'UPPER'));

# fall courses

insert into course (id, course_number, title, credit) values (79, 'CS 105', 'Ordinary Differential Equations', 3);
insert into course (id, course_number, title, credit) values (80, 'CS 220', 'Parallel and High Performance Computing', 3);
insert into course (id, course_number, title, credit) values (81, 'CS 130', 'Computer Organization', 3);
insert into course (id, course_number, title, credit) values (82, 'CS 226', 'Math Modeling Applications', 3);
insert into course (id, course_number, title, credit) values (83, 'CS 260', 'Image Processing', 3);
insert into course (id, course_number, title, credit) values (84, 'CS 246', 'Artificial Intelligence: Decision Support', 3);
insert into course (id, course_number, title, credit) values (85, 'CS 222', 'Database Systems', 3);
insert into course (id, course_number, title, credit) values (86, 'CS 205', 'Partial Differential Equations', 3);
insert into course (id, course_number, title, credit) values (87, 'CSE 241', 'Data Mining', 3);
insert into course (id, course_number, title, credit) values (88, 'CSE 263', 'Human Physiology', 3);
insert into course (id, course_number, title, credit) values (89, 'PH 101', 'Basics of Healthy Lifestyle', 3);
insert into course (id, course_number, title, credit) values (90, 'CSE 270', 'Sports Analytics', 3);
insert into course (id, course_number, title, credit) values (91, 'CSE 151', 'Introduction to Energy Sources', 3);
insert into course (id, course_number, title, credit) values (92, 'CSE 290', 'Start-Up Culture', 3);
insert into course (id, course_number, title, credit) values (93, 'CSE 221', 'Nanotechnology: Science and Application', 3);
insert into course (id, course_number, title, credit) values (94, 'CSE 285', 'How Things Work', 3);
insert into course (id, course_number, title, credit) values (95, 'CHSS 110', 'Introduction to Philosophy', 3);
insert into course (id, course_number, title, credit) values (96, 'CHSS 151', 'Intro to French Language & Culture', 3);
insert into course (id, course_number, title, credit) values (97, 'CHSS 194', 'Introduction to Cultural Anthropology', 3);
insert into course (id, course_number, title, credit) values (98, 'CHSS 112', 'Introduction to Logic & Rhetoric', 3);
insert into course (id, course_number, title, credit) values (99, 'CHSS 127', 'World Civilizations I', 3);
insert into course (id, course_number, title, credit) values (100, 'CHSS 181', 'Introduction to Sociology', 3);
insert into course (id, course_number, title, credit) values (101, 'CHSS 195', 'Introduction to Archeology', 3);
insert into course (id, course_number, title, credit) values (102, 'CHSS 236', 'Baroque Era', 3);
insert into course (id, course_number, title, credit) values (103, 'CHSS 180', 'Introduction to Psychology', 3);
insert into course (id, course_number, title, credit) values (104, 'CHSS 240', 'Music & Literature', 3);
insert into course (id, course_number, title, credit) values (105, 'CHSS 130', 'Introduction to Art', 3);
insert into course (id, course_number, title, credit) values (106, 'CHSS 158', 'Introduction to Turkish Language and Culture', 3);
insert into course (id, course_number, title, credit) values (107, 'CHSS 114', 'Introduction to Religion', 3);
insert into course (id, course_number, title, credit) values (108, 'CHSS 205', 'Learning, activism, and social movements', 3);
insert into course (id, course_number, title, credit) values (109, 'CHSS 212', 'Epistemology & Philosophy of Science', 3);
insert into course (id, course_number, title, credit) values (110, 'CHSS 160', 'Introduction to Arabic Language and Arab Culture', 3);
insert into course (id, course_number, title, credit) values (111, 'PSIA 102', 'Introduction to US Government', 3);
insert into course (id, course_number, title, credit) values (112, 'PSIA 201', 'Political Philosophy', 3);
insert into course (id, course_number, title, credit) values (113, 'PSIA 272', 'Geopolitics of Asia', 3);
insert into course (id, course_number, title, credit) values (114, 'ENV 250', 'Biodiversity: Conservation and Restoration', 3);
insert into course (id, course_number, title, credit) values (115, 'ENV 120', 'Food', 3);
insert into course (id, course_number, title, credit) values (116, 'ENV 211', 'Sustainable Cities', 3);
insert into course (id, course_number, title, credit) values (117, 'LAW 101', 'Law in Everyday Life', 3);


# fall course categories

insert into course_category (course_id, category_id) values (79, 5);
insert into course_category (course_id, category_id) values (80, 3);
insert into course_category (course_id, category_id) values (81, 1);
insert into course_category (course_id, category_id) values (82, 5);
insert into course_category (course_id, category_id) values (83, 4);
insert into course_category (course_id, category_id) values (84, 2);
insert into course_category (course_id, category_id) values (85, 3);
insert into course_category (course_id, category_id) values (86, 5);
insert into course_category (course_id, category_id) values (87, 6);
insert into course_category (course_id, category_id) values (88, 6);
insert into course_category (course_id, category_id) values (89, 6);
insert into course_category (course_id, category_id) values (90, 6);
insert into course_category (course_id, category_id) values (91, 6);
insert into course_category (course_id, category_id) values (92, 6);
insert into course_category (course_id, category_id) values (93, 6);
insert into course_category (course_id, category_id) values (94, 6);
insert into course_category (course_id, category_id) values (95, 6);
insert into course_category (course_id, category_id) values (96, 6);
insert into course_category (course_id, category_id) values (97, 6);
insert into course_category (course_id, category_id) values (98, 6);
insert into course_category (course_id, category_id) values (99, 6);
insert into course_category (course_id, category_id) values (100, 6);
insert into course_category (course_id, category_id) values (101, 6);
insert into course_category (course_id, category_id) values (102, 6);
insert into course_category (course_id, category_id) values (103, 6);
insert into course_category (course_id, category_id) values (104, 6);
insert into course_category (course_id, category_id) values (105, 6);
insert into course_category (course_id, category_id) values (106, 6);
insert into course_category (course_id, category_id) values (107, 6);
insert into course_category (course_id, category_id) values (108, 6);
insert into course_category (course_id, category_id) values (109, 6);
insert into course_category (course_id, category_id) values (110, 6);
insert into course_category (course_id, category_id) values (111, 6);
insert into course_category (course_id, category_id) values (112, 6);
insert into course_category (course_id, category_id) values (113, 6);
insert into course_category (course_id, category_id) values (114, 6);
insert into course_category (course_id, category_id) values (115, 6);
insert into course_category (course_id, category_id) values (116, 6);
insert into course_category (course_id, category_id) values (117, 6);

# fall course prerequisites

insert into course_prerequisite (course_id, prerequisite_course_id) values (79, 12);
insert into course_prerequisite (course_id, prerequisite_course_id) values (79, 5);
insert into course_prerequisite (course_id, prerequisite_course_id) values (80, 46);
insert into course_prerequisite (course_id, prerequisite_course_id) values (81, 43);
insert into course_prerequisite (course_id, prerequisite_course_id) values (82, 86);
insert into course_prerequisite (course_id, prerequisite_course_id) values (83, 75);
insert into course_prerequisite (course_id, prerequisite_course_id) values (83, 45);
insert into course_prerequisite (course_id, prerequisite_course_id) values (83, 5);
insert into course_prerequisite (course_id, prerequisite_course_id) values (83, 46);
insert into course_prerequisite (course_id, prerequisite_course_id) values (84, 6);
insert into course_prerequisite (course_id, prerequisite_course_id) values (85, 46);
insert into course_prerequisite (course_id, prerequisite_course_id) values (86, 79);

# course clusters

insert into course_cluster (course_id, cluster_id) values (86, 7);
insert into course_cluster (course_id, cluster_id) values (86, 8);
insert into course_cluster (course_id, cluster_id) values (86, 9);
insert into course_cluster (course_id, cluster_id) values (87, 7);
insert into course_cluster (course_id, cluster_id) values (87, 8);
insert into course_cluster (course_id, cluster_id) values (87, 9);
insert into course_cluster (course_id, cluster_id) values (88, 7);
insert into course_cluster (course_id, cluster_id) values (89, 7);
insert into course_cluster (course_id, cluster_id) values (90, 7);
insert into course_cluster (course_id, cluster_id) values (90, 8);
insert into course_cluster (course_id, cluster_id) values (90, 9);
insert into course_cluster (course_id, cluster_id) values (91, 8);
insert into course_cluster (course_id, cluster_id) values (91, 9);
insert into course_cluster (course_id, cluster_id) values (92, 5);
insert into course_cluster (course_id, cluster_id) values (92, 7);
insert into course_cluster (course_id, cluster_id) values (92, 8);
insert into course_cluster (course_id, cluster_id) values (92, 9);
insert into course_cluster (course_id, cluster_id) values (93, 7);
insert into course_cluster (course_id, cluster_id) values (93, 8);
insert into course_cluster (course_id, cluster_id) values (93, 9);
insert into course_cluster (course_id, cluster_id) values (94, 7);
insert into course_cluster (course_id, cluster_id) values (94, 8);
insert into course_cluster (course_id, cluster_id) values (94, 9);
insert into course_cluster (course_id, cluster_id) values (95, 3);
insert into course_cluster (course_id, cluster_id) values (95, 6);
insert into course_cluster (course_id, cluster_id) values (96, 1);
insert into course_cluster (course_id, cluster_id) values (96, 2);
insert into course_cluster (course_id, cluster_id) values (96, 4);
insert into course_cluster (course_id, cluster_id) values (98, 1);
insert into course_cluster (course_id, cluster_id) values (98, 3);
insert into course_cluster (course_id, cluster_id) values (99, 2);
insert into course_cluster (course_id, cluster_id) values (99, 4);
insert into course_cluster (course_id, cluster_id) values (100, 4);
insert into course_cluster (course_id, cluster_id) values (100, 6);
insert into course_cluster (course_id, cluster_id) values (101, 2);
insert into course_cluster (course_id, cluster_id) values (101, 4);
insert into course_cluster (course_id, cluster_id) values (103, 3);
insert into course_cluster (course_id, cluster_id) values (103, 6);
insert into course_cluster (course_id, cluster_id) values (104, 1);
insert into course_cluster (course_id, cluster_id) values (105, 1);
insert into course_cluster (course_id, cluster_id) values (106, 1);
insert into course_cluster (course_id, cluster_id) values (106, 2);
insert into course_cluster (course_id, cluster_id) values (106, 4);
insert into course_cluster (course_id, cluster_id) values (107, 3);
insert into course_cluster (course_id, cluster_id) values (107, 6);
insert into course_cluster (course_id, cluster_id) values (109, 3);
insert into course_cluster (course_id, cluster_id) values (109, 7);
insert into course_cluster (course_id, cluster_id) values (109, 8);
insert into course_cluster (course_id, cluster_id) values (109, 9);
insert into course_cluster (course_id, cluster_id) values (110, 1);
insert into course_cluster (course_id, cluster_id) values (110, 2);
insert into course_cluster (course_id, cluster_id) values (110, 4);
insert into course_cluster (course_id, cluster_id) values (111, 4);
insert into course_cluster (course_id, cluster_id) values (112, 4);
insert into course_cluster (course_id, cluster_id) values (112, 2);
insert into course_cluster (course_id, cluster_id) values (112, 3);
insert into course_cluster (course_id, cluster_id) values (113, 4);
insert into course_cluster (course_id, cluster_id) values (113, 5);
insert into course_cluster (course_id, cluster_id) values (113, 2);
insert into course_cluster (course_id, cluster_id) values (114, 7);
insert into course_cluster (course_id, cluster_id) values (115, 7);
insert into course_cluster (course_id, cluster_id) values (115, 9);
insert into course_cluster (course_id, cluster_id) values (116, 4);
insert into course_cluster (course_id, cluster_id) values (116, 7);
insert into course_cluster (course_id, cluster_id) values (116, 8);
insert into course_cluster (course_id, cluster_id) values (116, 9);
insert into course_cluster (course_id, cluster_id) values (117, 4);

# add division for GEN_ED

UPDATE course SET course.division = 'LOWER' where course_number LIKE 'CSE 1%';
UPDATE course SET course.division = 'LOWER' where course_number LIKE 'CHSS 1%';
UPDATE course SET course.division = 'LOWER' where course_number LIKE 'PSIA 1%';
UPDATE course SET course.division = 'LOWER' where course_number LIKE 'ENV 1%';
UPDATE course SET course.division = 'LOWER' where course_number LIKE 'LAW 1%';
UPDATE course SET course.division = 'LOWER' where course_number LIKE 'PH 1%';

UPDATE course SET course.division = 'UPPER' where course_number LIKE 'CSE 2%';
UPDATE course SET course.division = 'UPPER' where course_number LIKE 'CHSS 2%';
UPDATE course SET course.division = 'UPPER' where course_number LIKE 'PSIA 2%';
UPDATE course SET course.division = 'UPPER' where course_number LIKE 'ENV 2%';
UPDATE course SET course.division = 'UPPER' where course_number LIKE 'LAW 2%';
UPDATE course SET course.division = 'UPPER' where course_number LIKE 'PH 2%';