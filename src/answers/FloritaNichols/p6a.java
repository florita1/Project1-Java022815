package answers.FloritaNichols;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class p6a {
	
	public static String subMessage = "";
	public static String messageFlush = "";
	
	public static void main(String[] args) throws IOException {	
		// Open file with player cards and read in player1 and player2 hands
		List<List<String>> playerCards = openFile("src/resources/poker.txt");

		//System.out.println(playerCards.get(0));
		//System.out.println(playerCards.get(1));
		
		String[] testHand = {"6C","6D","TC","TH","QC"};
		checkPairs(testHand);
		checkSuit(testHand);
		
		String fullMessage = messageFlush + subMessage;
		System.out.println("This hand has a " + fullMessage);

	}

	public static List<List<String>> openFile(String filename) throws IOException {

		File file = new File(filename);
		//Creates a FileReader Object
		FileReader fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr); 
		String s = "";
		List<String> player1 = new ArrayList<String>();
		List<String> player2 = new ArrayList<String>();
		String hand1;
		String hand2;

		//Reads file line by line and assigns hand to respective player
		while((s = br.readLine()) != null) {
			//Substring line to take first 5 cards and assign them to player1
			//	second 5 cards go to player2
			hand1 = new String(s.substring(0, 14));
			hand2 = new String(s.substring(15, 29));
			player1.add(hand1);
			player2.add(hand2);
		} 

		//Creates a list with 2 elements and each element will be a list
		List<List<String>> players = new ArrayList<List<String>>();
		//Assigns player cards to list element 1 and 2
		players.add(player1);
		players.add(player2);
		fr.close();

		return players;
	}

	public static void checkPairs(String[] hand) {
		//String[] player1 = {"8C","8S","KC","9H","4S"};
		//String[] player2 = {"7D","2S","5D","3S","AC"};

		LinkedHashMap<String, Integer> cardCount = new LinkedHashMap<String,Integer>();
		String[] cards = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
		for(String card:cards) {
			cardCount.put(card, 0);
		}

		for (int i = 0; i < hand.length; i++) {	
			for(String c: cardCount.keySet()) {

				String x = hand[i];
				if(x.substring(0, 1).equals(c)) {
					int newVal = cardCount.get(c) + 1;
					cardCount.put(c,newVal);
				}				
			}
		}
		System.out.println("Cards in Deck: "+cardCount.values());
		int flushCount = 0;
		for(int cc : cardCount.values()){
			if(cc == 1)
				flushCount += 1;
			if(cc == 3 && cc == 2)
				subMessage = "full house";
			if(cc  == 2)
				subMessage += " pair";
			if(cc == 3)
				subMessage = "three of a kind";
			if(cc == 4)
				subMessage = "four of a kind";
		}
		if(flushCount == 5) messageFlush = "straight ";
	}
	
	public static void checkSuit(String[] hand) {
		//String[] player1 = {"8C","8S","KC","9H","4S"};
		//String[] player2 = {"7D","2S","5D","3S","AC"};

		LinkedHashMap<String, Integer> suitCount = new LinkedHashMap<String,Integer>();
		String[] suits = {"S","D","C","H"};
		for(String suit:suits) {
			suitCount.put(suit, 0);
		}

		for (int i = 0; i < hand.length; i++) {	
			for(String c: suitCount.keySet()) {

				String x = hand[i];
				if(x.substring(1, 2).equals(c)) {
					int newVal = suitCount.get(c) + 1;
					suitCount.put(c,newVal);
				}				
			}
		}
		System.out.println("Suits in Deck: "+suitCount.values());
		for(int cc : suitCount.values()){
			if(cc  == 5){
				Arrays.sort(hand);
				subMessage = "flush";
			}
		}
		
	}


}
