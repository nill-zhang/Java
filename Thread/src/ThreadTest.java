
public class ThreadTest {
	static Thread curThread = Thread.currentThread(); 
	static void testSubThread()
	{ 
		new subThread("myThread");
		mainThreadUsingSleep();
		
	}
	
	static void test_ImplementsRunnable() {
		new implementsRunnable("myThread-1");
		new implementsRunnable("myThread-2");
		new implementsRunnable("myThread-3");
		new implementsRunnable("myThread-4");
		mainThreadUsingSleep();
	}
	
	static void test_Join() {
		
		implementsRunnable t1 = new implementsRunnable("t1");
		implementsRunnable t2 = new implementsRunnable("t2");
		implementsRunnable t3 = new implementsRunnable("t3");
		implementsRunnable t4 = new implementsRunnable("t4");
		
		for(int k=1; k<10; k++) {
	            
	        	System.out.printf("%s has ran %d times!%n", curThread, k);
	                
	        }
	    // System.out.printf("%s has finished its job, waiting for others to terminate! %n", Thread.currentThread());
	    // if you don't call those instance's t.join, when main thread finishes, all the
		// other threads will hang when they finish
		try{
			System.out.printf("%s is waiting for other threads to finish!", curThread);
			t1.t.join();
			t2.t.join();
			t3.t.join();
			t4.t.join();
		}catch (InterruptedException e) {
			System.out.printf("%s has been interrupted!%n", curThread);
		}
		System.out.printf("%s has terminated!%n", curThread);
	}
	
	static void mainThreadUsingSleep() {
		
		System.out.printf("Total Threads running: %d%n", Thread.activeCount());
		try { 
			for(int j=1; j< 10; j++) {
				// if you have a bug in main thread, lets say you forgot the %d in the format specifier
				// in the following statement, main thread will throw exceptions and 
				// other threads will continue running
				System.out.printf("%s thread has been ran %d times!%n", curThread);
				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			System.out.printf(" %s is interruptted!%n", curThread);
	    }
	    System.out.printf("Total Threads running: %d%n", Thread.activeCount());
	    System.out.printf("%s exited!%n", curThread);
		
		
		
	}
		
		
		

	
	public static void main(String args[]) {
		
		// testSubThread();
		System.out.println("------------------------------------------------");
		// test_ImplementsRunnable();
		test_Join();
	
	}
		
}
	

