package test.java;

import java.util.Arrays;

import main.java.InvertedIndex;

import org.junit.Test;

public class InvertedIndexTest {

	@Test
	public void test() {
		InvertedIndex invertedIndex = new InvertedIndex();
		invertedIndex.generate();
		String[] results = invertedIndex.get("music");
		System.out.println(results.length);
		System.out.println(Arrays.toString(results)); 
	}

}
