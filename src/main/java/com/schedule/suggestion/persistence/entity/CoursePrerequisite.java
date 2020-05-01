package com.schedule.suggestion.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course_prerequisite")
public class CoursePrerequisite implements Serializable {
    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )
    // ----------------------------------------------------------------------
    @EmbeddedId
    private CoursePrerequisiteKey compositePrimaryKey;

    // ----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES
    // ----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "prerequisite_course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course prerequisiteCourse;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public CoursePrerequisite() {
        super();
        this.compositePrimaryKey = new CoursePrerequisiteKey();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY
    // ----------------------------------------------------------------------
    public Integer getCourseId() {
        return this.compositePrimaryKey.getCourseId();
    }

    public void setCourseId(Integer courseId) {
        this.compositePrimaryKey.setCourseId(courseId);
    }

    public Integer getPrerequisiteCourseId() {
        return this.compositePrimaryKey.getPrerequisiteCourseId();
    }

    public void setPrerequisiteCourseId(Integer prerequisiteCourseId) {
        this.compositePrimaryKey.setPrerequisiteCourseId(prerequisiteCourseId);
    }
}
