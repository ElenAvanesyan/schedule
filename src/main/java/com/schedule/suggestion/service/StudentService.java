package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.repositories.StudentRepository;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        return StudentDto.mapEntitiesToDtos(studentRepository.findAll());
    }

    public StudentDto getStudentByUsername(String username) {
        return StudentDto.mapEntityToDto(studentRepository.findStudentByUsername(username));
    }

    public List<CourseDto> getStudentPassedCourses(String username) {
        return CourseDto.mapEntitiesToDtos(studentRepository.getStudentPassedCourses(username));
    }

    public Integer findMaximumCourseCapacity(Integer courseId) {
        return studentRepository.findMaximumCourseCapacity(courseId);
    }
}
