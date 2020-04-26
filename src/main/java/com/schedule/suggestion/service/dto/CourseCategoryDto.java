package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.CourseCategory;
import com.schedule.suggestion.persistence.entity.CourseCluster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseCategoryDto {
    private Integer id;
    private Integer categoryId;
    private String categoryAlias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias;
    }


    public static CourseCategoryDto mapEntityToDto(CourseCategory entity) {
        if (entity == null) {
            return null;
        }

        CourseCategoryDto dto = new CourseCategoryDto();
        dto.setId(entity.getId());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setCategoryAlias(entity.getCategory().getCategoryAlias());

        return dto;
    }

    public static List<CourseCategoryDto> mapEntitiesToDtos(Collection<CourseCategory> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<CourseCategoryDto> dtos = new ArrayList<>();
        for (CourseCategory entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
