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

public class main {

	
	public static void main(String[] args) {
		
		SortedSet a = new SortedSet("pillow, are, so, comfy");
		SortedSet b = new SortedSet("i, scream, for, iceCream, hello");
		SortedSet c = new SortedSet(1,2,3,4,5);
		SortedSet d = new SortedSet(1, 3, 5, 6, 10, 50, 33);

		SortedSetUtils temp = new SortedSetUtils();
		SortedSet t = new SortedSet();
		t = temp.intersection(c, d);
		System.out.println("Intersection of c and d: " + t.toString());
		t = temp.union(c, d);
		System.out.println("Union of c and d: " + t.toString());
		c.addAll(90,-24,55);
		System.out.println("Size of c: " + c.size());
		
		
		d.add(2);
		d.add(4);
		d.add(-24);
		d.add(90);
		
		c.remove(2000);
		c.remove(55);
		d.remove(50);
		d.remove(33);
		d.remove(6);
		d.remove(10);
		d.remove(-1996);
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println("true or false for SortedSet c between d: " + c.equals(d));
		System.out.println("true or false for SortedSet a between d " + a.equals(b));

	}

}
