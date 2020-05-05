package com.schedule.suggestion.persistence.repositories;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.service.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByCourseNumber(String courseNumber);

    @Query("select distinct c from Course c left join c.listOfCourseSection cs where cs.term=:term")
    List<Course> findCourseByTerm(@Param("term") String term);
}
