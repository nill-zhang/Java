
public class ImplementsRunnable implements Runnable{
	
	Thread t;
	ImplementsRunnable(String threadName) {
		t= new Thread(this, threadName);
		System.out.printf("%s has been initialized!%n", threadName);
		this.t.start();
	
	}
	
	public void run() {
		try {
			
			for(int i = 1; i < 10; i++){
			    System.out.printf("%s has been ran %d times! %n", Thread.currentThread(), i);
			    Thread.sleep(500);
			}
		}catch (InterruptedException e){
		    System.out.printf("%s is interrupted!%n", Thread.currentThread());
			
		}
		System.out.printf("%s has been terminated! %n", Thread.currentThread());
		

	}

    
}
