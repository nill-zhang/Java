public class ExceptionTest {
	
	// test must be set as static otherwise, main can not make a static reference
	// to a non-static method
	static  void test_myException() throws MyException {
		MyException me = new MyException(3);
		throw me;
		
		
	}
	
	static void test_myChainedException() throws MyChainedException{
		MyChainedException mce = new MyChainedException();
		mce.initCause(new MyException(100));
		throw mce;
	}
	
	public static void main(String args[]){
		
		try { 
			
		    test_myException();
		    
		}catch (MyException e) {
			
			System.out.println(e);
			
		}finally {
			
			System.out.println("this will be printed whatsoever!");
		}
		
		
		
		try { 
	         
			System.out.println("nothing happened");
			
		}catch (ArithmeticException e) {
				
			System.out.println(e);
			
		}finally {
				
			System.out.println("this will be printed whatsoever!");
		}
		
		
		
		
		try {
			
			test_myChainedException();
			
		}catch (MyChainedException e) {
	       
			System.out.println(e.getCause());
			
		}
	
	}

}
