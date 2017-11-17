package ch.sinelsoft.tierheim.data;

import java.util.ArrayList;

public class PetHotel {

	private ArrayList<Room> rooms;
	
	public PetHotel() {
		this.rooms = new ArrayList<Room>();
	}
	
	public Room[] getRooms() {
		return this.rooms.toArray(new Room[0]);
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}
	
}
