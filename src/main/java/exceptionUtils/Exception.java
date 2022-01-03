package exceptionUtils;

public class Exception extends RuntimeException {
	
	
	public Exception(String message) {
		super(message);
	}
	public Exception(String message,Throwable e) {
		super(message);
	}

}
