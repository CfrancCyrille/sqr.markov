package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	String SimpleSentence = "Il fait beau.";
	String ComplexSentence = "Il fait beau aujourd'hui mais demain il pleuvra.";

	@Test
	public void read_SimpleSentence_3Words() {
		MarkovData markovData = new MarkovData();
		
		markovData.read(SimpleSentence);
		int expected = 3;
		int actual = markovData.keyWordSize();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void read_ComplexSentence_8Words() {
		MarkovData markovData = new MarkovData();
		
		markovData.read(ComplexSentence);
		int expected = 8;
		int actual = markovData.keyWordSize();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void read_EmptySentence_0Words() {
		MarkovData markovData = new MarkovData();
		
		markovData.read(" ");
		int expected = 0;
		int actual = markovData.keyWordSize();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void renforceWord_NewKey_False() {
		MarkovData markovData = new MarkovData();
		
		boolean expected = false;
		
		String keyString = "Il fait";
		String wordToLearn = "beau";
		boolean actual = markovData.renforceWord(keyString, wordToLearn);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void renforceWord_OldKey_True() {
		MarkovData markovData = new MarkovData();
		
		boolean expected = true;
		
		String keyString = "Il fait";
		String wordToLearn = "beau";
		markovData.learnWord(keyString, wordToLearn);
		boolean actual = markovData.renforceWord(keyString, wordToLearn);
		
		assertEquals(expected, actual);
	}

}