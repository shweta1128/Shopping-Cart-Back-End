package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter length as:");
		String value = input.nextLine();
		double length = Double.parseDouble(value);

		System.out.println("Is the measurement is in (m)meter or (f)feet ? f :");
		 value = input.nextLine();

		 if (value.equals("m")) {
			double foot = length * 3.2808399;
			System.out.println("The value of m is "  + foot + " f ");
		 } else {
			 double meter =  length * 0.3048;
			 System.out.println("The value of f is "  + meter + " m ");
		 }



	}

}
