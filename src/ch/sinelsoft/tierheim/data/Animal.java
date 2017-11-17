package ch.sinelsoft.tierheim.data;

public class Animal {
	
	private String name;
	private int age;
	private String species;
	
	public Animal() {
		this("unknown", "noname", -1);
	}
	
	public Animal(String species) {
		this(species, "unknown", -1);
	}
	
	public Animal(String species, String name) {
		this(species, name, -1);
	}
	
	public Animal(String species, String name, int age) {
		this.species = species;
		this.name = name;
		this.age = age;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public String getName() {
		return this.name;
	}
		
	public int getAge() {
		return this.age;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
