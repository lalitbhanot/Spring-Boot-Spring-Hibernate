package com.example.lalit.rest;

import java.util.ArrayList;
import java.util.List;


import com.example.lalit.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("stu1", "stu1"));
		students.add(new Student("stu2", "stu2"));
		students.add(new Student("stu3", "stu3"));

	}

	@GetMapping("/students")
	public List<Student> getStudent() {

		return students;
	}

	@GetMapping("/studentById/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student Id not found :" + studentId);

		}
		return students.get(studentId);
	}
}
