package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;
import com.flipkart.bean.*;
import com.flipkart.constant.Grade;

/**
 * @author Aditya Nahata
 *
 */
public interface StudentDao {

	/**
	 * Add Student
	 * @param student
	 * @returnType void
	 */
	public void addStudent(Student student, String password);
	
	/**
	 * Modify a given student details
	 * @param studentId
	 * @param student
	 * @returnType void
	 */
	public void modifyStudent(int studentId, Student student);
	
	/**
	 * Get Student from his id
	 * @param studentId
	 * @returnType Student
	 */
	public Student getStudent(int studentId);
	
	/**
	 * Add Grade for a given student in a course
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @returnType void
	 */
	public void addGrade(int studentId, int courseCode, Grade grade);
	
	/**
	 * Register a student to a Course
	 * @param studentId
	 * @param courseId
	 * @returnType void
	 */
	public void registerCourse(int studentId, int courseId);
	
	/**
	 * Drop a course for a student 
	 * @param studentId
	 * @param courseId
	 * @returnType void
	 */
	public void dropCourse(int studentId, int courseId);
	
	/**
	 * View Registered Courses of a student
	 * @param studentId
	 * @returnType ArrayList<Integer>
	 */
	public ArrayList<Integer> viewRegisteredCourses(int studentId);
	
	/**
	 * View all grades of a student
	 * @param studentId
	 * @returnType Map<String,Grade>
	 */
	public Map<Integer, Grade> viewGrades(int studentId);
	
	/**
	 * check if student has scholarship from database
	 * @param studentId
	 * @return boolena
	 */
	public boolean hasScholarship(int studentId);
	
	
	/**
	 * Set approved student to true
	 * @param studentId
	 * @param studentId
	 */
	public void approveStudent(int studentId);


	/**
	 *
	 * @param studentId
	 */
	public void deleteStudent(int studentId);


	/**
	 *
	 * @return unapproved student array list
	 */
	public ArrayList<Integer> viewUnapprovedStudents();
}