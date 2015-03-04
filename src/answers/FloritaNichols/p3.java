//import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class p3 {
	
	public static void main(String[] args) {
		// Getting data from file
		int[][] data = getData();
		
		// Calculating Benfords probabilities from data
		float[] dataGroupA = calculateProb(data[0]);
		float[] dataGroupB = calculateProb(data[1]);
		
		//Print statements to display probabilities
		
		System.out.println("Benfords P(d): 30.1%, 17.6%, 12.5%, 9.7%, 7.9%, 6.7%, 5.8%, 5.1%, 4.6%");
		System.out.print("Data1 P(d): ");
		for( float c : dataGroupA){
			System.out.print(c + "% ");
		}
		System.out.println("");
		System.out.print("Data2 P(d): ");
		
		for( float c : dataGroupB){
			System.out.print(c + "% ");
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
				values[x-1] += 1;
			}
		}


		float[] prob = new float[9];

		for(int y = 0; y <= 8; y++){
			prob[y] = (float) ((values[y]/1000.0) * 100);
		}

		/*for( float c : prob){
			System.out.println(c);
		}*/
		
		return prob;

		
	}
	
	/*public void paint(Graphics g, float[] data) {
		Font font = new Font("Arial",Font.BOLD,15);
		g.setFont(font);
		for(int i  = 0; i < 9; i ++)
		{
			g.setColor(Color.BLUE);
			g.drawString(Integer.toString(i), 20, i * 50 + 30);
			g.setColor(Color.RED);
			g.fillRect(70, i * 50 + 10, 20, (int) data[i]);
			g.drawString(Float.toString(data[i]) + "%", 180, i * 50 + 35);
		}

		String msg = "Bar Chart from Year 2001 - 2005";
		g.setColor(Color.darkGray);

		font = new Font("Arial",Font.BOLD,20);
		g.setFont(font);
		g.drawString(msg, 50, 300);
	}*/


}