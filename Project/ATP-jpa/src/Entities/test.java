package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: test
 *
 */
@Entity

@IdClass(testPK.class)
public class test implements Serializable {

	   
	@Id
	private int a;   
	@Id
	private int b;
	private static final long serialVersionUID = 1L;

	public test() {
		super();
	}   
	public int getA() {
		return this.a;
	}

	public void setA(int a) {
		this.a = a;
	}   
	public int getB() {
		return this.b;
	}

	public void setB(int b) {
		this.b = b;
	}
   
}
