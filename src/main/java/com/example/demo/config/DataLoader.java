package com.example.studentcourse.config;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.repository.CourseRepository;
import com.example.studentcourse.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public DataLoader(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {

        if (courseRepository.count() == 0) {

            Course c1 = courseRepository.save(new Course("Java Full Stack", "Mr. Sharma", 6));
            Course c2 = courseRepository.save(new Course("Python Programming", "Ms. Aisha", 4));
            Course c3 = courseRepository.save(new Course("Data Engineering", "Mr. Rahul", 5));
            Course c4 = courseRepository.save(new Course("Web Development", "Ms. Priya", 3));
            Course c5 = courseRepository.save(new Course("Machine Learning", "Dr. Khan", 6));
            Course c6 = courseRepository.save(new Course("Cloud Computing", "Mr. Arjun", 4));
            Course c7 = courseRepository.save(new Course("Cyber Security", "Ms. Neha", 5));
            Course c8 = courseRepository.save(new Course("DevOps", "Mr. Varun", 4));
            Course c9 = courseRepository.save(new Course("Database Management", "Ms. Sneha", 3));
            Course c10 = courseRepository.save(new Course("Spring Boot", "Mr. Joseph", 4));

            studentRepository.save(new Student("Noorain", "noorain@gmail.com", 21, c1));
            studentRepository.save(new Student("Aisha", "aisha@gmail.com", 22, c2));
            studentRepository.save(new Student("Rahul", "rahul@gmail.com", 23, c3));
            studentRepository.save(new Student("Priya", "priya@gmail.com", 20, c4));
            studentRepository.save(new Student("Arjun", "arjun@gmail.com", 24, c5));
            studentRepository.save(new Student("Neha", "neha@gmail.com", 22, c6));
            studentRepository.save(new Student("Varun", "varun@gmail.com", 25, c7));
            studentRepository.save(new Student("Sneha", "sneha@gmail.com", 21, c8));
            studentRepository.save(new Student("Joseph", "joseph@gmail.com", 23, c9));
            studentRepository.save(new Student("Meera", "meera@gmail.com", 20, c10));
        }
    }
}