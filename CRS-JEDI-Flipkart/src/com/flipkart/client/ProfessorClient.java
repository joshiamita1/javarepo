package com.flipkart.client;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.flipkart.bean.Professor;
import com.flipkart.business.ProfessorBusiness;
public class ProfessorClient {
	
	private static Logger logger = Logger.getLogger(ProfessorClient.class);
	Scanner sc = new Scanner(System.in);
	ProfessorBusiness profbusiness = new ProfessorBusiness(); 

public void displayMenu(Professor professor) {
		
	int choice=-1;
	do {
		logger.info("Select action to perform:");
		logger.info("1. To view courses taught");
		logger.info("2. To view students in a course");
		logger.info("3. Grade a student");
		logger.info("9. To logout");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			profbusiness.viewCatalog();
			break;
		case 2:
			profbusiness.getCourseTaught(professor);
			break;
		case 3:
			profbusiness.viewregisteredstudents(professor);
			break;
		case 4:
			profbusiness.gradeStudent();
			break;
		case 9:break;
			
		}
	
	}while(choice!=9);
	sc.close();	
	UserClient.showUserMenu();
	}
}
