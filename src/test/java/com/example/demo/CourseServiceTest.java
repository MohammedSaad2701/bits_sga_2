package com.example.studentcourse;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.repository.CourseRepository;
import com.example.studentcourse.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CourseServiceTest {

    @Test
    public void testGetAllCourses() {
        CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
        CourseService courseService = new CourseService(courseRepository);

        Course c1 = new Course("Java", "Mr. Sharma", 6);
        Course c2 = new Course("Python", "Ms. Aisha", 4);

        when(courseRepository.findAll()).thenReturn(List.of(c1, c2));

        List<Course> courses = courseService.getAllCourses();

        assertEquals(2, courses.size());
        assertEquals("Java", courses.get(0).getCourseName());
    }
}