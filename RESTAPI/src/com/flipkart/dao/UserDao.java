package com.flipkart.dao;


import java.util.ArrayList;

import java.util.List;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.exception.UserNotFoundException;

public interface UserDao {
	

	/**
	 * Add User
	 * @param user
	 * @returnType void
	 */
	public void addUser(User user, String password);
	
	/**
	 * Delete user from list of existing users
	 * @param userId
	 * @returnType void
	 */
	public void deleteUser(int userId);
	
	/**
	 * Modify details of a user
	 * @param userId
	 * @returnType void
	 */
	public void modifyUser(int userId, User user);
	
	/**
	 * Get a list of ids of all users in the database
	 * @returnType List<String>
	 */
	public List<Integer> getUsers();
	
	/**
	 * Get users with a particular role(Student, professor or admin)
	 * @param role
	 * @returnType List<String>
	 */
	public List<Integer> getUsers(Role role);
	
	/**
	 * Get all details of a particular user
	 * @param userId
	 * @returnType User
	 */
	public User getUser(int userId);
	
	
	
	public String getPassword(int userId) throws UserNotFoundException;

}