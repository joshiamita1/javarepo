package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.business.AdminBusiness;
import com.flipkart.business.AuthenticateBusiness;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;


/**
 * @author JEDI01
 *
 */

/**
 * @author lovis
 *
 */
public class CRSAdminClient {

	/**
	 * Logger
	 */
	public static Logger logger = Logger.getLogger(CRSAdminClient.class);
	
	/**
	 * Scanner
	 */
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Business Objects
	 */
	AdminBusiness adminBusinessObject = AdminBusiness.getInstance();
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	AuthenticateBusiness authenticateBusinessObject = AuthenticateBusiness.getInstance();
	

	/**
	 * @param userId
	 * Functionalities of the Admin
	 */
	public void displayMenu(int userId) {
		int choice;
		do {
			printChoices();
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				viewCoursesInCatalog();
				break;
			case 2:
				courseCatalogBusinessObject.viewAllCourses();
				break;
			case 3:
				viewUsersOfSpecificRole();
				break;
			case 4:
				assignCourseToProfessor();
				break;
			case 5:
				registerUser();
				break;
			case 6:
				deleteUser();
				break;
			case 7:
				addNewCourse();
				break;
			case 8:
				dropCourse();
				break;
			case 9:
				approveStudent();
				break;
			case 0:
				break;
			default:
				logger.info("Invalid Choice./nTry Again\n");
				break;
			}
		}
		while(choice!=0);
		
	}
	
	/**
	 * View Courses in particular Catalog
	 */
	public void viewCoursesInCatalog() {
		logger.info("Enter Catalog ID");
		int catalogId = sc.nextInt();
		courseCatalogBusinessObject.viewCoursesInCatalog(catalogId);
	}
	
	/**
	 * View Users of the specific Role
	 */
	public void viewUsersOfSpecificRole() {
		logger.info("Enter one of the following Role \n (\"ADMIN\", \"PROFESSOR\", \"STUDENT\"\n");
		sc.nextLine();
		String role = sc.nextLine();
		adminBusinessObject.getUsers(Role.valueOf(role));
	}
	
	
	/**
	 * Assign course to professor
	 */
	public void assignCourseToProfessor() {
		logger.info("Enter Course Code");
		int courseCode = sc.nextInt();
		logger.info("Enter Professor ID");
		int professorId = sc.nextInt();
		adminBusinessObject.assignProfessor(courseCode, professorId);
	}
	

	/**
	 * Display Available Features
	 */
	public void printChoices() {

		logger.info("===========================ADMIN===========================");
		logger.info("Enter your choice:");
		logger.info("1. To view courses in catalog");
		logger.info("2. View All Courses");
		logger.info("3. To view users of Specific Role");
		logger.info("4. Assign course to a professor");
		logger.info("5. Register a new user");
		logger.info("6. Delete a user");
		logger.info("7. Add a new course to catalog");
		logger.info("8. Drop a course from catalog");
		logger.info("9. Approve student");
		logger.info("0. To logout");
		logger.info("===========================================================");
	}
	
	/**
	 * Approve the student
	 */
	public void approveStudent() {
		logger.info("list of unapproved Students");
		adminBusinessObject.viewUnapprovedStudent();
		logger.info("Enter Student ID to approve");
		int studentId = sc.nextInt();
		adminBusinessObject.approveStudent(studentId);
	}
	
	/**
	 * Register User (PROFESSOR OR ADMIN)
	 */
	public void registerUser() {
		User user = new User();
		String password;
		logger.info("Select Role of the User \n(PROFESSOR, ADMIN)");
		sc.nextLine();
		user.setRole(Role.valueOf(sc.nextLine()));
		logger.info("Enter Name");
		user.setName(sc.nextLine());
		logger.info("Enter Password");
		password = sc.nextLine();
		logger.info("Enter Email");
		user.setEmailId(sc.nextLine());
		logger.info("Enter Mobile No.");
		user.setMobile(sc.nextLong());
		logger.info("Select Gender: \n'M' for male and 'F' for female");
		sc.nextLine();
		user.setGender(Gender.valueOf(sc.nextLine()));
		logger.info("Enter Address");
		user.setAddress(sc.nextLine());
		logger.info("Enter City");
		user.setCity(sc.nextLine());
		logger.info("Enter State");
		user.setState(sc.nextLine());
		logger.info("Enter Country");
		user.setCountry(sc.nextLine());
		switch(user.getRole()) {
		case ADMIN:
			if(authenticateBusinessObject.registerAdmin(user, password)) {
				logger.info("Registration Success");
			} else {
				logger.info("Please Register Again!\nRegistration Failed\n");
			}
			break;
		case PROFESSOR:
			logger.info("Enter Department");
			//sc.nextLine();
			Department department = Department.valueOf(sc.nextLine());
			if(authenticateBusinessObject.registerProfessor(user, password, department)) {
				logger.info("Registration Success.");
			} else {
				logger.info("Please Register Again!\nRegistration Failed\n");
			}
			break;
		default:
			break;
		}
	}
	
	/**
	 * Delete the User
	 */
	public void deleteUser() {
		logger.info("Enter user ID");
		int userId = sc.nextInt();
		adminBusinessObject.deleteUser(userId);
	}
	
	/**
	 * Add new Course to the Catalog
	 */
	public void addNewCourse() {
		int courseCode, catalogId;
		String courseName, courseDetail;
		logger.info("Enter Course ID");
		courseCode = sc.nextInt();
		sc.nextLine();
		logger.info("Enter Course Name");
		courseName = sc.nextLine();
		logger.info("Enter catalog ID");
		catalogId = sc.nextInt();
		logger.info("Enter Course Description");
		sc.nextLine();
		courseDetail = sc.nextLine();
		Course course = new Course(courseCode, courseName, catalogId, -1, courseDetail);
		courseCatalogBusinessObject.addCourse(course);
		logger.info("Added Course " + course.getCourseName() + " in Catalog " + course.getCatalogDetail());
	}
	
	/**
	 * Drop Course from the catalog
	 */
	public void dropCourse() {
		logger.info("Enter Course ID");
		int courseId = sc.nextInt();
		courseCatalogBusinessObject.dropCourse(courseId);
	}
}