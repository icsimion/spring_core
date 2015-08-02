package tut.sprng.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Identification {
	private long id;
	private String signature;

	@PostConstruct
	public void initIt() {
		System.out.println("Identification - PostConstruct");
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("Identification - PreDestroy");
	}

	public Identification(long id, String signature) {
		this.id = id;
		this.signature = signature;
	}

	public String getSignature() {
		return signature;
	}

	public long getId() {
		return id;
	}
}
