package ch.sinelsoft.tierheim.commands.handlers;

import java.util.Scanner;

import ch.sinelsoft.tierheim.commands.ICommand;
import ch.sinelsoft.tierheim.data.PetHotel;

public class SinelCommand implements ICommand {

	@Override
	public boolean handle(Scanner scanner, PetHotel petHotel, String[] params) {
		System.out.println("Wuuuuuuhuuuuuuu");
		return true;
	}

	@Override
	public String commandHelp() {
		return "sinel"; 
	}

}
