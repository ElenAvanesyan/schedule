package com.schedule.suggestion.persistence.repositories;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByUsername(String username);

    @Query("select count(distinct s) from Student s left outer join s.listOfCourse c left outer join c.listOfCoursePrerequisite cp where c.id=:courseId")
    Integer findMaximumCourseCapacity(@Param("courseId") Integer courseId);
}
