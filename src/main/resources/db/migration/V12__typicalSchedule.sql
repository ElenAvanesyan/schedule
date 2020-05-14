ALTER TABLE course
ADD COLUMN priority integer;

UPDATE course SET course.priority = 1 WHERE course.id = 5;
UPDATE course SET course.priority = 1 WHERE course.id = 9;
UPDATE course SET course.priority = 1 WHERE course.id = 12;
UPDATE course SET course.priority = 1 WHERE course.id = 43;
UPDATE course SET course.priority = 1 WHERE course.id = 73;
UPDATE course SET course.priority = 1 WHERE course.id = 78;

UPDATE course SET course.priority = 1 WHERE course.id = 49;
UPDATE course SET course.priority = 1 WHERE course.id = 79;
UPDATE course SET course.priority = 1 WHERE course.id = 85;
UPDATE course SET course.priority = 1 WHERE course.id = 86;

UPDATE course SET course.priority = 2 WHERE course.id = 6;
UPDATE course SET course.priority = 2 WHERE course.id = 10;
UPDATE course SET course.priority = 2 WHERE course.id = 45;
UPDATE course SET course.priority = 2 WHERE course.id = 46;
UPDATE course SET course.priority = 2 WHERE course.id = 74;
UPDATE course SET course.priority = 2 WHERE course.id = 81;

UPDATE course SET course.priority = 2 WHERE course.id = 80;
UPDATE course SET course.priority = 2 WHERE course.id = 82;

UPDATE course SET course.priority = 3 WHERE course.id = 11;
UPDATE course SET course.priority = 3 WHERE course.id = 47;
UPDATE course SET course.priority = 3 WHERE course.id = 75;
UPDATE course SET course.priority = 3 WHERE course.id = 118;

