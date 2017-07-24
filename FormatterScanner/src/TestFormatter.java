import java.util.Calendar;
import java.util.Locale;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Formatter;

public class TestFormatter {
	
    public static void testTime() {
    	
    	Calendar ca = Calendar.getInstance(Locale.CANADA);
    	Formatter fmt1 = new Formatter();
    	//month/day/year 12hour time
    	fmt1.format("%tD, %1$tr", ca,ca);
    	System.out.println(fmt1);
    	fmt1.close();
    	
    	Formatter fmt2 = new Formatter();
    	// year--month--day, 24hour time
    	fmt2.format("%tF, %<tT", ca);
    	System.out.println(fmt2);
    	fmt2.close();
    	
    	
    	Formatter fmt3 = new Formatter();
    	fmt3.format("%tc", ca);
    	System.out.println(fmt3);
    	fmt3.close();
  	  	
    }
    
    public static void testWidthPrecision() {
    	
    	Formatter formatter = new Formatter();
    	formatter.format("|%-38s|%08d|", "sfzhang has a long name", 25);
    	System.out.println(formatter);
    	formatter.close();
    	
    	
    	Formatter formatter2 = new Formatter();
        formatter2.format("|%38s|%08d|", "sfzhang has a long name", 25);
    	System.out.println(formatter2);
    	formatter2.close();
    	
    	Formatter formatter3 = new Formatter();
        formatter3.format("|%38.8s|%08d|", "sfzhang has a long name", 25);
    	System.out.println(formatter3);
    	formatter3.close();
    	
    	Formatter formatter5 = new Formatter();
        formatter5.format("|%-38.8s|%08d|", "sfzhang has a long name", 25);
    	System.out.println(formatter5);
    	formatter5.close();
    	
    	Formatter formatter4 = new Formatter();
    	formatter4.format("|%8f|%012f|%8.2f|", 0.34555, 0.34555, 0.34555);
    	System.out.println(formatter4);
    	formatter4.close();
    	
    	Formatter formatter6 = new Formatter();
    	formatter6.format("|%,.2f|%8.2f|", 10525554452.34555, 10525554452.34555);
    	System.out.println(formatter6);
    	formatter6.close();
    	
    	
    }
    
    
    public static void testArgumentIndex() {
    	
    	Formatter formatter6 = new Formatter();
    	formatter6.format("%3$S-->%2$S-->%1$S", "Grandfather", "Father", "Son");
    	System.out.println(formatter6);
    	formatter6.close();
    	
    	System.out.printf("%3$S-->%<S-->%<S\n", "Grandfather", "Father", "Son");
    	
    	
    	
    	
    	
    }

}
