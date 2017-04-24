package Methods;

import Exceptions.Exceptions;
import java.util.Scanner;

/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Methods.MenuSetup.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Games.Game stats and menu for the Slot Machine game
 *
 ********************************************************/

public class MenuSetup
{

	/**
	 * Fields
	 */
	Scanner choice = new Scanner(System.in);
	static int[] rewardsArray = {0,30,50,100};

	//Lets you play game or return to main menu
	public static void MenuOne() throws Exceptions
	{
		Scanner choice = new Scanner(System.in);
		int playGame;
		
		System.out.println("You have " + Earnings.getCredits() + " credits. Press 1 (costs 10 credits) to play, or 0 to return to the Main Menu.");
		playGame = choice.nextInt();

		// returns you to main menu
		if(playGame == 0)
		{
			System.out.println("Returning to Main Menu.");
			System.out.println();

		}

		//Will Run the "slot machine"
		if (playGame == 1)
		{
			Earnings.Slots();
			
		}

		//If invalid number is entered reruns MenuOne
		else if(playGame > 1)
		{
			System.out.println("Please enter valid number.");
			MenuOne();	
			
		}
	}

	//this method displays an array of our winning amounts, and how many times you've landed on each.
	public static void MenuTwo() throws Exceptions
	{
		for(int i = 0; i < 4; i++)
		{
			System.out.printf("%3d%s", rewardsArray[i], ":");
			Earnings.getWinningsArray();
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void MenuThree() throws Exceptions
	{
		String[] ratiosArray = {"(< 21)", "(> 20 and < 26)", " (> 25 and < 29)", " (29 or 30)"};
		for(int i = 0; i < 4; i++)
		{
			System.out.printf("%3d %3s ", rewardsArray[i], "=" );
			System.out.printf("%18s ", ratiosArray[i]);
			
			System.out.println();
			
		}
		System.out.println();
	}

}

