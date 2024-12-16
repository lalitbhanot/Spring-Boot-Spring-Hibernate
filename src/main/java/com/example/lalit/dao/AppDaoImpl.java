package com.example.lalit.dao;

import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements  AppDao{


    // define field for entity manager
    private EntityManager entityManager ;

    //constrcutor injection
    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save (Instructor instructorObj) {
        entityManager.persist(instructorObj);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Transactional
    public void deleteInstructorById (int id){
        Instructor tempInstructor = entityManager.find(Instructor.class,id) ;
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }


}
