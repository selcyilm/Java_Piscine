package day01.ex00;

/**
 * Transaction
 */
public class Transaction {
	static	enum	Type {
		DEBIT,
		CREDIT;
	}

	private	int		identifier;
	private	User	recipient;
	private	User	sender;
	private	int		amount;
	private	Type 	transferCategory;

	public void setBalance(int balance) {
		this.balance
	}


}