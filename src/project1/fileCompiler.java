package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class fileCompiler {
//all methods below were used to generate the list of information needed
	public static String[] gen(int length, String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner fileInput = new Scanner(file);
		
		String[] arr = new String[length];
		
		for(int i = 0; i < length; i++) {
			arr[i] = fileInput.nextLine();
		}
			
		fileInput.close();
		
		return arr;
	}
	
	public static void fileGen() throws FileNotFoundException {
		String[] states = gen(50, "states.txt");
		String[] names = gen(200, "names.txt");
				
		Random rand = new Random();
		
		System.out.println(rand.nextInt(50));
		
		PrintWriter fileOutput = new PrintWriter("projectLab2.txt");
		
		for(int i = 0; i < 10000; i++) {
			String one = states[rand.nextInt(50)];
			String two = names[rand.nextInt(200)];
			int three = rand.nextInt(10000);
			fileOutput.println(two + " " + one + " " + three);
		}
		
		fileOutput.close();
	}
}
