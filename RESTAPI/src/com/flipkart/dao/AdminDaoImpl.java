package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	private static AdminDaoImpl instance = null;
	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	private AdminDaoImpl() {
		
	}
	
	public static AdminDaoImpl getInstance() {
		if(instance==null) {
			instance = new AdminDaoImpl();
		}
		return instance;
	}
	
	@Override
	public void addAdmin(User admin, String password) {
		PreparedStatement stmt = null;
		try {
			UserDaoImpl userdao = UserDaoImpl.getInstance();
			userdao.addUser(admin, password);
			stmt =connection.prepareStatement(SQLQueriesConstant.GET_LAST_ENTRY);
			ResultSet resultSet = stmt.executeQuery();
			int userId=0;
			if(resultSet.next()){
				userId=resultSet.getInt("ID");
			}
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_ADMIN_QUERY);
			stmt.setInt(1, userId);
			if(admin.getGender()!=null)
				stmt.setString(3,String.valueOf(admin.getGender()));
			else
				stmt.setString(3,null);
			stmt.setString(3, admin.getCity());
			stmt.setString(4, admin.getAddress());
			stmt.setString(5,  admin.getCountry());
			stmt.setString(6, admin.getState());
			stmt.setLong(7,  admin.getMobile());
			stmt.setString(8, admin.getEmailId());
			int rows = stmt.executeUpdate();
			logger.info(rows + " admin added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void deleteAdmin(int userId) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_ADMIN_QUERY);
			stmt.setInt(1,userId);
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
			
			UserDaoImpl userdao = UserDaoImpl.getInstance();
			userdao.deleteUser(userId);
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public User getAdmin(int adminId) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_ADMIN_DETAILS_QUERY);
			statement.setInt(1, adminId);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int userId = resultSet.getInt("AdminID");
				String name = resultSet.getString("Name");
				String emailId = resultSet.getString("Email");
				long mobile = resultSet.getLong("mobile");
				Gender gender = Gender.valueOf(resultSet.getString("Gender"));
				
				User user = new User();
				user.setUserId(userId);
				user.setName(name);
				user.setEmailId(emailId);
				user.setMobile(mobile);
				user.setGender(gender);
				user.setRole(Role.ADMIN);

				//logger.info(" Student Details Retrieved sucessfully");
				return user;
			}
			return null;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			;
		}
		return null;
		// TODO Auto-generated method stub

	}

}
