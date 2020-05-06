package com.schedule.suggestion.persistence.repositories;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    Student findStudentByUsername(String username);

    @Query("select distinct s.listOfCourse from Student s where s.username=:username")
    List<Course> getStudentPassedCourses(@Param("username") String username);

    @Query(value="select count(s.id) from student s where " +
            "(select count(req.prerequisite_course_id) from course crs left join course_prerequisite req " +
            "on req.course_id = crs.id where crs.id=:courseId and (req.course_id is null or req.prerequisite_course_id in " +
            "(select crs2.id from completion comp join course crs2 on crs2.id = comp.course_id where comp.student_id = s.id))) = " +
            "(select count(req2.prerequisite_course_id) from course crs3 left join course_prerequisite req2 on req2.course_id = crs3.id " +
            "where crs3.id=:courseId)",
            nativeQuery = true)
    Integer findMaximumCourseCapacity(@Param("courseId") Integer courseId);
}
