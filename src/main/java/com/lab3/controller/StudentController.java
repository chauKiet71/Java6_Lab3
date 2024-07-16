package com.lab3.controller;

import com.lab3.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @GetMapping("/student/form")
    public String studentForm(Model model) {
        Student student = new Student();
        model.addAttribute("sv", student);
        return "student/form";
    }

    @PostMapping("/student/save")
    public String studentSave(@ModelAttribute("sv") Student form) {
        return "student/success";
    }
}
