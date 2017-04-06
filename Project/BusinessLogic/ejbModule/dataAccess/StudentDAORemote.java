package dataAccess;

import javax.ejb.Remote;

import Entities.Student;

@Remote
public interface StudentDAORemote {
	public boolean CreateStudent(Student st);
	public boolean EditStudent(Student st);
	
}
