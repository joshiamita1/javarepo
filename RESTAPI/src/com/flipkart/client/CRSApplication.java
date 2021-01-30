package com.flipkart.client;

import com.flipkart.exception.InvalidLoginException;
import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;
import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.bean.Student;
import com.flipkart.business.*;
import com.flipkart.constant.Role;
import com.flipkart.dao.UserDaoImpl;
import java.util.*;


/**
 * @author JEDI01
 *
 */
public class CRSApplication {
	
	/**
	 * Logger Object
	 */
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	
	/**
	 * Scanner Object
	 */
	static Scanner sc = new Scanner(System.in);
		
	/**
	 * Professor Client Menu Object
	 */
	CRSProfessorClient CRSProfessorClient = new CRSProfessorClient();
	
	/**
	 * Student Client Menu Object
	 */
	CRSStudentClient studentClient = new CRSStudentClient();
	
	/**
	 * Admin Client Menu Object
	 */
	CRSAdminClient CRSAdminClient = new CRSAdminClient();
	
	
	/**
	 * Authenticate Business Object
	 */
	AuthenticateBusiness authenticateBusinessObject = AuthenticateBusiness.getInstance();
	
	
	/**
	 * @param args
	 * Main Enter Point of the Application
	 */
	public static void main(String[]args) throws UserNotFoundException, InvalidLoginException {
		logger.info("================COURSE REGISTRATION SYSTEM================");
		logger.info("Welcome to the Course Registration System");
		
		// Displaying Login Portal
		showUserMenu();
		
		logger.info("========================EXITING CRS=======================");		
	}
	
	/**
	 * Display Login Portal
	 */
	public static void showUserMenu() throws UserNotFoundException, InvalidLoginException {
		boolean showMenu=true;
		int choice;
		do {
			logger.info("===========================USER===========================");
			logger.info("Enter 1 to Login");
			logger.info("Enter 2  to Register (if you are student)");
			logger.info("Enter any other number to exit CRS");
			logger.info("==========================================================");
			//char c =sc.next()

				choice = Integer.parseInt(sc.nextLine());


				switch(choice) {
				case 1:
					new CRSApplication().getInputLogin();
					break;
				case 2:
					new CRSApplication().getInputRegister();
					break;
				default:
					showMenu = false;
					logger.error("========================EXITING CRS=======================");
					break;
			}
		}while(showMenu);
		
	}
	
	/**
	 * Taking input for login
	 */
	public void getInputLogin() throws UserNotFoundException, InvalidLoginException {
		logger.info("Enter User Id");
		int userId = Integer.parseInt(sc.nextLine());
		logger.info("Enter User Password");
		String password = sc.nextLine();
		login(userId, password);
	}
	
	/**
	 * @param userId
	 * @param password
	 * Logging in
	 */
	public void login(int userId, String password) throws UserNotFoundException, InvalidLoginException {
		if(authenticateBusinessObject.validLogin(userId, password)) {
			Role role = authenticateBusinessObject.getRole(userId, password);
			logger.info("Welcome User ID : " + userId );
			switch(role) {
			case ADMIN :
				logger.info("Successfully Logged in as Admin");
				CRSAdminClient.displayMenu(userId);
				break;
			case PROFESSOR:
				logger.info("Successfully Logged in as Professor");
				CRSProfessorClient.displayMenu(userId);
				break;
			case STUDENT:
				logger.info("Successfully Logged in as Student");
				studentClient.displayMenu(userId);
				break;
			}
		}
		else {
			logger.info("Invalid Credentials");
		}
	}

	/**
	 * Taking input for registering
	 */
	void getInputRegister() throws UserNotFoundException, InvalidLoginException {
		Student student = new Student();
		String password;
		student.setRole(Role.STUDENT);
		student.setUserId(101);
		logger.info("Enter Name");
		student.setName(sc.nextLine());
		logger.info("Enter Password");
		password = sc.nextLine();
		logger.info("Enter Email");
		student.setEmailId(sc.nextLine());
		logger.info("Enter Mobile No.");
		student.setMobile(sc.nextLong());
		sc.nextLine();
		logger.info("Enter Branch \n(Civil, Chem, CS, EEE, Mech, ECE):");
		student.setBranch(Department.valueOf(sc.nextLine()));
		logger.info("Select Gender: \n'M' for male and 'F' for female");
		student.setGender(Gender.valueOf(sc.nextLine()));
		logger.info("If you have scholarship enter 1, else enter 0");
		int scholarShip = Integer.parseInt(sc.nextLine());
		if(scholarShip == 1) student.setHasScholarship(true);
		else student.setHasScholarship(true);
		logger.info("Enter Address");
		student.setAddress(sc.nextLine());
		logger.info("Enter City");
		student.setCity(sc.nextLine());
		logger.info("Enter State");
		student.setState(sc.nextLine());
		logger.info("Enter Country");
		student.setCountry(sc.nextLine());
		student.setAmountPayable(0);
		
		
		
		if(authenticateBusinessObject.registerStudent(student, password)) {
			UserDaoImpl temp =  UserDaoImpl.getInstance();
			int userid=temp.lastEntry();
			student.setUserId(userid);
			logger.info("=======================REGISTERED=======================");
			logger.info("Successfully Registered! Your user id is " + student.getUserId() + ".\nLogging You In");
			login(student.getUserId(), password);
		} else {
			logger.info("Please Register Again!\nRegistration Failed\n");
		}

	}


}