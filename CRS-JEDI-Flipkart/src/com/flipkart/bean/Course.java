package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Course {
	String courseCode;
	String courseName;
	List<Student> studentsRegistered;
	Professor professor;	
	public Course(String courseCode, String courseName, List<Student> studentsRegistered, Professor professor) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.studentsRegistered = new ArrayList<Student>();
		this.professor = professor;
	}
	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * @return the studentsRegistered
	 */
	public List<Student> getStudentsRegistered() {
		return studentsRegistered;
	}
	/**
	 * @param studentsRegistered the studentsRegistered to set
	 */
	public void setStudentsRegistered(List<Student> studentsRegistered) {
		this.studentsRegistered = studentsRegistered;
	}
	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}
	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
