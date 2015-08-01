package tut.sprng.beans;

public class Account {

	private int accountNumber;
	private String accountHolder;
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
		
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getInfo() {
		return "Holder: " + accountHolder + ", number: " + accountNumber;
	}
}
