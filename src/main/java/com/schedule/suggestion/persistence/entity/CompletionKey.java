package com.schedule.suggestion.persistence.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class CompletionKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "course_section_id", nullable = false)
    private Integer courseSectionId;

    public CompletionKey() {
        super();
    }

    public CompletionKey(Integer studentId, Integer courseSectionId) {
        super();
        this.studentId = studentId;
        this.courseSectionId = courseSectionId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer value) {
        this.studentId = value;
    }

    public Integer getCourseSectionId() {
        return this.courseSectionId;
    }

    public void setCourseSectionId(Integer value) {
        this.courseSectionId = value;
    }
}
