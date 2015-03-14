package answers.FloritaNichols.PokerGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokerGameDemo {

	public static void main(String[] args) throws IOException {
		try {
			FileOperations data = new FileOperations("src/resources/pokertemp.txt");
			List<String> player1 = new ArrayList<String>();
			List<String> player2 = new ArrayList<String>();
			data.getData(player1,1);
			data.getData(player2,2);
			
			int p1Win = 0; int p1Count = 0;
			int p2Win = 0; int p2Count = 0;
			for(int x = 0; x <= player1.size()-1; x++) {
				PlayersHand p1Hand = new PlayersHand(player1.get(x));
				PlayersHand p2Hand = new PlayersHand(player2.get(x));
				PokerHand p1WinStrat = new PokerHand(p1Hand);
				PokerHand p2WinStrat = new PokerHand(p2Hand);
				p1Win = p1WinStrat.getRank();
				p2Win = p2WinStrat.getRank();
				System.out.println("Player 1 win rank: "+p1Win+" Player 2 win rank: "+p2Win);
				if(p1Win > p2Win) {
					System.out.println("Player 1 wins");
					p1Count += 1;
				} else if(p1Win == p2Win) {
					HighestHand check = new HighestHand(player1.get(x), player2.get(x), p1Win);
					if(check.winner1) {
						System.out.println("Player 1 wins");
						p1Count += 1;
					} else {
						System.out.println("Player 2 wins");
						p2Count += 1;
					}
				} else {
					System.out.println("Player 2 wins");
					p2Count += 1;
				}
			}
			System.out.print("Player 1: " + p1Count + " Vs. Player 2: " + p2Count);
			
		} catch (Exception e) {
			//System.err.println(e);
		}
		
		

	}

}
