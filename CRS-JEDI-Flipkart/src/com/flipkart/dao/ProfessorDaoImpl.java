package com.flipkart.dao;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

public class ProfessorDaoImpl implements ProfessorDao {
	public static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	Professor p1 = new Professor("P1", "Anil@gmail.com", "Anil", 1234556, Role.PROFESSOR, Gender.MALE, "CS");
	Professor p2 = new Professor("P2", "Anil@gmail.com", "Rahul", 1234556, Role.PROFESSOR, Gender.FEMALE, "ECE");
	Professor p3 = new Professor("P3", "Rishabh@gmail.com", "Rishabh", 12345500, Role.PROFESSOR, Gender.MALE, "IT");
	List <Professor> professorList = new ArrayList<Professor>() ;
	HashMap <String,String> professorCreds = new HashMap<String,String>();
	
	public ProfessorDaoImpl()
	{
		professorCreds.put("Anil@gmail.com","101");
		professorCreds.put("Rahul@gmail.com","204");
		professorCreds.put("Rishabh@gmail.com","124");
		professorList.add(p1);
		professorList.add(p2);
		professorList.add(p3);
	}
	
	public List<Professor> getProfessors(){
		return professorList;
	}
		
	@Override
	public void addProfessor(Professor professor) {
		professorList.add(professor);
	}

	@Override
	public void addCourse(String professorId, Course course) {
		for(int i = 0; i < professorList.size(); ++i) {
			if(professorList.get(i).getUserId()==professorId) {
				List<Course> courseList = professorList.get(i).getCourselist() ;
				courseList.add(course);
				professorList.get(i).setCourselist(courseList);
			}
		}
	}
	
	@Override
	public Professor getProfessorDetails(String uName) {
		for(int i = 0; i < professorList.size(); ++i) {
			if(professorList.get(i).getName().equals(uName)) {
				return professorList.get(i);
			}
		}
		return null;
	}
	
	@Override
	public boolean checkCredentials(String uName,String password) {
		boolean isUnamePresent = professorCreds.containsKey(uName);
		if (isUnamePresent) {
			if (professorCreds.get(uName).equals(password))
				return true;
			else
			{
				logger.error("Incorrect Password");
				return false;
			}
		}
		else {
			logger.error("UserName invalid");
			return false;
		}
	}

	@Override
	public void deleteProfessor(String professorId) {
		for(int i = 0; i < professorList.size(); ++i) {
			if(professorList.get(i).getUserId().equals(professorId)) {
				professorList.remove(i);
				return;
			}
		}
	}

}