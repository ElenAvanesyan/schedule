package com.schedule.suggestion.persistence.entity;

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

    public Integer getStudentId() {
        return this.compositePrimaryKey.getStudentId();
    }

    public void setStudentId(Integer studentId) {
        this.compositePrimaryKey.setStudentId(studentId);
    }

    public Integer getCourseSectionId() {
        return this.compositePrimaryKey.getCourseSectionId();
    }

    public void setCourseSectionId(Integer courseSectionId) {
        this.compositePrimaryKey.setCourseSectionId(courseSectionId);
    }
}
