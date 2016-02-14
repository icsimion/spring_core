package tut.sprng.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.Set;

public class Activity {

	@Autowired
	private Identification identification;

	private String name;
	private Map<Long, String> games;

	@Autowired
	@Qualifier("pet_sidekick")
	private Pet pet;

	public void viewDetails() {
		System.out.println(identification);
		System.out.println(pet);
		System.out.println("Statuses:");
		Set<Map.Entry<Long, String>> entries = games.entrySet();
		for (Map.Entry<Long, String> entry : entries) {
			System.out.println(" - >  timestamp: " + entry.getKey() + ", game: " + entry.getValue());
		}
	}

	public void setGames(Map<Long, String> games) {
		this.games = games;
	}

//	public void setIdentification(Identification identification) {
//		this.identification = identification;
//	}
//
	public void setName(String name) {
		this.name = name;
	}

	public void initIt() {
		System.out.println("Activity - init-method");
	}

	public void cleanUp() {
		System.out.println("Activity - destroy-method");
	}
}


