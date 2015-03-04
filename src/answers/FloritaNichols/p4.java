import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class p4 {

	public static void main(String[] args) throws IOException {
		String[] sortedNames = openFile("names.txt");

		writeFile("p4aNames.txt", sortedNames);

		int[] nameValues = nameValue();

		//writeFile("p4bNames.txt", nameValues);

		int totalNameScore = 0;
		for (int i = 0; i < nameValues.length; i++){
			totalNameScore += nameValues[i];
		}
		
		System.out.print(totalNameScore);

	}

	public static String[] openFile(String filename) throws IOException {

		File file = new File(filename);
		//Creates a FileReader Object
		FileReader fr = new FileReader(file); 
		char [] a = new char[(int) file.length()];
		fr.read(a); // reads the content to the array
		String[] names = new String(a).replace("\"", " ").split(",");
		Arrays.sort(names);
		//for(String c : names)
		//System.out.println(c); //prints the characters one by one
		fr.close();
		return names;
	}

	public static <E> void writeFile(String filename, E[] fileContent) throws IOException {
		// creates the file
		File file2 = new File("p4aNames.txt");
		file2.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file2); 
		// Writes the content to the file
		for(E element : fileContent){
			writer.write(element + ",");
		}
		//writer.flush();
		writer.close();

	}

	public static int[] nameValue() throws IOException{
		String[] names = openFile("p4aNames.txt");
		int[] nameValues = new int[names.length];
		//System.out.print(names[3]);
		for(int name = 0; name<= (names.length-1); name++){ //names.length
			int letterVal = 0;
			int nameVal = 0;
			int listVal = 0;
			char[] word = names[name].trim().toCharArray();

			for(char letter : word){
				letterVal = (int) letter;
				nameVal += letterVal;
				//System.out.println(letter +" "+letterVal+" "+nameVal);
			}

			//System.out.println(nameVal);
			listVal = (name+1) * nameVal;
			//System.out.println(listVal);
			nameValues[name] = listVal;

		}
		return nameValues;
	}

}
