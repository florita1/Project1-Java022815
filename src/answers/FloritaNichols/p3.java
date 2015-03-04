import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.CharBuffer;



public class p3 {
	
	public static void main(String[] args) {
		int[][] data = getData();
		float[] dataGroupA = calculateProb(data[0]);
		float[] dataGroupB = calculateProb(data[1]);
		for( float c : dataGroupA){
			System.out.print(c + " ");
		}
		
		System.out.println("");
		
		for( float c : dataGroupB){
			System.out.print(c + " ");
		}
		
	}

	public static int[][] getData() {

		File file = new File("benfords_data.txt");
		// creates the file

		String[] valueStr = null;
		int[] data1 = new int[1000];
		int[] data2 = new int[1000];

		try {
			file.createNewFile();
			//Creates a FileReader Object
			FileReader fr = new FileReader(file);
			char[] bytes = new char[(int) file.length()];
			fr.read(bytes); // reads the content to the array
			valueStr = new String(bytes).replaceAll("[^0-9,]","").split(",");
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int i = 0; i<= (valueStr.length-1); i++){		
			if(i >= 0 && i <= 999){
				//System.out.println(valueStr[i]);
				data1[i] = Integer.valueOf(valueStr[i]);
			} else {
				//System.out.println(valueStr[i]);
				data2[i-999] = Integer.valueOf(valueStr[i]);
			}
		}
		data1[0] = 2;
		data1[data1.length-1] = 443;
		data2[0] = 2;
		int[][] dataTransfer = { data1, data2 };
		
		return dataTransfer;
	}


	public static float[] calculateProb(int[] dataGroup){
		int[] values = new int[9];

		for(int x : dataGroup){
			if(x <= 9){
				//System.out.print(x + " ");
				values[x-1] += 1;
				//System.out.println(values[x-1]);
			}
		}

		//System.out.println(values[5]);

		float[] prob = new float[9];

		for(int y = 0; y <= 8; y++){
			//System.out.println(values[y]);
			prob[y] = (float) ((values[y]/1000.0) * 100);
		}

		/*for( float c : prob){
			System.out.println(c);
		}*/
		
		return prob;

		// method for finding the probability using WIKI equation
		// method to graph probability on bar graph
		// possible step: add interface that asks client if they would like to see the
		//	probability displayed for the data set.
	}


}