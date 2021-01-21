package com.flipkart.client;
import org.apache.log4j.Logger;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorBusiness;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Grade;
import com.flipkart.constant.Role;
public class ProfessorClient {
	
	private static Logger logger = Logger.getLogger(ProfessorClient.class);
	Scanner sc = new Scanner(System.in);
	ProfessorBusiness profbusiness = new ProfessorBusiness(); 

public void displayMenu(Professor professor) {
		
	int choice=-1;
	do {
		logger.info("Select action to perform:");
		logger.info("1. To view students in a course");
		logger.info("2. Grade a student");
		logger.info("9. To logout");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		
		case 1:
			Set<Student> studentlist=profbusiness.viewRegisteredStudents("101");
			for(Student st:studentlist) {
				logger.info(st.getName()+" "+ st.getStudentId());
			}
			break;
		case 2:
			Student student1 = new Student("1","abhishek@gmail.com","Abhishek",9876511,Role.STUDENT,Gender.MALE,"1","EEE");
			profbusiness.gradeStudent("101",student1,Grade.A);
			break;
		case 9:break;
		default: logger.info("eneter a valid choice");
		}
	
	}while(choice!=9);
	//sc.close();	
	UserClient.showUserMenu();
	}
}
