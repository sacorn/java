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

public class SortedSetUtils {

	public SortedSetUtils() {
		
	}

	//returns SortedSet object with union of set A and set B
	public SortedSet union(SortedSet obj1, SortedSet obj2) {
		SortedSet newSortedSetObj = new SortedSet(obj1); // temp is a deep copy of o1
		for(int i = 0; i < obj2.size(); i++) {
			newSortedSetObj.add(obj2.get(i));
		}
		return newSortedSetObj;
	}

	//returns SortedSet that has elements found in both SortedSet objects sent to method
	public SortedSet intersection(SortedSet obj1, SortedSet obj2) {
		SortedSet temp = new SortedSet(obj1);
		SortedSet newSortedSet = new SortedSet();
		for(int i = 0; i < obj2.size(); i++) {// if any values are in both sets it goes in for
			if(temp.exists(obj2.get(i))) {
				newSortedSet.add(obj2.get(i));// values that are in both obj1 and obj2 get stored here
			}
		}
		return newSortedSet;// returns either like values or an empty set.
	}
}
