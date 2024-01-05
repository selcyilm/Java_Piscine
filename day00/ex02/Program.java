package day00.ex02;

import java.util.Scanner;

/**
 * Program
 */
public class Program {
	static int sum(int num) {
		int	sum;

		sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return (sum);
	}

	static boolean isPrime(int num) {
		int	i;

		i = 2;
		if (num < 2)
			return (false);
		while (i * i <= num) {
			if (num % i == 0)
				return (false);
			i++;
		}
		return (true);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int j = 0;
		System.out.println("->");
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			int i = sum(num);
			if (isPrime(i))
				j++;
		}
		System.out.printf("Count of coffe request- %d\n", j);
		scanner.close();
	}
}
