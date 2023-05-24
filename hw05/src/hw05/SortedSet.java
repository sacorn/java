/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 05
 * Purpose: In this program we are writing methods that will take generic values and create sets.
 * We can add values, remove, and we also check if they exist in the set in order to not have
 * duplicate values.
*/

package hw05;

import java.util.Arrays;

 

public class SortedSet<E extends Comparable<E>> {
	private E[] set;
	private int size;
	
	//constructor
	public SortedSet() {
		this.set = (E[])(new Comparable[10]);// default constructor which creates an empty set with an initial capacity of 10
	}
	
	//constructor with given capacity
	public SortedSet(int capacity) {
		this.set = (E[])(new Comparable[capacity]);
	}
	
	//constructor with given list of generic values or a generic array
	public SortedSet(E ... values) {
		this.set = (E[])(new Comparable[values.length]);
		addAll(values);
		this.size = values.length;
		Arrays.sort(this.set);
	}
	
	//Creates a copy constructor which will make a deep copy of a SortedSet.
	public SortedSet(SortedSet originalSet) { // this isnt public SortedSet(E SortedSet) bc we are already given a set object
		
		E[] newSet = (E[])(new Comparable[originalSet.size()]);
		this.size = originalSet.size();
		System.arraycopy(originalSet.set, 0, newSet, 0, originalSet.size());
		this.set = newSet;
		Arrays.sort(this.set); // dont have to do this since its likey that its sorted already but just in case
		
	}
	
	//this method checks weather a value exist in the set and returns true if value is in set, false if not in set.
	public boolean exists(E value) {
		return (binarySearch(this.set, value, 0, size()) != -1); // returns true if !=1
	}

	//add's given value to list if its not in the set
	public void add(E value) {
		int i = 0;
		if(!exists(value)) {
			if(this.set[0] == null) {
				this.set[0] = value;
				this.size++;
			}
			else {
				while(this.set[i] != null) {
					if(this.set.length == size()) resize();
					if(this.set[i].compareTo(value) > 0) {
						this.set[this.size++] = value; // size++ bc we want to place value into next slot that is not null before we increment the size of array. 
						//we do this bc we will save outselves from an error when we get to Arrays.sort() IF WE DO ++size then we add it to a slot where we skip a null
						//slot. IF that happens we then have a null data value between our "real" user input value.
						Arrays.sort(this.set, i, size());
						return;
					}
					else if(i == size() - 1) {
						this.set[this.size++] = value; // size++ bc we want to place value into next slot that is not null before we increment the size of array. 
						//we do this bc we will save outselves from an error when we get to Arrays.sort() IF WE DO ++size then we add it to a slot where we skip a null
						//slot. IF that happens we then have a null data value between our "real" user input value.
						Arrays.sort(this.set, i, size());
						return;
					}
					i++;
				}//while
			}//else
		}//if
	}

	//this method adds a list of values to generic array
	public void addAll(E ... value) {
		for(E singleValue : value) {
			add(singleValue);
		}
	}

	//this method removes value from our generic array
	public void remove(E value) {
		if(!exists(value)) return;

		else {
			 for (int i = 0, k = 0; i < size(); i++) { 
		            // if i is the same as value it will ignore it and continue placing the up-coming ones
		            if (this.set[i].compareTo(value) == 0) {
		                continue;
		            }
		            // places the values that are not the given one 1 position less than its original position in array
		            this.set[k++] = this.set[i]; 
		        }
			 this.set[size()-1] = null;
			 this.size--;// only once bc you remove one each time you call this function
		}
	}

	//returns value at given index
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return this.set[index];
	}

	//returns size in time complexity of O(1) instead of O(n)
	public int size() {
		return this.size; //starts at 1 not 0
	}

	//method shall take a SortedSet object as a parameter and return true if the two sets are equal, false if they are not
	public boolean equals(Object o) {
		SortedSet<E> tempSet = (SortedSet<E>) o;
		if(size() != tempSet.size()) return false;
		for(int i = 0; i < size(); i ++) {
			if(!this.set[i].equals(tempSet.set[i])) return false;
		}
		return true;
	}

	public String toString() {
		//I TRIED BUT THIS WAS THE HARDEST ONE TO WRITE. :/
		StringBuilder str = new StringBuilder();
		str.append("{");
		for(int i = 0; i < size(); i++) {
			str.append( (i < size() -1) ? this.set[i] + ", " : this.set[i]);
		}
		str.append("}");
		return str.toString();
		
	}


	//expands the generic array
	private void resize() {
		//SortedSet newSet = new SortedSet();
		//newSet.set = (E[])(new Comparable[this.set.length * 2]); <-- can do this but have to cast (E()) when setting this.set. Ex: this.set = (E()) newSet.set;
		E[] newSet = (E[])(new Comparable[this.set.length * 2]);
		System.arraycopy(this.set, 0, newSet, 0, this.set.length);
		this.set =  newSet;
	}

	//binary search. returns -1 if not found in set.
	private int binarySearch(E[] set, E value, int low, int high) {
		if (low < high) {
		    int mid = (low / 2) + (high / 2);
		    int result = set[mid].compareTo(value); // might have to override
		    if (result > 0) return binarySearch(set, value, low, mid); //left part of array,
		    if (result < 0) return binarySearch(set, value, mid + 1, high); // right part of array
		    return mid;
		} // if
		return -1; // not exist
	}
}