/**
 * Program
 */
public class Program {

	static FileHandler	file1;
	static FileHandler	file2;

	public static void main(String[] args) {

		if (args.length == 2) {
			file1 = new FileHandler(args[0]);
			file2 = new FileHandler(args[1]);
			file1.getWordList();
			file2.getWordList();

			System.out.println("File1: " + file1.wordsList);
			System.out.println("File2: " + file2.wordsList);
			
			Dictonary dictonary = new Dictonary(file1.wordsList, file2.wordsList);
			dictonary.createDictBase();
			dictonary.createDictBaseSet();
			System.out.println("Dict(Set): " + dictonary.baseDictSet);
			dictonary.baseDictList.sort(null);
			System.out.println("Dict(List): " + dictonary.baseDictList);

			dictonary.createVectorOfFiles();

			System.out.println("Vector File1: " + dictonary.file1Vector);
			System.out.println("Vector File2: " + dictonary.file2Vector);

			dictonary.createFileDict();
		}
		else {
			System.err.println("Error: invalid Input size!");
			System.exit(-1);
		}
	}
}
