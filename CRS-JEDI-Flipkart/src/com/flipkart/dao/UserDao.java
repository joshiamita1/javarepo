package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserDao {
	public void addUser(User user);
	public void deleteUser(String userId);
	public void modifyUser(String userId);
	public void getUsers(Role role);
}
