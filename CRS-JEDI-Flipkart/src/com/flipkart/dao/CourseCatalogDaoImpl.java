package com.flipkart.dao;
import java.util.*;
import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Grade;
import com.flipkart.constant.Role;
public class CourseCatalogDaoImpl  implements CourseCatalogDao{
 
	 List<Course> courseList = new ArrayList<Course>();
	 
	 //Course courses[] = new Course[3];
	public CourseCatalogDaoImpl()
	 {
		// TODO Auto-generated method stub
		
	
			Professor p1 = new Professor("P1", "Anil@gmail.com", "Anil", 1234556, Role.PROFESSOR, Gender.MALE, "CS");
			Professor p2 = new Professor("P2", "Anil@gmail.com", "Rahul", 1234556, Role.PROFESSOR, Gender.FEMALE, "ECE");
			Professor p3 = new Professor("P3", "Rishabh@gmail.com", "Rishabh", 12345500, Role.PROFESSOR, Gender.MALE, "IT");
		    Course course1 = new Course("101", "Course A", p1);
			Course course2 = new Course("102", "Course B", p2);
			Course course3 = new Course("103", "Course C", p3);
	//		course1.setCourseCode("101");
	//		course2.setCourseCode("102");
	//		course3.setCourseCode("103");
	//		course1.setCourseName("CourseA");
	//		course2.setCourseName("CourseB");
	//		course3.setCourseName("CourseC");
	//		course1.setProfessor(p1);
	//		course2.setProfessor(p1);
	//		course3.setProfessor(p2);
			courseList.add(course1);
			courseList.add(course2);
			courseList.add(course3);
			
	}
	 @Override
		public void addCourse(Course course)
		{
		 
		}
	 
	@Override
	public void deleteCourse(String courseCode) {
		for(int i = 0; i < courseList.size(); ++i) {
			if(courseList.get(i).getCourseCode().equals(courseCode)) {
				courseList.remove(i);
				return;
			}
		}
	}
	
	@Override
	public void assignProfessor(String courseCode, Professor professor){
		// Admin
	}
	
	@Override
	public void addRegisteredStudent(String courseCode, Student student){
		for(int i = 0; i < courseList.size(); ++i) {
			if(courseList.get(i).getCourseCode().equals(courseCode)) {
				Map<Student, Grade> mp= courseList.get(i).getStudentsGrades();
				mp.put(student, null);
				courseList.get(i).setStudentsGrades(mp);
				return;
			}
		}
	}
	
	@Override
	public void modifyCourse(String courseCode, Course course) {
		for(int i = 0; i < courseList.size(); ++i) {
			if(courseList.get(i).getCourseCode().equals(courseCode)) {
				courseList.set(i, course);
				return;
			}
		}
	}
	
	@Override
	public Course getCourse(String courseCode) {
		for(int i = 0; i < courseList.size(); ++i) {
			if(courseList.get(i).getCourseCode().equals(courseCode)) {
				return courseList.get(i);
			}
		}
		return null;
		// TODO Auto-generated method stub
		
	}
	  
		
}

  
	 
	

