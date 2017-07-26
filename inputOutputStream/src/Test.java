import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Test {
	public static byte[] getCharacterBytes(String s) {
		// get available Charsets
		for (Charset c : Charset.availableCharsets().values()) {
			System.out.println(c);
			
		}
    	
    	try {
    	    byte []bt = s.getBytes("UTF-8");
    	    return bt;
    	}catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		}
    	// try can be cut, if so, there will be no return
    	// so the next line needs to be there
		return null;
	}
	
	public static void duplicateUsingCReader(String s) {
		
		CharArrayReader cArrayReader = new CharArrayReader(s.toCharArray());
		// store the elements to be duplicated
		char [] target = new char[s.length()]; 
		for (int i=0; i<80; i++) {
			try {
				cArrayReader.read(target);
				// note that I used String's static method to convert an character array to string.
			    System.out.print(String.valueOf(target));
			    cArrayReader.reset();
			}catch (IOException e) {
				System.out.println(e);
			}
			
			
		}
	}
	
	
	public static void duplicateUsingCWriter(String s) {
		CharArrayWriter cArrayWriter = new CharArrayWriter();
		for (int i = 0; i < 80; i++){   
			try {
			    cArrayWriter.write(s);
			    System.out.print(cArrayWriter.toString());
			    cArrayWriter.reset();
		    } catch (IOException e) {
			    System.out.println(e);
		    }
  		}
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		byte []b;
		b = getCharacterBytes("我是张少锋，你是谁啊！");
		try {
			
			System.out.write(b);
	 	    System.out.write('\n');
	 	    System.out.write("\n".getBytes());
			
		}catch (IOException e) {
			System.out.println(e);
		}
		
		duplicateUsingCReader("*+@");
		System.out.printf("%nlines in between%n");
		duplicateUsingCWriter("*+*");

	}

}
