import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;;
/**
 * Dictonary
 */
public class Dictonary {

	List<String>	baseDictList = new ArrayList<>();
	Set<String>		baseDictSet = new TreeSet<>();
	List<String>	file1List;
	List<String>	file2List;
	Vector<Integer>	file1Vector = new Vector<>();
	Vector<Integer>	file2Vector = new Vector<>();
	boolean			isFileNull = false;

	public Dictonary(List <String> file1List, List<String> file2List) {
		this.file1List = file1List;
		this.file2List = file2List;
		if (file1List == null || file2List == null)
			this.isFileNull = true;
	}

	/*
	 * takes file1List and file2List and create and returns dictionary base words
	 * list.
	 */
	public List<String> createDictBase () {
		int	i;

		i = 0;
		while (i < file1List.size()) {
			if (!baseDictList.contains(file1List.get(i)))
				baseDictList.add(file1List.get(i));
			i++;
		}

		i = 0;
		while (i < file2List.size()) {
			if (!baseDictList.contains(file2List.get(i))) {
				baseDictList.add(file2List.get(i));
			}
			i++;
		}
		return (baseDictList);
	}
	/*
	 * does the same thing with the method upside but with Sets
	 */
	public Set<String> createDictBaseSet() {
		int	i;

		i = 0;
		while (i < file1List.size())
			baseDictSet.add(file1List.get(i++));

		i = 0;
		while (i < file2List.size())
			baseDictSet.add(file2List.get(i++));
		return (baseDictSet);
	}

	/*
	 * It takes the file lists and create the dictionary with words without duplicate
	 */
	public void createVectorOfFiles() {
		for (String each : baseDictSet) {
			file1Vector.add(wordCount(each, file1List));
		}

		for (String each : baseDictSet) {
			file2Vector.add(wordCount(each, file2List));
		}
	}
	
	/*
	 * creates the dictionary.txt file and put the all words inside of it
	 */
	public void	createFileDict() {
		try {
			File dictFile = new File("dictionary.txt");
			FileWriter fileWriter = new FileWriter(dictFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			dictFile.createNewFile();
			int	i;

			i = 1;
			for (String each : this.baseDictSet) {
				int totalWord = wordCount(each, file1List) + wordCount(each, file2List);

				bufferedWriter.append(i++ + ". " + each + ": " + totalWord + "\n");
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Error: creating file!");
			System.exit(5);
		}
	}

	public double getSimilarity() {
		double	numerator;
		double	denominator;
		double	ret;

		numerator = dotProductOfTwoVector(file1Vector, file2Vector);
		denominator = productOfMagnitutes(file1Vector, file2Vector);
		ret = numerator / denominator;
		if (numerator == -1 || denominator == -1) {
			System.err.println("Error: check your vector size cos it's not the same yo!");
			System.exit(6);
		}
		return (ret);
	}

	/*
	 * takes word and it returns how many times that 'word' was in the list
	 * return 0 if the list is emty
	 */
	private int	wordCount(String word, List<String> wordList) {
		if (wordList == null)
			return (0);
		int	i;
		int ret;

		ret = 0;
		i = 0;
		while (i < wordList.size()) {
			if (wordList.get(i).equals(word))
				ret++;
			i++;
		}
		return (ret);
	}

	/*
	 * takes two vector as an argument and it calculates and returns the dot product of two,
	 * two vector must be same size, returns -1 if the sizes is different
	 */
	private int	dotProductOfTwoVector(Vector<Integer> first, Vector<Integer> second) {
		if (first.size() != second.size())
			return (-1);

		int	i;
		int	sum;

		sum = 0;
		i = 0;
		while (i < first.size()) {
			sum += first.get(i) * second.get(i);
			i++;
		}
		return (sum);
	}

	/*
	 * The magnitudes of vectors A and B are calculated using the Euclidean norm,
	 * also known as the magnitude or length of a vector. To find the magnitude,
	 * you square each element of the vector, sum them up, and then take the 
	 * square root of the sum. So it returns the product of it. Both vectors
	 * must have same size, returns -1 if they are not zZz
	 */
	private double	productOfMagnitutes(Vector<Integer> first, Vector<Integer> second) {
		if (first.size() != second.size())
			return (-1);
		
		int		i;
		int		sumFirst;
		int		sumSecond;
		double	ret;

		sumFirst = 0;
		sumSecond = 0;
		i = 0;
		while (i < first.size()) {
			sumFirst += Math.pow(first.get(i), 2);
			sumSecond += Math.pow(second.get(i), 2);
			i++;
		}
		ret = Math.sqrt(sumFirst) * Math.sqrt(sumSecond);
		return (ret);
	}
}