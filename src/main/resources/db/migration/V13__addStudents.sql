insert into course (id, course_number, title, credit, priority) values (119, 'CS 296', 'Capstone', 3, 4);
insert into course_category (course_id, category_id) values (119, 1);


# students
insert into student
    (id, first_name, last_name, id_number, username, password) 
    values (11, 'Anna', 'Martirosyan', 'A09160029', 'anna_martirosyan1', 'anna1512-1');
insert into student
    (id, first_name, last_name, id_number, username, password)
    values (12, 'Anna', 'Martirosyan', 'A09160028', 'anna_martirosyan2', 'anna1512-2');
insert into student
    (id, first_name, last_name, id_number, username, password)
    values (13, 'Anna', 'Martirosyan', 'A09160027', 'anna_martirosyan3', 'anna1512-3');
insert into student
    (id, first_name, last_name, id_number, username, password)
    values (14, 'Anna', 'Martirosyan', 'A09160026', 'anna_martirosyan4', 'anna1512-4');
insert into student 
    (id, first_name, last_name, id_number, username, password) 
    values (15, 'Elen', 'Avanesyan', 'A09160030', 'elen_avanesyan', 'elen1004');
insert into student 
    (id, first_name, last_name, id_number, username, password) 
    values (16, 'Lusine', 'Hovhannisyan', 'A13183851', 'lusine_hovhannisyan', 'lusine123');
insert into student 
    (id, first_name, last_name, id_number, username, password) 
    values (17, 'Ani', 'Petrosyan', 'A72530628', 'ani_petrosyan3', 'ani123');


insert into completion (student_id, course_id, grade) values (11, 78, 4);
insert into completion (student_id, course_id, grade) values (11, 9, 3);
insert into completion (student_id, course_id, grade) values (11, 73, 3);
insert into completion (student_id, course_id, grade) values (11, 44, 3.7);
insert into completion (student_id, course_id, grade) values (11, 28, 3.7);

insert into completion (student_id, course_id, grade) values (12, 78, 4);
insert into completion (student_id, course_id, grade) values (12, 9, 3);
insert into completion (student_id, course_id, grade) values (12, 73, 3);
insert into completion (student_id, course_id, grade) values (12, 44, 3.7);
insert into completion (student_id, course_id, grade) values (12, 28, 3.7);
insert into completion (student_id, course_id, grade) values (12, 1, 3.7);
insert into completion (student_id, course_id, grade) values (12, 12, 3);
insert into completion (student_id, course_id, grade) values (12, 5, 3.3);
insert into completion (student_id, course_id, grade) values (12, 43, 3);
insert into completion (student_id, course_id, grade) values (12, 100, 3.7);
insert into completion (student_id, course_id, grade) values (12, 81, 4);
insert into completion (student_id, course_id, grade) values (12, 76, 3);
insert into completion (student_id, course_id, grade) values (12, 74, 3.3);
insert into completion (student_id, course_id, grade) values (12, 45, 3.7);
insert into completion (student_id, course_id, grade) values (12, 113, 3.7);


insert into completion (student_id, course_id, grade) values (13, 78, 4);
insert into completion (student_id, course_id, grade) values (13, 9, 3);
insert into completion (student_id, course_id, grade) values (13, 73, 3);
insert into completion (student_id, course_id, grade) values (13, 44, 3.7);
insert into completion (student_id, course_id, grade) values (13, 28, 3.7);
insert into completion (student_id, course_id, grade) values (13, 1, 3.7);
insert into completion (student_id, course_id, grade) values (13, 12, 3);
insert into completion (student_id, course_id, grade) values (13, 5, 3.3);
insert into completion (student_id, course_id, grade) values (13, 43, 3);
insert into completion (student_id, course_id, grade) values (13, 100, 3.7);
insert into completion (student_id, course_id, grade) values (13, 81, 4);
insert into completion (student_id, course_id, grade) values (13, 76, 3);
insert into completion (student_id, course_id, grade) values (13, 74, 3.3);
insert into completion (student_id, course_id, grade) values (13, 45, 3.7);
insert into completion (student_id, course_id, grade) values (13, 113, 3.7);
insert into completion (student_id, course_id, grade) values (13, 15, 3.7);
insert into completion (student_id, course_id, grade) values (13, 68, 3);
insert into completion (student_id, course_id, grade) values (13, 10, 2);
insert into completion (student_id, course_id, grade) values (13, 46, 3.3);
insert into completion (student_id, course_id, grade) values (13, 6, 3);
insert into completion (student_id, course_id, grade) values (13, 85, 4);
insert into completion (student_id, course_id, grade) values (13, 77, 3.7);
insert into completion (student_id, course_id, grade) values (13, 75, 3);
insert into completion (student_id, course_id, grade) values (13, 47, 3);
insert into completion (student_id, course_id, grade) values (13, 70, 4);


insert into completion (student_id, course_id, grade) values (14, 78, 4);
insert into completion (student_id, course_id, grade) values (14, 9, 3);
insert into completion (student_id, course_id, grade) values (14, 73, 3);
insert into completion (student_id, course_id, grade) values (14, 44, 3.7);
insert into completion (student_id, course_id, grade) values (14, 28, 3.7);
insert into completion (student_id, course_id, grade) values (14, 1, 3.7);
insert into completion (student_id, course_id, grade) values (14, 12, 3);
insert into completion (student_id, course_id, grade) values (14, 5, 3.3);
insert into completion (student_id, course_id, grade) values (14, 43, 3);
insert into completion (student_id, course_id, grade) values (14, 100, 3.7);
insert into completion (student_id, course_id, grade) values (14, 81, 4);
insert into completion (student_id, course_id, grade) values (14, 76, 3);
insert into completion (student_id, course_id, grade) values (14, 74, 3.3);
insert into completion (student_id, course_id, grade) values (14, 45, 3.7);
insert into completion (student_id, course_id, grade) values (14, 113, 3.7);
insert into completion (student_id, course_id, grade) values (14, 15, 3.7);
insert into completion (student_id, course_id, grade) values (14, 68, 3);
insert into completion (student_id, course_id, grade) values (14, 10, 2);
insert into completion (student_id, course_id, grade) values (14, 46, 3.3);
insert into completion (student_id, course_id, grade) values (14, 6, 3);
insert into completion (student_id, course_id, grade) values (14, 85, 4);
insert into completion (student_id, course_id, grade) values (14, 77, 3.7);
insert into completion (student_id, course_id, grade) values (14, 75, 3);
insert into completion (student_id, course_id, grade) values (14, 47, 3);
insert into completion (student_id, course_id, grade) values (14, 70, 4);

insert into completion (student_id, course_id, grade) values (14, 18, 4);
insert into completion (student_id, course_id, grade) values (14, 118, 3);
insert into completion (student_id, course_id, grade) values (14, 49, 3.3);
insert into completion (student_id, course_id, grade) values (14, 11, 3);
insert into completion (student_id, course_id, grade) values (14, 13, 3);

insert into completion (student_id, course_id, grade) values (14, 80, 4);
insert into completion (student_id, course_id, grade) values (14, 93, 4);
insert into completion (student_id, course_id, grade) values (14, 88, 3);
insert into completion (student_id, course_id, grade) values (14, 14, 4);
insert into completion (student_id, course_id, grade) values (14, 87, 3);