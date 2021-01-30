package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.flipkart.constant.PaymentMode;
import org.apache.log4j.Logger;

import com.flipkart.constant.GlobalConstants;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

/**
 * @author Aditya Nahata
 *
 */
public class FeePaymentDaoImpl implements FeePaymentDao  {
	
	private static FeePaymentDaoImpl instance = null;
	private static Logger logger = Logger.getLogger(FeePaymentDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	private FeePaymentDaoImpl() {
		
	}
	
	public static FeePaymentDaoImpl getInstance() {
		if(instance==null) {
			instance = new FeePaymentDaoImpl();
		}
		return instance;
	}
	
		@Override
	public void updateFees(int studentId, double amount) {
		// TODO Auto-generated method stub
			PreparedStatement statement = null;
		try {
			
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_FEE );
			
			statement.setDouble(1,amount);
			statement.setInt(2,studentId);
			
			
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info(" Fees Updated successfully");
			}
			else {
				logger.info("Error during update");
			}
						
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			
		}
		
		
	}


	@Override
	public void PayFees(int StudentId, double amount, PaymentMode mode) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(SQLQueriesConstant.MAKE_PAYMENT_QUERY );
			statement.setInt(1,StudentId);
			statement.setDouble(2,amount);
			Calendar cal = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			statement.setTimestamp(3, timestamp);
			statement.setString(4,String.valueOf(mode));
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Fee payment successful");
			}
			else {
				logger.info("Error during insertion");
			}

		}catch(Exception e) {
			logger.error(e.getMessage());

		}
	}

	@Override
	public double amountPayable(int studentId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		double fee =0;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_FEE_QUERY);
			statement.setInt(1,studentId);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				
				fee=(resultSet.getInt("amountPayable"));
				
			}
			return fee;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return fee;
		}
	
	}
	

}