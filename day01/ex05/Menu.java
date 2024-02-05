package day01.ex05;

import java.util.Scanner;

/**
 * Menu
 */
public class Menu {
	private	UsersList			users;
	private	boolean				isDev;
	private	TransactionsService	service;
	private	Scanner				scanner;

	public	Menu(boolean isDev, Scanner scanner) {
		this.isDev = isDev;
		this.scanner = scanner;
		service = new TransactionsService();
	}

	public	void	printMenu() {
		int count = 0;
		System.out.println(++count + ". Add a user");
		System.out.println(++count + ". View user balances");
		System.out.println(++count + ". Perform a transfer");
		System.out.println(++count + ". View all transaction for a spesific user");
		if (isDev) {
			System.out.println(++count + ". DEV - remove a transfer by ID");
			System.out.println(++count + ". DEV - check transfer validity");
		}
		System.out.println(++count + ". Finish execution");
	}

	public	void	addUser() {
		User	user;
		String	line;
		int		balance;
		String	userName;
		System.out.println("Enter a name and balance\n->");
		userName = scanner.next();
		//scanner.next();
		balance = scanner.nextInt();
		line = scanner.nextLine();
		if (!line.equals(""))
			throw	new	NonExistingCommandExeption("Invalid Input Type!");
		user = new User(userName, balance);
		this.service.addUser(user);
		System.out.printf("User with id = %d is added\n", user.getIdentifier());
	}

	public	void	viewUserBalance() {
		int		id;
		String	line;
		System.out.println("Enter a user ID\n->");
		id = scanner.nextInt();
		line = scanner.nextLine();
		if (!line.equals(""))
			throw	new	NonExistingCommandExeption("Invalid Input!");
		this.service.retrieveBalance(id, true);
	}
}