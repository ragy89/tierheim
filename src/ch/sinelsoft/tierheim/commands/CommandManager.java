package ch.sinelsoft.tierheim.commands;

import java.util.Arrays;
import java.util.Map;

/**
 * Class which is responsible for command handling
 */
public class CommandManager {

	/**
	 * The map between commands and handler classes
	 */
	private Map<String, Class<?>> commandHandlerMap;
	
	/**
	 * Constructor initializing the handler map
	 * 
	 * @param commandHandlerMap a map between commands and handler class names
	 */
	public CommandManager(Map<String, Class<?>> commandHandlerMap) {
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
			parts = Arrays.copyOfRange(parts, 1, parts.length);
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
			System.out.println(String.format("No handler for command \"%s\" found!", command));
			return false;
		}
		
		//try to create instance of class via reflection and execute it
		try {
			Class<?> classDef = this.commandHandlerMap.get(command);
			Object obj = classDef.newInstance();
			
			if (obj instanceof ICommand) {
				ICommand commandInstance = (ICommand) obj;
				return commandInstance.handle(params);
			} else {
				System.out.println(String.format("\"%s\" does not implement ICommand!", classDef.getName()));
				return false;
			}
		} catch (Exception e) {
			System.out.println(String.format("Could not find, instantiate or access the class for the command \"%s\"!", command));
			return false;
		}
	}
	
}
