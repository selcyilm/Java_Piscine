package day02.ex00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Program
 */
public class Program {
	public static void main(String[] args) throws FileNotFoundException {
		List<String> hexs = new ArrayList<>();
		try {
		FileInputStream fileInputStream = new FileInputStream("day02/ex00/giphy.gif");
		int bt;
		int	i = 0;
		while (i < 8) {
			bt = fileInputStream.read();
			if (bt != -1) {
				String str = Integer.toUnsignedString(bt, 16).toUpperCase(); 
				if (str.length() == 1) {
					str = "0" + str;
				}
				hexs.add(str);
			}
			i++;
		}
		fileInputStream.close();
	}
	catch (IOException e) {
	e.printStackTrace();
	}
		Map<String, String> signatures = new HashMap<>();
		File	file = new File("day02/ex00/signatures.txt");
		String keyValue[] = new String[2];
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			keyValue = line.split(", ");
			signatures.put(keyValue[0], keyValue[1]);
		}
		scanner.close();
		String compare = "";
		for (int i = 0; i < hexs.size(); i++) {
			compare += hexs.get(i);
			if (i != hexs.size() - 1)
				compare += " ";
		}
		for (Map.Entry<String, String> entry: signatures.entrySet()) {
			if (compare.contains(entry.getValue())) {
				System.out.println(entry.getKey());
				break ;
			}
		}
	}
}