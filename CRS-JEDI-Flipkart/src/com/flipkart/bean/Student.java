package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User {
	// Branch of the student
	private String branch;
	
	// List of course codes student registered
	private List<String> coursesRegistered;
	
	// Scholarship is provided or not
	boolean hasScholarship;
	
	// Parameterized Constructor
	public Student(String userId, String emailId, String name, long mobile, Role role, Gender gender, String studentId,
			String branch, boolean hasScholarship) {
		super(userId, emailId, name, mobile, role, gender);
		this.branch = branch;
		this.hasScholarship = hasScholarship;
		this.coursesRegistered = new ArrayList<String>();
		
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the coursesRegistered
	 */
	public List<String> getCoursesRegistered() {
		return coursesRegistered;
	}

	/**
	 * @param coursesRegistered the coursesRegistered to set
	 */
	public void setCoursesRegistered(List<String> coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}

	/**
	 * @return the hasScholarship
	 */
	public boolean isHasScholarship() {
		return hasScholarship;
	}

	/**
	 * @param hasScholarship the hasScholarship to set
	 */
	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}
		
}
