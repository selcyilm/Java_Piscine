package day01.ex05;

import java.util.Scanner;

/**
 * Program
 */
public class Program {

	public	static	void	goDoTheJob(int input, Scanner scanner, Menu menu, int exitInput) {
		if (input == exitInput)
			return ;
		switch (input) {
			case 1:
				menu.addUser();
				break ;
			case 2:
				menu.viewUserBalance();
				break ;
			case 3:
				menu.performTransfer();
				break ;
			case 4:
				menu.viewTransById();
				break ;
			case 5:
				menu.removeTrById();
				break ;
			case 6:
				menu.checkTransferValidity();
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
		boolean	passSelection;
		String	endline;

		userInput = 5;
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
		passSelection = false;
		while (userInput != exitInput) {
			menu.printMenu();
			try {
				userInput = scanner.nextInt();
				passSelection = true;
				endline = scanner.nextLine();
				if (endline.length() != 0 || userInput < 1 || userInput > exitInput) {
					throw	new	NonExistingCommandExeption("Invalid Input!");
				}
				goDoTheJob(userInput, scanner, menu, exitInput);
				System.out.println("-------------------------------------");
			} catch (Exception e) {
				System.out.println(e);
				if (!passSelection) {
				scanner.nextLine();
				System.out.println("-------------------------------------");
				}
			}
			passSelection = false;
		}
		scanner.close();
		System.out.println("BYE!");
	}
}