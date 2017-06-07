package exceptionHandel;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ExceptionHandeler
 */
@Stateless
@LocalBean
public class ExceptionHandeler extends Exception{

    /**
     * Default constructor. 
     */
	private String systemErrorMessage;
	private int line;
	private String errorClass;
	private String customMessage;
    public ExceptionHandeler() {
        // TODO Auto-generated constructor stub
    }
	public ExceptionHandeler(String systemErrorMessage, int line, String errorClass, String customMessage) {
		super();
		this.systemErrorMessage = systemErrorMessage;
		this.line = line;
		this.errorClass = errorClass;
		this.customMessage = customMessage;
		showErrorMessage();
	}
	private void showErrorMessage() {
		// TODO Auto-generated method stub
		System.out.println("Error: "+customMessage);
		System.out.println("Class: "+errorClass);
		System.out.println("Line: "+line);
		System.out.println("SystemMessage: "+systemErrorMessage);
		
	}
}
