package accountServices;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import Entities.Student;
import dataAccess.I_StudentDAORemote;
import exceptionHandl.ATP_ExceptionHandler;

@Path("/student")
public class StudentServices {
	@EJB
	private I_StudentDAORemote studentDAO;
	public StudentServices(){
		
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Student> GetAllStudent() throws ATP_ExceptionHandler{
		return studentDAO.GetAllStudent();
	}
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Student GetStudentByID(@PathParam("id") String id) throws ATP_ExceptionHandler{
		return studentDAO.GetStudentByID(id);
	}
	@GET
	@Path("/{username}")
	@Produces({MediaType.APPLICATION_JSON})
	public Student GetStudentByUserName(@PathParam("username") String userName) throws ATP_ExceptionHandler{
		return studentDAO.GetStudentByUserName(userName);
	}
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void CreateStudent(Student student) throws ATP_ExceptionHandler{
		studentDAO.CreateStudent(student);
	}
	
}