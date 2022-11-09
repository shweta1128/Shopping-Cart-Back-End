package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.PrivateKey;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter path to the word file: ");
		String filePath = userInput.nextLine();
		System.out.println("What is the search word you are looking for:");
		String searchWord = userInput.nextLine();
		File sourceFile = new File(filePath);
		System.out.println("Should the search be case sensitive?" + "(" + "Y" + "\\" + "N" + ")");
		String yesOrNo = userInput.nextLine();
		int lineCount = 0;
		//Boolean inWordFileText = true;
		try (Scanner fileInput = new Scanner(sourceFile)) {

			while (fileInput.hasNextLine()) {
				// Read the next line into 'lineOfText'
				String lineOfText = fileInput.nextLine();
				//String wordChangedToLowerCase = searchWord.toLowerCase();
				lineCount++;


				if (lineOfText.toLowerCase().contains(searchWord.toLowerCase()) && yesOrNo.equalsIgnoreCase("N") ){
					// Print the line
					//inWordFileText = true;
					System.out.println(lineCount + ") " + " " + lineOfText);

			    } else if (lineOfText.contains(searchWord) && yesOrNo.equalsIgnoreCase("Y")) {
					System.out.println(lineCount + ") " + " " + lineOfText);

				}

			}

		}
		catch(FileNotFoundException e){
			System.out.println("The file was not found: " + sourceFile.getAbsolutePath());

		}
		// Tell the user how many lines of content were found.
		//System.out.println("Found " + lineCount + " lines of text in " + filePath);
	}

}
