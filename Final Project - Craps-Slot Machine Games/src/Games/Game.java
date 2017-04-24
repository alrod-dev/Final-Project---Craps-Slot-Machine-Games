package Games;
import Exceptions.Exceptions;

import java.util.Scanner;

/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Games.Game.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Plays all Games
 *
 ********************************************************/

public class Game {

	public static void main(String[] args) throws Exceptions
	{
		DiceApp craps = new DiceApp();
		SlotMachineApp slots = new SlotMachineApp();
		Scanner input = new Scanner(System.in);
		
		String selection;

		do
		{

			System.out.print("What would you like to play (Slots, Craps, Exit): ");

			selection = input.nextLine();

			switch (selection)
			{
			case "Slots":
				slots.slots();
				break;

			case "Craps":
				craps.craps();
				break;

			case "Exit":
				System.out.println("Good Bye");
				break;

			default:
				System.out.println("Please choose Again.");
				break;
			}

		} while (!selection.equalsIgnoreCase("Exit"));


	}

}


