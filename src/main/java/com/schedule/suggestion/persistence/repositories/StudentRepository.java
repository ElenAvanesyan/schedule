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

    @Query(value="select count(st.id) from Student st where " +
            "(select count(req.prerequisite_course_id) from Course crs left join course_prerequisite req " +
            "on req.course_id = crs.id where crs.id=:courseId and (req.course_id is null or req.prerequisite_course_id in " +
            "(select crs2.id from completion comp join course crs2 on crs2.id = comp.course_id where comp.student_id = st.id) and " +
            "(select comp2.grade from completion comp2 join course crs4 on crs4.id = comp2.course_id where comp2.student_id = st.id and comp2.course_id = req.prerequisite_course_id) > 0)) = " +
            "(select count(req2.prerequisite_course_id) from Course crs3 left join course_prerequisite req2 on req2.course_id = crs3.id where crs3.id=:courseId) and " +
            "((select comp3.course_id from completion comp3 where comp3.student_id = st.id and comp3.course_id=:courseId) is null or " +
            "(select comp4.grade from completion comp4 where comp4.student_id = st.id and comp4.course_id=:courseId) = 0)",
            nativeQuery = true)
    Integer findMaximumCourseCapacity(@Param("courseId") Integer courseId);
}
