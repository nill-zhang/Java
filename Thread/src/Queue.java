public class Queue {
	
	int queue[];
	int lastIndexOfQueue = -1;
	Queue(int qsize) {
		// init a queue with size qsize
		queue = new int[qsize];
	}
	
	boolean isEmpty() {
		
		return lastIndexOfQueue == -1;
		
	}
	
	boolean isFull() {
		
		return lastIndexOfQueue == queue.length-1;
		
	}
	
	void shuffle() {
	
		for (int i=0; i< lastIndexOfQueue; i++) {
			
			queue[i]= queue[i+1]; 
		}
		
		lastIndexOfQueue -= 1;
		
		
		
		
	}
	
	synchronized void enqueue(int elem){
		try {
		     while(isFull()) {
			    wait();
		    }
		}catch (InterruptedException e) {
			System.out.println("interruppted!");
		}
		queue[++lastIndexOfQueue] = elem;
		System.out.printf("%s put %d into the queue!%n", Thread.currentThread().getName(), elem);
		// just added one item, queue is not empty, notify consumer to get item.
		notify();		
	}
	
	synchronized void deque() {

		try {
		     while(isEmpty()) {
			    wait();
		    }
		}catch (InterruptedException e) {
			System.out.println("interruppted!");
		}
		System.out.printf("%s get %d from the queue!%n", Thread.currentThread().getName(),queue[0]);
		shuffle();
		// just delete one item, queue is not full, notify producer to put item.
	    notify();
		
		
		// the following is redundant, don't need to notify when the instance of Queue is empty
		// because you already check in the beginning, when it is empty, you are waiting
		// for producer to enqueue to the Queue instance.
		// if (isEmpty()) {
		//	notify();
		// }
		
		
		
		
	}

}
