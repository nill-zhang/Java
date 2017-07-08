
public class Caller implements Runnable {
	String threadName;
	Thread t;
	Callee ce;
	public Caller (String trname, Callee ce) {
		t = new Thread(this, trname);
		this.t.start();
		this.ce = ce;
	}

	
	public void run() {
		// don't initialize a callee here, if you initialize a callee here
		// 3 different will act on 3 different callees, not on the same instance of Callee
		// neither can you initialize a new callee in the constructor because, you are doing
		// the same thing, constructing a new callee for every instance of caller.
		// you shoud initialize a instance of Callee, then pass it to 3 different threads, so
		// they can synchronize their actions on this shared callee.
		// Callee ce = new Callee();
		// ce.synchronizedPrintRandom();
		
		// this.ce.synchronizedPrintRandom();
		
		synchronized (this.ce) {
			this.ce.printRandom();
		}
	}

}
