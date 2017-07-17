public class SystemOp {
	
	public void reverse() {
		byte [] a = {'a', 'b', 'c', 'd', 'e'};
		System.out.println("a            :" + new String(a));
    	byte [] b = new byte[a.length];
    	for (int i=a.length-1; i>=0; i--) {
    		System.arraycopy(a, i, b, a.length-1-i, 1);
    	}
    	
    	System.out.println("reverse of a: " + new String(b));
		
	}
    public void testSystem() {
    	reverse();
    	System.out.println("line separator: " + System.lineSeparator());
    	
    	
    	
    	
    }
}
