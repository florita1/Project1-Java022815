import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;


public class p5 {

	public static void main(String[] args) throws IOException {	
		// Open file with numbers and write sorted values to new file
		List<BigInteger> newNumbers = openFile("longnums.txt");
		writeFile("p5a.txt", newNumbers);
		
		// Read sorted values from file and calculate sum of first n digits
		List<BigInteger> numbers = openFile("p5a.txt");
		calculateSum(numbers, 10);
	}
	public static List<BigInteger> openFile(String filename) throws IOException {

		File file = new File(filename);
		//Creates a FileReader Object
		FileReader fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr); 
		// Reads lines from file and assigns first 100 numbers to list
		String s = "";
		BigInteger number;
		List<BigInteger> numbers = new ArrayList<BigInteger>();
		while((numbers.size() <= 99) && (s = br.readLine()) != null) {
			number = new BigInteger(s);
			numbers.add(number);
		} 
		
		//System.out.println(numbers.get(0));
		Collections.sort(numbers);
		//System.out.println(numbers.get(0));
		fr.close();
		
		return numbers;
	}
	
	public static void writeFile(String filename, List<BigInteger> fileContent) throws IOException {
		// creates the file
		File file2 = new File(filename);
		file2.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file2); 
		// Writes the content to the file
		for( BigInteger List : fileContent){
			writer.write(List + "\n");
		}
		writer.close();

	}
	
	public static void calculateSum( List<BigInteger> values, int n) {
		// Initializes variables for loop
		BigInteger sum = new BigInteger("0");
		String strBigInt = "";
		String trimVal = "";
		// Iterates through list argument of sorted numbers
		for(BigInteger value : values) {
			strBigInt = value.toString();
			// Trims value down to specified n digits
			trimVal = strBigInt.substring(n);
			// Add trimmed value to sum
			sum = sum.add(new BigInteger(trimVal));
		}
		System.out.println(sum);
	}

}
