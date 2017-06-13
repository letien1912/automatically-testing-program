package dataAccess;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Student_ContestDetail;
import exceptionHandl.ATP_ExceptionHandler;

/**
 * Session Bean implementation class Student_ContestDAO
 */
@Stateless
@LocalBean
public class Student_ContestDAO implements I_Student_ContestDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public Student_ContestDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void CreateStudentContestDetail(Student_ContestDetail student_ContestDetail) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(student_ContestDetail);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 34, "Student_ContestDetailDAO", "Create StudentContestDetail Fail");
		}
	}

	@Override
	public List<Student_ContestDetail> GetAllStudentContestDetail() throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			return em.createNamedQuery("Student_ContestDetail.GetAll",Student_ContestDetail.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 46, "Student_ContestDetailDAO", "Get All Student_ContestDetail Fail");
		}
	}

	@Override
	public Student_ContestDetail GetStudent_ContestDetail(String studentID, String contestID)
			throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			return em.createNamedQuery("GetStudent_ContestDetail.GetByID",Student_ContestDetail.class)
					.setParameter("studentID", studentID)
					.setParameter("contestID", contestID)
					.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 58, "Student_ContestDetailDAO", "Get Student_ContestDetail By ID Fail");
		}
	}

	@Override
	public List<Student_ContestDetail> GetStudentContestDetailByContestID(String contestID)
			throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			return em.createNamedQuery("GetStudent_ContestDetail.GetByContestID",Student_ContestDetail.class)
					.setParameter("contestID", contestID)
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 73, "Student_ContestDetailDAO", "Get Student_ContestDetail By ContestID Fail");
		}
	}

	@Override
	public List<Student_ContestDetail> GetStudentContestDetailByStudentID(String studentID)
			throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			return em.createNamedQuery("GetStudent_ContestDetail.GetByStudentID",Student_ContestDetail.class)
					.setParameter("studentID", studentID)
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 87, "Student_ContestDetailDAO", "Get Student_ContestDetail By StudentID Fail");
		}
	}

}
