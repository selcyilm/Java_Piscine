package day00.ex01;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("->");
		if (!scanner.hasNextInt())
		{
			System.err.println("Illegal Argument!");
			System.exit(-1);
		}

		int	num = scanner.nextInt();
		if (num <= 1)
		{
			System.err.println("Illegal Argument");
			System.exit(-1);
		}

		int	i = 2;
		boolean isPrime = true;
		while (i * i <= num && isPrime)
		{
			if (num % i == 0)
				isPrime = false;
			i++;
		}
		System.out.printf("%b %d\n", isPrime, i - 1);
		scanner.close();
	}
}
