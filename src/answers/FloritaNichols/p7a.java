import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class p7 {

	public static void main(String[] args) throws IOException {
		String values = primeArray();
		writeFile("primearray.txt", values);
	}
	
	public static String primeArray() {
		int i =0;
	       int num =0;
	       //Empty String
	       String primeNumbers = "";
	       for (i = 1; i <= 100; i++) { 		  	  
	    	   int counter=0; 	  
	    	   for(num =i; num>=1; num--) {
	    		   if(i%num == 0) {
	    			   counter += 1;
	    		   }
	    	   }
	    	   
	    	   if (counter == 2 && i!=0) {
	    		   //Appended the Prime number to the String
	    		   primeNumbers = primeNumbers + i + " ";	    	   }	
	       }

	       return primeNumbers;
	}
	
	public static void writeFile(String filename, String numbers) throws IOException {
		// creates the file
		File file2 = new File(filename);
		file2.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file2); 
		// Writes the content to the file
		writer.write(numbers);

		writer.close();

	}

}

