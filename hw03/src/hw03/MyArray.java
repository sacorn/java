/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 03
 * Purpose: This program works with generics.
 */
package hw03;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class MyArray<E extends Comparable<E>> {
	//No other data fields necessary.
	private E[] data;
	
	//constructor
	public MyArray(int size) {
		this.data = (E[])(new Comparable[size]);
		}

	//This constructor can accept an array or a comma-separated list of values.
	public MyArray(E ... elements) {
		this.data = (E[])(new Comparable[elements.length]);
	    //Make a deep copy to prevent shared references.
		System.arraycopy(elements, 0, this.data, 0, elements.length);
		}
	
	//returns data at the given index.
	public E get(int index) {
		return data[index];
	}


	public MyArray get(int start, int end) {
		MyArray<E> newArray = new MyArray<E>();
		//5MyArray[] newArray;
		//ArrayList<MyArray> newArray = new ArrayList<MyArray>();
		E[] temp = (E[])(new Comparable[end-start]);
		for(int i = 0; i < temp.length; i++) {
			newArray.data[i] = this.data[start + 1];
		}
		return newArray;
	}
	//take an integer and a value and place the value at the given index. 
	public void put(int index, E value) {
		
		this.data[index] = value;
	}
	//take the values and place them into the array replacing the values between the start index position and the end index position.
	public void put(int start, int end, E[] elements) {
		for(E i : elements) {
			this.data[start++] = i;
		}
	}
	//
	public boolean equals(Object obj) {
		System.out.println("HI");
		MyArray other = (MyArray) obj;
		
		if(this.data.length != other.data.length) {
			System.out.println("Fails here");
			return false;
		}
		if (!(obj instanceof MyArray)) {
			System.out.println("Fails here 1");
			return false;
	       }
	return true; //if all are false then both objects are the same
		
	}
	//returns max
	public E max() {
		E max = this.data[0];
		
		for(int i = 1; i <= this.data.length - 1; i++) {
		    if (max.compareTo(this.data[i]) > 0) {
		        max = this.data[i];
		    }
		}
		return max;
	}
	//return min
	public E min() {
		E min = this.data[0];
		for(int i = 1; i < this.data.length; i++) {
			if(min.compareTo(this.data[i]) < 0) {
				min = this.data[i];
			}
		}
		return min;
	}
	//reverses the array
	public void reverse() {
		E temp;
		for(int i = 0; i < this.data.length / 2; i++) {
			temp = this.data[i];
		    this.data[i] = this.data[this.data.length - i - 1];
		    this.data[this.data.length - i - 1] = temp;
		}
	}
	//shuffles array
	public void shuffle() {
		List<E> arrayToShuffle = Arrays.asList(this.data);
		Collections.shuffle(arrayToShuffle);
		arrayToShuffle.toArray(this.data);
	}
	//shifting position of array info to the left
	public void leftShift(int shiftDistance) {
		for(int i = 0; i < shiftDistance; i++) {
			E temp = this.data[0];
		     for(int j = 0; j < this.data.length - 1; j++) {
		    	 this.data[j] = this.data[j+1];
		     }
		     this.data[this.data.length-1] = temp;
		}
	}
	//shifting array to the right by given integer
	public void rightShift(int shiftDistance) {
		for(int i = 0; i < shiftDistance; i++) {
			E temp = this.data[this.data.length - 1];
	        for(int j = this.data.length - 2; j >= 0 ; j--) {
	        	this.data[j + 1] = this.data[j];
	        }
	        this.data[0] = temp;
		}
	}
	//return size of array
	public int size() {
		return this.data.length;
	}
	//display each value of the array on one line and should separate each value with a comma and one space.
	public String toString() {
		StringBuilder str = new StringBuilder();

		for(int i = 0; i < size(); i++) {
			str.append( (i < size() -1) ? this.data[i] + ", " : this.data[i]);
		}
		return str.toString();
	}
	//sorts array
	public void sort() {
		E temp;
		for (int i = 0; i < this.data.length; i++) {
            for (int j = i + 1; j < this.data.length; j++) {
                if (this.data[i].compareTo(this.data[j]) > 0) {
                    temp = this.data[i];
                    this.data[i] = this.data[j];
                    this.data[j] = temp;
                }
            }
		}
	}
	
}