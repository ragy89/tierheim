package ch.sinelsoft.tierheim.commands;

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
	public boolean handle(String[] params);
	
}
