
public class Producer implements Runnable{
	Thread t;
	Queue myq;
    public Producer(Queue q) {
    	myq = q;
		t= new Thread(this, "Producer");
		t.start();
	}
    
    public void run() {
    	int j=0;
    	while(j < 60){
    	    myq.enqueue(j++);
        }
    }
}
