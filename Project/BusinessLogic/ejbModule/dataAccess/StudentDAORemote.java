package dataAccess;

import javax.ejb.Remote;

import Entities.Student;

@Remote
public interface StudentDAORemote {
	public boolean EditStudent(Student st);
	
}
