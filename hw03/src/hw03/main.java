/**
 * Name: Salvador Cornejo
 * Email: scorne18@calstatela.edu
 * Class: CS2013
 * Assignment: 03
 * Purpose: This program works with generics.
 */
package hw03;

import java.util.ArrayList;


// It's 11:53 and i know what i want to do but java isnt having it with the syntax im giving it and im freaking out how to correctly write them in 7 minutes :(
public class main {

	public static void main(String[] args) {
		
		MyArray<Integer> a = new MyArray<Integer>(8);
		MyArray<String> b = new MyArray<String>("baked", "potatoe", "and", "cookies");
		MyArray<Integer> c = new MyArray<Integer>(8, 55, 1, 22, -2);
		MyArray<Integer> d = new MyArray<Integer>(-2, 55, 1, 22, -8);
		
		
		
		System.out.println("MyArray a: " + a.toString());
		System.out.println("MyArray b:" + b.toString());
		System.out.println("MyArray c: " + c.toString());

		
		System.out.println("Grabbing cookies from MyArray: " + b.get(3));
		b.rightShift(3);
		System.out.println("MyArray with string has shifted right 3 positions: " + b.toString());
		b.leftShift(1);
		System.out.println("MyArray with string has shifted back 1 position from previous line: " + b.toString());
		c.sort();
		System.out.println("MyArray c sorted: " + c.toString());
		c.reverse();
		System.out.println("MyArray c reversed: " + c.toString());
		System.out.println("MyArray d and c (equals): " + c.equals(d));
		c.sort();
		d.sort();
		System.out.println("MyArray d and c (equals): " + c.equals(d));
		
	}
}
