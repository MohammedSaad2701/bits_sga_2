package com.example.studentcourse.service;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = getCourseById(id);

        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setInstructor(updatedCourse.getInstructor());
        existingCourse.setDurationInMonths(updatedCourse.getDurationInMonths());

        return courseRepository.save(existingCourse);
    }
}