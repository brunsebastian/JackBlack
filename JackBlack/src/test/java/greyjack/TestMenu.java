package greyjack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMenu {

	@Test
	public void test() {
		Navigation.lancerJeu();
		char prompt = Navigation.sc.nextLine().charAt(0);
		assertEquals(prompt, 'N');
	}

}
