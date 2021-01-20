package com.flipkart.dao;

import com.flipkart.bean.*;
public interface CourseCatalogDao {
	public void addCourse(Course course);
	public void deleteCourse(String courseCode);
	public void modifyCourse(String courseCode, Course course);
	public Course getCourse(String courseCode);
	public void assignProfessor(String courseCode, Professor professor);
	public void addRegisteredStudent(String courseCode, Student student);
}
