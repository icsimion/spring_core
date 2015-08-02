package tut.sprng.beans;

public class HeroService {

	private Hero hero;

	// constructor is used for autowire by constructor
	public HeroService(Hero hero) {
		System.out.println("HeroService - Autowiring by constructor used");
		this.hero = hero;
	}

	// default constructor to avoid BeanInstantiationException for autowire
	// byName or byType
	public HeroService() {
		System.out.println("HeroService - Default Constructor used");
	}

	// used for autowire byName and byType
	public void setHero(Hero hero) {
		System.out.println("HeroService - Autowiring byName / byType used");
		this.hero = hero;
	}

	public void viewDetails() {
		System.out.println("HeroService Details:  Hero:  Name = " + hero.getName() + "; number = " + hero.getNumber());
	}
}