package com.schedule.suggestion.service;

import com.schedule.suggestion.persistence.entity.Professor;
import com.schedule.suggestion.persistence.entity.Student;
import com.schedule.suggestion.persistence.repositories.ProfessorRepository;
import com.schedule.suggestion.persistence.repositories.StudentRepository;
import com.schedule.suggestion.service.dto.AuthenticationDto;
import com.schedule.suggestion.service.dto.CourseDto;
import com.schedule.suggestion.service.dto.ProfessorDto;
import com.schedule.suggestion.service.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorDto authenticateProfessor(AuthenticationDto authenticationDto) {
        if (authenticationDto.getUsername() == null || authenticationDto.getPassword() == null) {
            throw new Error("Username or password missing");
        }

        Professor professor = professorRepository.findProfessorByUsernameAndPassword(authenticationDto.getUsername(), authenticationDto.getPassword());

        if (professor == null) {
            throw new Error("Username or password is incorrect");
        }

        return ProfessorDto.mapEntityToDto(professor);
    }
}
