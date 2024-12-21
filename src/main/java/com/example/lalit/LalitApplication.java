package com.example.lalit;

import com.example.lalit.dao.AppDao;
import com.example.lalit.entity.Course;
import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;
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
			// createInstructorWithCourses(appDao);
			//findInstructorWithCourses(appDao) ;
			//findCoursesForInstructor(appDao) ;
			findInstructorByIdJoinFetch(appDao);
					};
	}

	private void findInstructorByIdJoinFetch(AppDao appDao) {
		int id=1;
		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(id);
		System.out.println("tempInstructor : " + tempInstructor + " , " +tempInstructor.getCourses());


	}

	private void findCoursesForInstructor(AppDao appDao) {
		int id=1;
		Instructor tempInstructor = appDao.findInstructorById(id);
		System.out.println("tempInstructor : " + tempInstructor );
		List<Course> courses = appDao.findCoursesByInstructorId(id);
		tempInstructor.setCourses(courses);
		// for getting the tempinstructor courses there should be firt setcourses
		System.out.println("tempInstructor courses : " + tempInstructor.getCourses() );

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

