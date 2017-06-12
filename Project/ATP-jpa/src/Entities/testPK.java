package Entities;

import java.io.Serializable;

/**
 * ID class for entity: test
 *
 */ 
public class testPK  implements Serializable {   
   
	         
	private int a;         
	private int b;
	private static final long serialVersionUID = 1L;

	public testPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof testPK)) {
			return false;
		}
		testPK other = (testPK) o;
		return true
			&& getA() == other.getA()
			&& getB() == other.getB();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getA();
		result = prime * result + getB();
		return result;
	}
   
   
}
