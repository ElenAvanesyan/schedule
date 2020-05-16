package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.entity.Student;
import com.schedule.suggestion.persistence.repositories.StudentRepository;
import com.schedule.suggestion.service.dto.AuthenticationDto;
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

    public StudentDto getStudentByUsername(Integer studentId) {
        return StudentDto.mapEntityToDto(studentRepository.findStudentById(studentId));
    }

    public List<CourseDto> getStudentPassedCourses(Integer studentId) {
        return CourseDto.mapEntitiesToDtos(studentRepository.getStudentPassedCourses(studentId));
    }

    public Integer findMaximumCourseCapacity(Integer courseId) {
        return studentRepository.findMaximumCourseCapacity(courseId);
    }

    public StudentDto authenticateStudent(AuthenticationDto authenticationDto) {
        if (authenticationDto.getUsername() == null || authenticationDto.getPassword() == null) {
            throw new Error("Username or password missing");
        }

        Student student = studentRepository.findStudentByUsernameAndPassword(authenticationDto.getUsername(), authenticationDto.getPassword());

        if (student == null) {
            throw new Error("Username or password is incorrect");
        }

        return StudentDto.mapEntityToDto(student);
    }
}
