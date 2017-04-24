package Games;

import Exceptions.Exceptions;
import Methods.Dice;
import java.util.ArrayList;
import java.util.Scanner;


/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Games.DiceApp.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Plays Craps game
 *
 ********************************************************/


public class DiceApp
{

	public void craps()
	{

		//Fields
		String gameStatus = "Y";
		String insideGameStatus = "";

		//Methods.Dice Field
		Dice dice1 = new Dice();
		Dice methods = new Dice();

		//Players Score Fields
		int tempScore1 = 0;
		int tempScore2 = 0;
		int scoreSum = 0;
		int playerScore = 100;
		int tempPlayerScore = 0;
		int tempBet = 0;

		//Players Stats Fields
		int tempRoll = 0;
		int timesRolled = 0;
		int wins = 0;
		int tempWin = 0;
		int loss = 0;
		int tempLoss = 0;

		//Scanner Fields
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		//Array Fields
		ArrayList<Integer> numberList = new ArrayList<>(4);

		numberList.add(timesRolled);
		numberList.add(wins);
		numberList.add(loss);
		numberList.add(playerScore);

		//Tries to catch any sort of errors along the way
		try
		{

			//While loop
			do
			{

				System.out.print("\nWould You Like to Play a game of Craps(Press 'Y' or 'N'): ");

				gameStatus = input.nextLine();

				switch (gameStatus)
				{

				//Default statement if the user inputs any invalid messages
				default:
					System.out.printf("%s is an invalid input, Please try again!", gameStatus);
					break;

				//Quits game
				case "N":

					System.out.print("\nGames.Game Status: Quit");
					System.out.println("\nGood Bye!");

					break;

				//Starts the game
				case "Y":

					do
					{

						dice1.gameStats(numberList);

						//If the player has 0 or less points the game quits automatically
						if (numberList.get(3) <= 0)
						{
							System.out.println("\nYou have no points left! You Lose!");

							gameStatus = "N";

							break;


							//The game continues if not
						} else
							System.out.printf("\nHow much would you like to bet(0 - %d): ", numberList.get(3));

						tempBet = input2.nextInt();

						insideGameStatus = "nothing";

						tempScore1 = dice1.roll();
						tempScore2 = dice1.roll();

						methods.updateRolls(numberList, tempRoll);

						scoreSum = tempScore1 + tempScore2;

						//Creates the table
						methods.diceTable(tempScore1, tempScore2, scoreSum);

						//Checks what the player has rolled and if depends whether they lost, won, or neither
						switch (scoreSum)
						{

						case 2:

							System.out.println("Loser!");

							insideGameStatus = "Loser";

							methods.updateLosses(numberList, tempLoss);

							methods.updatePlayersScoreLoss(numberList, tempPlayerScore, tempBet);

							break;

						case 3:

							System.out.println("Loser!");

							insideGameStatus = "Loser";

							methods.updateLosses(numberList, tempLoss);

							methods.updatePlayersScoreLoss(numberList, tempPlayerScore, tempBet);

							break;

						case 12:

							System.out.println("Loser!");

							insideGameStatus = "Loser";

							methods.updateLosses(numberList, tempLoss);

							methods.updatePlayersScoreLoss(numberList, tempPlayerScore, tempBet);

							break;

						case 7:

							System.out.println("Winner!");

							insideGameStatus = "Winner";

							methods.updateWins(numberList, tempWin);

							methods.updatePlayerScoreWin(numberList, tempPlayerScore, tempBet);

							break;

						case 11:

							System.out.println("Winner!");

							insideGameStatus = "Winner";

							methods.updateWins(numberList, tempWin);

							methods.updatePlayerScoreWin(numberList, tempPlayerScore, tempBet);

							break;

						default:

							System.out.println("No Winnings! Nothing Lost! Re-Rolling");

							break;
						}
						
						System.out.print("\nWould You Like to Play a game of Craps(Press 'Y' or 'N'): ");

						gameStatus = input.nextLine();

						if (gameStatus.equals("N"))
						{
							break;
						}

						//Breaks loops if it's "N"
					} while (!(insideGameStatus.equals("Winner") || insideGameStatus.equals("Loser")));

					break;

				}

			} while (!gameStatus.equals("N"));
		}


		//Catches any sort of error along the way if it fails in the try method
		catch (Exceptions errors)
		{
			errors.printStackTrace();
		}


		//Prints out final score once game is finished
		System.out.println("\nFinal Score");

		try
		{
			methods.gameStats(numberList);
		}
		catch (Exceptions errors)
		{
			errors.printStackTrace();
		}

		System.out.println();

	}
}