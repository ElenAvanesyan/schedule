package com.schedule.suggestion.service.model;

import java.time.LocalTime;

public class ScheduleSuggestionCriteria {
    private String term;
    private String preferredStartTime;
    private String preferredEndTime;
    private String preferredDays;
    private Integer numberOfCore;
    private Integer numberOfGenEd;
    private Integer numberOfTrack;
    private String track;
    private boolean isFoundationChecked;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public LocalTime getPreferredStartTime() {
        return LocalTime.parse(preferredStartTime);
    }

    public LocalTime getPreferredEndTime() {
        return LocalTime.parse(preferredEndTime);
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

    public Integer getNumberOfGenEd() {
        return numberOfGenEd;
    }

    public void setNumberOfGenEd(Integer numberOfGenEd) {
        this.numberOfGenEd = numberOfGenEd;
    }

    public Integer getNumberOfTrack() {
        return numberOfTrack;
    }

    public void setNumberOfTrack(Integer numberOfTrack) {
        this.numberOfTrack = numberOfTrack;
    }

    public boolean getIsFoundationChecked() {
        return isFoundationChecked;
    }

    public void setIsFoundationChecked(boolean isFoundationChecked) {
        this.isFoundationChecked = isFoundationChecked;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
