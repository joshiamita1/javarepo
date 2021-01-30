package com.flipkart.dao;

public interface NotificationSystemDao {


	/**
	 * Notify user with a given message
	 * @param userID
	 * @param Message
	 * @returnType void
	 */

	public void notifyUser(int userID, String Message);
}