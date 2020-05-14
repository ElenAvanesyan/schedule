package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.repositories.CourseRepository;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.model.ScheduleSuggestionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleSuggestionService {
    private final CourseRepository courseRepository;

    @Autowired
    public ScheduleSuggestionService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository; }

    public List<CourseDto> generateSchedule(Integer studentId, ScheduleSuggestionCriteria criteria) {
        List<CourseDto> schedule = new ArrayList<>();
        List<CourseDto> availableCourses = getAllAvailableCourses(studentId, criteria);

        return availableCourses;
    }

    public List<CourseDto> getAllAvailableCourses(Integer studentId, ScheduleSuggestionCriteria criteria) {
        String listOfPassedCourses = getListOfPassedCourses(studentId);

        return CourseDto.mapEntitiesToDtos(courseRepository.getAllAvailableCoursesByStudentId(
                listOfPassedCourses, criteria.getTerm(), criteria.getPreferredDays(),
                criteria.getPreferredStartTime(), criteria.getPreferredEndTime()));
    }

    public String getListOfPassedCourses(Integer studentId) {
        return courseRepository.getListOfPassedCourses(studentId);
    }
}
