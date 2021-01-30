package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;

/**
 * @author JEDI01
 *
 */

public class CRSStudentClient {

	/**
	 * Logger
	 */
	public static Logger logger = Logger.getLogger(CRSStudentClient.class);
	
	/**
	 * Scanner
	 */
	Scanner sc = new Scanner(System.in);

	/**
	 * Business Objects
	 */
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	 	
	/**
	 * @param studentId
	 * Functionalities of the Student
	 */
	public void displayMenu(int studentId) {
		int choice;
		do {
			printChoices();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				courseCatalogBusinessObject.viewAllCourses();
				break;
			case 2:
				logger.info("Select from available pool of courses");
				courseCatalogBusinessObject.viewAllCourses();
				registerCourse(studentId);
				break;
			case 3:
				logger.info("Select from registered courses");
				viewRegisteredCourses(studentId);
				dropCourse(studentId);
				break;
			case 4:
				viewRegisteredCourses(studentId);
				break;
			case 5:
				payFees(studentId);
				break;
			case 6:
				printReportCard(studentId);
				break;
			case 0:
				break;
			default:
				logger.info("Invalid Choice./nTry Again\n");
				break;
			}
		}while(choice!=0);
		
	}
	
	/**
	 * Display Available Features
	 */
	void printChoices() {
		logger.info("==========================STUDENT==========================");
		logger.info("Enter your choice:");
		logger.info("1. To view available courses");
		logger.info("2. To register a course");
		logger.info("3. To drop a course");
		logger.info("4. View registered courses");
		logger.info("5. Pay fees");
		logger.info("6. Print Report Card");
		logger.info("0. To logout");
		logger.info("===========================================================");
	}
	
	/**
	 * @param studentId
	 * Register Student for the course
	 */
	public void registerCourse(int studentId) {
		// Check if maximum limit is reached
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
			}
			// Check if there is availability in the course
			else if(courseCatalogBusinessObject.numberOfRegisterdStudents(courseId)==10) {
				logger.info("==============MAXIMUM STUDENT LIMIT REACHED==============");
				logger.info("10 Students already Registerd for the course so you can't register");
			} else {
				studentBusinessObject.registerCourse(studentId, courseId);
			}
		}
	}
	
	/**
	 * @param studentId
	 * Drop from the course 
	 */
	public void dropCourse(int studentId) {
		logger.info("Enter the course ID");
		int courseId = sc.nextInt();
		if(studentBusinessObject.checkValidCourseForStudent(studentId, courseId)) {
			studentBusinessObject.dropCourse(studentId, courseId);
		} else {
			logger.info("======================NOT REGISTERED======================");
			logger.info("You were not registered for this course");
		}
	}
	
	/**
	 * @param studentId
	 * Check courses student already registered
	 */
	public void viewRegisteredCourses(int studentId) {
		studentBusinessObject.viewRegisteredCourses(studentId);
	}
	
	/**
	 * @param studentId
	 * Pay Remaining Fees
	 */
	public void payFees(int studentId) {
		double fees = studentBusinessObject.getFees(studentId);
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
	
	/**
	 * @param studentId
	 * Print Report Card
	 */
	public void printReportCard(int studentId) {
		logger.info("=======================REPORT CARD=======================");
		studentBusinessObject.printReportCard(studentId);
	}
}
