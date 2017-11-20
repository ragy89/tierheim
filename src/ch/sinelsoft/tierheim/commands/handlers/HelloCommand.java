package ch.sinelsoft.tierheim.commands.handlers;

import java.util.Scanner;

import ch.sinelsoft.tierheim.commands.ICommand;
import ch.sinelsoft.tierheim.data.PetHotel;

/**
 * Simple command to say hello
 */
public class HelloCommand implements ICommand {

	@Override
	public boolean handle(Scanner scanner, PetHotel petHotel, String[] params) {
		System.out.println("Servus und hallo!");
		return true;
	}

	@Override
	public String commandHelp() {
		return "hello";
	}

}
