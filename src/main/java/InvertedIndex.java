package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {

	String[] data = new String[] {
			"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
			"Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
			"Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
			"This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
			"Another book with music related content" };

	Map<String, Set<Integer>> inverted_index = new HashMap<String, Set<Integer>>();

	public void generate() {
		Set<Integer> sentence;
		String line;
		for (int i = 0; i < data.length; i++) {
			// Replacing special characters
			line = data[i].replaceAll(",", "").replaceAll(" '", " ").replaceAll("' ", " ").replaceAll("-", " ");
			String[] splitLine = line.split(" ");
			
			for (String word : splitLine) {
				if (!inverted_index.containsKey(word.toLowerCase())) {
					sentence = new HashSet<Integer>();
				} else {
					sentence = inverted_index.get(word.toLowerCase());
				}
				sentence.add(i);
				inverted_index.put(word.toLowerCase(), sentence);
			}
		}
	}

	public String[] get(String word) {
		Set<Integer> indexes = inverted_index.get(word.toLowerCase());
		if (indexes == null) {
			return new String[0];
		}
		String[] results = new String[indexes.size()];
		
		Iterator<Integer> it = indexes.iterator();
		int i = 0;
		while (it.hasNext()) {
			results[i] = "\"" + data[it.next().intValue()] + "\"";
			i++;
		}
		return results;
	}

}
