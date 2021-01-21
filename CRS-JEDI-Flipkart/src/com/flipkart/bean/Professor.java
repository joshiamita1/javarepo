package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Professor extends User {
	// Department of the professor
	private String department;
	
	// List of course codes professor is teaching
	private List<String> coursesList;
	public Professor(String userId, String emailId, String name, long mobile, Role role, Gender gender,
			String department) {
		super(userId, emailId, name, mobile, role, gender);
		this.department = department;
		this.coursesList = new ArrayList<String>();
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the coursesList
	 */
	public List<String> getCoursesList() {
		return coursesList;
	}
	/**
	 * @param coursesList the coursesList to set
	 */
	public void setCoursesList(List<String> coursesList) {
		this.coursesList = coursesList;
	}
	
		
}
