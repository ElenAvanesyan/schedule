package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentDto {
    private Integer id;
    private String idNumber;
    private String firstName;
    private String lastName;
    private String username;
    private List<CourseDto> listOfCourse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CourseDto> getListOfCourse() {
        return listOfCourse;
    }

    public void setListOfCourse(List<CourseDto> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }

    public static StudentDto mapEntityToDto(Student entity) {
        if (entity == null) {
            return null;
        }

        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setIdNumber(entity.getIdNumber());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setListOfCourse(CourseDto.mapEntitiesToDtos(entity.getListOfCourse()));

        return dto;
    }

    public static Student mapDtoToEntity(StudentDto dto) {
        if (dto == null) {
            return null;
        }

        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setIdNumber(dto.getIdNumber());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());

        return entity;
    }

    public static List<Student> mapDtosToEntities(Collection<StudentDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        List<Student> entities = new ArrayList<>();
        for (StudentDto dto: dtos) {
            entities.add(mapDtoToEntity(dto));
        }

        return entities;
    }

    public static List<StudentDto> mapEntitiesToDtos(Collection<Student> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<StudentDto> dtos = new ArrayList<>();
        for (Student entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
