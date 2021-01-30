package com.flipkart.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.flipkart.constant.Department;
       
      
@XmlRootElement(name = "student") 
public class Student extends User 
     {
	// Branch of the student
	
	   @DecimalMin(value = "15", message = "Student shall be minimum of age 15 yr")
	   @DecimalMax(value = "30", message = "Student can not have age more than 30 yr")
	   private int age;

	   @Size(min = 1, max = 25, message = "The length of firstName should be between 1 to 25")
	   private String firstName;

	   @Size(min = 1, max = 25, message = "The length of firstName should be between 1 to 25")
	   private String lastName;
	   
	   @Pattern(message = "Invalid Email Address->" +
	            "Valid emails:user@gmail.com or my.user@domain.com etc.",
	            regexp = "^[a-zA-Z0-9_!#$%&�*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")

	
	private Department branch;
	
	// Scholarship is provided or not
	boolean hasScholarship;
	
	// Student is Approved;
	boolean isApproved;
	
	// Amount Payable
	double amountPayable;

	/**
	 * @return the branch
	 */
	public Department getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Department branch) {
		this.branch = branch;
	}

	/**
	 * @return the hasScholarship
	 */
	public boolean isHasScholarship() {
		return hasScholarship;
	}

	/**
	 * @param hasScholarship the hasScholarship to set
	 */
	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}

	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	/**
	 * @return the amountPayable
	 */
	public double getAmountPayable() {
		return amountPayable;
	}

	/**
	 * @param amountPayable the amountPayable to set
	 */
	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}
	
	
		
}
