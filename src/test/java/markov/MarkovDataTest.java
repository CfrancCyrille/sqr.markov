package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	//@Test
	/*public void test() {
		fail("Not yet implemented");
	}*/

	@Test
	/**
	 * GIVEN read
	 * WHEN Simple sentence
	 * THEN true
	 */
	public void testReadSimpleSentenceTrue(){
		MarkovData data = new MarkovData();
		String sentence = "Simple Sentence";
		data.read(sentence);
		assertEquals(2, data.keyWordSize());
		
	}

	@Test
	/**
	 * GIVEN renforcedWord
	 * WHEN Simple Sentence
	 * THEN true
	 */
	public void testRenforcedWordTrue(){
		MarkovData data = new MarkovData();
		boolean result = true;
		String sentence = "Simple Sentence";
		data.learnWord(sentence, "Simple" );
		result = data.renforceWord(sentence, "simple");
		assertTrue(result);
	}
}
