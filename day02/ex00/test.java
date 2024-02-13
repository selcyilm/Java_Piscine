package day02.ex00;

import java.util.Scanner;

/**
 * test
 */
public class test {
	public static void main(String[] args) {
		Scanner	scanner = new Scanner(System.in);
		System.out.print("Enter the file path: ");
		String	path = scanner.nextLine();
		System.out.println("-> ");
		String	input = scanner.nextLine();
		while (!input.equals("42")) {
			Signatures	signatures = new Signatures(path + input);
			signatures.hexs = signatures.getSignature();
			signatures.parseSignatureTxt();
			String ret = signatures.compareMaptoSignature(signatures.signatures, signatures.listToString());
			System.out.println(ret);
			input = scanner.nextLine();
		}
	}
}