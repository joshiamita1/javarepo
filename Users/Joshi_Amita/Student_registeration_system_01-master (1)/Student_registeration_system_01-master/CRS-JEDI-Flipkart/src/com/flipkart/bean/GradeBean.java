package com.flipkart.bean;

public class GradeBean {
	CourseBean coursedetailCourse;
	StudentBean studentdetail;
	char grade;
	public CourseBean getCoursedetailCourse() {
		return coursedetailCourse;
	}
	public void setCoursedetailCourse(CourseBean coursedetailCourse) {
		this.coursedetailCourse = coursedetailCourse;
	}
	public StudentBean getStudentdetail() {
		return studentdetail;
	}
	public void setStudentdetail(StudentBean studentdetail) {
		this.studentdetail = studentdetail;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
}
