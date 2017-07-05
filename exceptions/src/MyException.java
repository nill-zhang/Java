public class MyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int errNo;
	
	// constructor for custom MyException Class.
	public MyException(int errorno) {
		
		errNo = errorno;
	}
	
	// override Throwable's toString method.
	public String toString() {
		
		return String.format("error[%d] has occurred", errNo);
		
	}

}
