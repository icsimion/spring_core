package tut.sprng.beans;

public class PetService {

	private Pet pet;

	// constructor is used for autowire by constructor
	public PetService(Pet pet) {
//		System.out.println("PetService - Autowiring by constructor used");
		this.pet = pet;
	}

	// default constructor to avoid BeanInstantiationException for autowire
	// byName or byType
	public PetService() {
		System.out.println("PetService - Default Constructor used");
	}

	// used for autowire byName and byType
	public void setPet(Pet pet) {
		System.out.println("PetService - Autowiring byName / byType used");
		this.pet = pet;
	}

	public void viewDetails() {
		System.out.println("PetService Details:  Pet:  Name = " + pet.getName() + "; number = " + pet.getNumber());
	}
}