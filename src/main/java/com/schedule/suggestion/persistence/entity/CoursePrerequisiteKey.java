package com.schedule.suggestion.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CoursePrerequisiteKey implements Serializable {
    private static final long serialVersionUID = 1L;
    // ----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES
    // ----------------------------------------------------------------------
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "prerequisite_course_id", nullable = false)
    private Integer prerequisiteCourseId;

    // ----------------------------------------------------------------------
    // CONSTRUCTORS
    // ----------------------------------------------------------------------
    public CoursePrerequisiteKey() {
        super();
    }

    public CoursePrerequisiteKey(Integer courseId, Integer prerequisiteCourseId) {
        super();
        this.courseId = courseId;
        this.prerequisiteCourseId = prerequisiteCourseId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    // ----------------------------------------------------------------------

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getPrerequisiteCourseId() {
        return this.prerequisiteCourseId;
    }

    public void setPrerequisiteCourseId(Integer prerequisiteCourseId) {
        this.prerequisiteCourseId = prerequisiteCourseId;
    }
}
