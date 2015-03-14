package answers.FloritaNichols.PokerGame;

public class pokerTest {
	public static void main(String[] args) {
		HighestHand check = new HighestHand("8C 8S AC 9H 9S", "9D 9S 8D 8S KC", 1);
		if(check.winner1) {
			System.out.println("player 1 wins");
		} else {
			System.out.println("player 2 wins");
		}
	}
}
