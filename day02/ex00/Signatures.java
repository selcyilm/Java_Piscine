package day02.ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Signatures
 */
public class Signatures {

	Map<String, String>	signatures = new HashMap<>();
	List<String>		hexs;
	private	String				userInput;
	private	FileInputStream		fileInputStream;
	private	FileOutputStream	fileOutputStream;
	private	File				file;
	private	Scanner				scanner;

	public	Signatures(String userInput) {
		this.userInput = userInput;
	}

	public	List<String>	getSignature() {
		hexs = new ArrayList<>();
		try {
		fileInputStream = new FileInputStream(userInput);
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
	} catch (IOException e) {
			e.printStackTrace();
		
		}
		return (hexs);
	}

	public	void	parseSignatureTxt() {
		signatures = new HashMap<>();
		file = new File("day02/ex00/signatures.txt");
		String keyValue[] = new String[2];
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			keyValue = line.split(", ");
			signatures.put(keyValue[0], keyValue[1]);
		}
		scanner.close();
	}

	public	String	listToString() {
		String compare = "";
		for (int i = 0; i < hexs.size(); i++) {
			compare += hexs.get(i);
			if (i != hexs.size() - 1)
				compare += " ";
		}
		return (compare);
	}

	public	String	compareMaptoSignature(Map<String, String> signatures, String compare) {
		String ret = "";
		for (Map.Entry<String, String> entry: signatures.entrySet()) {
			if (compare.contains(entry.getValue()))
				return (entry.getKey());
		}
		return (null);
	}
}