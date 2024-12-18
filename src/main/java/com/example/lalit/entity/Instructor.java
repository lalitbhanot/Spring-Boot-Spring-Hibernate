package com.example.lalit.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "email")
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetailId; // see line number 30 in InstructorDetail for the
													// @OneToOne(mappedBy="instructorDetailId"
	// fetch type is EAGER so that the when parent is called then the child objects are also called for .
	/*
	 * @OneToMany( fetch=FetchType.EAGER, mappedBy = "instructor", cascade = {
	 * CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	 * CascadeType.REFRESH })
	 */
	@OneToMany( fetch=FetchType.LAZY, mappedBy = "instructor", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<Course> courses;

	public Instructor() {

	}

	public Instructor(String first_name, String last_name, String email) {

		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetailId() {
		return instructorDetailId;
	}

	public void setInstructorDetailId(InstructorDetail instructorDetailId) {
		this.instructorDetailId = instructorDetailId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	// adding  convenience method for bi directinal relationship 
	public void add(Course tempCourse) {
		if (courses == null) 
		{
			courses= new ArrayList<>();
		}
		
		courses.add(tempCourse) ;
		tempCourse.setInstructor(this);
		
	}
	
	
	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", instructor_detail_id=" + instructorDetailId + "]";
	}

}
