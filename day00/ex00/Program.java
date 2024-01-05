import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("->");
		int user = scanner.nextInt();
		int sum = 0;
		while (user != 0)
		{
			sum += user % 10;
			user /= 10;
		}
		System.out.println(sum);
		scanner.close();
	}
}
