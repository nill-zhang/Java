public class ProcessOp {
	
	
	
	public static void testSubProcess() {
		

    	Runtime r = Runtime.getRuntime();
    	java.lang.Process pNotepad = null;
    	System.out.println("avalible processors: "+ r.availableProcessors());
    	
    	try {
    	    pNotepad = r.exec("notepad");
    	    Thread.sleep(5000);
    	    System.out.println("is notepad alive? " + pNotepad.isAlive());
    	    pNotepad.destroy();
    	    System.out.println("is notepad alive? " + pNotepad.isAlive());
    	    pNotepad.waitFor();
    	}catch (Exception e) {
			System.out.println(e);
		}
    	if(pNotepad.exitValue() !=0) {
    		
    		System.out.println("notepad was terminated abnormally!");
    		
    	}
    	
    	
	}
	
    public static void main(String args[]) {
    	
    	MemoryManagement mm = new MemoryManagement();
    	SystemOp so = new SystemOp();
    	so.testSystem();
        // mm.testMemory(); 
    	// testSubProcess();
    	
    	
    	
    }
	
	
	
	
}
