package day01.ex04;

/**
 * Program
 */
public class Program {
	public static void main(String[] args) {
		User user1 = new User("Selçuk", 1000);
		User user2 = new User("Bora", 2000);
		User user3 = new User("Göksu", 3000);
		User user4 = new User("Selim", 4000);

		TransactionsService service = new TransactionsService();
		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);
		service.addUser(user4);

		System.out.println("Before:");
		System.out.println("Selçuk's balance: " + user1.getBalance());
		System.out.println("Bora's balance: " + user2.getBalance());
		service.performTransaction(user1.getIdentifier(), user2.getIdentifier(), 250);
		System.out.println("After:");
		System.out.println("Selçuk's balance: " + user1.getBalance());
		System.out.println("Bora's balance: " + user2.getBalance());

		System.out.println("\n===========\n" + service.toString());
	}

}