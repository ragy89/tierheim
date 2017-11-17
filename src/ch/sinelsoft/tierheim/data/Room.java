package ch.sinelsoft.tierheim.data;

import java.util.ArrayList;

public class Room {
	
	String roomId;
	ArrayList<Animal> animalList = new ArrayList<Animal>();
	int capacity;
	
	public Room() {
		this("unknown", -1); 
	}
	
	public Room(String roomId, int capacity) {
	}
	
	public String getRoomId() {
		return this.roomId;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean addAnimal(Animal a) {
		if (animalList.size()<capacity) {
			animalList.add(a);
			return true;
		}
		return false;
	}
	
	public boolean removeAnimal(Animal a) {
		return animalList.remove(a);
	}

}
