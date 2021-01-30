  
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;



/**
 * @author JEDI01
 *
 */

public class ProfessorBusiness {
	
	/**
	 * Singleton Field
	 */
	private static ProfessorBusiness instance = null;
	
	
	/**
	 * Dao Objects
	 */
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(ProfessorBusiness.class);
	
	// Private Constructor
	private ProfessorBusiness() {
		
	}
	
	/**
	 * @return Instance of the class
	 */
	public static ProfessorBusiness getInstance() {
		if(instance==null) {
			instance = new ProfessorBusiness();
		}
		return instance;
	}
	
	
	/**
	 * @param courseId
	 * @param studentId
	 * @param grade
	 */
	public void gradeStudent(int courseId, int studentId, Grade grade) {
		studentDaoObject.addGrade(studentId, courseId, grade);
		logger.info("Added Grade " + grade);
		logger.info("Student :" + studentId);
		logger.info("Course Id : " + courseId);
		logger.info("======================STUDENT GRADED======================");
	}
	
	
	/**
	 * @param professorId
	 * @param courseId
	 * @return if given professor teaches the given course
	 */
	public boolean validCourseForProfessor(int professorId, int courseId) {
		
		return courseCatalogDaoObject.validCourseForProfessor(professorId, courseId);
	}
	
	
	/**
	 * @param professorId
	 * @return 
	 */
	public ArrayList<Course> viewAssignedCourses(int professorId) {
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCoursesForProfessor(professorId);
		ArrayList<Course> courseListdetails= new ArrayList<Course>();
		logger.info(String.format("%20s %20s","Course Id","Course Name"));
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(String.format("%20s %20s",course.getCourseCode() , course.getCourseName()));
			courseListdetails.add(course);
		}
		return courseListdetails;
		
	}
	
	
	/**
	 * @param courseId
	 * @return 
	 */
	public List<Student> viewRegisteredStudents(int courseId) {
     //  View all the RegisteredStudent in course
		Map<Integer, Grade> mp = courseCatalogDaoObject.viewGrades(courseId);
		List<Student> studentlist = new ArrayList<Student>();
		//logger.info(String.format("%20s %20s","Registered Students under \" + professorDaoObject.getProfessor(courseCatalogDaoObject.getCourse(courseId).getProfessorId()).getName()",));
		logger.info("Registered Students under " + professorDaoObject.getProfessor(courseCatalogDaoObject.getCourse(courseId).getProfessorId()).getName() + " for course " +  courseCatalogDaoObject.getCourse(courseId).getCourseName() + " are :");
		logger.info(String.format("%20s %20s","Student ID :","Student Name"));
		//can remove call to dao by using s directly
		for(Integer s : mp.keySet()) {
			Student temp= studentDaoObject.getStudent(s);
			studentlist.add(temp);
			logger.info(String.format("%20s %20s", temp.getUserId(),temp.getName() ));
		}
		return studentlist;
	}  
}
