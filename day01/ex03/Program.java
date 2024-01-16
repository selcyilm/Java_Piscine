package day01.ex03;


import day01.ex03.Transaction.Type;

/**
 * Program
 */
public class Program {

	public static void main(String[] args) {
		User user1 = new User("John", 1000000);
		User user2 = new User("tRUMP", 50000);
		User user3 = new User("James", 90000000);
		User user4 = new User("Hello", 6000000);
		User user5 = new User("Jonathan", 4000000);

		Transaction t1 = new Transaction(user1, user2, Type.DEBIT, -100);
		Transaction t2 = new Transaction(user3, user4, Type.CREDIT, 10000);
		Transaction t3 = new Transaction(user5, user2, Type.DEBIT, -500);

		TransactionsLinkedList trs = new TransactionsLinkedList();

		trs.addTransaction(t1);
		trs.addTransaction(t2);
		trs.addTransaction(t3);

		Transaction arr[] = trs.toArray();
		System.out.println("=======================");
		for (int i = 0; i < arr.length; i++)
			System.out.printf("%d=>\n%s\n\n", i, arr[i]);

		trs.removeTransaction(t1.getIdentifier());

		System.out.println("========================");

		arr = trs.toArray();

				for (int i = 0; i < arr.length; i++)
			System.out.printf("%d=>\n%s\n\n", i, arr[i]);
	}
}