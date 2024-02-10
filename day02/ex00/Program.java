package day02.ex00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Program
 */
public class Program {
	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner	scanner = new Scanner(new File("day02/ex00/test.txt"));
		List<String> lines = new ArrayList<>();

		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
		scanner.close();
	}	
}