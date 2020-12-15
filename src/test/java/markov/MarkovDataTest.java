package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	// public void read(String text)
	// public boolean renforceWord(String keyString, String wordToLearn)

	@Test
	/**
	 * GIVEN read
	 * WHEN Simple sentence
	 * THEN 3Words
	 */
	public void testReadSimpleSentences3Words() {
		MarkovData test = new MarkovData();
		test.read("Cesont 3 mots");
		int actual = test.keyWordSize();
		int expected = 3;
		assertEquals(expected, actual);	
	}

	@Test
	/**
	 * GIVEN renforceWord
	 * WHEN Simple sentence
	 * THEN true
	 */
	public void testrenforceWordSimpleSentencesTrue(){
		MarkovData test = new MarkovData();
		String laphrase = "ajout de un mots en plus";
		test.learnWord(laphrase, "plus");
		boolean result = test.renforceWord(laphrase, "plus");
		assertEquals(result, true);
	}

}
