package day02.ex00;

import java.util.Scanner;
import java.io.File;

/*
 * Program
 */
public class Program {
	public static void main(String[] args) {
		Scanner	scanner = new Scanner(System.in);
		File	fileTodel = new File("day02/ex00/result.txt");
		if (fileTodel.exists())
			fileTodel.delete();
		String	path = "day02/ex00/";
		System.out.print("-> ");
		String	input = scanner.nextLine();
		while (!input.equals("42")) {
			Signatures	signatures = new Signatures(path + input);
			signatures.hexs = signatures.getSignature();
			signatures.parseSignatureTxt();
			String ret = signatures.compareMaptoSignature(signatures.signatures, signatures.listToString());
			if (ret != null) {
				signatures.writeToFile(ret);
				System.out.println("PROCESSED");
			}
			else
				System.out.println("NOT DEFINED");
			System.out.print("-> ");
			input = scanner.nextLine();
		}
		scanner.close();
	}
}