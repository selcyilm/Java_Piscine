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

	public void createVectorOfFiles() {
		for (String each : baseDictSet) {
			file1Vector.add(wordCount(each, file1List));
		}

		for (String each : baseDictSet) {
			file2Vector.add(wordCount(each, file2List));
		}
	}

	private int	wordCount(String word, List<String> wordList) {
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
}