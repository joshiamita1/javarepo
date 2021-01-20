package com.flipkart.bean;

import java.util.ArrayList;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class Student extends User {
	String StudentId;
	String branch;
	ArrayList<Course> coursesRegistered;
	public Student(String userId, String emailId, String name, long mobile, Role role, Gender gender, String studentId,
			String branch, ArrayList<Course> coursesRegistered) {
		super(userId, emailId, name, mobile, role, gender);
		StudentId = studentId;
		this.branch = branch;
		this.coursesRegistered = coursesRegistered;
	}
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
