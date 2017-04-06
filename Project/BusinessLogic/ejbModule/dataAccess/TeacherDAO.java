package dataAccess;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Contest;
import Entities.Input;
import Entities.Output;
import Entities.Problem;
import Entities.Teacher;

/**
 * Session Bean implementation class TeacherDAO
 */
@Stateless
@LocalBean
public class TeacherDAO implements TeacherDAORemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="Entities")
	private EntityManager em;
    public TeacherDAO() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public boolean EditTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			em.merge(teacher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean CreateProblem(Problem problem) {
		// TODO Auto-generated method stub
		try {
			em.persist(problem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	@Override
	public boolean EditProblem(Problem problem) {
		// TODO Auto-generated method stub
		try {
			em.merge(problem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean DeleteProblem(Problem problem) {
		// TODO Auto-generated method stub
		try {
			em.remove(problem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean CreateContest(Contest contest) {
		// TODO Auto-generated method stub
		try {
			em.persist(contest);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean EditContest(Contest contest) {
		// TODO Auto-generated method stub
		try {
			em.merge(contest);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean DeleteContest(Contest contest) {
		// TODO Auto-generated method stub
		try {
			em.remove(contest);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean CreateInput(Input input) {
		// TODO Auto-generated method stub
		try {
			em.persist(input);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean EditInput(Input input) {
		// TODO Auto-generated method stub
		try {
			em.merge(input);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean DeleteInput(Input input) {
		// TODO Auto-generated method stub
		try {
			em.remove(input);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean CreateOutput(Output output) {
		// TODO Auto-generated method stub
		try {
			em.persist(output);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean EditOutput(Output output) {
		// TODO Auto-generated method stub
		try {
			em.merge(output);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean DeleteOutput(Output output) {
		// TODO Auto-generated method stub
		try {
			em.remove(output);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
