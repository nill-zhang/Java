public class TestJavaLang {
	public static void main(String args[]) {
		
		testTypeWrapper();
		testCharacter();
		testBoolean();
		
	}
	
	public static void testCharacter() {
		
		 
	    // convert a digit to its character format
	    System.out.println(Character.toUpperCase(Character.forDigit(15, 16)));
	    System.out.println(Character.digit('A', 16));
	    int cp = Character.codePointAt("张", 0);
	    System.out.printf("code point of 张： %d%n", cp);
	    char zhang[] = Character.toChars(cp);
	    System.out.println("is BMP CodePoint? "+ Character.isBmpCodePoint(cp));
	    System.out.println(zhang);
		
	}
	
	public static void testBoolean() {
		
		Boolean b = new Boolean("THIS IS A long True!!");
		assert b == false;
		System.out.println("b is " + b);
	}
	
	
	public static void testTypeWrapper() {
		// you can using a string to instantiate type wrappers
	    Integer it = new Integer("3000");
	    // the following line of code will print -72, why because of truncation
	    // byteValue() will only keep the last 8 binary digits
	    // which is 10111000 from 3000's binaryString
	    // this is -(01000111+1), which is -72
	    System.out.println(it.byteValue());
	    System.out.println(Integer.toBinaryString(it));
		
	    // byte type is [-128, 127], don't give other invalid string
	    Byte b1 = new Byte("-128");
	    System.out.println(b1.floatValue());
	    b1 = -1;
	    System.out.println(Integer.toBinaryString(b1));
		
	    
	    Byte b2;
	    Integer i1;
	    b2 = Byte.valueOf("01111111", 2);
	    System.out.println(b2);
	    i1 = Integer.valueOf("11111111", 2);
	    System.out.println(i1);
	    // only Integer and Long has this toString() method
	    // in which you can specify a radix
	    // also only Integer and Long has toBinaryString, toHexString, toOctalString
	    // which are wrappers of toString(, radix) method
	    System.out.println(Integer.toString(i1, 8));
	    System.out.println(Integer.toString(i1, 16));
	    System.out.println(Integer.toString(i1, 2));
	    
	    // this will cause exception
	    // "FF" will be interpreted as 255 not as -1
	    // even though you are calling Byte methods
	    // will exceed (-128, 127)
	    // b2 = Byte.parseByte("FF", 16);
	    // System.out.println(b2);
	    
	    // note that only difference between valueOf and ParseByte methods
	    // is that they return Byte and byte type, This is not a problem
	    // because of auto-boxing
	    b2 = Byte.parseByte("70", 8);
	    System.out.println(b2);
	    
	    System.out.println(Integer.toBinaryString(-1));
	    System.out.printf("Bytes of Byte: %d%n", Byte.BYTES);
	    System.out.printf("Bytes of Short: %d%n", Short.BYTES);
	    System.out.printf("Bytes of Integer: %d%n", Integer.BYTES);
	    System.out.printf("Bytes of Long: %d%n", Long.BYTES);
	    System.out.printf("Bytes of Float: %d%n", Float.BYTES);
	    System.out.printf("Bytes of Double: %d%n", Double.BYTES);
	    System.out.printf("Bytes of Character: %d%n", Character.BYTES);
	   
	 
	}
	
	
	
	
	
	
	
	
	
	

}
