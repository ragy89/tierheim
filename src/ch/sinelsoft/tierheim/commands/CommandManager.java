package ch.sinelsoft.tierheim.commands;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import ch.sinelsoft.tierheim.data.PetHotel;

/**
 * Class which is responsible for command handling
 */
public class CommandManager {

	/**
	 * The scanner instance to use for input
	 */
	private Scanner scanner;
	
	/**
	 * The instance of the pet hotel
	 */
	private PetHotel petHotel;
	
	/**
	 * The map between commands and handler classes
	 */
	private Map<String, Class<?>> commandHandlerMap;
	
	/**
	 * Constructor initializing the handler map
	 * 
	 * @param commandHandlerMap a map between commands and handler class names
	 */
	public CommandManager(Scanner scanner, PetHotel petHotel, Map<String, Class<?>> commandHandlerMap) {
		this.scanner = scanner;
		this.petHotel = petHotel;
		this.commandHandlerMap = commandHandlerMap;
	}
	
	/**
	 * Tries to extract a command from a line provided by user input
	 * 
	 * @param line the raw line data
	 */
	public void processLine(String line) {
		line = line.trim();
		String[] parts = line.split(" ");
		
		//the command is at index 0
		String command = parts[0];
		
		//the parameters are the rest of the parts
		String[] params = new String[0];
		if (parts.length > 1) {
			params = Arrays.copyOfRange(parts, 1, parts.length);
		}
		
		this.executeCommand(command, params);
	}
	
	/**
	 * Method which cares about the actual execution of a command
	 * 
	 * @param command the command which was entered
	 * @param params the array of parameters as entered in the console
	 * @return true upon successful execution of the command, otherwise false
	 */
	protected boolean executeCommand(String command, String[] params) {
		//check if handler is registered
		if (!this.commandHandlerMap.containsKey(command)) {
			//TODO ragy: show help of commands here!
			System.out.println(String.format("No handler for command \"%s\" found!", command));
			return false;
		}
		
		//try to create instance of class via reflection and execute it
		Class<?> classDef = this.commandHandlerMap.get(command);
		Object obj = null;
		try {
			obj = classDef.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(String.format("Problem while creating instance of class \"%s\"", classDef.getName()));
			return false;
		}
		
		if (obj instanceof ICommand) {
			ICommand commandInstance = (ICommand) obj;
			//TODO ragy: call method to validate params here and if false, show help!
			boolean wasSuccessful = commandInstance.handle(this.scanner, this.petHotel, params);
			System.out.println(String.format(">%s", wasSuccessful ? "success!" : "fail!"));
			return wasSuccessful;
		} else {
			System.out.println(String.format("\"%s\" does not implement ICommand!", classDef.getName()));
			return false;
		}
	}
	
}
