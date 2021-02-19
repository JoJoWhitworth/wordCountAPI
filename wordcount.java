package com.joewhitworth.wordcountapi;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.lang.Object;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class wordcount {
	static File input = new File(
			"C:\\Users\\J-del\\eclipse-workspace\\WordCountAPI\\src\\com\\joewhitworth\\wordcountapi\\input.txt");

	// Regex string that removes special characters with the exception of: &, /,
	// whitespace
	static String removeSpecialCharacters = "[^\\w\\s\\/\\&]|_";

	static void wordCount() throws IOException {
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);

		String line;

		int wordCount = 0;
		int charCount = 0;
		double average = 0;

		while ((line = br.readLine()) != null) // While loop for counting characters and number of words
		{
			line = line.replaceAll(removeSpecialCharacters, "");

			String[] words = line.split(" "); // Determine what separates the words, in this instance it will be spaces.
			for (int i = 0; i < words.length; i++) // This counts the words in the text file
			{
				if (words[i].length() == 0) {
					continue;
				}
				wordCount++;
			}
			line = line.replaceAll("\\s", ""); // Removes whitespaces
			String[] characters = line.split("");
			for (int j = 0; j < characters.length; j++) // This counts the characters in the text file
			{
				charCount++;
			}
		}
		DecimalFormat df2 = new DecimalFormat("#.###"); // Formats the decimal to be 3DP
		average = (double) charCount / wordCount; // Calculation for the average word length
		System.out.println("Word Count = " + wordCount);
		System.out.println("Average word length = " + df2.format(average)); // 3 decimal place.
		fr.close();
		br.close();
	}

	static void numberOfWords() throws IOException {
		Map<Integer, Integer> lengthCount = new HashMap<Integer, Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			line = line.replaceAll(removeSpecialCharacters, "");

			while (line != null) {
				String[] words = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					if (words[i].length() == 0) {
						continue;
					}
					if (lengthCount.get(words[i].length()) == null) {
						lengthCount.put(words[i].length(), 1);
					} else {
						int newValue = lengthCount.get(words[i].length());
						newValue++;
						lengthCount.put(words[i].length(), newValue);
					}
				}
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
		}

		Map<Integer, Integer> sorted = new TreeMap<Integer, Integer>(lengthCount);
		int maxValue = 0;
		for (Object length : sorted.keySet()) {
			System.out.println("Number of words of length " + length + " is " + lengthCount.get(length));
			int num = (int) lengthCount.get(length);

			if (num > maxValue) {
				maxValue = num;
			}
		}
		int finalValue = maxValue;

		// Lambda functions to filter out lengthCount, so it returns the maxValue word
		// lengths
		String maxWordLengths = lengthCount.entrySet()
				.stream()
				.filter(entry -> finalValue == entry
				.getValue())
				.map(e -> e.getKey().toString()).collect(Collectors.joining(", "));

		System.out.println("The most frequently occurring word length is " + maxValue + ", for word lengths of " + maxWordLengths);
	}

	public static void main(String[] args) throws IOException {
		wordCount();
		numberOfWords();
	}
}
