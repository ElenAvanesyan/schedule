package com.schedule.suggestion.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "completion")
public class Completion implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
    //----------------------------------------------------------------------
    @EmbeddedId
    private CompletionKey compositePrimaryKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "grade", insertable = false, updatable = false)
    private Double grade;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Completion() {
        super();
        this.compositePrimaryKey = new CompletionKey();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY
    //----------------------------------------------------------------------
    public Integer getStudentId() {
        return this.compositePrimaryKey.getStudentId();
    }

    public void setStudentId(Integer studentId) {
        this.compositePrimaryKey.setStudentId(studentId);
    }

    public Integer getCourseId() {
        return this.compositePrimaryKey.getCourseId();
    }

    public void setCourseId(Integer courseId) {
        this.compositePrimaryKey.setCourseId(courseId);
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public Double getGrade() {
        return this.grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
