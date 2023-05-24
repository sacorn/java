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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.DOMException;

public class BinarySearchTree<E extends Comparable<E> > {
	protected BSTNode<E> root;
	
	// constructor which initializes an empty tree
	public BinarySearchTree() {
		this.root = null;
	}
	
	// constructor which takes variable length parameter list
	public BinarySearchTree(E ... elements) {
		for(E data: elements) {
			insert(data);
		}
	}
	// Method which adds a new value to the tree according to the rules of a Binary Search Tree.
	public void insert(E data) {
		BSTNode<E> childNode = new BSTNode<>(data); 
		
		if(isEmpty()) {
			this.root = childNode; // parent is null by default in BSTNode class
		}
		else {
			try {
				BSTNode<E> parent = insertionPosition(data);
				if((parent.data).compareTo(data) > 0) {
					parent.leftChild = childNode;
					childNode.parent = parent;
				}
				else if(data.compareTo(parent.data) > 0) {
					parent.rightChild = childNode;
					childNode.parent = parent;
				}
			}
			catch (IllegalArgumentException ex) { // CHECK MIGHT BE WRONG
				throw ex;
			}
		}
	}
	
	//returns node(future parent) that will be above our new one
	public BSTNode<E> insertionPosition(E data) {
		BSTNode<E> current = this.root;
		BSTNode<E> parent = null;
		
		while(current != null) {
			if(data.equals(current.data)) {
				throw new IllegalArgumentException(); 
			}
			else if((current.data).compareTo(data) > 0) { // if current.data is greater
				parent = current;
				current = current.leftChild;
			}
			else if(data.compareTo(current.data) > 0) {
				parent = current;
				current = current.rightChild;
			}
		}
		return parent;
	}


	// Returns true or false depending on if the key is found in the tree or not.
	public boolean find(E data) {
		BSTNode<E> current = this.root;
		while(current != null) {
			if(data.equals(current.data)) {
				return true;
			}
			else if((current.data).compareTo(data) > 0) {
				current = current.leftChild;
			}
			else if(data.compareTo(current.data) > 0) {
				current = current.rightChild;
			}
		}
		return false;
	}
	

	// Returns an ArrayList of values generated using preorder traversal.
	public ArrayList<E> preorder() {
		
		ArrayList<E> list = new ArrayList<>();
		if(this.root == null) {
			return list;
		}
		else {
			
			return preOrder(this.root, list);
		}
	}
	
	//collects values in preorder and sends back an arraylist
	private ArrayList<E> preOrder(BSTNode<E> node, ArrayList<E> list) {
		if(node == null) {
			return list;
		}
		list.add(node.data);
		preOrder(node.leftChild, list);
		preOrder(node.rightChild, list);
		
		return list;
	}

	
	// Returns an ArrayList of values generated using inorder traversal.
	public ArrayList<E> inorder() {
		ArrayList<E> list = new ArrayList<>();
		if(this.root == null) {
			return list;
		}
		else {
			return inOrder(this.root, list);
		}
	}
	
	//collects values in inorder and sends back an arraylist
	private ArrayList<E> inOrder(BSTNode<E> node, ArrayList<E> list) {
		if(node == null) {
			return list;
		}
		inOrder(node.leftChild, list);
		list.add(node.data);
		inOrder(node.rightChild, list);
		return list;
	}

	// Returns an ArrayList of values generated using postorder traversal.
	public ArrayList<E> postorder() {
		ArrayList<E> list = new ArrayList<>();
		if(this.root == null) {
			return list;
		}
		else {
			return postOrder(this.root, list);
		}
	}
	
	//collects values in postorder and sends back an arraylist
	private ArrayList<E> postOrder(BSTNode<E> node, ArrayList<E> list) {
		if(node == null) {
			return list;
		}
		postOrder(node.leftChild, list);
		postOrder(node.rightChild, list);
		list.add(node.data);
		return list;
	}
	
	// Returns an ArrayList of values generated using breadthfirst traversal.
	public ArrayList<E> breadthfirst() {
		ArrayList<E> list = new ArrayList<>();
		if(this.root == null) {
			return list;
		}
		else {
			return breadthFirst(this.root, list);
		}
	}
	
	//collects values in breadthFirst and sends back an arraylist
	private ArrayList<E> breadthFirst(BSTNode<E> node, ArrayList<E> list) {
		if (this.root == null) {
	    	   return list;
	       }
	       Queue<BSTNode> q = new LinkedList<>(); 
	       q.add(this.root);
	       while (!q.isEmpty()) {
	           BSTNode<E> current = (BSTNode<E>) q.remove();
	           list.add(current.data);
	           if(current.leftChild != null) {
	        	   q.add(current.leftChild);
	           }
	           if(current.rightChild != null) {
	        	   q.add(current.rightChild);
	           } 
	       }
	       return list;
	}

	// Method which takes a value (not an index) and calls private delete method sending it a node.
	public void delete(E data) {
		delete(nodeToDelete(data));
	}
	
	// receives node with given value(data) to find and deletes it off the tree
	private void delete(BSTNode<E> node) {
		if(isLeaf(node)) {
			if(isLeftChild(node)) {
				node.parent.leftChild = null;
			}
			
			else if(isRightChild(node)) {
				node.parent.rightChild = null;
			}
		}
		

		else if(numChildren(node) == 1) {
			BSTNode<E> child = getChildNode(node);

			if(isLeftChild(node)) {
				node.parent.leftChild = child;
				child.parent = node.parent;
			}
			else if(isRightChild(node)) {
				node.parent.rightChild = child;
				child.parent = node.parent;
			}
		}


		else if(numChildren(node) == 2) {
			BSTNode<E> maxDataNode = maxLeftSubtree(node);
			node.setItem(maxDataNode.getData());
			delete(maxDataNode);
		}
	}
	
	// returns the node to delete. Or null if the node was not found
	public BSTNode<E> nodeToDelete(E data) {
		BSTNode<E> current = this.root;
		while(current != null) {
			if(data.equals(current.data)) {
				return current;
			}
			else if((current.data).compareTo(data) > 0) {
				current = current.leftChild;
			}
			else if(data.compareTo(current.data) > 0) {
				current = current.rightChild;
			}
		}
		return null;
	}
	
	private BSTNode<E> maxLeftSubtree(BSTNode<E> node) {
		BSTNode<E> current = node.leftChild; // temp node
		while(current.rightChild != null) {
			current = current.rightChild;
		}
		return current;
	}
	
	
	// returns right or left child of a given node. Previous to this method call it is
	// known there is only one child, either right or left
	private BSTNode<E> getChildNode(BSTNode<E> node) {
		if(node.leftChild != null) {
			return node.leftChild;
		}
		// when they call this method we know it has to have at least one child
		// no need for else if(node.rightChild != null){return node.rC} and else {retrun null}
		else {
			return node.rightChild;
		}
	}
	
	// Returns the number of children of the given node.
	protected int numChildren(BSTNode<E> node) {
		int count = 0;
		if(node.leftChild != null) {
			count++;
		}
		if(node.rightChild != null) {
			count++;
		}
		return count;
	}
	
	// Returns true or false if the node is a leaf or not.
	protected boolean isLeaf(BSTNode<E> node) {
		return (node.leftChild == null && node.rightChild == null);
	}
	
	// returns true if node is a left child
	protected boolean isLeftChild(BSTNode<E> node) {
		if(node.parent == null) {
			return false;
		}
		else if(node.parent.leftChild == null) {
			return false;
		}
		else {
			return (node.parent.leftChild.data).equals(node.data);
		}
		
	}
	
	// returns true if node is a right child
	protected boolean isRightChild(BSTNode<E> node) {
		if(node.parent == null) {
			return false;
		}
		else if(node.parent.rightChild == null) {
			return false;
		}
		else {
			return (node.parent.rightChild.data).equals(node.data);
		}
		
	}
	
	// Returns true or false if the tree is empty or not.
	public boolean isEmpty() {
		return (this.root == null);
	}


	
	// Implement the toString method to adapt the code below to return a string representation of the tree.
	// Remember that toString() must return a String, and the algorithm below prints out the values as it 
	// iterates through the tree. You will need to figure out how to adapt the algorithm below to store the
	// values in a String and return the final String instead of printing as you go.
	/*public String toString() {
		
	}*/

	public void printTree() {  
	    if (this.root.rightChild != null) {
	        this.printTree(this.root.rightChild, true, "");
	    }
	
	    printNodeValue(this.root);

	    if (this.root.leftChild != null) {
	        this.printTree(this.root.leftChild, false, "");
	    }
	}





	private void printTree(BSTNode<E> node, boolean isRight, String indent) {
	    if (node.rightChild != null) {
	        printTree(node.rightChild, true, indent + (isRight ? "        " : " |      "));
	    }

	    System.out.print(indent);

	    if (isRight) {
	        System.out.print(" /");
	    }
	    else {
	        System.out.print(" \\");
	    }
	    System.out.print("----- ");
	    printNodeValue(node);
	    if (node.leftChild != null) {
	        printTree(node.leftChild, false, indent + (isRight ? " |      " : "        "));
	    }
	}

	private void printNodeValue(BSTNode<E> node) {
	    if (node == null) {
	        System.out.print("<null>");
	    }
	    else {
	        System.out.print(node.getData());
	    }
	    System.out.println();
	}
	
	
	
}
