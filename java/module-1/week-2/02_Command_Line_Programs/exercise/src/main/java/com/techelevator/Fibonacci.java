package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int sum ;
		int firstNumber = 0;
		int secondNumber = 1;

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number as:");
		String value = input.nextLine();
		int fibonacci = Integer.parseInt(value);
		// int [] number = new int [fibonacci];



      for (int i = 0; i <= fibonacci; i ++  ) {
		  i = firstNumber + secondNumber;
		  firstNumber = secondNumber;
		secondNumber = i;
		if ( i == 0) {
			System.out.println( "0 "+ "1");


		} else {
			System.out.println( " " + i );
		}



	  }
	}

}
