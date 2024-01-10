package day01.ex02;

/**
 * User
 */
public class User {

	private	String name;
	private	int	identifier;
	private	int	balance;

	public User(String name, int balance) {
		this.name = name;
		if (balance > 0)
			this.balance = balance;
		else
			this.balance = 0;
		this.identifier = UserIdsGenerator.getInstance().generateId();

	}

	public User() {

	}

	public void	setName(String name) {
		this.name = name;
	}

	public void	setBalance(int balance) {
		this.balance = balance;
	}

	public String	getName() {
		return (name);
	}

	public int	getBalance() {
		return (balance);
	}

	public int	getIdentifier() {
		return (identifier);
	}

	@Override
	public String	toString() {
		return ("Name: " + this.name + "\nBalance: " + this.balance +
				"\nIdentifier: " + this.identifier);
	}
}
