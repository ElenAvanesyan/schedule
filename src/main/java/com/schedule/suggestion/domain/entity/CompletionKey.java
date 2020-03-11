package com.schedule.suggestion.domain.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class CompletionKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "course_section_id", nullable = false)
    private Long courseSectionId;

    public CompletionKey() {
        super();
    }

    public CompletionKey(Long studentId, Long courseSectionId) {
        super();
        this.studentId = studentId;
        this.courseSectionId = courseSectionId;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long value) {
        this.studentId = value;
    }

    public Long getCourseSectionId() {
        return this.courseSectionId;
    }

    public void setCourseSectionId(Long value) {
        this.courseSectionId = value;
    }
}
