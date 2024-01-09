package day01.ex00;

import java.util.UUID;

/**
 * Transaction
 */
public class Transaction {
	static	enum	Type {
		DEBIT,
		CREDIT;
	}

	private	UUID	identifier;
	private	User	recipient;
	private	User	sender;
	private	int		amount;
	private	Type	transferCategory;

	public Transaction (User sender, User recipient, Type transferCategory, int amount) {
		this.identifier = UUID.randomUUID();
		this.sender = sender;
		this.recipient = recipient;
		this.transferCategory = transferCategory;
		if ((transferCategory == Type.CREDIT && amount < 0)
		|| (transferCategory == Type.DEBIT && amount > 0)) {
			System.out.println("Error: Invalid transaction, amount is set to 0");
			this.amount = 0;
		}
		else if (sender.getBalance() < amount) {
			System.out.printf("Error: Insufficent credit, amount is set to 0");
			this.amount = 0;
		}
		else {
			this.amount = amount;
		}
	
	}

	public UUID	getIdentifier() {
		return (this.identifier);
	}

	public User	getsender() {
		return (this.sender);
	}

	public User	getRecipient () {
		return (this.recipient);
	}

	public Type	getTransferCategory() {
		return (this.transferCategory);
	}

	public int	getAmount() {
		return (this.amount);
	}

	@Override
	public String toString() {
		return ("Sender:\n" + this.sender.getName() + "\nRecipient:\n" + this.recipient.getName() +
				"\nTransfer Category: " + this.transferCategory + "\nID:\n" +
				this.identifier);
	}

}