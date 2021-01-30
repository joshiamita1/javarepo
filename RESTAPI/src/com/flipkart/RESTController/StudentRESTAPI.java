package com.flipkart.RESTController;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.CourseCatalogBusiness;
import com.flipkart.business.StudentBusiness;
import com.flipkart.constant.Grade; 
@Path("/student")
public class StudentRESTAPI {

	/**
	 * Business Objects
	 */
	CourseCatalogBusiness courseCatalogBusinessObject = CourseCatalogBusiness.getInstance();
	StudentBusiness studentBusinessObject = StudentBusiness.getInstance();
	private static Logger logger = Logger.getLogger(StudentRESTAPI.class);
	
	private static final String text = "Message from Server :\n%s";
	/**
	 * @param studentId
	 * Check courses student already registered
	 * @return 
	 */
	@GET
	@Path("/courses/registered/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	//@PathParam("studentId") int studentId
	public ArrayList<Course> viewRegisteredCourses(@PathParam("studentId") int studentId) {
		return studentBusinessObject.viewRegisteredCourses(studentId);
			
	}
	
	@GET
	@Path("/courses/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> getAllCourses() {
		return courseCatalogBusinessObject.viewAllCourses();
	}
	
	@GET
	@Path("viewGrade/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Grade> viewGrades(@PathParam("studentId") int studentId) {
		
		return studentBusinessObject.printReportCard(studentId);
	}
	
	@POST
	@Path("/courses/register/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCourse( Course course, @PathParam("studentId") int studentId) {
		studentBusinessObject.registerCourse(studentId, course.getCourseCode());
		return Response.status(201).entity("Registered to courseId: "+course.getCourseCode()+ " Successfully").build();
	}
	
	@DELETE
	@Path("/courses/drop/{studentId}/{courseId}")
	public Response deleteCustomer(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) {
		studentBusinessObject.dropCourse(studentId, courseId);
		return Response.status(200).entity("successfully deleted").build();
		
	}
	
	@PUT
	@Path("/payFees/{studentId}/{choice}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String payFees(@PathParam("studentId")int studentId,@PathParam("choice")int choice){
		//logger.info(student.getUserId()+ choice);
		studentBusinessObject.makePayment(studentId, studentBusinessObject.getFees(studentId), choice);
		
		return "Fee Payment for student ID:"+ studentId + "Successful";
	}
	
	
	@GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response registerStudent() {
        String response = String.format(text, new Date());
        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
    }
 

    @POST
    @Path("/register")
    public Response registerStudent(
            @Valid Student student) throws ValidationException {
 
        String response = String.format(text, student);
        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
    }
}
	
//	@GET
//    @Path("/validate")
//    public Response validateStudent(
//            @Size(min = 2, max = 25, message = "firstName Length should be between 2 and 25 character")
//            @QueryParam("firstName") String firstName,
// 
//            @Size(min = 2, max = 25, message = "lastName Length should be between 2 and 25 character")
//            @QueryParam("lastName") String lastName,
// 
//            @Min(value = 15, message = "age should not be less that 15")
//            @QueryParam("age")
//                    String age) throws ValidationException {
// 
//        String student = String.format("firstName: %s, lastName: %s, age: %s", firstName, lastName, age);
//        String response = String.format(text, student);
//        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
//    	
//	}


	
