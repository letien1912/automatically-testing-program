package dataAccess;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Problem;
import exceptionHandl.ATP_ExceptionHandler;

/**
 * Session Bean implementation class ProblemDAO
 */
@Stateless
@LocalBean
public class ProblemDAO implements I_ProblemDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public ProblemDAO() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void CreateProblem(Problem problem) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(problem);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 31, "ProblemDAO", "Create Problem Fail!");
		}
	}
	@Override
	public void EditProblem(Problem problem) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.merge(problem);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 43, "ProblemDAO", "Edit Problem Fail!");
		}
	}
	@Override
	public void DeleteProblem(Problem problem) throws ATP_ExceptionHandler {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.remove(em.merge(problem));
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ATP_ExceptionHandler(e.getMessage(), 56, "ProblemDAO", "Delete Problem Fail!");
		}
	}

}
