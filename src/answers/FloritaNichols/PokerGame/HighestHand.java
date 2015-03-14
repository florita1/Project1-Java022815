package answers.FloritaNichols.PokerGame;

import java.util.LinkedHashMap;

public class HighestHand {
	
	boolean winner1 = false;
	private int cardVal;
	private int handVal;
	private int rank;
	private String[] hand1;
	private String[] hand2;
	private LinkedHashMap<String,Integer> cardValues = null;
	
	public HighestHand(String startHand1, String startHand2, int setRank) {
		setCardValues();
		//System.out.println(cardValues.keySet());
		//System.out.println(cardValues.values());
		hand1 = startHand1.split(" ");
		hand2 = startHand2.split(" ");
		rank = setRank;
		chooseWinner();
	}
		
	public int getHighCard(String[] testHand) {
		cardVal = 0;
		for(String x : testHand) {
			for(String c: cardValues.keySet()) {
				if(x.substring(0, 1).equals(c)) {
					if(cardVal <= cardValues.get(c)){
						cardVal = cardValues.get(c);
					}
				}
			}
		}
		//System.out.println(cardVal);
		return cardVal;
	}
	
	public int getHighHand(String[] testHand) {
		handVal = 0;
		for(String x : testHand) {
			handVal += cardValues.get(x.substring(0, 1));
		}
		//System.out.println(handVal);
		return handVal;
	}
	
	public void chooseWinner() {
		int rank1 = 0;
		int rank2 = 0;
		if(rank == 0) {
			rank1 = getHighCard(hand1);
			rank2 = getHighCard(hand2);
		} else {
			rank1 = getHighHand(hand1);
			rank2 = getHighHand(hand2);
		}
		if(rank1 > rank2) {
			winner1 = true;
		}
	}


	public LinkedHashMap<String,Integer> getCardValues() {
		return cardValues;
	}


	public void setCardValues() {
		this.cardValues = new LinkedHashMap<String,Integer>();
		String[] cards = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
		int val = 1;
		for( String card : cards) {
			this.cardValues.put(card, val += 1);
		}
	}

}
