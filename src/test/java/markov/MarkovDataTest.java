package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	@Test
	public void testRead() {
		MarkovData nbMot = new MarkovData();
		nbMot.read("Il y a cinq mot");
		int actual = nbMot.keyWordSize();
		int expected = 5;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRead8() {
		MarkovData nbMot = new MarkovData();
		nbMot.read("Il y a pas du tout cinq mot");
		int actual = nbMot.keyWordSize();
		int expected = 8;
		assertEquals(expected, actual);
	}

}
