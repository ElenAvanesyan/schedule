package com.schedule.suggestion.service.model;

import java.time.LocalTime;

public class ScheduleSuggestionCriteria {
    private String term;
    private LocalTime preferredStartTime;
    private LocalTime preferredEndTime;
    private String preferredDays;
    private Integer numberOfCore;
    private Integer numberOfGened;
    private Integer numberOfTrack;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public LocalTime getPreferredStartTime() {
        return preferredStartTime;
    }

    public void setPreferredStartTime(LocalTime preferredStartTime) {
        this.preferredStartTime = preferredStartTime;
    }

    public LocalTime getPreferredEndTime() {
        return preferredEndTime;
    }

    public void setPreferredEndTime(LocalTime preferredEndTime) {
        this.preferredEndTime = preferredEndTime;
    }

    public String getPreferredDays() {
        return preferredDays;
    }

    public void setPreferredDays(String preferredDays) {
        this.preferredDays = preferredDays;
    }

    public Integer getNumberOfCore() {
        return numberOfCore;
    }

    public void setNumberOfCore(Integer numberOfCore) {
        this.numberOfCore = numberOfCore;
    }

    public Integer getNumberOfGened() {
        return numberOfGened;
    }

    public void setNumberOfGened(Integer numberOfGened) {
        this.numberOfGened = numberOfGened;
    }

    public Integer getNumberOfTrack() {
        return numberOfTrack;
    }

    public void setNumberOfTrack(Integer numberOfTrack) {
        this.numberOfTrack = numberOfTrack;
    }
}
