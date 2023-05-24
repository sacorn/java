package hw02;

import java.util.ArrayList;

public class Inventory extends ArrayList<Item> {
	//constructor
	public Inventory() {}
	//displays all items
	public void displayAllItems() {
		ArrayList<Item> myList = new ArrayList<Item>();
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i).toString());
		}
	}
	//displays only books
	public void displayAllBooks() {
		ArrayList<Item> myList = new ArrayList<Item>();
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i) instanceof Book) {
				System.out.println(myList.get(i).toString());
			}
		}
	}
	//displays only CDs
	public void displayAllCDs() {
		ArrayList<Item> myList = new ArrayList<Item>();
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i) instanceof CD) {
				System.out.println(myList.get(i).toString());
			}
		}
	}
	//displays total cost
	public void totalCost() {
		ArrayList<Item> myList = new ArrayList<Item>();
		double total = 0;
		for(int i = 0; i < myList.size(); i++) {
			total += myList.get(i).getPrice();
		}
		System.out.println(total);
	}

}
