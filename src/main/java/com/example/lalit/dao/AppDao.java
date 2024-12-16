package com.example.lalit.dao;

import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;

public interface AppDao {

    public void save(Instructor instructorObj);
    public Instructor findInstructorById(int id);
    public void deleteInstructorById(int id) ;
    InstructorDetail findInstructorDetailById(int id);
}