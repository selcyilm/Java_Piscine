package day01.ex05;

/**
 * UsersList
 */
public interface UsersList {

	void	addUser(User last);
	User	retrieveById(int id);
	User	retrieveByIndex(int index);
	int		retrieveByCount();
}