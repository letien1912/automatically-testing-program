package exceptionHandl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ExceptionHandeler
 */
@Stateless
@LocalBean
public class ATP_ExceptionHandler extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5255193906000616302L;
	/**
     * Default constructor. 
     */
	private String systemErrorMessage;
	private int line;
	private String errorClass;
	private String customMessage;
    public ATP_ExceptionHandler() {
        // TODO Auto-generated constructor stub
    }
	public ATP_ExceptionHandler(String systemErrorMessage, int line, String errorClass, String customMessage) {
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
