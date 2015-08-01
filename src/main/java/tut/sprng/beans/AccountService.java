package tut.sprng.beans;

public class AccountService {

	private Account account;

	// constructor is used for autowire by constructor
	public AccountService(Account account) {
		System.out.println("Autowiring by constructor used");
		this.account = account;
	}

	// default constructor to avoid BeanInstantiationException for autowire
	// byName or byType
	public AccountService() {
		System.out.println("Default Constructor used");
	}

	// used for autowire byName and byType
	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return this.account;
	}

	public int sum(int a, int b) {
		return a + b;
	}
}