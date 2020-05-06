package com.schedule.suggestion.controller;

import com.schedule.suggestion.service.CourseService;
import com.schedule.suggestion.service.StudentService;
import com.schedule.suggestion.service.dto.CompletionDto;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:4200")

public class ScheduleSuggestionController {
    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public ScheduleSuggestionController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
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

    @RequestMapping(path = "/student", method = RequestMethod.GET)
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(path = "/student/{username}", method = RequestMethod.GET)
    public StudentDto getStudentByUsername(@PathVariable String username) {
        return studentService.getStudentByUsername(username);
    }

    @RequestMapping(path = "/student/courses/{username}", method = RequestMethod.GET)
    public List<CourseDto> getStudentPassedCourses(@PathVariable String username) {
        return studentService.getStudentPassedCourses(username);
    }

    @RequestMapping(path = "/capacity/{courseId}", method = RequestMethod.GET)
    public Integer getStudentByUsername(@PathVariable Integer courseId) {
        return studentService.findMaximumCourseCapacity(courseId);
    }
}
