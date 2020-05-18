package com.schedule.suggestion.controller;

import com.schedule.suggestion.persistence.entity.Professor;
import com.schedule.suggestion.service.CourseService;
import com.schedule.suggestion.service.ProfessorService;
import com.schedule.suggestion.service.ScheduleSuggestionService;
import com.schedule.suggestion.service.StudentService;
import com.schedule.suggestion.service.dto.*;
import com.schedule.suggestion.service.model.ScheduleSuggestionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin()


public class ScheduleSuggestionController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final ProfessorService professorService;
    private final ScheduleSuggestionService scheduleSuggestionService;

    @Autowired
    public ScheduleSuggestionController(CourseService courseService, StudentService studentService,
                                        ProfessorService professorService, ScheduleSuggestionService scheduleSuggestionService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.professorService = professorService;
        this.scheduleSuggestionService = scheduleSuggestionService;
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
    public List<CourseDto> getAllCoursesByTerm(@PathVariable String term) {
        return courseService.getAllCoursesByTerm(term);
    }

    @RequestMapping(path = "/student", method = RequestMethod.GET)
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(path = "/student/authenticate", method = RequestMethod.POST)
    public StudentDto authenticateStudent(@RequestBody AuthenticationDto authenticationDto) {
        return studentService.authenticateStudent(authenticationDto);
    }

    @RequestMapping(path = "/professor/authenticate", method = RequestMethod.POST)
    public ProfessorDto authenticateProfessor(@RequestBody AuthenticationDto authenticationDto) {
        return professorService.authenticateProfessor(authenticationDto);
    }

    @RequestMapping(path = "/student/{studentId}", method = RequestMethod.GET)
    public StudentDto getStudentByUsername(@PathVariable Integer studentId) {
        return studentService.getStudentByUsername(studentId);
    }

    @RequestMapping(path = "/student/passed/{studentId}", method = RequestMethod.GET)
    public List<CourseDto> getStudentPassedCourses(@PathVariable Integer studentId) {
        return studentService.getStudentPassedCourses(studentId);
    }

    @RequestMapping(path = "/capacity/{courseId}", method = RequestMethod.GET)
    public Integer findMaximumCourseCapacity(@PathVariable Integer courseId) {
        return studentService.findMaximumCourseCapacity(courseId);
    }

    @RequestMapping(path = "/generate/{studentId}", method = RequestMethod.POST)
    public ScheduleSuggestionResponseDto generateSchedule(@PathVariable Integer studentId,
                                                          @RequestBody ScheduleSuggestionCriteria criteria) {
        return scheduleSuggestionService.generateSchedule(studentId, criteria);
    }

    @RequestMapping(path = "/available/{term}/{studentId}", method = RequestMethod.GET)
    public List<CourseDto> getAvailableCoursesById(@PathVariable Integer studentId,
                                                   @PathVariable String term) {
        return scheduleSuggestionService.getAvailableCoursesById(studentId, term);
    }
}
