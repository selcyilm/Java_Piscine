package day01.ex02;

/**
 * Program
 */
public class Program {
	public static void main(String[] args) {
		User user1 = new User("Krill", 5000);
		User user2 = new User("John", 100);
		User user3 = new User("Trump", 1000000000);
		
		UsersArrayList users = new UsersArrayList();
		users.addUser(user1);
		users.addUser(user2);
		users.addUser(user3);

		System.out.println(users.retrieveByIndex(2));
		System.out.println(users.retrieveByCount());
		System.out.println(users.retrieveById(4));

	}
	
}