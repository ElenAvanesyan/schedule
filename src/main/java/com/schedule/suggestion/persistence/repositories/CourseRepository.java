package com.schedule.suggestion.persistence.repositories;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.service.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByCourseNumber(String courseNumber);
}
