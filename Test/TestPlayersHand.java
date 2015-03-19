import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import answers.FloritaNichols.PokerGame.PlayersHand;

public class TestPlayersHand {

	static PlayersHand Phand;
	static String s1;

	@BeforeClass
	public static void createHands() {
		s1 = "AD 2C 3S 4S 5D";
		Phand = new PlayersHand(s1);
	}

	@Test
	public void checkSuits() {
		LinkedHashMap<String, Integer> testMap = new LinkedHashMap<String, Integer>();
		testMap.put("S", 2);
		testMap.put("D", 2);
		testMap.put("C", 1);
		testMap.put("H", 0);
		LinkedHashMap<String, Integer> expected_output = Phand.checkSuits();
		assertEquals(expected_output, testMap);
	}

	@Test
	public void checkCards() {
		LinkedHashMap<String, Integer> testMap = new LinkedHashMap<String, Integer>();
		testMap.put("2", 1);
		testMap.put("3", 1);
		testMap.put("4", 1);
		testMap.put("5", 1);
		testMap.put("6", 0);
		testMap.put("7", 0);
		testMap.put("8", 0);
		testMap.put("9", 0);
		testMap.put("T", 0);
		testMap.put("J", 0);
		testMap.put("Q", 0);
		testMap.put("K", 0);
		testMap.put("A", 1);
		LinkedHashMap<String, Integer> expected_output = Phand.checkCards();
		assertEquals(expected_output, testMap);
	}

}
