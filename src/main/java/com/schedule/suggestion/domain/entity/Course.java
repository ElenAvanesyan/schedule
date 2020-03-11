package com.schedule.suggestion.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size(max = 10)
    private String courseNumber;

    @NotBlank
    @Column(unique = true)
    @Size(min = 1, max = 50)
    private String title;

    @NotBlank
    private Integer credit;

    @OneToMany(mappedBy = "course", targetEntity = CourseSection.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseSection> listOfCourseSection;

    @OneToMany(mappedBy = "course", targetEntity = CourseSection.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseCategory> listOfCourseCategory;

    @OneToMany(mappedBy = "course", targetEntity = CourseSection.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseCluster> listOfCourseCluster;

    @OneToMany(mappedBy = "course", targetEntity = CourseSection.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CoursePrerequisite> listOfCoursePrerequisite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public void setListOfCourseSection(Set<CourseSection> listOfCourseSection) {
        this.listOfCourseSection = listOfCourseSection;
    }

    public Set<CourseSection> getListOfCourseSection() {
        return this.listOfCourseSection;
    }

    public void setListOfCourseCategory(Set<CourseCategory> listOfCourseCategory) {
        this.listOfCourseCategory = listOfCourseCategory;
    }

    public Set<CourseCategory> getListOfCourseCategory() {
        return this.listOfCourseCategory;
    }

    public void setListOfCourseCluster(Set<CourseCluster> listOfCourseCluster) {
        this.listOfCourseCluster = listOfCourseCluster;
    }

    public Set<CourseCluster> getListOfCourseCluster() {
        return this.listOfCourseCluster;
    }

    public void setListOfCoursePrerequisite(Set<CoursePrerequisite> listOfCoursePrerequisite) {
        this.listOfCoursePrerequisite = listOfCoursePrerequisite;
    }

    public Set<CoursePrerequisite> getListOfCoursePrerequisite() {
        return this.listOfCoursePrerequisite;
    }
}
