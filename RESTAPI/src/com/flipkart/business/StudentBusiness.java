package com.flipkart.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.flipkart.constant.PaymentMode;
import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.GlobalConstants;
import com.flipkart.constant.Grade;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.FeePaymentDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;


/**
 * @author JEDI01
 *
 */
/**
 * @author lovis
 *
 */
/**
 * @author lovis
 *
 */
/**
 * @author lovis
 *
 */
/**
 * @author lovis
 *
 */
public class StudentBusiness{
	
	/**
	 * Singleton Field
	 */
	private static StudentBusiness instance = null;
	
	/**
	 * Dao Objects
	 */
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();
	FeePaymentDaoImpl feePaymentDaoObject = FeePaymentDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(StudentBusiness.class);
	
	
	/**
	 * Private Constructor
	 */
	private StudentBusiness() {
		
	}
	
	/**
	 * @return Instance of the class
	 */
	public static StudentBusiness getInstance() {
		if(instance==null) {
			instance = new StudentBusiness();
		}
		return instance;
	}
	
	/**
	 * @param studentId
	 */
	public ArrayList<Course> viewRegisteredCourses(int studentId) {
		ArrayList<Integer> courseList = studentDaoObject.viewRegisteredCourses(studentId);
		ArrayList<Course> courseListdetails= new ArrayList<Course>();
		if(courseList.size() == 0) {
			logger.info("No registered courses");
		}
		else {
			logger.info(String.format("%20s %20s","Course Id","Course Name"));
			for(Integer course : courseList) {
				Course c = courseCatalogDaoObject.getCourse(course);
				logger.info(String.format("%20s %20s",c.getCourseCode() , c.getCourseName()));
				courseListdetails.add(c);
			}
		}
		return courseListdetails;
		
	}
	
	/**
	 * @param studentId
	 * @param courseId
	 */
	public void registerCourse(int studentId, int courseId) {
		//Check can be added to validation package
		if(studentDaoObject.getStudent(studentId).isApproved()) {
			studentDaoObject.registerCourse(studentId, courseId);
			logger.info("Added Course " + courseCatalogDaoObject.getCourse(courseId).getCourseName() + " in " + studentDaoObject.getStudent(studentId).getName() + "'s Syllabus");
			double addFees = GlobalConstants.feesOfSingleCourse;
			if (studentDaoObject.hasScholarship(studentId)) {
				addFees /= 10;
				addFees *= 7;
			}
			feePaymentDaoObject.updateFees(studentId, feePaymentDaoObject.amountPayable(studentId) + addFees);
		}
		else
		{
			logger.info("You are not approved, Get Approval from Admin to register ");
		}
	}
	
	
	/**
	 * @param studentId
	 * @param courseId
	 */
	public void dropCourse(int studentId, int courseId) {
		studentDaoObject.dropCourse(studentId, courseId);
		logger.info("Removed Course " + courseCatalogDaoObject.getCourse(courseId).getCourseName() + " from " + studentDaoObject.getStudent(studentId).getName() + "'s Syllabus");
		double addFees = -1 * GlobalConstants.feesOfSingleCourse;
		if(studentDaoObject.hasScholarship(studentId)) {
			addFees /= 10;
			addFees *=7;
		}
		feePaymentDaoObject.updateFees(studentId, feePaymentDaoObject.amountPayable(studentId) + addFees);
	}
	
	/**
	 * @param studentId
	 */
	public Map<String,Grade> printReportCard(int studentId) {
		Student s = studentDaoObject.getStudent(studentId);
		Map<String,Grade> gradeslist= new HashMap<String, Grade>();
		logger.info("Student ID : "+ s.getUserId()+"Student Name : " + s.getName() + "\nBranch : " + s.getBranch() + "\nEmail : " + s.getEmailId() + "\nGender : " + s.getGender() + "\nMobile :" + s.getMobile() + "\n");
		Map<Integer, Grade> grades = studentDaoObject.viewGrades(studentId);
		logger.info("Grades of " + s.getName() + ":");
		for(Map.Entry<Integer, Grade> entry : grades.entrySet()) {
			Course c =courseCatalogDaoObject.getCourse(entry.getKey());
			logger.info(c.getCourseName() + " : " + entry.getValue());
			gradeslist.put(c.getCourseName(), entry.getValue());
		}
		logger.info("\n\nReport Card Sent to :" + s.getEmailId());
		return gradeslist;
	}
	
	/**
	 * @param studentId
	 * @param courseId
	 * @return if student is enrolled in the given course
	 */
	public boolean checkValidCourseForStudent(int studentId, int courseId) {
		return courseCatalogDaoObject.validCourseForStudent(studentId, courseId);
	}
	
	/**
	 * @param studentId
	 * @return the number of Enrolled Courses
	 */
	public int numberOfRegisteredCourses(int studentId) {
		return courseCatalogDaoObject.numberOfRegisteredCourses(studentId);
	}
	
	/**
	 * @param studentId
	 * @return Due Fees for given student
	 */
	public double getFees(int studentId) {
		return feePaymentDaoObject.amountPayable(studentId);
	}
	
	/**
	 * @param studentId
	 * @param fees
	 * @param choice
	 * Make Payment and update payment
	 */
	public void makePayment(int studentId, double fees, int choice) {
		
		//TodO
		feePaymentDaoObject.PayFees(studentId, fees, PaymentMode.values()[choice-1]);
		feePaymentDaoObject.updateFees(studentId, 0);
		notificationSystemDaoObject.notifyUser(studentId, "Fees of " + fees + " Paid Successfully!");
		
	}
}