package ch.sinelsoft.tierheim.commands.handlers;

import ch.sinelsoft.tierheim.commands.ICommand;

/**
 * Simple command to say hello
 */
public class HelloCommand implements ICommand {

	@Override
	public boolean handle(String[] params) {
		System.out.println("Servus und hallo!");
		return true;
	}

}
