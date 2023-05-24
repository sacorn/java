/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 06
 * Purpose: We are given number of rows and columns and we need to use link list
 * to make create nodes and attach them either right or down. so we will have a nxm
 * link list.
 */


package hw06;

public class Array2DNode<E> {
	private E item;
	protected Array2DNode<E> nextCol;
	protected Array2DNode<E> nextRow;
	
	Array2DNode() {
		this.item = null;
		this.nextCol = null;
		this.nextRow = null;
	}
	Array2DNode(E item) {
		this.item = item;
		this.nextCol = null;
		this.nextRow = null;
	}
	//get item
	public E getItem() {
		return this.item;
	}
	
	//giving item to node
	public void setItem(E item) {
		this.item = item;
	}
	
}
