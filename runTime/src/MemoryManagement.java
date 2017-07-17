import java.util.Random;

public class MemoryManagement {
	public void testMemory() {
		Runtime rt = Runtime.getRuntime();
		Random rd = new Random();
		System.out.printf("before array definition, totoal memory: %d, free memory: %d%n", rt.totalMemory(),rt.freeMemory());
		Integer []ints = new Integer[100000];
		System.out.printf("before array assignment, totoal memory: %d, free memory: %d%n", rt.totalMemory(),rt.freeMemory());
		for(int i=0; i<ints.length; i++) {
			ints[i] = new Integer(rd.nextInt(10000));
			
		}
		
		System.out.printf("after  array assignment, totoal memory: %d, free memory: %d%n", rt.totalMemory(),rt.freeMemory());
		
		for(int i=0; i<ints.length; i++) {
			ints[i] = null;
			
		}
		
		System.out.printf("before garbage collection, totoal memory: %d, free memory: %d%n", rt.totalMemory(),rt.freeMemory());
		// before this statement, unused objects are not released
		rt.gc();
		System.out.printf("after  garbage collection, totoal memory: %d, free memory: %d%n", rt.totalMemory(),rt.freeMemory());
		
		
	}
	
	

}
