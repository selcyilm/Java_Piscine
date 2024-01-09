package day01.ex00;

import day01.ex00.Transaction.Type;

/**
 * Program
 */
public class Program {

	public static void main(String[] args) {
		User s1 = new User("Selçuk", 1500);
		User s2 = new User("Ahmet", 300);

		System.out.println(s1.toString());
		System.out.println(s2.toString());

		Transaction transaction = new Transaction(s1, s2, Type.DEBIT, -100);
		System.out.println(transaction.toString());
		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}
}