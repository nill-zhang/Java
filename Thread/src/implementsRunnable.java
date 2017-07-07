
public class implementsRunnable implements Runnable{
	
	Thread t;
	implementsRunnable(String threadName) {
		t= new Thread(this, threadName);
		System.out.printf("%s has been initialized!", threadName);
		this.t.start();
		
		
	}
	
	public void run() {
		try {
			
			for(int i = 0; i < 10; i++){
			    System.out.printf(" %s has been ran %d times! %n", Thread.currentThread(), i);
			    Thread.sleep(500);
			}
		}catch (InterruptedException e){
		    System.out.printf("%s is interrupted!", Thread.currentThread());
			
		}
		System.out.printf("%s has been terminated! %n", Thread.currentThread());
		

	}

    
}
