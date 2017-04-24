package Games;

import Exceptions.Exceptions;
import Methods.MenuSetup;
import java.util.Scanner;

/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Methods.Earnings.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Slot Machine game
 *
 ********************************************************/

public class SlotMachineApp 
{
	
	public void slots() throws Exceptions
	{

		MainMenu();                                                      //Will run main menu method.

	}
	
	public static void MainMenu() throws Exceptions
	{             
		int option = 1;                                                   //Lets you start the program.
		Scanner input = new Scanner(System.in);                           //lets user input 
		
		while(option > 0)
		{
			System.out.println("\nPlease enter (1-4) to choose an option below:");
			System.out.println("1: Play");
			System.out.println("2: Check winnings");
			System.out.println("3: Payout");           //REWORD THIS
			System.out.println("4: quit");
			option = input.nextInt();


			switch(option)                     //depending on options value we run one of these cases, opening up different menus.
			{
			case 1:                           //allows game to be played or return to main menu
				MenuSetup.MenuOne();
				break;
			case 2:
				MenuSetup.MenuTwo();          //Will allow you to see how many times you have won each reward.
				break;
			case 3:
				MenuSetup.MenuThree();        //Will allow you to see what the reward amounts are
				break;
			case 4:
				option = 0;
				System.out.println("\nGoodbye, and thanks for playing!");           //$$$$$ Quit the SLOTS $$$$$
				break;
			}
		}
	}

}


