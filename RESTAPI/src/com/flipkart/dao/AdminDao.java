  
package com.flipkart.dao;

import com.flipkart.bean.User;

public interface AdminDao {

	/**
	 * Adds an admin
	 * @param admin
	 */
	public void addAdmin(User admin,String password);
	
	/**
	 * Deletes an admin
	 * @param adminId
	 */
	public void deleteAdmin(int userId);
	
	public User getAdmin(int adminId);
}