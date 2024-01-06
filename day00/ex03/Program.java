package day00.ex03;

import java.util.Scanner;

public class Program {
	
	static void	invalidArgument() {
		System.err.println("Invalid Argument");
		System.exit(-1);
	}

	static void	printTable(int min) {
		int	i;

		i = 0;
		while (i < min) {
			System.out.printf("=");
			i++;
		}
		System.err.println(">");
	}

	static int	storeValue(int min, int week_num, int all) {
		int	i;
		int pow;

		pow = 1;
		i = 0;
		while (i < week_num) {
			pow *= 10;
			i++;
		}
		pow = all + (pow * min);
		return (pow);
	}

	static int	getValue(int all, int week_num) {
		int	ret;
		int	i;

		i = 0;
		ret = 0;
		while (i < week_num) {
			all /= 10;
			i++;
		}
		ret = all % 10;
		return (ret);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			String week;
			int	week_num;
			int	all;

			week_num = 0;
			all = 0;
			while (week_num < 18) {
				week = scanner.nextLine();

				if (week.equals("42"))
					break ;
				else if (!week.equals("Week " + (week_num + 1)))
					invalidArgument();
				
				int	grade, min = 9;
				for (int i = 0; i < 5; i++) {
					grade = scanner.nextInt();
					if (grade < 1 || grade > 9)
						invalidArgument();
					if (grade < min)
						min = grade;
				}
				week_num++;
				all = storeValue(min, week_num, all);
				scanner.nextLine();
			}
			for (int i = 1; i <= week_num; i++) {
				System.out.printf("Week %d ", i);
				printTable(getValue(all, i));
			}
			scanner.close();
			System.exit(0);
	}
}
