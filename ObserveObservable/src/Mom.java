import java.util.Observable;
import java.util.Observer;

import javax.activation.UnsupportedDataTypeException;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Mom extends Observable implements Observer{
	String name;
	
	public Mom(String nm) {
		name = nm;
	}

	public void update(Observable ob, Object waitTime) {
		
		if((Long)waitTime == 0) {
	
			System.out.printf("%s: breakfast is ready!%n", name);
			setChanged();
			notifyObservers();
		}
	
	}


	
	
	
}
