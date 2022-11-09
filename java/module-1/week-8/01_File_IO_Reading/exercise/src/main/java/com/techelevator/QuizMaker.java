package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		//private static final PIPE_DELIMITER = "|";
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the fully qualified name of the file to read in for quiz questions:");
		String filePath = userInput.nextLine();
		System.out.println("What color is the sky?" );
		File sourceFile = new File(filePath);
	}

}
