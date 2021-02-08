package com.flipkart.bean;



public class CourseBean {
	String courseCode;
	String courseName;
	StudentBean studentlist[];
	ProfessorBean professordetail;
	int  courseStrength;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public StudentBean[] getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(StudentBean[] studentlist) {
		this.studentlist = studentlist;
	}
	public ProfessorBean getProfessor() {
		return professordetail;
	}
	public void setProfessor(ProfessorBean professor) {
		this.professordetail = professor;
	}
	public int getCourseStrength() {
		return courseStrength;
	}
	public void setCourseStrength(int courseStrength) {
		this.courseStrength = courseStrength;
	}
}
