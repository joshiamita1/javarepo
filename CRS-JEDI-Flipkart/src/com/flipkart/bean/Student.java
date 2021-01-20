package com.flipkart.bean;

import java.util.ArrayList;

public class Student extends User {
	String StudentId;
	String branch;
	ArrayList<Course> coursesRegistered;
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public ArrayList<Course> getCoursesRegistered() {
		return coursesRegistered;
	}
	public void setCoursesRegistered(ArrayList<Course> coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}
	
	
}
