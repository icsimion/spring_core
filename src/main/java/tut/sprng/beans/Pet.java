package tut.sprng.beans;

public class Pet {

	private int number;
	private String name;
	
	public void setNumber(int number) {
		this.number = number;
	}
		
	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet: Name = " + this.getName() + "; Number = " + this.getNumber();
	}
}
