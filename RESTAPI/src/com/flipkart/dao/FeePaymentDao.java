package com.flipkart.dao;

import com.flipkart.constant.PaymentMode;

public interface FeePaymentDao {

	
	/**
	 * Calculate fee for a student
	 * @param studentId
	 * @returnType double
	 */
	public double amountPayable(int studentId);
	

	/**
	 * Update fee for a student 
	 * @param StudentId
	 * @param fees
	 * @returnType void
	 */
	public void updateFees(int StudentId, double fees);
	
	/**
	 * Pay Student Fees
	 * @param StudentId, amount , mode
	 *
	 */
	public void PayFees(int StudentId, double amount, PaymentMode mode);
}