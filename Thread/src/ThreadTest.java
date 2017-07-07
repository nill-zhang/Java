
public class ThreadTest {
	
	static void testSubThread()
	{ 
		new subThread("myThread");
		mainThread();
		
	}
	
	static void test_ImplementsRunnable() {
		new implementsRunnable("myThread-1");
		new implementsRunnable("myThread-2");
		new implementsRunnable("myThread-3");
		new implementsRunnable("myThread-4");
		mainThread();
	}
	
	static void mainThread() {
		
		System.out.printf("Total Threads running: %d%n", Thread.activeCount());
		try { 
			for(int j=0; j< 10; j++) {
				System.out.printf("%s thread is running!%n", Thread.currentThread());
				Thread.sleep(2000);
			}
		}catch (InterruptedException e) {
			System.out.printf(" %s is interruptted!", Thread.currentThread());
	    }
	    System.out.printf("Total Threads running: %d%n", Thread.activeCount());
	    System.out.printf("%s exited!", Thread.currentThread());
		
		
		
	}
		
		
		

	
	public static void main(String args[]) {
		
		testSubThread();
		System.out.println("------------------------------------------------");
		test_ImplementsRunnable();
		
	
	}
		
}
	

