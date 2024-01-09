package day01.ex00;

import java.util.UUID;

/**
 * User
 */
public class User {

	private	String name;
	private	int	identifier;
	private	int	balance;

	public void	setName(String name) {
		this.name = name;
	}

	public void	setIdentifier(int identifier) {
		this.identifier = identifier;
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

}