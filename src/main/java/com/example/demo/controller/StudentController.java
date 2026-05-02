package com.example.studentcourse.controller;

import com.example.studentcourse.model.Student;
import com.example.studentcourse.service.CourseService;
import com.example.studentcourse.service.StudentService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/students/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        return "add-student";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute Student student,
                              @RequestParam Long courseId,
                              Model model) {
        try {
            studentService.saveStudent(student, courseId);
            return "redirect:/students";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Email already exists or invalid data entered.");
            model.addAttribute("courses", courseService.getAllCourses());
            return "add-student";
        }
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getStudentsWithCourses());
        return "list-students";
    }

    @GetMapping("/students/edit/{id}")
    public String showUpdateStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("courses", courseService.getAllCourses());
        return "update-student";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute Student student,
                                @RequestParam Long courseId,
                                Model model) {
        try {
            studentService.updateStudent(id, student, courseId);
            return "redirect:/students";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Email already exists or invalid data entered.");
            model.addAttribute("student", student);
            model.addAttribute("courses", courseService.getAllCourses());
            return "update-student";
        }
    }
}