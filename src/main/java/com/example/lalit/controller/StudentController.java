package com.example.lalit.controller;

import com.example.lalit.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api")
@RestController
public class StudentController {

    List<Student> students ;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("stu1","stu1"));
        students.add(new Student("stu2","stu2"));
        students.add(new Student("stu3","stu3"));

    }


    @GetMapping("/students")
    public List<Student> getStudent() {

        return students ;
    }

    @GetMapping("/studentById/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("stu1","stu1"));
        students.add(new Student("stu2","stu2"));
        students.add(new Student("stu3","stu3"));
        return students.get(studentId) ;
    }

}
