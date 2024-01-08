package day00.ex04;

import java.util.Scanner;

public class Program {
	static void	illegalArg() {
		System.err.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		char arr[] = input.toCharArray();

		int alphabet[] = new int[256];

		int	k = 0;
		while (k < arr.length) {
			alphabet[(int)arr[k]]++;
			k++;
		}

		int	index[] = new int[10];
		int	min = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] == 0 || alphabet[i] < alphabet[index[min]])
				continue ;
			index[min] = i;

			min = 0;
			for (int j = 1; j < 10 && alphabet[index[min]] > 0; j++) {
				if (alphabet[index[min]] > alphabet[index[j]])
					min = j;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (alphabet[index[j]] < alphabet[index[j + 1]]) {
					int tmp = index[j + 1];
					index[j + 1] = index[j];
					index[j] = tmp;
				}
			}
		}

		int	size = 1;
		for (int i = 0; i < 10; i++) {
			if (alphabet[index[i]] == 0)
				break;
			size = i + 1;
		}

		int max = alphabet[index[0]];
		if (max > 999)
			illegalArg();

		for (int i = 11; i > 0; i--) {
			int height = max * i;
			int heightNext = max * (i - 1);

			for (int j = 0; j < size; j++) {
				if (alphabet[index[j]] * 10 >= height)
					System.out.printf("  #");
				else if (alphabet[index[j]] * 10 >= heightNext)
					System.out.printf("% 3d", alphabet[index[j]]);
				else
					break ;
			}
			System.out.println("");
		}
		for (int i = 0; i < size; i++)
			System.out.printf("  %c", (char)index[i]);
		System.out.println("");
		scanner.close();
	}
	
}