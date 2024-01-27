package day01.ex05;

/**
 * TransactionNotFoundException
 */
public class TransactionNotFoundException extends RuntimeException {
	public	TransactionNotFoundException (String text) {
		super(text);
	}
}