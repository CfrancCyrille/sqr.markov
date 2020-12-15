package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
	String simpleSentence= "juste un test"; 
	String complexSentence = "juste un test, mais plus compliqué";
	
	@Test
	public void read_SimpleSentence_3Words() {
		MarkovData markovData = new MarkovData();
		int expected = 3;
		
		markovData.read(simpleSentence);
		int actual = markovData.keyWordSize();
		
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void read_ComplexSentence_8Words() {
		MarkovData markovData = new MarkovData();
		int expected = 6;
		
		markovData.read(complexSentence);
		int actual = markovData.keyWordSize();
	}

}
