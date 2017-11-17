package ch.sinelsoft.tierheim;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ch.sinelsoft.tierheim.commands.CommandManager;

/**
 * The main class of the application
 */
public class Main {
	
	/**
	 * Main method which doesn't need any args
	 */
	public static void main(String[] args) {
		System.out.println("Hallo aus dem Tierheim!");
		
		//prepare the command manager
		Map<String, String> map = new HashMap<String, String>();
		CommandManager cmdMgr = new CommandManager(map);
		
		//create a new scanner and listen for input
		Scanner s = new Scanner(System.in);
		while (true) {
			//read the next line
			System.out.println("Enter your command:");
			String line = s.nextLine();
			//empty line means exit the program
			if (line.isEmpty()) {
				s.close();
				break;
			}			
			//process the line received
			cmdMgr.processLine(line);
		}
		
		System.out.println("Byebye!!!");
	}	

}
