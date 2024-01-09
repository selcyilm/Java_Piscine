package day01.ex00;

import java.util.UUID;

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

	}

	public User() {

	}

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

	@Override
	public String	toString() {
		return ("Name: " + this.name + " Balance: " + this.balance +
				" Identifier: " + this.identifier);
	}
}
