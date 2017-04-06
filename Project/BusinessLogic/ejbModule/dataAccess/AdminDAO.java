package dataAccess;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Student;
import Entities.Teacher;

/**
 * Session Bean implementation class AdminDAO
 */
@Stateless
@LocalBean
public class AdminDAO implements AdminDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public AdminDAO() {
        // TODO Auto-generated constructor stub
    	
    }
	@Override
	public boolean CreateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			em.persist(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	@Override
	public boolean DeleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			em.remove(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	
	}
	@Override
	public boolean DeleteStudent(Student st) {
		// TODO Auto-generated method stub
		try {
			em.remove(st);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
