package com.schedule.suggestion.controller;

import com.schedule.suggestion.service.CourseService;
import com.schedule.suggestion.service.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:3000")

public class ScheduleSuggestionController {
    private final CourseService courseService;

    @Autowired
    public ScheduleSuggestionController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(path = "/course", method = RequestMethod.GET)
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(path = "/course/{courseNumber}", method = RequestMethod.GET)
    public CourseDto getCourseByCourseNumber(@PathVariable String courseNumber) {
        return courseService.getCourseByCourseNumber(courseNumber);
    }

    @RequestMapping(path = "/course/term/{term}", method = RequestMethod.GET)
    public List<CourseDto> getCourseByTerm(@PathVariable String term) {
        return courseService.getCourseByTerm(term);
    }
}
