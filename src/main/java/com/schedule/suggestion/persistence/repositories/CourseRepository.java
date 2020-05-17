package com.schedule.suggestion.persistence.repositories;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.persistence.entity.CourseSection;
import com.schedule.suggestion.service.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByCourseNumber(String courseNumber);

    @Query("SELECT DISTINCT c FROM Course c LEFT JOIN c.listOfCourseSection cs WHERE cs.term=:term")
    List<Course> findAllCoursesByTerm(@Param("term") String term);

    @Query(value = "SELECT GROUP_CONCAT(comp.course_id ORDER BY comp.course_id ASC SEPARATOR ',')" +
            "FROM completion comp WHERE comp.student_id=:studentId AND comp.grade > 0",
            nativeQuery = true)
    String getListOfPassedCourses(@Param("studentId") Integer studentId);

    @Query(value = "SELECT c.* FROM course c " +
            "LEFT JOIN course_prerequisite cp ON cp.course_id = c.id " +
            "LEFT JOIN course_section cs on c.id = cs.course_id " +
            "LEFT JOIN course_category cc on c.id = cc.course_id " +
            "WHERE NOT FIND_IN_SET(c.id, :passedCourses) " +
            "AND (cs.term=:term AND cs.week_days=:weekDays " +
            "AND cs.start_time >= :startTime " +
            "AND cs.end_time <= :endTime " +
            "OR cc.category_id = 1) " +
            "GROUP BY c.id " +
            "HAVING SUM(COALESCE(FIND_IN_SET(cp.prerequisite_course_id, :passedCourses), 0) > 0) = " +
            "COUNT(cp.prerequisite_course_id);",
            nativeQuery = true)
    List<Course> getAllAvailableCoursesByStudentId(@Param("passedCourses") String passedCourses,
                                                   @Param("term") String term, @Param("weekDays") String weekDays,
                                                   @Param("startTime") LocalTime startTime,
                                                   @Param("endTime") LocalTime endTime);

    @Query(value = "SELECT c.* FROM course c " +
            "LEFT JOIN course_prerequisite cp ON cp.course_id = c.id " +
            "WHERE NOT FIND_IN_SET(c.id, :passedCourses) " +
            "GROUP BY c.id " +
            "HAVING SUM(COALESCE(FIND_IN_SET(cp.prerequisite_course_id, :passedCourses), 0) > 0) = " +
            "COUNT(cp.prerequisite_course_id);",
            nativeQuery = true)
    List<Course> getAvailableCoursesById(@Param("passedCourses") String passedCourses);
}
