package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {

	String[] data = new String[] {
			"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
			"Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
			"Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
			"This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
			"Another book with music related content" };

	Map<String, List<Integer>> inverted_index = new HashMap<String, List<Integer>>();

	public void generate() {
		List<Integer> sentences;
		String line;
		for (int i = 0; i < data.length; i++) {
			// Replacing special characters
			line = data[i].replaceAll(",", "").replaceAll(" '", " ").replaceAll("' ", " ").replaceAll("-", " ");
			String[] splitLine = line.split(" ");
			
			for (String word : splitLine) {
				sentences = new ArrayList<Integer>();
				if (inverted_index.containsKey(word.toLowerCase())) {
					sentences = inverted_index.get(word.toLowerCase());
				}
				if (!sentences.contains(i)) {
					sentences.add(i);
				}
				inverted_index.put(word.toLowerCase(), sentences);
			}
		}
	}

	public String[] get(String word) {
		List<Integer> indexes = inverted_index.get(word.toLowerCase());
		String[] results = new String[indexes.size()];
		
		for (int i = 0; i < indexes.size(); i++) {
			results[i] = "\"" + data[i] + "\"";
		}
		return results;
	}

}
