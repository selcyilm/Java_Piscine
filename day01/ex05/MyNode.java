package day01.ex05;

/**
 * MyNode
 */
public class MyNode {

	private	MyNode next;
	private	Transaction	data;

	public	MyNode(Transaction data, MyNode next) {
		setData(data);
		setNext(next);
	}

	public	MyNode	getNext() {
		return (next);
	}

	public	Transaction	getData() {
		return (data);
	}

	public	void	setData(Transaction data) {
		this.data = data;
	}

	public	void	setNext(MyNode next) {
		this.next = next;
	}


}