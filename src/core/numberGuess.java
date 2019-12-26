package core;

import java.util.Scanner;

public class numberGuess {
	
	private static int target=(int) (Math.random() * 100) + 1;
	private static Scanner s= new Scanner(System.in);

	public static void main(String[] args) {
		
	//	System.out.println(target);
		play();
	}

	
	private static int getInput() {
		
		return s.nextInt();
	}
	
	private static void play() {
		for(int i=0;i<5;i++) {
			int input=getInput();
			if(input==target) {
				System.out.println("Correct!");
				return;
			} else {
				System.out.println("wrong, Try Again..");
			}
		}
	}
}
