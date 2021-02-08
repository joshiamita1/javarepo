package com.flipkart.business;

import org.apache.log4j.Logger;

public class AuthorCredentialSystemBusiness
{
	public static Logger logger = Logger.getLogger(AuthorCredentialSystemBusiness.class);
	
	public boolean approveStudent() {
		
		logger.info("Approve student function, AuthorCredentialSystemBusiness class");
		return true;
		
	}
	public boolean registerAdmin() {
		
		logger.info("Register Admin function, AuthorCredentialSystemBusiness class");
		return true;
	}
	public boolean registerProfessor() {
		
		logger.info("Register professor function, AuthorCredentialSystemBusiness class");
		return true;
	}

}
