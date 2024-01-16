package day01.ex04;

/**
 * UsersArrayList
 */
public class UsersArrayList implements UsersList {
	private	User users[];
	private	int	fixedSize;
	private	int	count;

	public	UsersArrayList() {
		this.fixedSize = 10;
		this.count = 0;
		this.users = new User[this.fixedSize];
	}

	@Override
	public	void	addUser(User last) {
		if (users.length == this.count) {
			User newUsers[] = new User[this.count + this.count / 2];
			for (int i = 0; i < users.length; i++) {
				newUsers[i] = users[i];
			}
			users = newUsers;
		}
		users[count] = last;
		count++;
	}

	@Override
	public	User	retrieveById(int id) {
		for (int i = 0; i < users.length; i++) {
			if (this.users[i].getIdentifier() == id) {
				return (users[i]);
			}
		}
		throw new	UserNotFoundException("Error: Invalid Id");
	}

	@Override
	public	User	retrieveByIndex(int index) {
		if (index < 0 || index >= this.count) {
			throw new	UserNotFoundException("Error: Invalid Index");
		}
		return (users[index]);
	}

	@Override
	public	int	retrieveByCount() {
		return (this.count);
	}
}