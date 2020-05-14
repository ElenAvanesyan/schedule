package com.schedule.suggestion.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    @Size(max = 10)
    private String courseNumber;

    @NotNull
    @Column(unique = true)
    @Size(min = 1, max = 50)
    private String title;

    @NotNull
    private Integer credit;

    private Integer priority;

    @OneToMany(mappedBy = "course", targetEntity = CourseSection.class, cascade = CascadeType.ALL)
    private List<CourseSection> listOfCourseSection;

    @OneToMany(mappedBy = "course", targetEntity = CourseCategory.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseCategory> listOfCourseCategory;

    @OneToMany(mappedBy = "course", targetEntity = CourseCluster.class, cascade = CascadeType.ALL)
    private List<CourseCluster> listOfCourseCluster;

    @OneToMany(mappedBy = "course", targetEntity = CoursePrerequisite.class, cascade = CascadeType.ALL)
    private List<CoursePrerequisite> listOfCoursePrerequisite;

    @ManyToMany(mappedBy = "listOfCourse", targetEntity = Student.class)
    private List<Student> listOfCourse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setListOfCourseSection(List<CourseSection> listOfCourseSection) {
        this.listOfCourseSection = listOfCourseSection;
    }

    public List<CourseSection> getListOfCourseSection() {
        return this.listOfCourseSection;
    }

    public void setListOfCourseCategory(List<CourseCategory> listOfCourseCategory) {
        this.listOfCourseCategory = listOfCourseCategory;
    }

    public List<CourseCategory> getListOfCourseCategory() {
        return this.listOfCourseCategory;
    }

    public void setListOfCourseCluster(List<CourseCluster> listOfCourseCluster) {
        this.listOfCourseCluster = listOfCourseCluster;
    }

    public List<CourseCluster> getListOfCourseCluster() {
        return this.listOfCourseCluster;
    }

    public void setListOfCoursePrerequisite(List<CoursePrerequisite> listOfCoursePrerequisite) {
        this.listOfCoursePrerequisite = listOfCoursePrerequisite;
    }

    public List<CoursePrerequisite> getListOfCoursePrerequisite() {
        return this.listOfCoursePrerequisite;
    }

    public List<Student> getListOfCourse() {
        return this.listOfCourse;
    }

    public void setListOfCourse(List<Student> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }
}
