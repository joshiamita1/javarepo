package com.flipkart.dao;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Course;
public interface ProfessorDao {
	public void addProfessor(Professor professor);
	public void addCourse(String professorId, Course course);
	public Professor getProfessorDetails(String uName);
	public void deleteProfessor(String professorId);
	public boolean checkCredentials(String uName,String password);
}
