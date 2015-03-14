package answers.FloritaNichols.PokerGame;

import java.util.LinkedHashMap;

public class PlayersHand {
	private LinkedHashMap<String, Integer> cardCount;
	private LinkedHashMap<String, Integer> suitCount;
	private String[] hand;

	public PlayersHand(String startHand) {
		setHand(startHand.split(" "));

		suitCount = new LinkedHashMap<String,Integer>();
		String[] suits = {"S","D","C","H"};
		for(String suit:suits) {
			suitCount.put(suit, 0);
		}

		cardCount = new LinkedHashMap<String,Integer>();
		String[] cards = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
		for(String card:cards) {
			cardCount.put(card, 0);
		}
	}
	
	public LinkedHashMap<String,Integer> checkSuits() {
		for(String x : hand) {
				for(String c: suitCount.keySet()) {
					if(x.substring(1, 2).equals(c)) {
						int newVal = suitCount.get(c) + 1;
						suitCount.put(c,newVal);
					}				
				}
		}
		//System.out.println("Suits in Deck: "+suitCount.values());
		return suitCount;
	}

	public LinkedHashMap<String,Integer> checkCards() {
		for(String x : hand) {	
				for(String c: cardCount.keySet()) {
					if(x.substring(0, 1).equals(c)) {
						int newVal = cardCount.get(c) + 1;
						cardCount.put(c,newVal);
					}				
				}
		}

		//System.out.println("Cards in Deck: "+cardCount.values());
		return cardCount;
	}

	public String[] getHand() {
		return hand;
	}

	public void setHand(String[] hand) {
		this.hand = hand;
	}

}
