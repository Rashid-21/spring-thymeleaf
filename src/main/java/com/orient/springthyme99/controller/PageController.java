package com.orient.springthyme99.controller;

import com.orient.springthyme99.entity.Student;
import com.orient.springthyme99.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class PageController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String home() {

        return "index";
    }

    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "students";
    }

    @GetMapping("/create")
    public String create(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) {
        studentRepository.save(student);

        return "redirect:/students";
    }


    @GetMapping("/delete")
    public String delete(@ModelAttribute("students") Student student) {
        studentRepository.delete(student);

        return "delete";
    }

    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("students") Student student) {

        studentRepository.delete(student);

        return "redirect:/students";

    }


}

