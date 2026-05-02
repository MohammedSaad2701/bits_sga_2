package com.example.studentcourse.repository;

import com.example.studentcourse.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    @Query("SELECT s FROM Student s INNER JOIN s.course c")
    List<Student> findStudentsWithCourses();
}