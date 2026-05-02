package com.example.studentcourse.controller;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.service.CourseService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/courses/save")
    public String saveCourse(@ModelAttribute Course course, Model model) {
        try {
            courseService.saveCourse(course);
            return "redirect:/courses";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Course name already exists or invalid data entered.");
            return "add-course";
        }
    }

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "list-courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String showUpdateCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "update-course";
    }

    @PostMapping("/courses/update/{id}")
    public String updateCourse(@PathVariable Long id,
                               @ModelAttribute Course course,
                               Model model) {
        try {
            courseService.updateCourse(id, course);
            return "redirect:/courses";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Course name already exists.");
            model.addAttribute("course", course);
            return "update-course";
        }
    }
}