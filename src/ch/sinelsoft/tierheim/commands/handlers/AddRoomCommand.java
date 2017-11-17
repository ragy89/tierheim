package ch.sinelsoft.tierheim.commands.handlers;

import java.util.Scanner;

import ch.sinelsoft.tierheim.commands.ICommand;
import ch.sinelsoft.tierheim.data.PetHotel;
import ch.sinelsoft.tierheim.data.Room;

public class AddRoomCommand implements ICommand {

	@Override
	public boolean handle(Scanner scanner, PetHotel petHotel, String[] params) {			
		//validate parameters
		if (params.length != 2) {
			System.out.println("You need to provide two params: the room id and the capacity");
			return false;
		}
		
		//try to cast the second parameter into an integer for capacity
		int capacity;
		try {
			capacity = Integer.parseInt(params[1]);
		} catch (NumberFormatException e) {
			System.out.println(String.format("%s is not a valid capacity", params[1]));
			return false;
		}
		
		//create and add room
		Room room = new Room(params[0], capacity);
		petHotel.addRoom(room);

		return true;
	}

}
