package com.wordCounter.demo;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordCounterApplicationTests {

	@Test
		// I expect this test to pass since the entered data is normal.
	public void averageCalculation(){
		String input = "Hello world & good morning. The date is 18/05/2016";
		double expected = 4.556;
		//double actual = wordAndCharCount(average);
	}

	@Test
		// I expect this test to pass since the entered data is normal.
	void removesSpecialCharacters(){
		String input ="*%$^";
		int expected = 0;
		//int actual = wordAndCharCount(wordCount);
	}

	@Test
		// I expect this test to pass since the entered data is normal.
	void countingWords(){
		String input ="This is a test to see the number of words that can be counted.";
		int expected = 14;
		//int actual = wordAndCharCount(wordCount);
	}
	@Test
		// I expect this test to pass since the entered data is normal.
	void threeDP(){
		String input ="This is a test to see the number of words that can be counted.";
		double expected = 3.429;
		//double actual = wordAndCharCount(average);
	}
	@Test
		// I expect this test to pass since the entered data is normal.
	void mostFrequent(){
		String input ="Another input to test the most frequently occurring words in this sentence.";
		int expected = 3;
		//int actual = numberOfWords(maxValue);
	}
	@Test
		// I expect this test to pass since the entered data is normal.
	void wordLength(){
		String input = "Another input to test the most frequently occurring words in this sentence.";
		int expected = 2;
		//int actual =  numberOfWords(length);
	}
	
}
