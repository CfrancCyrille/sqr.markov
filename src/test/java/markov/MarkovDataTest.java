package markov;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class MarkovDataTest {
	
	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	
	/** GIVEN_WHEN_THEN */
	
	public void read_list_listt() {
		
		List<String> expected = new ArrayList<String>();
		expected.add("hello");
		expected.add("how");
		expected.add("are");
		expected.add("you");		
		
		String text="hello how are you";
		
		MarkovData m = new MarkovData();
		m.read(text);
		
		for(int i = 0;i<expected.size();i++)
		{
			
			String actual = m.getKeyWord(i);
			assertEquals(expected.get(i), actual);
			
		}
			
	}
	

}
