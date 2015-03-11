package answers.FloritaNichols;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class p6a {
	
	public static int rank = 0;
	public static boolean flush = false;
	public static boolean strait = false;
	
	public static void main(String[] args) throws IOException {	
		// Open file with player cards and read in player1 and player2 hands
		List<List<String>> playerCards = openFile("src/resources/poker.txt");

		//System.out.println(playerCards.get(0).size());
		//System.out.println(playerCards.get(1));
		
		List<String> player1 = playerCards.get(0);
		//System.out.println(player1.get(0));
		
		for(int hands = 0; hands <= 5; hands++) { //playerCards.get(0).size()
			System.out.println(player1.get(hands));
			rank = 0;
			flush = false;
			strait = false;
			String[] hand = player1.get(hands).split(" ");
			checkSuit(hand);
			checkPairs(hand);
			System.out.println("Hand rank: " + rank);
			
			if(rank == 0) {
				Arrays.sort(hand);
				System.out.println(hand[4]);
			}
		
		}

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
		String[] cards = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
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
		
		if(cardCount.containsValue(2) && cardCount.containsValue(3)) rank = 6;
		if(cardCount.containsValue(4)) rank = 7;
		if(cardCount.containsValue(3)) rank = 3;
		
		int pairCount = 0;
		for(int pair:cardCount.values()){
			if( pair == 2){
				pairCount += 1;
			}
		}
		if(pairCount == 1) rank = 1;
		if(pairCount == 2) rank = 2;
		
		if(cardCount.containsValue(1)) {
			try {
			for(int v = 0; v<=12; v++) {
				if(cardCount.get(cards[v]).equals(1)) {
					if(cardCount.get(cards[v+1]).equals(1)) {
						if(cardCount.get(cards[v+2]).equals(1)) {
							if(cardCount.get(cards[v+3]).equals(1)){
								if(cardCount.get(cards[v+4]).equals(1)){
									strait = true;
								}}}}}
			}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(strait == true) {
			rank = 4;
			if(flush == true){
				rank = 8;
			}
		}
		
		
		String[] faces = {"A","T","J","Q","K"};
		int royalCount = 0;
		for(String face : faces) {
			if(cardCount.get(face) == 1) {
				royalCount += 1;
			}
		}
		
		if(royalCount == 5 && flush) {
			// Setting rank for Royal Flush if a suit appears 5 times in checkSuit (flush is true)
			rank = 9; 
		}
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
		
		if(suitCount.containsValue(5)) {
			flush = true;
			rank = 5;
		}
		
		
	}


}
