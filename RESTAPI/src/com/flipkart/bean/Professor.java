package com.flipkart.bean;

import com.flipkart.constant.Department;


/**
 * @author JEDI01
 *
 */
public class Professor extends User {
	
	// Department of the professor
	private Department department;
	
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
