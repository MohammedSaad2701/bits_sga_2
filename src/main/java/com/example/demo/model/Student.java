package com.example.studentcourse.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String studentName;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Student() {
    }

    public Student(String studentName, String email, int age, Course course) {
        this.studentName = studentName;
        this.email = email;
        this.age = age;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}