package com.example.lalit.dao;

import com.example.lalit.entity.Course;
import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    public void save(Instructor instructorObj);
    public Instructor findInstructorById(int id);
    public void deleteInstructorById(int id) ;
    public InstructorDetail  findInstructorDetailById(int id);
    public void deleteInstructorDetailsById (int id) ;
    public List<Course> findCoursesByInstructorId(int id);
    public Instructor findInstructorByIdJoinFetch(int id) ;
}