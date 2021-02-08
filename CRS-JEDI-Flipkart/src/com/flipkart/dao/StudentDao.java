package com.flipkart.dao;

import java.util.ArrayList;
import java.util.Map;
import com.flipkart.bean.*;
import com.flipkart.constant.Grade;

public interface StudentDao {
	public void addStudent(Student student);
	public void registerCourse(int studentId, Course course);
	public void dropCourse(int studentId, int courseId);
	public ArrayList<Course> viewRegisteredCourses(int studentId);
	public Map<Course, Grade> viewGrades(int studentId);
}
