import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner newInput = new Scanner(System.in);
		int userInputNumber = 0;
		boolean numberRetrieved = false;
		boolean isAPalindrome = false;
		
		System.out.println("Enter a number to select the method to be used.");
		System.out.println("1: String only method.");
		System.out.println("2: Stringbuilder class method.");
		
		do {
			try {
				System.out.println("Enter a number 1-2: ");
				userInputNumber = input.nextInt();
				
				if(!(userInputNumber < 1 || userInputNumber > 2)) {numberRetrieved = true;} else {System.out.println("Bad input.");}
				
			}
			catch(InputMismatchException ex) {
				System.out.println("Bad input.");
				input.nextLine();
			}
		} while(!numberRetrieved);
		
		System.out.println("Enter a phrase to determine if it is a palindrome: ");
		String userPhrase = newInput.nextLine();
		
		switch (userInputNumber) {
		case 1:
			isAPalindrome = stringComparison(userPhrase.toCharArray());
		case 2:
			isAPalindrome = stringBuilderComparison(userPhrase);
		}
		
		if(isAPalindrome){
			System.out.println("The phrase is a palindrome");
			System.exit(0);
		} else {
			System.out.println("The phrase is not a palindrome");
			System.exit(0);
		}
	}
	
	private static boolean stringComparison(char[] userInput) {
		int i1 = 0;
	    int i2 = userInput.length - 1;
	    while (i2 > i1) {
	        if (userInput[i1] != userInput[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;

	}
	
	private static boolean stringBuilderComparison(String userInput) {
		return userInput.equals(new StringBuilder(userInput).reverse().toString());
	}
}
