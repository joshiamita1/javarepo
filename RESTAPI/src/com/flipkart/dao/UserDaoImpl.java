package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance = null;
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	StudentDaoImpl studentDaoObject = StudentDaoImpl.getInstance();
	AdminDaoImpl adminDaoObject = AdminDaoImpl.getInstance();
	ProfessorDaoImpl professorDaoObject = ProfessorDaoImpl.getInstance();
	
	private UserDaoImpl() {
		
	}
	
	public static UserDaoImpl getInstance() {
		if(instance==null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public void addUser(User user, String password) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_USER_QUERY);
			stmt.setString(1,user.getName());
			stmt.setString(2,password);
			stmt.setString(3,user.getRole().toString());
			int rows = stmt.executeUpdate();
			logger.info(rows + " user added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_USER_QUERY);
			stmt.setInt(1,userId);
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}


	@Override
	public void modifyUser(int userId, User user) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.MODIFY_USER_QUERY );
			
			statement.setString(1,user.getName());
			statement.setString(2,String.valueOf(user.getRole()));
			statement.setInt(3, userId);
			
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Added user sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}


	@Override
	public List<Integer> getUsers() {
		
		PreparedStatement statement = null;
		List<Integer> userList = new ArrayList<Integer>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int userId = resultSet.getInt("id");
				userList.add(userId);
			}
			return userList;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public ArrayList<Integer> getUsers(Role role) {
		
		PreparedStatement statement = null;
		ArrayList<Integer> userList = new ArrayList<Integer>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ROLE);
			statement.setString(1, role.toString());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int userId = resultSet.getInt("id");
				userList.add(userId);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return userList;
		
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ID);
			statement.setInt(1,userId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				User user = new User();
				String name = resultSet.getString("username");
				Role role = Role.valueOf(resultSet.getString("role")); 
				
				user.setName(name);
				user.setRole(role);
				logger.info(role);
				if(role.equals(Role.STUDENT)) {
					//logger.info("#######################"+userId);
					Student s= studentDaoObject.getStudent(userId);
					
					if(s!=null) {
						s.setRole(Role.STUDENT);
						return s;
					}
				}
				else if(role.equals(Role.PROFESSOR)) {
					Professor p= professorDaoObject.getProfessor(userId);
					
					if(p!=null) {
						p.setRole(role);
						return p;
					}
				}
				else if(role.equals(Role.ADMIN)) {
					User a= adminDaoObject.getAdmin(userId);
					if(a!=null) {
						a.setRole(role);
						return a;
					}
				}
				return user;
			}
			else{
				logger.info("User does not exist");
			}
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	
	@Override
	public String getPassword(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		//logger.info(userId);
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ID);
			statement.setInt(1,userId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				
				String password = resultSet.getString("password");
				//logger.info(password);
				return password;
			}
			else{
				throw new UserNotFoundException();
			}

		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	
	}

	
	public int lastEntry() {
		PreparedStatement statement = null;
		int userId=0;
		try {
			statement =connection.prepareStatement(SQLQueriesConstant.GET_LAST_ENTRY);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				userId=resultSet.getInt("ID");
				
				
			}
			return userId;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
		
	}
}