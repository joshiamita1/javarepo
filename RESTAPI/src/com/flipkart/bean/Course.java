package com.flipkart.bean;



/**
 * @author JEDI01
 *
 */
public class Course {
	// Course code
	int courseCode;
	
	// Course name
	String courseName;
		
	// Catalog Id of the course
	int catalogId;
	
	// Professor of the course
	int professorId;
	
	// Detail of the course
	String catalogDetail;
	
	public Course()
	{
		
	}
	public Course(int courseCode, String courseName, int catalogId, int professorId, String catalogDetail) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.catalogId = catalogId;
		this.professorId = professorId;
		this.catalogDetail = catalogDetail;
	}

	/**
	 * @return the courseCode
	 */
	public int getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the catalogId
	 */
	public int getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the courseDetail
	 */
	public String getCatalogDetail() {
		return catalogDetail;
	}

	/**
	 * @param courseDetail the courseDetail to set
	 */
	public void setCatalogDetail(String catalogDetail) {
		this.catalogDetail = catalogDetail;
	}
	
	
	
	
}
