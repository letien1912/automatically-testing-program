package dataAccess;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Teacher;
import exceptionHandl.ATP_ExceptionHandler;

/**
 * Session Bean implementation class TeacherDAO
 */
@Stateless
@LocalBean
public class TeacherDAO implements I_TeacherDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public TeacherDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void CreateTeacher(Teacher teacher) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(teacher);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 32, "TeacherDAO", "Create Teacher fail");
		}
	}

	@Override
	public Teacher GetTeacherInfo(String teacherID) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			return em.createNamedQuery("Teacher.GetByID",Teacher.class)
					.setParameter("teacherID", teacherID)
					.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 43, "TeacherDAO", "GetTeacherInfo fail");
		}
	}

	@Override
	public void UpdateTeacherInfo(Teacher teacher) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.merge(teacher);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 58, "TeacherDAO", "Update Teacher's Info Fail");
		}
		
	}

}
