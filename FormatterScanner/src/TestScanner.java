import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestScanner {
	
	public static void testFromString() {
		
		int age = 0;
		double weight = 0.000;
		
		String string = "Sfzhang is 31 years old, he is 71.33 kg and is a Chinese!";
		
		Scanner scanner = new Scanner(string);
		while(scanner.hasNext()) {
		
			System.out.println(scanner.next());
	    	
			if (scanner.hasNextInt()){
			    age = scanner.nextInt();
		    }

		    if (scanner.hasNextDouble()){
			    weight = scanner.nextDouble();
		    }
		}
		
		scanner.close();
		scanner = new Scanner("My name is Alex, I am 30 years old, I have a daughter Blabla bla");
		//scanner.findInLine("is ");
		scanner.findWithinHorizon("is ", 200);
		if(scanner.hasNext()){
			// remove the trailing ','
			System.out.println("are you trying to find? " + scanner.next().replaceAll(",", ""));
			
		}
		
		
		System.out.println("Sfzhang: age: " + age + " weight: " + weight);
		 
		
}
	
	
	public static void testFromFile() {
		
		String filename = "testScanner.txt";
		
		try (FileWriter fWriter = new FileWriter(filename)){
		    fWriter.write("sfzhang,         404-55 Oakmount Road, 30, Male, 70.33");
		}catch (IOException e) {
			System.out.println(e);
		}
		
		// note that I can use two statements in try
		try (FileReader fReader = new FileReader(filename);  Scanner scanner = new Scanner(fReader)){
			// note the delimiter here, it uses a regular expression
		    scanner.useDelimiter(", *");
		    while (scanner.hasNext()) {
		    	if(scanner.hasNextInt()) {
		    		System.out.println("age: " + scanner.nextInt());
		    	}else if (scanner.hasNextDouble()) {
		    		System.out.println("weight: " + scanner.nextDouble());
				}else {
					System.out.println("other: " + scanner.next());
				}			
			}
		}catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			;
		}
		// delete the temporary test file.
		Path path = Paths.get(filename);
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
		
	}
	
	
	public static void testFromStdin() {
		
		try(Scanner scanner = new Scanner(System.in)){
		   
			while (scanner.hasNext()) {
			    
				if(scanner.hasNextInt()) {
				
			      	System.out.println(scanner.nextInt());
				
			    }
			
			    if(scanner.next().equals("done")) {
				
			    	break;
		    	}
			
		     }
		
		}
	
		
	}
	

}
