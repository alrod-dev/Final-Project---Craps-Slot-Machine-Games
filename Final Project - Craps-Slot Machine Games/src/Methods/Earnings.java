package Methods;

import Exceptions.Exceptions;
import java.util.Random;
import java.util.Scanner;

/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Methods.Earnings.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Methods.Earnings system for the slot machine game
 *
 ********************************************************/


public class Earnings
{
	/**
	 * Fields
	 */

	//starts the player off with 100 credits.
	private static int credits = 100;

	//lets the player play
	private static int playAgain = 1;

	//gives the total to be used in an array later.
	private static int total = 0;
	private static int[] winningsArray = new int[4];
	static int count = 0;
	
	public static int Slots() throws Exceptions
	{
		//Lets user input
		Scanner input2 = new Scanner(System.in);

		//used to generate winnings
		Random rand = new Random();

		// initializes an array for our random integers mainly to be used in a different menu option.
		int[] random = new int[3];

		//Lets you play the game when this is set to 1
		playAgain = 1;
		
		while(playAgain == 1)
		{
			//assigns a random value to each element in our array
			random[0] = rand.nextInt(10) + 1;
			random[1] = rand.nextInt(10) + 1;
			random[2] = rand.nextInt(10) + 1;

			//adds our random integers together to be used as "probabilities" for winnings.
			total = random[0] + random[1] + random[2];

			//displays it to the user
			System.out.println(random[0] + " + " + random[1] + " + " + random[2] + " = " + total);

			//you lose if you get a total 20 or less.
			if(total < 21)
			{
				winningsArray[0] += 1;
				credits = credits - 10;
				System.out.println("Sorry, you lose! You now have " + credits + " Credits!");
				System.out.println("Press 1 to play again or 0 to quit.");
				playAgain = input2.nextInt();

				//runs method play again to see if user wants to play again or return to main
				PlayAgain();
			
			}

			//you win 30 credits - 10 for credit cost if total is between (not including) 20 and 26
			else if(total >= 21 && total <= 25 )
			{
				winningsArray[1] += 1;
				credits = credits + 20;
				System.out.println("Congratulations, You won 30 Credits! You now have " + credits + " Credits!");
				System.out.println("Press 1 to play again or 0 to quit.");
				playAgain = input2.nextInt();

				//runs method play again to see if user wants to play again or return to main
				PlayAgain();
			
			}

			//you win 50 credits - 10 for credit cost if total is between (not including) 25 and 29
			else if(total >= 26 && total <= 28)
			{
				//this block gives a reward of 50 - cost of credits, and asks to play again then runs the play again method.
				winningsArray[2] += 1;
				credits = credits + 40;                                   
				System.out.println("Congratulations, You won 50 Credits! You now have " + credits + " Credits!");
				System.out.println("Press 1 to play again or 0 to quit.");
				playAgain = input2.nextInt();
				
				PlayAgain();
			
			
			}

			//JACKPOT!! you win 100 credits - 10 for credit cost if total is above 28 ( so if it is 29, or 30)
			else if(total > 28)
			{
			    //this block gives a reward of 100 - cost of credits, and asks to play again then runs the play again method.
				winningsArray[3] += 1;
				credits = credits + 90;                                    
				System.out.println("JACKPOT!! You won 100 credits!! You now have " + credits + " credits!!");      
				System.out.println("Press 1 to play again or 0 to quit.");
				playAgain = input2.nextInt();
				
				PlayAgain();
			}
		
		}
		
		return credits;
		
	}

	//this method lets us play again or return to main menu
	public static void PlayAgain() throws Exceptions
	{
		
		if(playAgain == 0)
		{
			System.out.println("Returning to Main Menu.");
			System.out.println();
			playAgain = 0;
		}
		else if(playAgain == 1)
		{
			playAgain = 1;
		}
		else if(playAgain > 1)
		{
			//if anything but 1 or 0 are entered, this resets to menu 1 (USUALLY)
			System.out.println("Please enter a valid number");
			MenuSetup.MenuOne();
		}
	}

	//access winningsArray from other classes.
	public static int[] getWinningsArray() throws Exceptions
	{

		//this for loop lets you access each element of winningsArray to display on MenuTwo method.
		for(int i = 0; i < 1; i++)
		{
			System.out.printf("%4d %s", winningsArray[count], " ");
	
		}
		count++;
		
		return winningsArray;
	}

	//allows us to access credits in our other classes.
	public static int getCredits() throws Exceptions
	{
		return credits;
	}

	//allows us to access total in our other classes.
	public static int getTotal() throws Exceptions
	{
		return total;
	}
	
}

