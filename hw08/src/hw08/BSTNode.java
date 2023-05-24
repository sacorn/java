/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 08
 * Purpose: write inOrder, postOrder, preOrder, insert, delete and other methods
 * to create a binary search tree where we can correctly insert and place values
 * as well as deleting a leave or node with one or two children.
 */

package hw08;

public class BSTNode<E> {
	protected BSTNode<E> parent;
	protected BSTNode<E> rightChild;
	protected BSTNode<E> leftChild;
	protected E data;
	
	BSTNode(E data) {
		this.parent = null;
		this.rightChild = null;
		this.leftChild = null;
		this.data = data;
	}

	public E getData() {
		return this.data;
	}
	
	public void setItem(E data) {
		this.data = data;
	}

}
