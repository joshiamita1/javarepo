  
package com.flipkart.dao;

import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;

import java.util.List;

public interface ProfessorDao {

	

	/**
	 * Add a professor to the list of existing professors
	 * @param professor
	 * @returnType void
	 */
	public void addProfessor(User user, String password, Department department);
	
	/**
	 * Delete a professor
	 * @param professorId
	 * @returnType void
	 */
	public void deleteProfessor(int professorId);
	
	/**
	 * Get list of all professors
	 * @return
	 * @returnType List<String>
	 */
	public List<Integer> getProfessors();
	
	/**
	 * get details of a particular professor from the id
	 * @param professorId
	 * @return
	 * @returnType Professor
	 */
	public Professor getProfessor(int professorId);


	

}