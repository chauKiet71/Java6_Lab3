package com.Lab2.controller;

import com.Lab2.bean.Student;
import com.Lab2.bean.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class UtilityController {
    @RequestMapping("/demo/utilities")
    public String demoUtilities(Model model) throws IOException {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> typeref = new TypeReference<List<Student>>() {};
        List<Student> students = mapper.readValue(file, typeref);

        model.addAttribute("dssv", students);
        model.addAttribute("now", new Date());
        return "utilities";
    }
}
