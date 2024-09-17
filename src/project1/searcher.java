package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class searcher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("data.txt");
		Scanner fileInput = new Scanner(file);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type out the debt limit, search phrase, and state abbreviation in the listed order with a space in between each.");
		int limit = input.nextInt();
		String phrase = input.next().toUpperCase();
		String abbr = input.next().toUpperCase();
		
		report(limit, phrase, abbr, file);		
		
		
	}
	
	public static void report(int limit, String phrase, String abbr, File file) throws FileNotFoundException {
		Scanner fileInput = new Scanner(file);
		int aboveLimit = 0, debtFree = 0, searchTrue = 0, inState = 0; //US report
		int stateLimit = 0, stateFree = 0, stateTrue = 0;
		int max = Integer.MIN_VALUE, counter = 0, stateMax = Integer.MIN_VALUE; //comparatives
		String maxDebtAcc = "", stateHigh = "";


		while(fileInput.hasNext()) {
			String name = fileInput.next();
			String state = fileInput.next();
			int debt = fileInput.nextInt();
			
			//counts amount above the debt limit
			if(debt > limit) {
				aboveLimit++;
				if(state.equals(abbr)) {
					stateLimit++;
				}
			}
			
			//counts amount debt free
			if(debt == 0) {
				debtFree++;
				if(state.equals(abbr)) {
					stateFree++;
				}
			}
			
			//counts amount of people flagging true on the search phrase
			if(name.substring(0,1).equals(phrase)) {
				searchTrue++;
				if(state.equals(abbr)) {
					stateTrue++;
				}
			}
			
			//identifies highest debt user and amount
			if(debt > max) {
				max = debt;
				maxDebtAcc = name;
			}
			
			//counts amount in state
			if(state.equals(abbr)) {
				inState++;
				if(debt > stateMax) {
					stateMax = debt;
					stateHigh = name;
				}
				
			}
			counter++;
		}
		
		System.out.print("U.S. Report\r\n"
				+ "Customers: " + counter + "\r\n"
				+ "Highest debt: " + maxDebtAcc + "\r\n"
				+ "Customer names that start with " + phrase + ": " + searchTrue + "\r\n"
				+ "Customers with debt over $" + limit + ": " + aboveLimit + "\r\n"
				+ "Customers debt free: " + debtFree + "\r\n"
				+ "\r\n"
				+ abbr + " Report\r\n"
				+ "Customers: " + inState + "\r\n"
				+ "Highest debt: " + stateHigh + "\r\n"
				+ "Customer names that start with " + phrase + ": " + stateTrue + "\r\n"
				+ "Customers with debt over "  + limit + ": " + stateLimit + "\r\n"
				+ "Customers debt free: " + stateFree);


	}
}
