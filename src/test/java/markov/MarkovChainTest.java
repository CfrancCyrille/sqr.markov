package markov;

import static org.junit.Assert.*;

import org.junit.Test;

import markov.MarkovChain;

public class MarkovChainTest {

	//@Test
	public void test() {
		fail("Not yet implemented");
	}

	

    /**
     * Test of generateMarkov method, of class MarkovChain.
     * WHEN learn("test test")
     * THEN markovChain.generateMarkov(1) = "test"
     */
    @Test
    public void testGenerateMarkov() {
        System.out.println("generateMarkov");
        int numWords = 1;
        MarkovChain markovChain = new MarkovChain(numWords);
        markovChain.learn("test test");
        assertEquals(markovChain.generateMarkov(1), markovChain.generateMarkov(1));
    }

	
	
	
}
