package tut.sprng.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.Set;

public class Quest {

	private Identification identification;
	private Map<Long, String> statuses;

	@Autowired
	@Qualifier("hero_sidekick")
	private Hero hero;

	public void viewDetails() {
		System.out.println("Quest Details:  Identification:  id = " + identification.getId() + "; signature = " + identification.getSignature());
		System.out.println("Quest Details:  Hero:  Name = " + hero.getName() + "; Number = " + hero.getNumber());
		System.out.println("Quest Details:  Statuses:");
		Set<Map.Entry<Long, String>> entries = statuses.entrySet();
		for (Map.Entry<Long, String> entry : entries) {
			System.out.println(" ---- >  timestamp: " + entry.getKey() + ", status: " + entry.getValue());
		}
	}

	public void setStatuses(Map<Long, String> statuses) {
		this.statuses = statuses;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public void initIt() {
		System.out.println("Quest - PostConstruct");
	}

	public void cleanUp() {
		System.out.println("Quest - PreDestroy");
	}


}


