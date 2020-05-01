package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.CoursePrerequisite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoursePrerequisiteDto {
    private Integer prerequisiteCourseId;

    public Integer getPrerequisiteId() {
        return prerequisiteCourseId;
    }

    public void setPrerequisiteId(Integer prerequisiteCourseId) {
        this.prerequisiteCourseId = prerequisiteCourseId;
    }


    public static CoursePrerequisiteDto mapEntityToDto(CoursePrerequisite entity) {
        if (entity == null) {
            return null;
        }

        CoursePrerequisiteDto dto = new CoursePrerequisiteDto();
        dto.setPrerequisiteId(entity.getPrerequisiteCourseId());

        return dto;
    }

    public static List<CoursePrerequisiteDto> mapEntitiesToDtos(Collection<CoursePrerequisite> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<CoursePrerequisiteDto> dtos = new ArrayList<>();
        for (CoursePrerequisite entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
