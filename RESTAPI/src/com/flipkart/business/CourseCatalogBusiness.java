package com.flipkart.business;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDaoImpl;


/**
 * @author JEDI01
 *
 */
public class CourseCatalogBusiness{ 

	/**
	 * Singleton Field
	 */
	private static CourseCatalogBusiness instance = null;
	
	
	/**
	 *  Dao Objects
	 */
	CourseCatalogDaoImpl courseCatalogDaoObject = CourseCatalogDaoImpl.getInstance();
	private static Logger logger = Logger.getLogger(CourseCatalogBusiness.class);
	

	/**
	 * Private Constructor
	 */
	private CourseCatalogBusiness() {
		
	}
	
	/**
	 * @return Instance of the class
	 */
	public static CourseCatalogBusiness getInstance() {
		if(instance==null) {
			instance = new CourseCatalogBusiness();
		}
		return instance;
	}
	
	/**
	 * View all courses
	 * @return 
	 */
	public ArrayList<Course> viewAllCourses() {   
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCourses();
		ArrayList<Course> courseListdetails= new ArrayList<Course>();
		logger.info(String.format("%20s %20s", "Course Id","Course Name"));
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(String.format("%20s %20s", course.getCourseCode() ,course.getCourseName()));
			courseListdetails.add(course);
		}
		return courseListdetails;
		
	}
	
	/**
	 * @param catalogId
	 * Courses in particular Catalog
	 */
	public ArrayList<Course> viewCoursesInCatalog(int catalogId) {
		
		ArrayList<Integer> coursesList = courseCatalogDaoObject.getCoursesInCatalog(catalogId);
		ArrayList<Course> courseListdetails= new ArrayList<Course>();
		logger.info(String.format("%20s %20s", "Course Id","Course Name"));
		
		for(Integer courseCode : coursesList) {
			Course course = courseCatalogDaoObject.getCourse(courseCode);
			logger.info(String.format("%20s %20s", course.getCourseCode() ,course.getCourseName()));
			courseListdetails.add(course);
		}
		return courseListdetails;
	}
	
	/**
	 * @param course
	 * Add Course to the Catalog
	 */
	public void addCourse(Course course) {
		courseCatalogDaoObject.addCourse(course);
	}
	
	/**
	 * @param courseId
	 * Drop Course from the catalog
	 */
	public void dropCourse(int courseId) {
		courseCatalogDaoObject.deleteCourse(courseId);
		logger.info("Delete course from the table.");
	}

	
	/**
	 * @param courseId
	 * @return number of Registered Students in the particular Course
	 */
	public int numberOfRegisterdStudents(int courseId) {
		int n = courseCatalogDaoObject.numberOfRegisteredStudents(courseId);
		logger.info("Number of the students registered in course : " + courseId + " are " + n + ".");
		return n;
	}

}