package com.techelevator;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
//		System.out.println(" ");
//		Integer number = Integer.valueOf(userInput.nextLine());
//		System.out.println("If the number divisible by 3 : ");
//		Integer divisibleBy3 = Integer.valueOf(userInput.nextLine());
//		System.out.println("If the number divisible by 5 :");
//		Integer divisibleBy5 = Integer.valueOf(userInput.nextLine());
//		System.out.println("If the number divisible by 3 & 5 : ");
//		Integer divisibleBy3And5 = Integer.valueOf(userInput.nextLine());
		System.out.println("Enter the destination file : ");
		String destination = userInput.nextLine();
		if (destination.isBlank()){
			System.out.println("invalid input");
			System.exit(1);// this stops the program  or terminated
		}

		File object = new File(destination);
		int answer = 0;
		try (PrintWriter writer = new PrintWriter(object)) {
			// Write the text in uppercase to the output file.


			 for (int i =1; i < 301; i++){


				if (i % 3 == 0 && i % 5 == 0 ) {
					writer.println("FizzBuzz");
				} else if (i % 5 == 0){
					writer.println("Buzz");
				} else if (i % 3 == 0  ) {
					writer.println("Fizz");

				} else {
					writer.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			// Could not find the file at the specified path.
			System.err.println("The file does not exist. +  " );

		}

	}



}
