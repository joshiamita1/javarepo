package com.flipkart.bean;

import java.util.ArrayList;
import com.flipkart.constant.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Course {
	String courseCode;
	String courseName;
	Map<Student, Grade> studentsGrades;
	Professor professor;	
	public Course(String courseCode, String courseName, Professor professor) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.studentsGrades = new TreeMap<Student, Grade>();
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
	public Map<Student, Grade> getStudentsGrades() {
		return studentsGrades;
	}
	/**
	 * @param studentsGrades the studentsGrades to set
	 */
	public void setStudentsGrades(Map<Student, Grade> studentsGrades) {
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
