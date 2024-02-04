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

}