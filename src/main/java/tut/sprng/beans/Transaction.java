package tut.sprng.beans;

public class Transaction {

	private Identification identification;
	private Account account;

	public void viewDetails() {
		System.out.println(" Transaction Details: ");
		System.out.println(" Account:  number=" + account.getAccountNumber() + "; holder=" + account.getAccountHolder());
		System.out.println(" Identification:  id=" + identification.getId() + "; signature=" + identification.getSignature());
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
}


