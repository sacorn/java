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

public class Array2D<E> extends Array2DNode{
	private int rows;
	private int cols;
	private Array2DNode<E> head;
	private Array2DNode<E> rowTail;
	private Array2DNode<E> colTail;
	
	//constuctor
	Array2D() {
		this.rows = 0;
		this.cols = 0;
		this.head = null;
		this.rowTail = null;
		this.colTail = null;
	}
	
	// constructor that takes number of rows and columns
	Array2D(int rows, int cols) { // addfirst column info given here
		this.rows = rows;
		this.cols = cols;
		this.head = null;
		this.rowTail = null;
		this.colTail = null;
		addFirstRow();		
	}
	
	//constructor that takes 2D array with values
	Array2D(E[][] arr) {
		int rows = 0;
		int cols = 0;
		for(int i = 0; i < arr.length; i++) {
			rows++;
		}
		for(int i = 0; i < arr[0].length; i++) { // every row should have the same amount of columns
			cols++;
		}
		this.rows = rows;
		this.cols = cols;
		this.head = null;
		this.rowTail = null;
		this.colTail = null;
		createFromArray(arr);
	}

	//returns column size
	public int colSize() {
		return this.cols;
	}

	//returns row size
	public int rowSize() {
		return this.rows;
	}

	// creates linklist with values in the array
	private void createFromArray(E[][] arr) {
		Array2DNode<E> temp = null;
		//creating first row
		for(int i = 0; i < cols; i++) {
			Array2DNode<E> newNode = new Array2DNode<>(arr[0][i]);// 0 bc we are getting only first row. i = column position
			if(i == 0) {
				temp = this.head = this.colTail = this.rowTail = newNode;
			}
			else {
				temp.nextCol = newNode;
				temp = newNode;
			}
		}//i
		this.colTail = temp;
		//completes the rest of the rows and connects them to the first one
		for(int i = 1; i < rows; i++) { //rowSize()-1 bc we created a row already, i=0. UPDATE:  i=1 BC WE ALREADY CREATED FIRST ROW and want to read in from arr
			Array2DNode<E> tempHead = null;
			Array2DNode<E> tempColTail = null;
			//creates new row
			for(int k = 0; k < cols; k++) {
				Array2DNode<E> newNode = new Array2DNode<>(arr[i][k]);
				if(k == 0) {
					tempHead = tempColTail = newNode;
				}
				else {
					tempColTail.nextCol = newNode;
					tempColTail = newNode;
				}
			}// for k

			int count = 0;
			Array2DNode<E> tempMovingRightColOldRow = this.rowTail;
			Array2DNode<E> tempMovingRightColNewRow = tempHead;
			//connects new row with the previous one in linklist
			while(count < cols) {
				tempMovingRightColOldRow.nextRow = tempMovingRightColNewRow;
				tempMovingRightColOldRow = tempMovingRightColOldRow.nextCol;
				tempMovingRightColNewRow = tempMovingRightColNewRow.nextCol; // does it loose the following nodes?
				count++;
			}
			this.rowTail = tempHead;
		}// for i
	}

	//Assigns the given item to the Array2DNode at position (row, col).
	public void set(int row, int col, E item) {
		if(row > rowSize() || col > colSize() || row < 0 || col < 0) {
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		Array2DNode<E> temp = this.getHead();
		//moving right
		while(count < (col-1)) {
			temp = temp.nextCol;
			count++;
		}
		count = 0;
		//moving down after we got our column
		while(count < (row-1)) {
			temp = temp.nextRow;
			count++;
		}
		temp.setItem(item);
	}

	//Adds a new column of empty nodes to the beginning of the list.
	public void addFirstCol() {
		if(colSize() == 0 && rowSize() == 0) {
			Array2DNode newNode = new Array2DNode<>(null);
			this.head = this.colTail = this.rowTail = newNode;
			this.rows++;
			this.cols++;
		}
		else if(this.getHead() == null) { //if no columns exist or no rows (AKA nothing exists)
			Array2DNode<E> temp = null;
			for(int i = 0; i < rows; i++) {
				Array2DNode<E> newNode = new Array2DNode<>(null);
				if(i == 0) {
					temp = this.head = this.colTail = this.rowTail = newNode;
				}
				else {
					temp.nextRow = newNode;
					temp = newNode;
				}
			}//i
			this.rowTail = temp;
			//creating the rest of the columns and connecting them
			for(int i = 1; i < cols; i++) { // i= 1 bc we already created a column, now we have to finish the rest
				Array2DNode<E> tempHead = null;
				Array2DNode<E> tempRowTail = null;
				//creates new row
				for(int k = 0; k < rows; k++) {
					Array2DNode<E> newNode = new Array2DNode<>(null);
					if(k == 0) {
						tempHead = tempRowTail = newNode;
					}
					else {
						tempRowTail.nextRow = newNode;
						tempRowTail = newNode;
					}
				}// for
				
				int count = 0;
				Array2DNode<E> tempMovingDownlOldCol = this.colTail;
				Array2DNode<E> tempMovingDowndowNewCol = tempHead;
				//connects last row. now we attach old row w/ new row
				while(count < rows) {
					tempMovingDownlOldCol.nextCol = tempMovingDowndowNewCol;
					tempMovingDownlOldCol = tempMovingDownlOldCol.nextRow;
					tempMovingDowndowNewCol = tempMovingDowndowNewCol.nextRow; // does it loose the following nodes?
					count++;
				}
				this.colTail = tempHead;
			}
		}
		else {
			Array2DNode<E> tempHead = null;
			Array2DNode<E> tempRowTail = null;
			for(int i = 0; i < rowSize(); i++) { // can be a while too
				Array2DNode<E> newNode = new Array2DNode<>(null);
				if(i == 0) {
					 tempHead = tempRowTail = newNode;
				}
				else {
					tempRowTail.nextRow = newNode;
					tempRowTail = newNode;
				}
			}
			int count = 0;
			Array2DNode<E> oldRow = this.getHead();
			Array2DNode<E> newRow = tempHead;
			while(count < rowSize()) { // attaches new column to front of the first column.
				newRow.nextCol = oldRow;
				newRow = newRow.nextRow;
				oldRow = oldRow.nextRow;
				count++;
			}
			this.head = tempHead;
			this.rowTail = tempRowTail;
			this.cols++;
			}
		
	}
	
	//Adds a new row to the beginning of the list.
	public void addFirstRow() {
		if(colSize() == 0 && rowSize() == 0) {
			Array2DNode newNode = new Array2DNode<>(null);
			this.head = this.colTail = this.rowTail = newNode;
			this.rows++;
			this.cols++;
		}
		else if(this.getHead() == null) { //if no columns exist or no rows (AKA nothing exists)
			Array2DNode<E> temp = null;
			for(int i = 0; i < cols; i++) {
				Array2DNode<E> newNode = new Array2DNode<>(null);
				if(i == 0) {
					temp = this.head = this.colTail = this.rowTail = newNode;
				}
				else {
					temp.nextCol = newNode;
					temp = newNode;
				}
			}//i
			this.colTail = temp;
			
			for(int i = 0; i < (rows-1); i++) { //rowSize()-1 bc we created a row already
				Array2DNode<E> tempHead = null;
				Array2DNode<E> tempColTail = null;
				//creates new row
				for(int k = 0; k < cols; k++) {
					Array2DNode<E> newNode = new Array2DNode<>(null);
					if(k == 0) {
						tempHead = tempColTail = newNode;
					}
					else {
						tempColTail.nextCol = newNode;
						tempColTail = newNode;
					}
				}// for
				
				int count = 0;
				Array2DNode<E> tempMovingRightColOldRow = this.rowTail;
				Array2DNode<E> tempMovingRightColNewRow = tempHead;
				//connects last row. now we attach old row w/ new row
				while(count < cols) {
					tempMovingRightColOldRow.nextRow = tempMovingRightColNewRow;
					tempMovingRightColOldRow = tempMovingRightColOldRow.nextCol;
					tempMovingRightColNewRow = tempMovingRightColNewRow.nextCol; // does it loose the following nodes?
					count++;
				}
				this.rowTail = tempHead;
			}
		}
		
		else {
			Array2DNode<E> tempHead = null;
			Array2DNode<E> tempColTail = null;
			for(int i = 0; i < colSize(); i++) {
				Array2DNode<E> newNode = new Array2DNode<>(null);
				if(i == 0) {
					tempHead = tempColTail = newNode;
				}
				else {
					tempColTail.nextCol = newNode;
					tempColTail = newNode;
				}
			}//for
			int count = 0;
			Array2DNode<E> oldCol = this.getHead();
			Array2DNode<E> newCol = tempHead;
			while(count < colSize()) {
				newCol.nextRow = oldCol;
				newCol = newCol.nextCol;
				oldCol= oldCol.nextCol;
				count++;
			}
			this.head = tempHead;
			this.colTail = tempColTail;
			this.rows++;
		}

	}
	
	//Adds a new column to the end of the list.
	public void addLastCol() {
		//Maybe write code if nothing exist create a column?
		
		Array2DNode<E> tempHead = null;
		Array2DNode<E> tempRowTail = null;
		for(int i = 0; i < rowSize(); i++) {
			Array2DNode<E> newNode = new Array2DNode<>(null);
			if(i == 0) {
				tempHead = tempRowTail = newNode;
			}
			else {
				tempRowTail.nextRow = newNode;
				tempRowTail = newNode;
			}
		}
		int count = 0;
		Array2DNode<E> tempMovingDownRowOldCol = this.colTail;
		Array2DNode<E> tempMovingDownRowNewCol = tempHead;
		while(count < rowSize()) { // connecting our new column to end
			tempMovingDownRowOldCol.nextCol = tempMovingDownRowNewCol;
			tempMovingDownRowOldCol = tempMovingDownRowOldCol.nextRow;
			tempMovingDownRowNewCol = tempMovingDownRowNewCol.nextRow;
			count++;
		}
		this.colTail = tempHead;
		this.cols++;
	}
	
	//Adds a new column to the end of the list.
	public void addLastRow() {
		
		Array2DNode<E> tempHead = null;
		Array2DNode<E> tempColTail = null;
		//creates new row
		for(int i = 0; i < colSize(); i++) {
			Array2DNode<E> newNode = new Array2DNode<>(null);
			if(i == 0) {
				tempHead = tempColTail = newNode;
			}
			else {
				tempColTail.nextCol = newNode;
				tempColTail = newNode;
			}
		}// for
		int count = 0;
		Array2DNode<E> tempMovingRightColOldRow = this.rowTail;
		Array2DNode<E> tempMovingRightColNewRow = tempHead;
		//connects last row.
		while(count < colSize()) {
			tempMovingRightColOldRow.nextRow = tempMovingRightColNewRow;
			tempMovingRightColOldRow = tempMovingRightColOldRow.nextCol;
			tempMovingRightColNewRow = tempMovingRightColNewRow.nextCol;
			count++;
		}
		this.rowTail = tempHead;
		this.rows++;
	}
	
	//Inserts a column at the given index. (Insert here means the columns shift over by 1 from the insertion point onward).
	public void insertCol(int index) {
		if(index > colSize() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
			Array2DNode<E> tempNewHead = null;
			Array2DNode<E> tempNewRowTail = null;
			for(int i = 0; i < rowSize(); i++) { //can make a helper f(x) and return a pair: tempHead & tempNewRowTail
				Array2DNode<E> newNode = new Array2DNode<>(null);
				if(i == 0) {
					tempNewHead = tempNewRowTail = newNode;
				}
				else {
					tempNewRowTail.nextRow = newNode;
					tempNewRowTail = newNode;
				}
			}//for
			int count = 0;
			Array2DNode<E> tempNextHead = this.getHead();
			Array2DNode<E> tempPrevHead = this.getHead();
			// going right on columns till we find our position where it will give us prev and next position
			while(count < (index-1)) {
				if(count == 0) {
					tempNextHead = tempNextHead.nextCol;
					count++;
				}
				else {
					tempNextHead = tempNextHead.nextCol;
					tempPrevHead = tempPrevHead.nextCol;
					count++;
				}
			}
			count = 0;
			while(count < rowSize()) {
				tempPrevHead.nextCol = tempNewHead;
				tempNewHead.nextCol = tempNextHead;
				tempPrevHead = tempPrevHead.nextRow;
				tempNewHead = tempNewHead.nextRow;
				tempNextHead = tempNextHead.nextRow;
				count++;
			}
			this.cols++;
	}
	
	//Inserts a row at the given index. (Insert here means the rows shift over by 1 from the insertion point onward).
	public void insertRow(int index) {
		if(index > rowSize() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Array2DNode<E> tempNewHead = null;
		Array2DNode<E> tempNewColTail = null;
		//creating row
		for(int i = 0; i < colSize(); i++) { //can make a helper f(x) and return a pair: tempHead & tempNewRowTail
			Array2DNode<E> newNode = new Array2DNode<>(null);
			if(i == 0) {
				tempNewHead = tempNewColTail = newNode;
			}
			else {
				tempNewColTail.nextCol = newNode;
				tempNewColTail = newNode;
			}
		}//for
		int count = 0;
		Array2DNode<E> tempNextHead = this.getHead();
		Array2DNode<E> tempPrevHead = this.getHead();
		//going down columns till we find our position where we will save the prev and next data of our new row.
		while(count < (index-1)) {
			if(count == 0) {
				tempNextHead = tempNextHead.nextRow;
				count++;
			}
			else {
				tempNextHead = tempNextHead.nextRow;
				tempPrevHead = tempPrevHead.nextRow; //WAS A MISTAKE HERE HAD: tempNextHead
				count++;
			}
		}
		count = 0;
		//connecting new row between existing rows
		while(count < colSize()) {
			tempPrevHead.nextRow = tempNewHead;
			tempNewHead.nextRow = tempNextHead;
			tempPrevHead = tempPrevHead.nextCol;
			tempNewHead = tempNewHead.nextCol;
			tempNextHead = tempNextHead.nextCol;
			count++;
		}
		this.rows++;
	}
	
	//Removes the first column.
	public void deleteFirstCol() {
		Array2DNode<E> temp = this.getHead();
		this.head = this.getHead().nextCol;
		this.rowTail = this.rowTail.nextCol;
		int count = 0;
		while(count < rowSize()) {
			temp.nextCol = null;
			temp = temp.nextRow;
			count++;
		}
		this.cols--;
	}
	
	//Removes the first row.
	public void deleteFirstRow() {
		Array2DNode<E> temp = this.getHead();
		this.head = this.getHead().nextRow;
		this.colTail = this.colTail.nextRow;
		int count = 0;
		while(count < colSize()) {
			temp.nextRow = null;
			temp = temp.nextCol;
			count++;
		}
		this.rows--;
	}
	
	//Removes the last column.
	public void deleteLastCol() {
		Array2DNode<E> temp = this.getHead();
		int count = 0;
		//finds new previous coulmn from colTail
		while(count < (colSize()-2)) {// -2 bc we want to go one previous column from last column
			temp = temp.nextCol;
			count++;
		}
		this.colTail = temp;
		count = 0;
		while(count < rowSize()) {
			temp.nextCol = null;
			temp = temp.nextRow;
			count++;
		}
		this.cols--;
	}
	
	//Removes the last row.
	public void deleteLastRow() {
		Array2DNode<E> temp = this.getHead();
		int count = 0;
		while(count < (rowSize()-2)) {
			temp = temp.nextRow;
			count++;
		}
		this.rowTail = temp;
		count = 0;
		//going down our new rowTail to give .nextRow = null
		while(count < colSize()) {
			temp.nextRow = null;
			temp = temp.nextCol;
			count++;
		}
		this.rows--;		
	}
	
	//Removes the column at the given index.
	public void deleteCol(int index) {
		int firstCol = 0;
		if(index > colSize() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if(index == colSize()) {
			deleteLastCol();
		}
		else if((index-1) == firstCol) {
			deleteFirstCol();
		}
		else {
			//Array2DNode tempNextHead = this.head;
			Array2DNode<E> prevCol = this.getHead();
			Array2DNode<E> colToDelete = this.getHead();
			int count = 0;
			//finding column we want so we can set each node's .nextCol to null in that column and prev column
			while(count < index-1) {
				if(count == 0) {
					colToDelete = colToDelete.nextCol;
					count++;
				}
				else {
					colToDelete = colToDelete.nextCol;
					prevCol = prevCol.nextCol;
					count++;
				}
			}//while
			count = 0;
			//connecting prev column with next column of one we want to delete. setting .nextCol = null on colum we want to delete
			while(count < rowSize()) {
				prevCol.nextCol = colToDelete.nextCol;
				colToDelete.nextCol = null;
				prevCol = prevCol.nextRow;
				colToDelete = colToDelete.nextRow;
				count++;
			}
			this.cols--;
		}
	}
	
	//Removes the row at the given index.
	public void deleteRow(int index) {
		int firstRow = 0;
		if(index > rowSize() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if(index == rowSize()) {
			deleteLastRow();
		}
		else if((index-1) == firstRow) {
			deleteFirstRow();
		}
		else {
			Array2DNode<E> prevRow = this.getHead();
			Array2DNode<E> rowToDelete = this.getHead();
			int count = 0;
			while(count < index-1) {
				if(count == 0) {
					rowToDelete = rowToDelete.nextRow;
					count++;
				}
				else {
					rowToDelete = rowToDelete.nextRow;
					prevRow = prevRow.nextRow;
					count++;
				}
			}// while
			count = 0;
			while(count < colSize()) {
				prevRow.nextRow = rowToDelete.nextRow;
				rowToDelete.nextRow = null;
				prevRow = prevRow.nextCol;
				rowToDelete = rowToDelete.nextCol;
				count++;
			}
			this.rows--;
		}
	}
	
	// Returns the item at the given (row, col)
	public E get(int row, int col) {
		if(row > rowSize() || col > colSize() || row < 0 || col < 0) {
			throw new IndexOutOfBoundsException();
		}
		int count = 0;
		Array2DNode<E> temp = this.getHead();
		//moving right
		while(count < (col-1)) {
			temp = temp.nextCol;
			count++;
		}
		count = 0;
		//moving down after we got our column
		while(count < (row-1)) {
			temp = temp.nextRow;
			count++;
		}
		return temp.getItem();
	}
	
	//Returns an ArrayList<E> which holds the values from the requested column.
	public ArrayList<E> getCol(int col) {
		Array2DNode<E> temp = this.getHead();
		int count = 0;
		while(count < (col-1)) {
			temp = temp.nextCol;
			count++;
		}
		count = 0;
		ArrayList<E> column = new ArrayList<E>();
		while(count < rowSize()) {
			column.add(temp.getItem());
			temp = temp.nextRow;
			count++;
		}
		return column;
	}
	//Returns an ArrayList<E> which holds the values from the requested row.
	public ArrayList<E> getRow(int row) {
		if(row > rowSize() || row < 0) {
			throw new IndexOutOfBoundsException();
		}
		Array2DNode<E> temp = this.getHead();
		int count = 0;
		//finds row we want
		while(count < (row-1)) {
			temp = temp.nextRow;
			count++;
		}
		count = 0;
		ArrayList<E> ro = new ArrayList<E>();
		//puts data from link list into ArrayList
		while(count< colSize()) {
			ro.add(temp.getItem());
			temp = temp.nextCol;
			count++;
		}
		return ro;
	}
	
	public void print() {
		Array2DNode<E> temp = this.getHead();
		Array2DNode<E> temp2 = this.getHead();
		
		for(int k =0; k < rowSize(); k++) {
			System.out.print("Row " + (k + 1) + ": ");
			for(int i = 0; i < colSize(); i++) {
				System.out.print(temp.getItem() + "    ");
				temp = temp.nextCol;
			}
			temp = temp2.nextRow;
			temp2 = temp2.nextRow;
			System.out.print("\n");
		}
		
	}

	public Array2DNode<E> getHead() {
		return this.head;
	}


	
}
