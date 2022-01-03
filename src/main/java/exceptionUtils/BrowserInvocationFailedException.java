package exceptionUtils;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends Exception {

	public BrowserInvocationFailedException(String message) {
		super(message);
		
	}
	public BrowserInvocationFailedException(String message,Throwable e) {
		super(message);
		
	}

}
