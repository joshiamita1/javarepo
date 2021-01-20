package com.flipkart.bean;

public class Professor extends User {
	String department;
	Course courselist[];
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Course[] getCourselist() {
		return courselist;
	}
	public void setCourselist(Course[] courselist) {
		this.courselist = courselist;
	}

}
