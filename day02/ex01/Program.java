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
			System.out.println(file1.getWordList());
			System.out.println(file2.getWordList());
		}
		else {
			System.err.println("Error");
			System.exit(-1);
		}
	}
}