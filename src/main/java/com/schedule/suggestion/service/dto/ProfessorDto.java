package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.Professor;
import com.schedule.suggestion.persistence.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProfessorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static ProfessorDto mapEntityToDto(Professor entity) {
        if (entity == null) {
            return null;
        }

        ProfessorDto dto = new ProfessorDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());

        return dto;
    }

    public static Professor mapDtoToEntity(ProfessorDto dto) {
        if (dto == null) {
            return null;
        }

        Professor entity = new Professor();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());

        return entity;
    }

    public static List<Professor> mapDtosToEntities(Collection<ProfessorDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        List<Professor> entities = new ArrayList<>();
        for (ProfessorDto dto: dtos) {
            entities.add(mapDtoToEntity(dto));
        }

        return entities;
    }

    public static List<ProfessorDto> mapEntitiesToDtos(Collection<Professor> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<ProfessorDto> dtos = new ArrayList<>();
        for (Professor entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
