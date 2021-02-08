
package com.flipkart.validation;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.business.AuthenticateBusiness;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.constant.Department;

public class Validate {

	Scanner sc = new Scanner(System.in);
	private static Logger logger = Logger.getLogger( Validate .class);
	AuthenticateBusiness authenticateBusinessObject = AuthenticateBusiness.getInstance();
	ProfessorBusiness professorBusinessObject = ProfessorBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	
	/**
	 * Validate Admin
	 * @param user
	 * @param password
	 * @returnType void
	 */
	
public void validateRegisterCourse(int studentId) {
		
		if(studentBusinessObject.numberOfRegisteredCourses(studentId)==4) {
			logger.info("=========MAXIMUM COURSE REGISTRATION LIMIT REACHED=========");
			logger.info("You cannot add courses as you have already selected 4 courses");
		} else{
			logger.info("Enter course id");
			int courseId = sc.nextInt();
			// Check if student is already registered for the course
			if(studentBusinessObject.checkValidCourseForStudent(studentId, courseId)) {
				logger.info("====================ALREADY REGISTERED====================");
				logger.info("You are already Registered for this course");
			}// Check if there is availability in the course
			else if(courseCatalogBusinessObject.numberOfRegisterdStudents(courseId)==10) {
				logger.info("==============MAXIMUM STUDENT LIMIT REACHED==============");
				logger.info("10 Students already Registerd for the course so you can't register");
			} else {
				studentBusinessObject.registerCourse(studentId, courseId);
			}
		}
	}

	
	/**
	 * Validate if Professor teaches a course
	 * @param professorId
	 * @param courseId
	 * @returnType void
	 */
	public void validateProfCourse(int professorId, int courseId) {
		if(professorBusinessObject.validCourseForProfessor(professorId, courseId)) {
			professorBusinessObject.viewRegisteredStudents(courseId);
		} else {
			logger.info("This Course is not taught by you!");
		}
	}
	
	/**
	 * Validate the registration of a course for a student
	 * @param studentId
	 * @returnType void
	 */
	
	
	/**
	 * Validate dropping of a course by a student
	 * @param studentId
	 * @param courseId
	 * @returnType void
	 */
	public void validateDropCourse(int studentId, int courseId) {
		if(studentBusinessObject.checkValidCourseForStudent(studentId, courseId)) {
			studentBusinessObject.dropCourse(studentId, courseId);
		} else {
			logger.info("======================NOT REGISTERED======================");
			logger.info("You were not registered for this course");
		}
	}
	
	/**
	 * Validate fee payment process
	 * @param studentId
	 * @param fees
	 * @returnType void
	 */
	public void validateFee(int studentId, double fees) {
		if(fees==0) {
			logger.info("No dues pending!");
		}
		else{
			logger.info("Pending Fees = " + fees + "INR-/ only!");
			logger.info("Please Choose Mode of the Payment\n1. To pay with Credit Card\n2. To pay using cash \n3. To pay using Net Banking");
			int choice = sc.nextInt();
			if(choice>=1 && choice <= 3) {
				studentBusinessObject.makePayment(studentId, fees, choice);
			} else {
				logger.info("Invalid Mode.\nTranscation Terminated.");
			}
		}
	}
	
}