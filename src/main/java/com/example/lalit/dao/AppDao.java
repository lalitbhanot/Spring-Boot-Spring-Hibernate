package com.example.lalit.dao;

import com.example.lalit.entity.Course;
import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;
import com.example.lalit.entity.Student;

import java.util.List;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);
    Student findStudentAndCourseByStudentId(int theId) ;

}
