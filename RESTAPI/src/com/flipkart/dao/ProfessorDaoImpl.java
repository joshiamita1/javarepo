package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class ProfessorDaoImpl implements ProfessorDao {

	
	private static ProfessorDaoImpl instance = null;
	private static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	private ProfessorDaoImpl() {
		
	}
	
	public static ProfessorDaoImpl getInstance() {
		if(instance==null) {
			instance = new ProfessorDaoImpl();
		}
		return instance;
	}
	
	@Override
	public Professor getProfessor(int professorId) {
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_PROF_DETAIL);
			statement.setInt(1,professorId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				
				int userId = resultSet.getInt("professorId");
				String emailId = resultSet.getString("email");
		
				String name = resultSet.getString("name");
				long mobile = resultSet.getLong("mobile");
				
				Gender gender = Gender.valueOf(resultSet.getString("gender"));
				Department dept = Department.valueOf(resultSet.getString("department"));

				Professor professor = new Professor();
				
				professor.setUserId(userId);
				professor.setEmailId(emailId);
				professor.setName(name);
				professor.setDepartment(dept);
				professor.setMobile(mobile);
				professor.setRole(Role.PROFESSOR);
				professor.setGender(gender);
				
				
				return professor;
			}
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProfessor(User professor, String password, Department department) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			
			UserDaoImpl userdao = UserDaoImpl.getInstance();
			userdao.addUser(professor, password);
			
			stmt =connection.prepareStatement(SQLQueriesConstant.GET_LAST_ENTRY);
			ResultSet resultSet = stmt.executeQuery();
			int userId=0;
			if(resultSet.next()){
				userId=resultSet.getInt("ID");
			}
			
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_PROF_QUERY);
			stmt.setInt(1,userId);			
			stmt.setString(2,String.valueOf(department));
			if(professor.getGender()!=null)
				stmt.setString(3,String.valueOf(professor.getGender()));
			else
				stmt.setString(3,null);
			stmt.setString(4,professor.getCity());
			stmt.setString(5,professor.getAddress());
			stmt.setString(6,professor.getCountry());
			stmt.setString(7,professor.getState());
			stmt.setLong(8,professor.getMobile());
			stmt.setString(9,professor.getEmailId());
			stmt.setString(10, professor.getName());
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				logger.info("Added Professor sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			logger.info(rows + " professor added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		
	}
	@Override
	public void deleteProfessor(int userId) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_PROF_QUERY);
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
	public List<Integer> getProfessors() {
		PreparedStatement statement = null;
		List<Integer> newListProf = new ArrayList<Integer>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_PROFESSORID_QUERY);
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
				int profId = resultSet.getInt("ProfessorId");
				newListProf.add(profId);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
		
		
		
	}

	
	
}