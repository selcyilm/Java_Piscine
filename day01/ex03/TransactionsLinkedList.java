package day01.ex03;

/**
 * TransactionsLinkedList
 */
public class TransactionsLinkedList implements TransactionsList {

	private	Transaction	head;
	private	int		count;

	public	TransactionsLinkedList () {
		this.head = null;
		this.count = 0;
	}
	
}