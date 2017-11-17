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
	
}
