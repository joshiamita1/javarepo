/**
 * 
 */
package com.flipkart.constant;


/**
 * @author JEDI01
 *
 */
public class SQLQueriesConstant{
	
	//General Queries
	public static String GET_LAST_ENTRY = " SELECT ID from authorcredentialdb order by ID desc limit 1  ";
	
	//Login query for a user
	public static String GET_USER_DETAIL = "select id from authorcredentialdb ";
	public static String GET_USER_DETAIL_ROLE = "select id from authorcredentialdb where role = ?";
	public static String DELETE_USER_QUERY = "delete from authorcredentialdb where id = ? ";
	public static String GET_USER_DETAIL_ID = "select username, password, role from authorcredentialdb where id = ?";
	public static String ADD_NEW_USER_QUERY = "insert into authorcredentialdb (username, password, role) values(?,?,?)";
	public static String MODIFY_USER_QUERY ="update authorcredentialdb set username = ?,role = ?  where id=?";
	
	//NotificationSystem
	public static String NOTIFICATION_QUERY="insert into notificationsystem (UserID , Message, TimeNotified) values (?, ?,?)";
	
	// View Courses
	public static String VIEW_COURSE_QUERY = "select * from Coursecatalog where courseId =?";
	public static String VIEW_COURSEID_QUERY = "select courseId from coursecatalog";
	public static String VIEW_COURSE_PROF_COUNT_QUERY = "select count(*) as pcCount from Coursecatalog where courseId=? AND ProfessorId=?";
	public static String VIEW_PROFESSOR_DETAIL_QUERY = "select * from Coursecatalog where ProfessorId=?";
	public static String VIEW_COURSEINCATALOG_QUERY = "select courseId from Coursecatalog where CatalogId=?";
	public static String ADD_NEW_COURSE_QUERY = "insert into Coursecatalog (CatalogID, courseId, CatalogDetail, ProfessorId, courseName) values (?, ?, ?, null, ?)";
	public static String VIEW_COURSEGRADES_QUERY = "select * from RegisteredCourse where CourseId=?";
	public static String DELETE_COURSE_QUERY = "delete from Coursecatalog where CourseId = ? ";
	public static String UPDATE_COURSE_QUERY = "update Coursecatalog SET ProfessorId=?, courseName=? WHERE courseId = ?";
	public static String UPDATE_COURSEPROF_QUERY = "update Coursecatalog SET ProfessorId=? WHERE courseId = ?";
	public static String COUNT_REGISTERED_STUDENTS_QUERY = "select count(*) as StudentCount from RegisteredCourse where (CourseId = ?)";
	public static String CHECK_REGISTERED_COURSE_QUERY = "select count(*) as CourseCount from RegisteredCourse where (StudentId = ? AND CourseId = ?)";
	public static String COUNT_REGISTERED_COURSE_QUERY = "select count(*) as CourseCount from RegisteredCourse where (StudentId = ?)";
	
	// Student Queries
	public static String MODIFY_STUDENT_QUERY ="update Student  set Name = ?,EmailId	 = ?,Mobile = ?,Gender = ?, branch = ?, hasScholarship = ?, isApproved = ?,city = ?, address = ?,state = ?  where studentId=?";
	public static String GET_STUDENT_DETAILS_QUERY = "select * from student where StudentID=?";
	public static String ADD_STUDENT_QUERY = "insert into Student (StudentID,Name,EmailId,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state) values (?,?,?,?,?,?,?,?,?,?,?)";
	public static String ADD_REGISTERED_COURSE_STUDENT_QUERY = "insert into RegisteredCourse (studentId, courseId) values(?,?)";
	public static String ADD_GRADE_QUERY = "update RegisteredCourse set grade=? where studentid = ? and courseID =? limit 1";
	public static String DROP_COURSE_STUDENT_QUERY = "delete from RegisteredCourse where  studentId = ? and courseId = ? ";
	public static String GET_REGISTERED_COURSES_QUERY = "select rc.studentId, rc.courseId,cc.CourseName from RegisteredCourse as rc inner join coursecatalog as cc on rc.courseID =cc.CourseId where rc.studentId = ?";
	public static String VIEW_GRADES_QUERY = "select * from RegisteredCourse where studentId = ?";
	public static String COUNT_COURSE= "select count(CourseId) as coursecount from RegisteredCourse where studentId = ?";
	public static String UPDATE_FEE="update student set AmountPayable = ? where studentId=?";
	public static String MAKE_PAYMENT_QUERY = "insert into feepayment(studentId, AmountPaid, DateofPayment, Mode ) values(?, ?, ?, ?)";
	public static String GET_FEE_QUERY="select amountPayable from student where StudentId= ?";
	public static String GET_HAS_SCHOLARSHIP =" select HasScholarship from student where StudentID= ?";
	public static String APPROVE_STUDENT_QUERY="update Student set isApproved =? where studentID= ?";
	public static String DELETE_STUDENT_QUERY = "delete from student where studentId = ? ";
	public static String GET_UNAPPROVED_STUDENTS = "select studentId from student where isApproved=0";

	// Professor Queries
	public static String VIEW_PROFESSORID_QUERY = "select ProfessorId from Professor";
	public static String DELETE_PROF_QUERY = "delete from professor where professorId = ? ";
	public static String GET_PROF_DETAIL = "select p.professorId, p.department, p.gender, p.email, p.Name, p.mobile from professor as p where p.professorId =? ";
	public static String ADD_NEW_PROF_QUERY = "insert into professor(professorId, department, gender, city, address, country, state, mobile, email, name) values(?,?,?,?,?,?,?,?,?,?) ";
	
	// Admin Queries
	public static String DELETE_ADMIN_QUERY = "delete from admin where adminId = ? ";
	public static String ADD_NEW_ADMIN_QUERY = "insert into admin(adminId, gender, city, address, country, state, mobile, email) values (?,?,?,?,?,?,?,?)";
	public static String GET_ADMIN_DETAILS_QUERY = "select * from admin where AdminID=?";
	
	//
}