package Tree;

import java.io.Serializable;

public class Node <E> implements Serializable {
	int key;
	E data;
	Node<E> leftChild;
	Node<E> rightChild;
	public Node(int k,E e)
	{
		key=k;
		data=e;
		leftChild=null;
		rightChild=null;
	}
	public void display() {
		System.out.println(data);

	}
}
