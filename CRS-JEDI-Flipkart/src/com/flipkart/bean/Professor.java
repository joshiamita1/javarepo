package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Professor extends User {
	String department;
	List<Course> courselist;
	public Professor(String userId, String emailId, String name, long mobile, Role role, Gender gender,
			String department) {
		super(userId, emailId, name, mobile, role, gender);
		this.department = department;
		this.courselist = new ArrayList<Course>();
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the courselist
	 */
	public List<Course> getCourselist() {
		return courselist;
	}
	/**
	 * @param courselist the courselist to set
	 */
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	
}
