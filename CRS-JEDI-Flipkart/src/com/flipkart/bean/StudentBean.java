package com.flipkart.bean;

public class StudentBean extends User {
	String StudentID;
	String branch;
	RegisteredCoursesbean courselist;
	
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public RegisteredCoursesbean getCourselist() {
		return courselist;
	}
	public void setCourselist(RegisteredCoursesbean courselist) {
		this.courselist = courselist;
	}
	
	

}
