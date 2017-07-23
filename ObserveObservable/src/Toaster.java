import java.util.Observable;

public class Toaster extends Observable {
	
	void Counting(long timeToWait) {
		
		for (; timeToWait >= 0; timeToWait--) {
			
			setChanged();
			notifyObservers(timeToWait);
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				System.out.println("interrupted!");
			}
			
		}
		
	}
	
	
	

}
