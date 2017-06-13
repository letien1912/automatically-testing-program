package ErrorHandling;

public class ProblemExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode = ErrorCode.OK;
	private String errorParam;

	public ProblemExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	public ProblemExceptionHandler(String message) {
		super(message);
	}

	public ProblemExceptionHandler(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ProblemExceptionHandler(ErrorCode errorCode, String errorParam) {
		super();
		this.errorCode = errorCode;
		this.errorParam = errorParam;
	}

	public String ErrorMessange() throws Exception {
		switch (errorCode) {
		case OK:
			throw new Exception("Should not go here");
		case FILE_NOT_FOUND:
			return String.format("Cant not found file -%c .", errorParam);
		case COMPILE_UNSUCCESS:
			return String.format("Compile is unsuccess -%c", errorParam);
		case COMPILER_ERROR:
			return String.format("Compiler error -%c", errorParam);
		case NO_DATA:
			return String.format("-%c has no data from SQL", errorParam);
		case INPUT_OUTPUT_DIFFERENT:
			return String.format("the size of input and output is not same");
		default:
			break;
		}
		return null;
	}
	
	public String getErrorParam() {
		return errorParam;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public enum ErrorCode {
		OK, FILE_NOT_FOUND, COMPILE_UNSUCCESS, COMPILER_ERROR, NO_DATA, INPUT_OUTPUT_DIFFERENT
	}
}
