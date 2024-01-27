package day01.ex05;

import java.util.UUID;

/**
 * TransactionsList
 */
public interface TransactionsList {
	public	void			addTransaction(Transaction transaction);
	public	void			removeTransaction(UUID id);
	public	Transaction[]	toArray();
}