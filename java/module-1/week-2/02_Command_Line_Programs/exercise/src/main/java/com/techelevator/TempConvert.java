package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the temperature as:");
		String value = input.nextLine();
		double temperature = Double.parseDouble(value);

		System.out.println("Is the temperature is in (C) Celsius, or (F)Fahrenheit? F: ");
		value = input.nextLine();

		if (value.equals("C")) {
			double farenheit = temperature * 1.8 + 32;
			System.out.println("The vale of C is " + farenheit + "F is");
		} else {
			double celsius = (temperature - 32) / 1.8;
			System.out.println("The value is F " + celsius + "C is ");
		}




		}


	}


