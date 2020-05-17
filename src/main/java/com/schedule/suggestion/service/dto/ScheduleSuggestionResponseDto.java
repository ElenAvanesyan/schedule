package com.schedule.suggestion.service.dto;

import java.util.List;

public class ScheduleSuggestionResponseDto {
    private List<CourseSectionDto> listOfCourseSection;
    private List<String> listOfMessages;

    public List<CourseSectionDto> getListOfCourseSection() {
        return listOfCourseSection;
    }

    public void setListOfCourseSection(List<CourseSectionDto> listOfCourseSection) {
        this.listOfCourseSection = listOfCourseSection;
    }

    public List<String> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<String> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }
}
