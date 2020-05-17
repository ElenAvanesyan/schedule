package com.schedule.suggestion.service.dto;

import com.schedule.suggestion.persistence.entity.CourseSection;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseSectionDto {
    private Integer id;
    private String sectionName;
    private String term;
    private String instructorName;
    private String weekDays;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer courseId;
    private String courseNumber;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String weekDays) {
        this.weekDays = weekDays;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public static CourseSectionDto mapEntityToDto(CourseSection entity) {
        if (entity == null) {
            return null;
        }

        CourseSectionDto dto = new CourseSectionDto();
        dto.setId(entity.getId());
        dto.setInstructorName(entity.getInstructorName());
        dto.setSectionName(entity.getSectionName());
        dto.setTerm(entity.getTerm());
        dto.setWeekDays(entity.getWeekDays());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setCourseId(entity.getCourseId());
        dto.setCourseNumber(entity.getCourseNumber());
        dto.setTitle(entity.getCourseTitle());

        return dto;
    }

    public static CourseSection mapDtoToEntity(CourseSectionDto dto) {
        if (dto == null) {
            return null;
        }

        CourseSection entity = new CourseSection();
        entity.setId(dto.getId());
        entity.setInstructorName(dto.getInstructorName());
        entity.setSectionName(dto.getSectionName());
        entity.setTerm(dto.getTerm());
        entity.setWeekDays(dto.getWeekDays());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());

        return entity;
    }

    public static List<CourseSection> mapDtosToEntities(Collection<CourseSectionDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }

        List<CourseSection> entities = new ArrayList<>();
        for (CourseSectionDto dto: dtos) {
            entities.add(mapDtoToEntity(dto));
        }

        return entities;
    }

    public static List<CourseSectionDto> mapEntitiesToDtos(Collection<CourseSection> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        List<CourseSectionDto> dtos = new ArrayList<>();
        for (CourseSection entity: entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }

}
