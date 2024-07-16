package com.lab3.controller;

import com.lab3.bean.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController2 {

    @RequestMapping("/validation/form")
    public String form(Model model) {
        Student2 student = new Student2();
        model.addAttribute("sv", student);
        return "validation/form";
    }

    @PostMapping("/validation/validate")
    public String validate(Model model, @Validated @ModelAttribute("sv") Student2 student, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau:");
            return "validation/form";
        }
        return "validation/success";
    }
}
