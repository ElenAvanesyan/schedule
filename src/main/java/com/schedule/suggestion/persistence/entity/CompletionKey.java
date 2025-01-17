package com.schedule.suggestion.persistence.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class CompletionKey implements Serializable {
    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES
    // ----------------------------------------------------------------------
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    // ----------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------
    public CompletionKey() {
        super();
    }

    public CompletionKey(Integer studentId, Integer courseId) {
        super();
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    // ----------------------------------------------------------------------
    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer value) {
        this.studentId = value;
    }

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer value) {
        this.courseId = value;
    }
}
