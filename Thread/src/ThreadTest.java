
public class ThreadTest {
	static Thread curThread = Thread.currentThread(); 
	static void testSubThread()
	{ 
		new SubThread("myThread");
		mainThreadUsingSleep();
		
	}
	
	static void testImplementsRunnable() {
		new ImplementsRunnable("myThread-1");
		new ImplementsRunnable("myThread-2");
		new ImplementsRunnable("myThread-3");
		new ImplementsRunnable("myThread-4");
		mainThreadUsingSleep();
	}
	
	static void testJoin() {
		
		ImplementsRunnable t1 = new ImplementsRunnable("t1");
		ImplementsRunnable t2 = new ImplementsRunnable("t2");
		ImplementsRunnable t3 = new ImplementsRunnable("t3");
		ImplementsRunnable t4 = new ImplementsRunnable("t4");
		
		for(int k=1; k<10; k++) {
	            
	        	System.out.printf("%s has ran %d times!%n", curThread, k);
	                
	        }
	    // System.out.printf("%s has finished its job, waiting for others to terminate! %n", Thread.currentThread());
	    // if you don't call those instance's t.join and don't let main sleep for a longer time
		// when main thread finishes, all the other threads will hang when they finish
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
	
	static void testSynchronization() {
		// initialize a instance of Callee
		Callee cle = new Callee("random printer");
		// initialize 3 different threads
        // Caller invoker1 = new Caller("Caller1", cle);
     	// Caller invoker2 = new Caller("Caller2", cle);
     	// Caller invoker3 = new Caller("Caller3", cle);
		Callee ducle1, ducle2, ducle3;
		ducle1=ducle2=ducle3=cle;
	    Caller invoker1 = new Caller("Caller1", ducle1);
	    Caller invoker2 = new Caller("Caller2", ducle2);
	    Caller invoker3 = new Caller("Caller3", ducle3);
	    
	    System.out.printf("%s is waiting for subthreads to finish!%n", curThread);
	    try {
		    invoker1.t.join();
		    invoker2.t.join();
		    invoker3.t.join();
	    }catch (InterruptedException e) {
		    System.out.println("interrupted");
	    }
	    System.out.printf("%s has terminated!%n", curThread);	   
		
	}
	
	 static void testInterThreadCommunication() {
		// execute this function many times can get different results
		Queue q = new Queue(8);
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		try {
		    p.t.join();
		    c.t.join();
	    }catch (InterruptedException e) {
		    System.out.println("interrupted");
	    }
	    System.out.printf("%s has terminated!%n", curThread);	
		
		
	}
	 
	 static void testControlWithFlags() {
		// main will call ControlWithFlag instance cwf's method to
		// to affect the sub thread who is working on it.
		ControlWithFlags cwf = new ControlWithFlags("controlled");
		try {
			// if main don't sleep, after initialize the sub thread, main will
			// return and run fast, can not even notice the effect. so main have to
			// sleep for sometime and see how subthread's behavior is affected by
			// main thread.
			Thread.sleep(2000);
			cwf.suspend();
			
			
			Thread.sleep(2000);
			cwf.resume();
			
			
			Thread.sleep(2000);
			cwf.stop();	
			
			// give sub thread sometime to respond
			Thread.sleep(2000);
			
		}catch (InterruptedException e) {
			System.out.printf("%s has been interrupted!%n", Thread.currentThread().getName());
		}
		
		System.out.printf("%s terminated! %n", Thread.currentThread().getName());
		
	 }
		
		
		

	
	public static void main(String args[]) {
		
		// testSubThread();
		System.out.println("------------------------------------------------");
		// testImplementsRunnable();
		// testJoin();
		// testSynchronization();
		// testInterThreadCommunication();
		testControlWithFlags();
	
	}
		
}
	

