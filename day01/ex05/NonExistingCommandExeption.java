package day01.ex05;

/**
 * NonExistingCommandExeption
 */
public class NonExistingCommandExeption extends RuntimeException{
	public	NonExistingCommandExeption(String text) {
		super(text);
	}
	
}