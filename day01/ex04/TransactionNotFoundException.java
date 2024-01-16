package day01.ex04;

/**
 * TransactionNotFoundException
 */
public class TransactionNotFoundException extends RuntimeException {
	public	TransactionNotFoundException (String text) {
		super(text);
	}
}