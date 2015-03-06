import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ConsecutiveP7b {

	public static void main(String[] args) throws IOException {
		int[] values = openFile("primearray.txt");
		fillArray(values, 0, 4);
		fillArray(values, 0, 9);
		
	}
	
	public static int[] openFile(String filename) throws IOException {

		File file = new File(filename);
		//Creates a FileReader Object
		FileReader fr = new FileReader(file); 
		char [] a = new char[(int) file.length()];
		fr.read(a); // reads the content to the array
		String[] values = new String(a).split(" ");
		int[] primeValues = new int[values.length];
		for(int x = 0; x <= values.length-1; x++) {
			primeValues[x] = Integer.parseInt(values[x]);
		}
		fr.close();
		
		return primeValues;
	}
	
	public static void fillArray(int[] primeArray, int low, int high) {
		// Elements in the array that are between the specified indices
		int elementsInSlice = high - low;
		// The amount of numbers that are between the low index and high index
		int valuesInBetween = primeArray[high] - primeArray[low];
		
		// The difference will give you the amount of numbers that are missing
		//	to make a consecutive list from the low index to the high index
		int missingValues = valuesInBetween - elementsInSlice;
		
		System.out.println(missingValues);		
		
	}

}
