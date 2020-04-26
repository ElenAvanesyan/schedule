package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.repositories.CourseRepository;
import com.schedule.suggestion.service.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> getAllCourses() {
        return CourseDto.mapEntitiesToDtos(courseRepository.findAll());
    }

    public CourseDto getCourseByCourseNumber(String courseNumber) {
        return CourseDto.mapEntityToDto(courseRepository.findCourseByCourseNumber(courseNumber));
    }
}
