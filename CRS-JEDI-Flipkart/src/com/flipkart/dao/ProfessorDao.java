package com.flipkart.dao;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Course;
public interface ProfessorDao {
	public void addProfessor(Professor professor);
	public void addCourse(Professor professor, Course course);
}
