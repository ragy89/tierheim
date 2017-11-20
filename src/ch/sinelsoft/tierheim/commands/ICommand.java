package ch.sinelsoft.tierheim.commands;

import java.util.Scanner;

import ch.sinelsoft.tierheim.data.PetHotel;

/**
 * Interface for actual command implementations
 */
public interface ICommand {

	/**
	 * Method to handle a command
	 * 
	 * @param params array of parameters in string format as received from the console
	 * @return true upon success, otherwise false
	 */
	public boolean handle(Scanner scanner, PetHotel petHotel, String[] params);
	
	/**
	 * This method should return a single describing how to use the command.
	 * Example: "addroom roomId capacity"
	 * 
	 * @return string describing the command
	 */
	public String commandHelp();
	
	/**
	 * TODO ragy: implement method which is responsible to validate the received params
	 * and return a boolean value if they are valid. After adding it to the interface, you
	 * must implement it in all existing commands.
	 */
	
}
