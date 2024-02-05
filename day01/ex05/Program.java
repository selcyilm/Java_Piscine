package day01.ex05;

import java.util.Scanner;

/**
 * Program
 */
public class Program {


	public	static	int	setSelect(Scanner scanner, int exitInput) {
		System.out.print("-> ");
		int setSelect = scanner.nextInt();
		while (setSelect > exitInput || setSelect < 1) {
			System.err.print("Invalid Input try again!\n-> ");
			setSelect = scanner.nextInt();
		}
		return (setSelect);
	}

	public	static	void	goDoTheJob(int input, Scanner scanner, Menu menu) {
		switch (input) {
			case 1:
				menu.addUser();
				break ;
			case 2:
				menu.viewUserBalance();
				break ;
			case 3:

				break ;
			case 4:

				break ;
			case 5:

				break ;
			case 6:

				break ;
			default:
				break ;
		}
	}

	public static void main(String[] args) {
		Menu	menu;
		Scanner	scanner;
		int		userInput;
		int		exitInput;
		int		select;
		
		scanner = new Scanner(System.in);
		if (args.length != 0 && args[0].equals("--profile=dev")) {
			exitInput = 7;
			menu = new Menu(true, scanner);
		}
		else {
			exitInput = 5;
			menu = new Menu(false, scanner);
		}
		userInput = 0;
		while (userInput != exitInput) {
		menu.printMenu();
		userInput = setSelect(scanner, exitInput);
		System.out.printf("User input is %d\n", userInput);
		goDoTheJob(userInput, scanner, menu);
		System.out.println("--------------------------------------");
		}
		System.out.println("BYE!");
	}
}