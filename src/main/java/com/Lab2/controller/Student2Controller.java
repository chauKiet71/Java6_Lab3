package com.Lab2.controller;

import com.Lab2.bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class Student2Controller {
    @RequestMapping("/student/list")
    public String list(Model model, @RequestParam("indexx")Optional<Integer> index) throws IOException {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> typeref = new TypeReference<List<Student>>() {};
        List<Student> students = mapper.readValue(file, typeref);

        model.addAttribute("sv", students.get(index.orElse(0)));
        model.addAttribute("dssv", students);
        return "student/list";
    }
}
