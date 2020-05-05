package com.schedule.suggestion.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    @Size(max = 10)
    private String idNumber;

    @NotNull
    @Column(unique = true)
    @Size(min = 1, max = 100)
    private String username;

    @NotNull
    @Size(min = 1, max = 100)
    private String password;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "completion",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> listOfCourse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setListOfCourse(List<Course> listOfCourse) {
        this.listOfCourse = listOfCourse;
    }

    public List<Course> getListOfCourse() {
        return this.listOfCourse;
    }
}
