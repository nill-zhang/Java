public class ControlWithFlags implements Runnable {
	Thread t;
	boolean suspendedFlag;
	boolean stopFlag;
	public ControlWithFlags(String thName) {
		suspendedFlag = false;
		stopFlag = false;
		t= new Thread(this, thName);
	    t.start();
		
	}
	
	public void run() {
		try {
		    for(int i=0; i<30; i++) {
		    	
		    	 synchronized (this) {
		    		while(suspendedFlag) {
				    		wait();
				    }
		    	 }
		    	synchronized (this) {
		    		while (stopFlag) {
		    			System.out.printf("%s terminated!%n", Thread.currentThread().getName());
						return;
						
					}
				}
		    	
			    System.out.printf("%s is running!%n", Thread.currentThread().getName());
		        Thread.sleep(500);
		    }	
		}catch (InterruptedException e) {
		    System.out.printf("%s has been interrupted!%n", Thread.currentThread().getName());
		}
		
	}
	
   synchronized public void suspend() {
		
		suspendedFlag = true;
		System.out.printf("%s suspended subthread %n",Thread.currentThread().getName());
	}
	
   synchronized public void stop() {
		
	   stopFlag=true;
	   System.out.printf("%s stopped subthread %n",Thread.currentThread().getName());
	}
		
	
	synchronized public void resume() {
		
		suspendedFlag = false;
		System.out.printf("%s resumed subthread %n",Thread.currentThread().getName());
		notify();
	}
		
}
