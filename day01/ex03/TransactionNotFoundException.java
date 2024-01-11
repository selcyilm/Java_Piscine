package day01.ex03;

/**
 * TransactionNotFoundException
 */
public class TransactionNotFoundException extends RuntimeException {
	public	TransactionNotFoundException (String text) {
		super(text);
	}
}