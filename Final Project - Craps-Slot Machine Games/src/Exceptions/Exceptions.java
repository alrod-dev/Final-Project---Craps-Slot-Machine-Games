package Exceptions;

/********************************************************
 *
 *  Project :  <Final Project - Craps\Slot Machine Games.Game>
 *  File    :  <Exceptions.Exceptions.java>
 *  Name    :  <Alfredo Rodriguez, Antone Mason && Casey Linton>
 *  Date    : <4/23/17>
 * 	Class	: CSIS 1400
 * 	Teacher	: Stanley Egwuonwu
 *	Description: Custom exceptions class which catches any
 *			   	 error the user or the code may have
 *
 ********************************************************/

public class Exceptions extends Exception
{
	//Creates a custom exception to catch any errors
	public Exceptions(String message)
	{
		super(message);
	}

}