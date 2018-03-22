/*
 * Author: Nathan Bromer
 * Assignment: 07
 * Due Date: 03/22/2018
 * IT2040C/Section 2/Semester: Spring 2018
 * Description: This program is made to look at a text file and find the longest word while also finding the most and least
 * of a letter.
 * 
 */
package bromernn_Assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		new Main().findLongestWords();// runs findLongestWords
		new Main().ammountOfLetters();// runs ammountOfLetters
	}

	// This program finds the longest word in the text file
	public String findLongestWords() throws FileNotFoundException {
		String longest_word = "";
		String current;
		Scanner sc = new Scanner(new File("words.txt"));// reads the file

		while (sc.hasNext()) {
			current = sc.next();
			// compares the two instances of the word lengths found and returns the bigger one
			if (current.length() > longest_word.length()) {
				longest_word = current;
			}
		}

		System.out.println("Longest Found Word :   " + longest_word);//prints the findings
		return longest_word;
	}

	//This program finds all of the letters in the text file
	public void ammountOfLetters() throws FileNotFoundException {
		// Creates a TreeMap with each individual character and an integer value of all
		// in the text file.
		TreeMap<Character, Integer> hashMap = new TreeMap<Character, Integer>();
		Scanner sc = new Scanner(new File("words.txt")); // Reads the Text file.
		while (sc.hasNext()) { // goes through and counts each individual letter and adds it into the map
			char[] chars = sc.nextLine().toLowerCase().toCharArray();
			for (Character c : chars) {
				if (!Character.isLetter(c)) {
					continue;
				} else if (hashMap.containsKey(c)) {
					hashMap.put(c, hashMap.get(c) + 1);
				} else {
					hashMap.put(c, 1);
				}
			}
		}
		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());// Print statement
		}
	}
}
