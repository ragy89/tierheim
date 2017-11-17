package ch.sinelsoft.tierheim.commands.handlers;

import java.util.Scanner;

import ch.sinelsoft.tierheim.commands.ICommand;
import ch.sinelsoft.tierheim.data.PetHotel;
import ch.sinelsoft.tierheim.data.Room;

public class RoomsCommand implements ICommand {

	@Override
	public boolean handle(Scanner scanner, PetHotel petHotel, String[] params) {
		Room[] rooms = petHotel.getRooms();
		
		if (rooms.length == 0) {
			System.out.println("No rooms found!");
		} else {
			System.out.println("The following rooms were found");
			for (Room r : petHotel.getRooms()) {
				System.out.println(String.format("%s has a capacity of %d", r.getRoomId(), r.getCapacity()));
			}
		}
		
		return true;
	}

}
