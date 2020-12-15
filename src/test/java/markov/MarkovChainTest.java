package markov;

import static org.junit.Assert.*;

import org.junit.Test;

import app.MarkovApp;

public class MarkovChainTest {


	// public void learn(String text)
	// public String generateMarkov(int numWords)

	@Test
	public void testlearn() throws Exception {
		MarkovChain test = new MarkovChain(5);
		String data = MarkovApp.readFileAsString("pe ja jalieke dhhs jejskalak jac");
		test.learn(data);
		assertEquals(5, test.getSize());
	}

	
}
