
public class SubThread extends Thread{
	
	public SubThread(String threadName) {
		super(threadName);
		System.out.println("initialized a new thread!");
		this.start();
	    
	}
	
	public void run() {
		
		try {
		for(int i=0; i < 10; i++) {
			
			// currentThread also needs to be accessed in a static way!
			// the following also works?????
			System.out.printf("%s is running!%n", currentThread());
			
			// The static method sleep(long) from the type Thread should be accessed in a static way
			// this.sleep(1000);	
			Thread.sleep(1000);
		}
		}catch (InterruptedException e) {
			System.out.printf("%s is interrupted!%n", Thread.currentThread());
		}
		
	}

}
