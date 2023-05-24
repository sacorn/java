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

import java.util.ArrayList;

public class main {

	public static <E> void main(String[] args) {
		Array2D a = new Array2D();
		System.out.println("This is a:");
		a.print();
		System.out.println("This is a a after inserting colums or rows");
		a.addFirstCol();
		a.addFirstCol();
		a.addFirstCol();
		a.addFirstRow();
		a.insertCol(3);
		a.print();
		
		System.out.println("This is a a after setting some nodes: ");
		a.set(2, 4, "hi");
		a.set(2, 2, "hi");
		a.set(1, 4, "hey");
		a.print();
		
		System.out.println("This is a a after deleting column 4: ");
		a.deleteCol(4);
		a.print();
		System.out.println("This is a a after deleting last row: ");
		a.deleteLastRow();
		a.print();
		
		System.out.println("This is a a after inserting a row and colum: ");
		a.addLastRow();
		a.addLastCol();
		a.print();
		
		
		
		Array2D b = new Array2D(4,3); // (row,col)
		System.out.println("This is b:");
		b.print();
		System.out.println("This is b after inserting row in positiong 4");
		b.insertRow(3);
		b.print();
		System.out.println("This is b after setting some nodes");
		b.set(3, 3, "  Yerba Mate  ");
		b.set(5, 1, 44);
		b.print();
		
		Integer[][] arr = { { 1, 2, 4 }, { 3, 4, 5 } , {9,1,7}}; 
		Array2D c = new Array2D(arr);
		System.out.println("This is c:");
		c.print();
		System.out.println("This is c after setting a node:");
		c.set(1, 3, "now a string");
		c.print();
		c.deleteCol(2);
		System.out.println("This is c after deleting column 2:");
		c.print();
		
		System.out.println("This is c after deleting row 2:");
		c.deleteRow(2);
		c.print();
		
	}

}
