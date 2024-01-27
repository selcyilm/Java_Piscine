package day01.ex05;

/**
 * UserIdsGenerator
 */
public class UserIdsGenerator {

	private	static	UserIdsGenerator instance = null;
	private	static	int	lastId;

	private	UserIdsGenerator() {
		lastId = 0;
	}

	public	static	UserIdsGenerator getInstance() {
		if (instance == null) {
			instance = new UserIdsGenerator();
		}
		return (instance);
	}

	public	int	generateId() {
		lastId++;
		return (lastId);
	}
}
