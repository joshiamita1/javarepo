package com.flipkart.bean;

import com.flipkart.constant.*;
import java.util.Map;
import java.util.TreeMap;

public class Course {
	// Course code
	String courseCode;
	
	// Course name
	String courseName;
	
	// Grades of the students enrolled in the course
	Map<String, Grade> studentsGrades;
	
	// Professor of the course
	Professor professor;
	public Course(String courseCode, String courseName, Professor professor) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.studentsGrades = new TreeMap<String, Grade>();
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
	 * @return the studentsGrades
	 */
	public Map<String, Grade> getStudentsGrades() {
		return studentsGrades;
	}
	/**
	 * @param studentsGrades the studentsGrades to set
	 */
	public void setStudentsGrades(Map<String, Grade> studentsGrades) {
		this.studentsGrades = studentsGrades;
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
