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
    Student findStudentById(Integer studentId);

    @Query("select distinct s.listOfCourse from Student s where s.id=:studentId")
    List<Course> getStudentPassedCourses(@Param("studentId") Integer studentId);

    @Query(value="SELECT count(st.id) FROM Student st WHERE " +
            "(SELECT count(prereq.prerequisite_course_id) " +
            "FROM Course crs LEFT JOIN course_prerequisite prereq " +
            "ON prereq.course_id = crs.id " +
            "WHERE crs.id=:courseId AND (prereq.course_id IS NULL OR prereq.prerequisite_course_id IN " +
            "(SELECT crs2.id " +
            "FROM completion comp JOIN course crs2 ON crs2.id = comp.course_id " +
            "WHERE comp.student_id = st.id) AND " +
            "(SELECT comp2.grade " +
            "FROM completion comp2 JOIN course crs3 ON crs3.id = comp2.course_id " +
            "WHERE comp2.student_id = st.id AND " +
            "comp2.course_id = prereq.prerequisite_course_id) > 0)) = " +
            "(SELECT count(req2.prerequisite_course_id) " +
            "FROM Course crs4 LEFT JOIN course_prerequisite req2 ON req2.course_id = crs4.id " +
            "WHERE crs4.id=:courseId) " +
            "AND " +
            "((SELECT comp3.course_id " +
            "FROM completion comp3 " +
            "WHERE comp3.student_id = st.id AND comp3.course_id=:courseId) IS NULL OR " +
            "(SELECT comp4.grade " +
            "FROM completion comp4 " +
            "WHERE comp4.student_id = st.id AND comp4.course_id=:courseId) = 0)",
            nativeQuery = true)
    Integer findMaximumCourseCapacity(@Param("courseId") Integer courseId);
}
