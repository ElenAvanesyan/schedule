package com.schedule.suggestion.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "completion")
public class Completion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CompletionKey compositePrimaryKey;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    public Completion() {
        super();
        this.compositePrimaryKey = new CompletionKey();
    }

    public Long getStudentId() {
        return this.compositePrimaryKey.getStudentId();
    }

    public void setStudentId(Long studentId) {
        this.compositePrimaryKey.setStudentId(studentId);
    }

    public Long getCourseSectionId() {
        return this.compositePrimaryKey.getCourseSectionId();
    }

    public void setCourseSectionId(Long courseSectionId) {
        this.compositePrimaryKey.setCourseSectionId(courseSectionId);
    }
}
