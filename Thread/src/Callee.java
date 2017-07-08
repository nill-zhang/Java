import java.util.Random;

public class Callee {
	
	String selfName;
	public Callee(String calleeName) {
		selfName = calleeName;
	}
	
	synchronized void synchronizedPrintRandom() {
		Random rand = new Random();
		int r= rand.nextInt();
		try {
			
			for (int i=0; i<=5; i++){
				Thread.sleep(200);
				System.out.printf("%s is calling %s: %d%n", Thread.currentThread().getName(), selfName, r);
			}
		}catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	void printRandom() {
		Random rand = new Random();
		int r= rand.nextInt();
		try {
			
			for (int i=0; i<=5; i++){
				Thread.sleep(200);
				System.out.printf("%s is calling %s: %d%n", Thread.currentThread().getName(), selfName, r);
				}
		}catch (InterruptedException e) {
			System.out.println(e);
		}
		
		
		
	}
}

