package day01.ex05;

import java.util.Scanner;
import java.util.UUID;

import day01.ex05.Transaction.Type;

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

	public	void	performTransfer() {
		int		senderID;
		int		recipentID;
		int		transferAmount;
		String	line;
		
		System.out.println("Enter a sender ID, a recipent ID, and a Transfer Amount\n->");
		senderID = scanner.nextInt();
		recipentID = scanner.nextInt();
		transferAmount = scanner.nextInt();
		line = scanner.nextLine();
		if (!line.equals(""))
			throw	new	NonExistingCommandExeption("Invalid Input type!");
		this.service.performTransaction(senderID, recipentID, transferAmount);
		System.out.println("Transfer is completed!");
	}

	public	void	viewTransById() {
		String		line;
		int			id;
		Transaction transaction[];
		User		sender;
		User		recipent;

		System.out.println("Enter an ID\n\n->");
		id = scanner.nextInt();
		line = scanner.nextLine();
		
		if (!line.equals(""))
			throw	new	NonExistingCommandExeption("Invalid Input");
		transaction = this.service.getUserTransfer(id);
		if (transaction == null) {
			System.out.println("User doesn't have any transaction!");
			return ;
		}

		for (Transaction tr : transaction) {
			sender = tr.getsender();
			recipent = tr.getRecipient();
			if (tr.getTransferCategory() == Type.DEBIT) {
				System.out.printf("To %s (id = %d) -%d with id= ", 
				recipent.getName(), recipent.getIdentifier(), tr.getAmount());
				System.out.println(tr.getIdentifier());
			}
			else {
				System.out.printf("From %s (id = %d) %d with id= ", 
				sender.getName(), sender.getIdentifier(), tr.getAmount());
				System.out.println(tr.getIdentifier());
			}
		}
	}

	public	void	removeTrById() {
		Transaction transaction[];
		String transferIdStr;
		int		userId;
		UUID	transferIdUuid;

		System.out.println("Enter a User ID and a Transfer ID\n->");
		userId = scanner.nextInt();
		transferIdStr = scanner.nextLine();
		if (transferIdStr == null)
			throw	new	NonExistingCommandExeption("Transaction Not Found: Invalid Id");
		transaction = this.service.getUserTransfer(userId);
		for (Transaction tr : transaction) {
			transferIdUuid = tr.getIdentifier();
			if (transferIdStr.equals(transferIdUuid.toString())) {
				if (tr.getTransferCategory() == Type.DEBIT) {
					System.out.println("removed!");
				}
				else {
					System.out.println("REMOVED");
				}
				this.service.deleteTransaction(userId, transferIdUuid);
			}
		}
	}
}