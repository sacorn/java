package hw08;

import java.util.ArrayList;

public class main {

	public static <E> void main(String[] args) {
		BinarySearchTree a = new BinarySearchTree();
		a.insert(25);
		a.insert(20);
		a.insert(36);
		a.insert(10);
		a.insert(22);
		a.insert(28);
		a.insert(40);
		a.insert(38);
		a.insert(45);
		a.insert(5);
		a.insert(12);
		a.insert(15);
		a.insert(8);
		a.delete(25);
		a.delete(20);
		a.delete(22);
		a.delete(15);
		
		a.printTree();
		System.out.println(a.find(40));
		ArrayList<E> l = new ArrayList<>();
		l = a.breadthfirst();
		for(E w : l) {
			System.out.println(w);
		}
	}

}
