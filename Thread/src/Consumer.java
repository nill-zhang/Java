
public class Consumer implements Runnable {
	Thread t;
	Queue myq;
	public Consumer(Queue q) {
		t = new Thread(this, "Consumer");
        myq = q;
        t.start();
	}
	
	public void run(){
		while (true) {
		    myq.deque();
	    }
	}

}
