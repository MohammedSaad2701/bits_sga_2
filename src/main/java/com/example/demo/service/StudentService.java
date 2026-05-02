package com.example.studentcourse.service;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseService courseService;

    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    public Student saveStudent(Student student, Long courseId) {
        Course course = courseService.getCourseById(courseId);
        student.setCourse(course);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsWithCourses() {
        return studentRepository.findStudentsWithCourses();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Long id, Student updatedStudent, Long courseId) {
        Student existingStudent = getStudentById(id);
        Course course = courseService.getCourseById(courseId);

        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setCourse(course);

        return studentRepository.save(existingStudent);
    }
}