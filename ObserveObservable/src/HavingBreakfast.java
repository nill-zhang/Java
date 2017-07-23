
public class HavingBreakfast {

	public static void  main(String args[]) {
		
		Mom mom = new Mom("Helen");
		Toaster t = new Toaster();
		ToasterClock tc = new ToasterClock();
		Daughter daughter = new Daughter("Nova");
		
		t.addObserver(mom);
		t.addObserver(tc);
		
		mom.addObserver(daughter);
		t.Counting(5);
		
		
	}
	
	
	
}
