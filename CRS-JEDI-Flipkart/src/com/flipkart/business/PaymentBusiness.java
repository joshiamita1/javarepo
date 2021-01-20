package com.flipkart.business;

import org.apache.log4j.Logger;

public class PaymentBusiness {
	
	public static Logger logger = Logger.getLogger(PaymentBusiness.class);
	
	 public void calculatefee() {
		 logger.info("calculatefee function, PaymentBusiness class");
		 
	 }
	 public boolean checkscholorship() {
		 
		 logger.info("checkscholorship function, PaymentBusiness class");
		 return true;
	 }
}
