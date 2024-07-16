package com.lab4.lab4;

import com.lab4.lab4.bean.Student;
import com.lab4.lab4.bean.StudentMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    StudentDao dao;

    @RequestMapping("/student/index")
    public String index(Model model) {
        Student student = new Student("", "", 0.0, true, "VN");
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(@PathVariable String key, Model model) {
        model.addAttribute("key", key);
        Student student = dao.findByKey(key);
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }

    @RequestMapping("/student/create")
    public String create(Student student) {
        dao.create(student);
        return "redirect:/student/index";
    }

    @RequestMapping("/student/update/{key}")
    public String update(Student student, @PathVariable String key, Model model) {
        dao.update(key, student);
        return "redirect:/student/edit/" + key;
    }

    @RequestMapping("/student/delete/{key}")
    public String delete(@PathVariable String key) {
        dao.delete(key);
        return "redirect:/student/index";
    }

}
