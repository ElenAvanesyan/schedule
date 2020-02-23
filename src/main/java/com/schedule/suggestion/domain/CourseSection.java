package com.schedule.suggestion.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "course_section")
public class CourseSection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 10)
    private Integer sectionNumber;

    @NotBlank
    @Size(min = 1, max = 10)
    private String term;

    @Size(max = 30)
    private String instructorName;

    @Size(max = 3)
    private String weekDays;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
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

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return this.course;
    }
}
