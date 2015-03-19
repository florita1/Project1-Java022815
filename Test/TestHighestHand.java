import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import answers.FloritaNichols.PokerGame.HighestHand;

public class TestHighestHand {

	static HighestHand HHand;
	static String s1;
	static String s2;

	@BeforeClass
	public static void createHands() {
		s1 = "2D 5C 5S QS 7D";
		s2 = "9C AC KC 9D 2H";
		HHand = new HighestHand(s1, s2, 1);
	}

	@Test
	public void getHighCard() {
		String[] s1N = s1.split(" ");
		int expected_output = HHand.getHighCard(s1N);
		assertEquals(expected_output, 11);
		// fail("Not yet implemented");
	}

	@Test
	public void getHighHand() {
		String[] s2N = s2.split(" ");
		int expected_output = HHand.getHighHand(s2N);
		assertEquals(expected_output, 42);
		// fail("Not yet implemented");
	}

}
