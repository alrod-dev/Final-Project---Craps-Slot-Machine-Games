package Methods;

import Exceptions.Exceptions;
import java.util.ArrayList;
import java.util.Random;


/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Methods.Dice.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Craps Methods
 *
 ********************************************************/

public class Dice
{


	//Constructor not necessary
	//but added for reference
	public Dice()
	{

	}

	//Get value of the number between 1-6
	public static int roll() throws Exceptions
	{

		Random randomGenerator = new Random();

		return randomGenerator.nextInt(6) + 1;
	}


	//Prints out a table of values
	public static void gameStats(ArrayList<Integer> gameList) throws Exceptions
	{
		System.out.println("\nTimes Rolled\tWins\tLosses\tPlayer's Points");

		//Creates the table
		System.out.println(gameList.get(0) + "\t\t\t\t" + gameList.get(1) + "\t\t" + gameList.get(2) + "\t\t" + gameList.get(3));
	}

	//Prints out dices that were rolled
	public static void diceTable(int tempScore1, int tempScore2, int scoreSum) throws Exceptions
	{
		System.out.println("\nMethods.Dice 1\tMethods.Dice 2\tSum");
		System.out.println(tempScore1 + "\t\t" + tempScore2 + "\t\t" + scoreSum);
	}

	//Updates the number of time the dices have been rolled
	public static void updateRolls(ArrayList<Integer> gameList, int tempRoll) throws Exceptions
	{
		tempRoll = gameList.get(0);
		gameList.remove(0);
		gameList.add(0, (1 + tempRoll));
	}

	//Updates the number of times the player has won
	public static void updateWins(ArrayList<Integer> gameList, int tempWin) throws Exceptions
	{
		tempWin = gameList.get(1);
		gameList.remove(1);
		gameList.add(1, (1 + tempWin));
	}

	//Updates the number or time the player has lost
	public static void updateLosses(ArrayList<Integer> gameList, int tempLoss) throws Exceptions
	{
		tempLoss = gameList.get(2);
		gameList.remove(2);
		gameList.add(2, (1 + tempLoss));
	}

	//Updates the score is the player wins
	public static void updatePlayerScoreWin(ArrayList<Integer> gameList, int tempPlayerScore, int tempBet) throws Exceptions
	{

		tempPlayerScore = gameList.get(3);
		gameList.remove(3);
		gameList.add(3, (tempPlayerScore + (tempBet * 2)));
	}

	//Updates the player score if the player lost
	public static void updatePlayersScoreLoss(ArrayList<Integer> gameList, int tempPlayerScore, int tempBet) throws Exceptions
	{
		tempPlayerScore = gameList.get(3);
		gameList.remove(3);
		gameList.add(3, (tempBet - tempPlayerScore));
	}


}
