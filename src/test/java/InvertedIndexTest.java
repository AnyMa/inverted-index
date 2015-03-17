package test.java;

import java.util.Arrays;

import main.java.InvertedIndex;

import org.junit.Assert;
import org.junit.Test;

public class InvertedIndexTest {

	@Test
	public void testExistingWord() {
		InvertedIndex invertedIndex = new InvertedIndex();
		invertedIndex.generate();
		String[] results = invertedIndex.get("music");
		System.out.println(results.length);
		System.out.println(Arrays.toString(results));
		Assert.assertEquals(2, results.length);
		Assert.assertEquals(
				Arrays.toString(results),
				"[\"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad\", \"Another book with music related content\"]");
	}

	@Test
	public void testNonExistingWord() {
		InvertedIndex invertedIndex = new InvertedIndex();
		invertedIndex.generate();
		String[] results = invertedIndex.get("nonexistingword");
		System.out.println(results.length);
		System.out.println(Arrays.toString(results));
		Assert.assertEquals(0, results.length);
		Assert.assertEquals(Arrays.toString(results), "[]");
	}

}
