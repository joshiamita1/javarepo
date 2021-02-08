  
package com.flipkart.business;

import com.flipkart.exception.InvalidLoginException;
import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;
import com.flipkart.constant.Role;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.NotificationSystemDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDaoImpl;

/**
 * @author JEDI01
 *
 */
public class AuthenticateBusiness {
	
	
	public static Logger logger = Logger.getLogger(AuthenticateBusiness.class);
	
	/**
	 * Singleton Field
	 */
	private static AuthenticateBusiness instance = null;

	/**
	 * Dao Objects
	 */
	UserDaoImpl userDaoObject = UserDaoImpl.getInstance();
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	NotificationSystemDaoImpl notificationSystemDaoObject = NotificationSystemDaoImpl.getInstance();

	
	
	/**
	 * Private Constructor
	 */
	
	/**
	 * @return Instance of the class
	 */
	public static AuthenticateBusiness getInstance() {
		if(instance==null) {
			instance = new AuthenticateBusiness();
		}
		return instance;
	}
	
	/**
	 * @param inputId
	 * @param inputPassword
	 * @return authentication status
	 */
	public boolean validLogin(int inputId, String inputPassword) throws UserNotFoundException, InvalidLoginException {
		try {
			String userPassword = userDaoObject.getPassword(inputId);
			if(userPassword.equals(inputPassword)) {
				return true;
			}
			else {
				throw new InvalidLoginException();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			return false;
		}

	}
	
	
	/**
	 * @param inputId
	 * @param inputPassword
	 * @return Role of the user
	 */
	public Role getRole(int inputId, String inputPassword) {
		return userDaoObject.getUser(inputId).getRole();	
	}
	

	
	/**
	 * @param student
	 * @param password
	 * @return Registration Status
	 */
	public boolean registerStudent(Student student, String password) {
		
		studentDaoObject.addStudent(student, password);
		logger.info("=======================REGISTERED=======================");
		logger.info("Added user into Student Table\n");
		int userid=userDaoObject.lastEntry();
		student.setUserId(userid);
		logger.info(student.getUserId());
		notificationSystemDaoObject.notifyUser(student.getUserId(), "Successfully Registerd!");
		return true;
	}

	/**
	 * @param admin
	 * @param password
	 * @return Registration Status
	 */
	public boolean registerAdmin(User admin, String password)
	{
		adminDaoObject.addAdmin(admin, password);
		logger.info("=======================REGISTERED=======================");
		logger.info("Added user into Admin Table\n");
		return true;
	}

	/**
	 * @param user
	 * @param password
	 * @param department
	 * @return Registration Status
	 */
	public boolean registerProfessor(User user, String password, Department department) {
		professorDaoObject.addProfessor(user, password, department);
		logger.info("=======================REGISTERED=======================");
		logger.info("Added user into Professor Table\n");
		return true;
	}
}