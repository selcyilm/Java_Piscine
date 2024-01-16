package day01.ex03;

import java.util.UUID;

/**
 * TransactionsLinkedList
 */
public class TransactionsLinkedList implements TransactionsList {

	private	MyNode	head;
	private	int		count;

	public	TransactionsLinkedList () {
		this.head = null;
		this.count = 0;
	}

	@Override
	public	void	addTransaction(Transaction transaction) {
		MyNode	current = new MyNode(transaction,null);
		if (head == null)
			head = current;
		else {
			MyNode n = head;
			while (n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(current);
		}
		count++;
	}

	@Override
	public	void	removeTransaction(UUID id) {

		if (head.getData().getIdentifier().equals(id)) {
			head = head.getNext();
			count--;
			return ;
		}

		MyNode current = head;
		MyNode prev = null;
		while (current != null && !current.getData().getIdentifier().equals(id)) {
			prev = current;
			current = current.getNext();
		}

		if (current != null) {
			prev.setNext(current.getNext());
			count--;
		}
		else
			throw new TransactionNotFoundException("Invalid Id");
	}

	@Override
	public	Transaction[]	toArray() {
		Transaction[] transactions = new Transaction[count];
		int i = 0;
		MyNode current = head;
		while (i < this.count) {
			transactions[i++] = current.getData();
			current = current.getNext();
		}
		return (transactions);
	}
}