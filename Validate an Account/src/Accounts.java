

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Accounts {
	
	// A method called "validator" that accepts an account number as its argument & returns a Boolean
	static int validNumbers[];
	public static boolean validator(String acNum){
		for (int i = 0; i < validNumbers.length; i++) {
			if (Integer.parseInt(acNum) == validNumbers[i]) {
				return true;
			}
		}
		// Must return false in order to check if number is valid 
		return false;
	}
		// method that adds each digit of a valid account number and returns the calculated value
		public static int calculator(String validNum) {
			int sum = 0;
			for(int i = 0; i < validNum.length(); i++) {
				sum = sum + Integer.parseInt(String.valueOf(validNum.charAt(i)));
			}
			// Displaying sum of account numbers
			return sum;
		}
		
		/*
		 *  Asking the user to enter an account number and display if it is valid.
		 *  If account number is incorrect, the program will ask to continue or not (y/n).
		 *  If valid, calculations will be performed 
		 */
		
		public static void main(String args[])throws IOException{
				  validNumbers = new int[200];
				  Scanner sc1 = new Scanner(new File("validNumbers.txt"));
				  int i = 0;  
				  while(sc1.hasNextInt()) {
					  validNumbers[i++] = sc1.nextInt();			  		  
			  }
			  
			// Creating loop for what the user enters
			  boolean newValidator = true;
			  try (Scanner scanner = new Scanner(System.in)) {
				// User inputs
				  while(newValidator) {
					  System.out.print("Enter the account number: ");
					  String num = scanner.nextLine();
					  
					  // If the account is found, the calculations will get displayed 
					  if(validator(num)) {
						  System.out.print("The calculated value to this account is: " + calculator(num));
					  }
					  else {
						  System.out.println("Not valid account number");
							  newValidator = true;					
					  }
					  // The loop to keep asking is the user wants to enter in another account number
					  System.out.println("\nWould you like to enter another account number? (y/n)");
					    String ans = scanner.nextLine();
					  
					    if (ans.equals("n") || ans.equals("N")) {
					        newValidator = false;       
					    }
					}
			}
			  System.out.println("** Program Exit **");
			  } 
		  }

/*-------------------------------------------------------------------------------------------------------------
 * -- When the account is entered (3) wrong & then terminated (One run with three incorrect numbers) --
 *	
 *  Enter the account number: 789456
 *	Not valid account number
 *
 *	Would you like to try again? (y/n)
 *	y
 *	Enter the account number: 456123
 *	Not valid account number
 * 	
 *	Would you like to try again? (y/n)
 *	y
 * 	Enter the account number: 7894562
 *	Not valid account number
 *	
 *	Would you like to try again? (y/n)
 *	n
 *	Not valid input, the program is now terminated!
 *
 *-------------------------------------------------------------------------------------------------------------
 *-------------------------------------------------------------------------------------------------------------
 * -- When the account is entered (3) right time(s) & calculated (Three different calculations in one run) --
 *  Enter the account number: 452294
 *	The calculated value to this account is: 26
 *	Would you like to enter another account number? (y/n)
 *	y
 * 	Enter the account number: 242145
 *	The calculated value to this account is: 18
 *	Would you like to enter another account number? (y/n)
 *	y
 *	Enter the account number: 870833
 *	The calculated value to this account is: 29
 * 	Would you like to enter another account number? (y/n)
 *	n
 *	** Program Exit **
 *
 */

