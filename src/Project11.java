/*
 * @author: Arboy Magomba
 * @version: 1.6
 * @title: Project 11
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Project11 {	
	
	// Store the common and personal dictionaries in ArrayLists instead of arrays. 
	// Call the refactored methods from objectives 1–3 in place of the old methods so
	// that the program works exactly like the original version
	public static void main(String[] args)
			throws FileNotFoundException, IOException {

			final String FILENAME_COMMON = "common-dictionary.txt";
			final String FILENAME_PERSONAL = "personal-dictionary.txt";
			String prompt = "Enter a word or 'quit' to stop: ";

			// Read the common dictionary and store the words in an ArrayList.
			ArrayList<String> common = readFile(FILENAME_COMMON);

			// Construct an ArrayList to store the personal dictionary.
			ArrayList<String> personal = new ArrayList<String>();
			

			// Read the personal dictionary, creating the file if it doesn't 
			// exist. Store the words in the personal ArrayList
			
			personal = readFile(FILENAME_PERSONAL);
			
			// Construct a Scanner to read user input from the keyboard.
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Spell Checker");
			System.out.println("-------------");
			
			// Perform a priming read to get the first word.
			System.out.print(prompt);
			String word = keyboard.nextLine().toLowerCase();
			
			// Enter the user input loop.
			while (!word.equals("quit")) {
				
				// Check if the word is in both ArrayLists 
				if (checkSpelling(word, common, personal)) {
					System.out.println("The word is spelled correctly.");
				} 
				else {
					System.out.println("The word was not found in the "
						+ "dictionary.");			
					System.out.println("Would you like to add it to your personal "
						+ "dictionary (yes/no)?");
					String response = keyboard.nextLine().toLowerCase();
					
					// If the user responds "yes"  add the word to the end of the arrayList and sort it.
					if (response.equals("yes")) { 
						personal.add(word); 
						Collections.sort(personal);
					}
				}
				
				
				// Get the next word from the user.
				System.out.println();
				System.out.print(prompt);
	
				
				if (keyboard.hasNextLine()) {
				    word = keyboard.nextLine().toLowerCase();
				} else {
				    break; // Exit the loop if there is no next line
				}
			}
			
			if (word.equals("quit")) {
				System.out.println("Goodbye!");
			}
			
			keyboard.close();
			writeFile(FILENAME_PERSONAL, personal);
		}
	
	
	
	
	// This method reads a file with a given name and returns the lines in an ArrayList of Strings
	public static ArrayList<String> readFile(String filename)
		throws FileNotFoundException, IOException {
		
		
		// Construct a file object for the file with the given name.
		File file = new File(filename);
		
		// If the file does not exist, create it.
		file.createNewFile();
		
		// Construct a scanner object to read the file.
		Scanner fileScanner = new Scanner(file);
		
		// Store each line of the file an ArrayList.	
		ArrayList<String> lines = new ArrayList<String>();
		
		
		while (fileScanner.hasNextLine()) {
			lines.add(fileScanner.nextLine());
		}
		
		fileScanner.close();
		
		return lines;
	}
	
	
	// This method checks if the String can be found in either of two ArrayLists.
	public static boolean checkSpelling(String word, ArrayList<String> common,
			ArrayList<String> personal) {
		
		if (Collections.binarySearch(common, word) >= 0) {
			return true;
		}
		
		if (Collections.binarySearch(personal, word) >= 0) {
			return true;
		}
		
		return false;
	
	}
	
	
	// The old method writes each String in an oversize array to a file with a given name.
	// The new method is given an ArrayList of Strings, rather than an oversize array.
	public static void writeFile(String fileName, ArrayList<String> list)
		throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter(fileName);
		
		for (int i = 0; i < list.size(); ++i) {
            writer.println(list.get(i));
        }
		
		writer.close();
		
	}
	
}

