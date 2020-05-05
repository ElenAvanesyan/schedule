package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.Completion;
import com.schedule.suggestion.persistence.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompletionDto {
    private Integer studentId;
    private Integer courseId;
    private Double grade;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getGrade() {
        return this.grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public static CompletionDto mapEntityToDto(Completion entity) {
        if (entity == null) {
            return null;
        }

        CompletionDto dto = new CompletionDto();
        dto.setStudentId(entity.getStudentId());
        dto.setCourseId(entity.getCourseId());
        dto.setGrade(entity.getGrade());

        return dto;
    }

    public static Completion mapDtoToEntity(CompletionDto dto) {
        if (dto == null) {
            return null;
        }

        Completion entity = new Completion();
        entity.setStudentId(dto.getStudentId());
        entity.setCourseId(dto.getCourseId());
        entity.setGrade(dto.getGrade());

        return entity;
    }

    public static List<Completion> mapDtosToEntities(Collection<CompletionDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        List<Completion> entities = new ArrayList<>();
        for (CompletionDto dto: dtos) {
            entities.add(mapDtoToEntity(dto));
        }

        return entities;
    }

    public static List<CompletionDto> mapEntitiesToDtos(Collection<Completion> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<CompletionDto> dtos = new ArrayList<>();
        for (Completion entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
