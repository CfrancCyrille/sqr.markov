package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {

	MarkovData data = new MarkovData();
	String keyString = "bonjour";
	String wordtoLearn = "monsieur";

	@Test
	public void read_OneWord_List1(){
		data.read("");
		int expected = 1;
		int actual = data.keyWordSize();
		assertEquals(expected, actual);
	}

	@Test
	public void read_5Words_size5() {
		data.read("On trouve 5 mots ici");
		int expected  = 5;
		int actual = data.keyWordSize();
		assertEquals(expected, actual);
	}

	@Test
	public void read_OneBigWordWithSpecialChars_size1() {
		data.read("J'aime_les_c@r@ctères_sp&ci@ux");
		int expected  = 1;
		int actual = data.keyWordSize();
		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void read_null_NullPointerException() {
		data.read(null);
	}

	@Test
	public void renforceWord_firstWord_false(){
		boolean expected = false;
		boolean actual = data.renforceWord(keyString, wordtoLearn);
		assertEquals(expected, actual);
	}

	@Test
	public void renforceWord_notFirstWord_true(){
		boolean expected = true;
		data.learnWord("bonjour", "bonsoir");
		boolean actual = data.renforceWord(keyString, wordtoLearn);
		assertEquals(expected, actual);
	}
}
