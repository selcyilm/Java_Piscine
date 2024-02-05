package day01.ex05;

import java.util.UUID;

/**
 * TransactionsService
 */
public class TransactionsService {
	private	UsersList	users;

	public	TransactionsService() {
		this.users = new UsersArrayList();
	}

	public	void	addUser(User user) {
		users.addUser(user);
	}

	public	int	getBalance(int id) {
		return (this.users.retrieveById(id).getBalance());
	}
	
	public	int	retrieveBalance(int id, boolean print) {
		int ret = this.users.retrieveById(id).getBalance();
		if (print)
			System.out.println(this.users.retrieveById(id).getName() + " - " + ret);
		return (ret);
	}

	public	void	performTransaction(int senderId, int recipentId, int amount) {
		User		sender = users.retrieveById(senderId);
		User		recipent = users.retrieveById(recipentId);

		if (amount <= 0 || (amount > 0 && amount > sender.getBalance())) {
			throw	new	IllegalTransactionException("Invalid Transaction!");
		}
		//Transaction tr1 = new Transaction(sender, recipent, Transaction.Type.DEBIT, -amount);
		Transaction tr2 = new Transaction(recipent, sender, Transaction.Type.CREDIT, +amount);
		sender.getTransactionsList().addTransaction(tr2);
		recipent.getTransactionsList().addTransaction(tr2);

		sender.setBalance(sender.getBalance() - amount);
		recipent.setBalance(recipent.getBalance() + amount);
	}

	public	Transaction[] getUserTransfer(User user) {
			return (user.getTransactionsList().toArray());
	}

	public	void	deleteTransaction(int userId, UUID id) {
		User user = users.retrieveById(userId);
		user.getTransactionsList().removeTransaction(id);
	}

	public	Transaction[] validateTransaction() {
		TransactionsList	tmp;
		Transaction	transactionArray[];
		int			numUsers;

		tmp = new TransactionsLinkedList();
		numUsers = this.users.retrieveByCount();
		for (int i = 0; i < numUsers; i++) {
			transactionArray = this.users.retrieveByIndex(i).getTransactionsList().toArray();
			for (Transaction tr: transactionArray) {
				boolean valid = false;
				for (Transaction tr2: tr.getRecipient().getTransactionsList().toArray()) {
					if (tr.getIdentifier().equals(tr2.getIdentifier())) {
						valid = true;
						break ;
					}
				}
				if (!valid) {
					tmp.addTransaction(tr);
				}
			}
		}
		return (tmp.toArray());
	}

	@Override
	public	String	toString() {
		String text = this.users.toString() + "users\n";
		for (int i = 0; i < users.retrieveByCount(); i++) {
			User user = users.retrieveByIndex(i);
			text += user.toString() + "\n";
			for (Transaction tr: user.getTransactionsList().toArray()) {
				text += tr.toString() + "\n";
			}
		}
		return (text);
	}
}