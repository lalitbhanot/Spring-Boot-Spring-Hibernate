package com.example.lalit;

import com.example.lalit.dao.AppDao;
import com.example.lalit.entity.Course;
import com.example.lalit.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LalitApplication {

	public static void main(String[] args) {
		SpringApplication.run(LalitApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (AppDao appDao)
	{
		return  runner ->{
createCourseAndStudents(appDao) ;
					};
	}

	private void createCourseAndStudents(AppDao appDao) {

		// create a course
Course tempCourse = new Course("nw course") ;
		// create a student
Student tempStudent1 = new Student("newStuFname","newStulName","email.com");
Student tempStudent2  = new Student("newStuFname2","newStulName2","email.com2");
		// add student to cousrse
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		//save the course
		appDao.save(tempCourse);
	}


}

