package com.flipkart.bean;

public class ProfessorBean extends User {
	String department;
	CourseBean courselist[];
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public CourseBean[] getCourselist() {
		return courselist;
	}
	public void setCourselist(CourseBean[] courselist) {
		this.courselist = courselist;
	}

}
