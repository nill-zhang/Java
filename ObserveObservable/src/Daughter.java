import java.util.Observable;
import java.util.Observer;

public class Daughter implements Observer{
	
	String name;
	
	public Daughter(String nm) {
		name = nm;
	}

	public void update(Observable obs, Object obj) {
		
		System.out.printf("%s: Ok, I am coming down!!", name);
		
		
	}
	
	
}
