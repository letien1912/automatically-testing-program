package dataAccess;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Student;

/**
 * Session Bean implementation class StudentDAO
 */
@Stateless
@LocalBean
public class StudentDAO implements StudentDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public StudentDAO() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public boolean EditStudent(Student st) {
		// TODO Auto-generated method stub
		try{
			em.merge(st);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
}
