package com.example.studentcourse;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.CourseService;
import com.example.studentcourse.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    @Test
    public void testGetAllStudents() {
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        CourseService courseService = Mockito.mock(CourseService.class);

        StudentService studentService = new StudentService(studentRepository, courseService);

        Course course = new Course("Java", "Mr. Sharma", 6);

        Student s1 = new Student("Noorain", "noorain@gmail.com", 21, course);
        Student s2 = new Student("Aisha", "aisha@gmail.com", 22, course);

        when(studentRepository.findAll()).thenReturn(List.of(s1, s2));

        List<Student> students = studentService.getAllStudents();

        assertEquals(2, students.size());
        assertEquals("Noorain", students.get(0).getStudentName());
    }
}