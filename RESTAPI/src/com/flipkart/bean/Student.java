package com.flipkart.bean;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.flipkart.constant.Department;
    
//@XmlRootElement(name = "student") 
public class Student extends User  
{
	// Branch of the student
	
	
	 
	 String password;
	 
	 @DecimalMin(value = "15", message = "Student shall be minimum of age 15 yr")
	    @DecimalMax(value = "30", message = "Student can not have age more than 30 yr")
	    private int age;
	 
	    @Size(min = 1, max = 25, message = "The length of firstName should be between 1 to 25")
	    private String firstName;
	 
	    @Size(min = 1, max = 25, message = "The length of firstName should be between 1 to 25")
	    private String lastName;
	 
	 
	 public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	   public int getAge() {
	        return age;
	    }
	 
	    public String getFirstName() {
	        return firstName;
	    }
	 
	    public String getLastName() {
	        return lastName;
	    }
	   
	    public Student() {
	    	 
	    }
	 
	    public String toString() {
	        return String.format("firstName : %s, lastName : %s, age: %s",
	                firstName, lastName, age);
	    }
	   
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
