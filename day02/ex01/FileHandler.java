import java.io.*;
import java.util.*;

/**
 * FileHandler
 */
public class FileHandler {
	private static final long	MAX_FILE_SIZE = 1024 * 1024 * 10;
	BufferedReader				bufferedReader;
	FileReader					fileReader;
	String						fileName;
	List<String>				wordsList = new ArrayList<>();

	/*
	 * It is a container for taking the file path and initialize the buffered reader and
	 * file reader.
	 */
	public FileHandler(String filePath) {
		try {
			this.fileReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + filePath + " is not found!");
			System.exit(1);
		}
		this.bufferedReader = new BufferedReader(this.fileReader);
		this.fileName = filePath;
	}

	/*
	 * it basically read the whole file and replace all non word characters into space,
	 * then splits all the file with space, then add it to its list.
	 */
	public List<String> getWordList() {
		File	file;

		file = new File(fileName);
		if (file.length() > MAX_FILE_SIZE) {
			System.err.println("Error: File is more than 10MB!");
			System.exit(2);
		}
		
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("\\W", " ");
				line = line.replaceAll("\\s+", " ");
				String words[] = line.split(" ");
				for (String each : words) {
					wordsList.add(each);
				}
			}
		} catch (IOException e) {
			System.err.println("Error: reading file!");
			System.exit(3);;
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println("Error: closing file!");
			System.exit(4);
		}
		return wordsList;
	}
}
