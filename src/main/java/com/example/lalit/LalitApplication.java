package com.example.lalit;

import com.example.lalit.dao.AppDao;
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
		// createInstructor(appDao);
		//findInstructor(appDao) ;
		// deleteInstructor(appDao) ;
		 findInstructorDetails(appDao);
	};
}

	private void findInstructorDetails(AppDao appDao) {
	}

	private void createInstructor(AppDao appDao) {
		// create the instructor
		Instructor tempInstructor = new Instructor("lalit","bhanot","email@gmail.com") ;
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtubechannel","somehobby") ;

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		appDao.save(tempInstructor);
	}

	private void findInstructor(AppDao appDao)
	{
		int id = 1;
		Instructor tempInstructor = appDao.findInstructorById(id);
		System.out.println("tempInstructor : " + tempInstructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDao appDao)
	{
		int id = 1 ;
		appDao.deleteInstructorById(id);

	}
}