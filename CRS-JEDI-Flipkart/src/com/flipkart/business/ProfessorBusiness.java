package com.flipkart.business;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Grade;
import com.flipkart.constant.Role;
import com.flipkart.dao.CourseCatalogDaoImpl;
import com.flipkart.dao.ProfessorDaoImpl;

public class ProfessorBusiness {
	
	ProfessorDaoImpl professorDaoObject = new ProfessorDaoImpl();
	CourseCatalogDaoImpl courseCatalogObject = new CourseCatalogDaoImpl();
	
	public static Logger logger = Logger.getLogger(ProfessorBusiness.class);
	
	public void gradeStudent(String courseCode, Student student, Grade grade) {
		Course course = courseCatalogObject.getCourse(courseCode);
		Map<Student, Grade> mp= course.getStudentsGrades();
		mp.put(student, grade);
		courseCatalogObject.modifyCourse(courseCode, course);
	}
	public TreeSet<Student> viewRegisteredStudents(String courseCode) {
		Course course = courseCatalogObject.getCourse(courseCode);
		Map<Student, Grade> mp = course.getStudentsGrades();
		return (TreeSet<Student>) mp.keySet();
	}
}
