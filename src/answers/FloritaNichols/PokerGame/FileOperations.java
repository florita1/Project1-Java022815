package answers.FloritaNichols.PokerGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileOperations {

	private String filename;
	private File file;
	private FileReader fr; 
	private BufferedReader br;

	public FileOperations(String startFilename) throws FileNotFoundException {
		setFilename(startFilename);
		file = new File(filename);
		//fr = new FileReader(file); 
		//br = new BufferedReader(fr);

	}

	public void getData(List<String> player, int playerNumber) throws IOException {
		fr = new FileReader(file); 
		br = new BufferedReader(fr);
		String s = "";
		String hand;

		//Reads file line by line and assigns hand to respective player
		while((s = br.readLine()) != null) {
			//Substring line to take first 5 cards and assign them to player1
			//	second 5 cards go to player2
			if(playerNumber == 1) {
				hand = new String(s.substring(0, 14));
			} else {
				hand = new String(s.substring(15, 29));
			}
			
			player.add(hand);			
		}
		fr.close();
		br.close();

	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
