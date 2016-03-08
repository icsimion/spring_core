package tut.sprng.beans;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Identification {
	private long id;
	private String signature;
	private String token;

	public Identification(long id, String signature) {
		this.id = id;
		this.signature = signature;
		System.out.println("Identification - Constructor DI: id=" + id + ", signature="+ signature);
	}

//	@Override public void afterPropertiesSet() throws Exception { System.out.println("Identification - InitializingBean"); }


	//	public void init() {
	//		System.out.println("Identification - init");
	//	}
	//

//	@PostConstruct
//	public void initIt() {
//		System.out.println("Identification - PostConstruct");
//	}
//
//	@PreDestroy
//	public void cleanUp() {
//		System.out.println("Identification - PreDestroy");
//	}


	public String getSignature() {
		return signature;
	}

	public long getId() {
		return id;
	}

	public String getToken() { return token; }

	@Override
	public String toString() {
		return "Identification: Id = " + this.getId() + "; Dignature = " + this.getSignature();
	}

}
