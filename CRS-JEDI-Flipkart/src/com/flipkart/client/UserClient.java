package com.flipkart.client;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;

import java.util.*;
public class UserClient {
	
	private static Logger logger = Logger.getLogger(UserClient.class);
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
		logger.info("Welcome to the Course Registration System");
		UserClient.showUserMenu();
		logger.info("Exiting CRS");
		sc.close();
		
	}
	public static void showUserMenu() {
		boolean showMenu=true;
		int choice;
		do {
			logger.info("======User Menu=====");
			logger.info("Enter 1 to login");
			logger.info("Enter 2  to register as a new student student");
			logger.info("Enter any other number to exit CRS");
			choice = Integer.parseInt(sc.nextLine());
			UserClient uc = new UserClient();
			switch(choice) {
				case 1:
					uc.login();
					break;
					
				case 2:
						uc.registerStudent();
						break;
					
				default:
					showMenu = false;
					logger.error("=====Exiting=====");
					break;
				}
		}while(showMenu);
		
	}
	void registerStudent() {
		
	}
	void login() {
		
		ProfessorDaoImpl profcred = new ProfessorDaoImpl();
		logger.info("Enter User Email");
		String uname = sc.nextLine();
		logger.info("Enter User Password");
		String password = sc.nextLine();
		boolean loginstatus=profcred.checkCredentials(uname, password);
		if (loginstatus)
			{
				logger.info("Successful login as Professor");
				ProfessorClient pc = new ProfessorClient();
				ProfessorDao professorDao= new ProfessorDaoImpl();
				Professor professor = professorDao.getProfessorDetails(uname);
				pc.displayMenu(professor);
			}
	}
	void logout() {
		
	}

}
