package com.example.studentcourse.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Column(nullable = false)
    private String instructor;

    @Column(nullable = false)
    private int durationInMonths;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName, String instructor, int durationInMonths) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.durationInMonths = durationInMonths;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}