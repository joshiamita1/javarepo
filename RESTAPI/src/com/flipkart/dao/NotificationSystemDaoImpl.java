package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class NotificationSystemDaoImpl implements NotificationSystemDao{

	private static NotificationSystemDaoImpl instance = null;
	private static Logger logger = Logger.getLogger(NotificationSystemDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	private NotificationSystemDaoImpl() {
		
	}
	
	public static NotificationSystemDaoImpl getInstance() {
		if(instance==null) {
			instance = new NotificationSystemDaoImpl();
		}
		return instance;
	}
	@Override
	public void notifyUser(int userID, String Message) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.NOTIFICATION_QUERY);
			statement.setInt(1,userID);
			statement.setString(2,Message);
			Calendar cal = Calendar.getInstance(); 
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			statement.setTimestamp(3, timestamp);		
			//logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Notification sent sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
	}
	

}
}
