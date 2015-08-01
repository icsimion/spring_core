package tut.sprng.beans;

public class Identification {
	private long id;
	private String signature;

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
