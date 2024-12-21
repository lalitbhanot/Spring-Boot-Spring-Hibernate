package com.example.lalit;

import com.example.lalit.dao.AppDao;
import com.example.lalit.entity.Course;
import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LalitApplication {

	public static void main(String[] args) {
		SpringApplication.run(LalitApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (AppDao appDao)
	{
		return  runner ->{
			 createInstructorWithCourses(appDao);
					};
	}

	private void createInstructorWithCourses(AppDao appDao) {
			// create the instructor
			Instructor tempInstructor = new Instructor("lalit1","bhanot1","email1@gmail.com") ;
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtubechannel1","somehobby1") ;

			// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Course
		Course tempCourse = new Course("New Courses for saving");
		tempInstructor.add(tempCourse);
			// save the instructor
			appDao.save(tempInstructor);
		}

	}

