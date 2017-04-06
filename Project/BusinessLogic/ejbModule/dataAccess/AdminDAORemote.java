package dataAccess;
import javax.ejb.Remote;

import Entities.Student;
import Entities.Teacher;

@Remote
public interface AdminDAORemote {
	public boolean CreateTeacher(Teacher teacher);
	public boolean DeleteTeacher(Teacher teacher);
	public boolean DeleteStudent(Student st);
	
}
