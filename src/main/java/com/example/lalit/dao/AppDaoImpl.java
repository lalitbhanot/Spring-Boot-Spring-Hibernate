package com.example.lalit.dao;

import com.example.lalit.entity.Course;
import com.example.lalit.entity.Instructor;
import com.example.lalit.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    @Transactional
    public void  deleteInstructorDetailsById(int id) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,id);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);
        query.setParameter("data",id) ;
        return query.getResultList() ;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " + "JOIN FETCH i.courses where i.id = :data",Instructor.class);
        query.setParameter("data",id)   ;
        return query.getSingleResult();
    }


}