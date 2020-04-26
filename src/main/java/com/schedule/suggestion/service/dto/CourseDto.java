package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.Course;
import com.schedule.suggestion.persistence.entity.CourseSection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CourseDto {
    private Integer id;
    private String courseNumber;
    private String title;
    private Integer credit;
    private List<CourseSectionDto> courseSections;
    private List<CourseClusterDto> courseClusters;
    private List<CourseCategoryDto> courseCategories;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public List<CourseSectionDto> getCourseSections() {
        return courseSections;
    }

    public void setCourseSections(List<CourseSectionDto> courseSections) {
        this.courseSections = courseSections;
    }

    public List<CourseClusterDto> getCourseClusters() {
        return courseClusters;
    }

    public void setCourseClusters(List<CourseClusterDto> courseClusters) {
        this.courseClusters = courseClusters;
    }

    public List<CourseCategoryDto> getCourseCategories() {
        return courseCategories;
    }

    public void setCourseCategories(List<CourseCategoryDto> courseCategories) {
        this.courseCategories = courseCategories;
    }


    public static CourseDto mapEntityToDto(Course entity) {
        if (entity == null) {
            return null;
        }

        CourseDto dto = new CourseDto();
        dto.setId(entity.getId());
        dto.setCourseNumber(entity.getCourseNumber());
        dto.setTitle(entity.getTitle());
        dto.setCredit(entity.getCredit());
        dto.setCourseSections(CourseSectionDto.mapEntitiesToDtos(entity.getListOfCourseSection()));
        dto.setCourseClusters(CourseClusterDto.mapEntitiesToDtos(entity.getListOfCourseCluster()));
        dto.setCourseCategories(CourseCategoryDto.mapEntitiesToDtos(entity.getListOfCourseCategory()));

        return dto;
    }

    public static Course mapDtoToEntity(CourseDto dto) {
        if (dto == null) {
            return null;
        }

        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setCourseNumber(dto.getCourseNumber());
        entity.setTitle(dto.getTitle());
        entity.setCredit(dto.getCredit());

        return entity;
    }

    public static List<Course> mapDtosToEntities(Collection<CourseDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        List<Course> entities = new ArrayList<>();
        for (CourseDto dto: dtos) {
            entities.add(mapDtoToEntity(dto));
        }

        return entities;
    }

    public static List<CourseDto> mapEntitiesToDtos(Collection<Course> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<CourseDto> dtos = new ArrayList<>();
        for (Course entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }
}
