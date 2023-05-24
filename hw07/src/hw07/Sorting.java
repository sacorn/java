/**
 * Name: Salvador Cornejo
Email: sal.cornejo96@gmail.com
Assignment: insertionSort, bubbleSort, selectionSort, mergeSort, quickSort, countingSort, and radixSort.
Assignment Number: 04
Description: In this assignment we write sorting algorithms and we test them with text files filled with random numbers.

 */
package hw07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {
	private Sorting() {}
	//sorts list using insertion sort algorithm
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
		int j = 0;
		int listSize = list.size();
		for(int i = 1; i < listSize; i++) {
			E temp = list.get(i);
			j = i;
			while((j > 0) && (list.get(j-1).compareTo(temp) > 0)) {
				list.set(j, list.get(j-1));
				j--;
			}//while
			list.set(j, temp);
		}
		
	}
	//sorts list using bubble sort algorithm
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		int listSize = list.size();
		E a;
		for(int i = 1; i < (listSize-1); i++) {
			boolean swapped = false;
			for(int j = 0; j < (listSize-1); j++) {
				if((list.get(j)).compareTo(list.get(j+1)) > 0) {
					Collections.swap(list, j, (j+1));
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	// sorts given list using selection sort algorithm
	public static<E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		int listSize = list.size();
		int min = 0;
		for(int i = 0; i < (listSize-1); i++) {
			min = i;
			for(int j = (i+1); j < listSize; j++) {
				if(list.get(min).compareTo(list.get(j)) > 0) {
					min = j;
				}
			}
			Collections.swap(list, i, min);
		}
	}
	//sorts given list using merge sort algorithm
	public static<E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		if(list.size() > 1) {
			int mid = (list.size()-1) / 2;
			
			ArrayList<E> leftList = new ArrayList<E>();
			for(int i = 0; i <= mid; i++) {
				leftList.add(list.get(i));
			}
			//calls itself to break left side of list even further(shorter) till it gets to one element
			mergeSort(leftList);
			
			ArrayList<E> rightList = new ArrayList<E>();
			for(int i = (mid+1); i < list.size(); i++) {
				rightList.add(list.get(i));
			}
			//calls itself to break right side of list even further(shorter) till it gets to one element
			mergeSort(rightList);
			//starts to but its self back together by comparing rightList values with leftList values
			merge(leftList, rightList, list);
		}
	}
	
	//brings list back together by comparing leftList and rightList and places smallest element back to the list. Piecing leftList and rightList back together to get full list
	public static<E extends Comparable<E>> void merge(ArrayList<E> leftList, ArrayList<E> rightList, ArrayList<E> list) {
		int i = 0, j = 0,  k = 0;
		//comparing leftList and rightList values
		while((i < leftList.size()) && (j < rightList.size())) {
			if(rightList.get(j).compareTo(leftList.get(i)) > 0) {
				list.set(k, leftList.get(i));
				i++;
			}
			else {
				list.set(k, rightList.get(j));
				j++;
			}
			k++;
		}
		//fills in the rest of the list with the remaining elements of leftList
		while(i < leftList.size()) {
			list.set(k, leftList.get(i));
			i++;
			k++;
		}
		//fills in the rest of the list with the remaining elements of rightList
		while(j < rightList.size()) {
			list.set(k, rightList.get(j));
			j++;
			k++;
		}
		
	}
	
	//calls quick_sort by sending it list, low vaue and high value
	public static<E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quick_sort(list,0, (list.size()-1));
	}
	
	//calls its self after updating pivot index and swapping as we call partition
	public static <E extends Comparable<E>> void quick_sort(ArrayList<E> list, int low, int high) {
		if(low < high) {
			int p = partition(list, low, high);
			quick_sort(list, low, (p-1));
			quick_sort(list, (p+1), high);
		}
	}
	
	//makes swaps in list by comparing two values and returns pivot index
	public static <E extends Comparable<E>> int partition(ArrayList<E> list, int low, int high) {
		E pivot = list.get(high);
		int i = (low-1);
		
		for(int j = low; j < high; j++) {
			if(pivot.compareTo(list.get(j)) > 0) { //if pivot is greater than list.get(j) then it goes in
				i++;
				Collections.swap(list, i, j);
			}
		}
		Collections.swap(list, (i+1), high);
		return (i+1);
	}
	
	//sorts list of numbers using counting sort algorithm
	public static void countingSort(ArrayList<Integer> list) {
		int max = Collections.max(list);//findMax(list);
		ArrayList<Integer> temp = counting_sort(list, (max+1)); // saves sorted list
		list.clear();// clears unsorted list
		list.addAll(temp); // fills up our list with sorted values
	}
	
	//returns sorted list
	public static ArrayList<Integer> counting_sort(ArrayList<Integer> list, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>(Collections.nCopies(list.size(), 0));// assigns each index a value of zero
		ArrayList<Integer> counts = new ArrayList<Integer>(Collections.nCopies(k, 0));// assigns each index a value of zero
		int listSize = list.size();
		
		for(int i = 0; i < listSize; i++) {
			
			counts.set(list.get(i), (counts.get(list.get(i)) +1));// get current count at index and add by one
		}
		//counts 
		for(int i = 1; i < k; i++) {
			counts.set(i, (counts.get(i) + counts.get(i-1)));
		}
		
		for(int i = (listSize-1); 0 <= i ; i--) {
			
			result.set((counts.get(list.get(i)) -1), list.get(i));
			counts.set(list.get(i), (counts.get(list.get(i)) -1));
		}
		return result;
	}
	
	//sorts list using radixSort
	public static void radixSort(ArrayList<Integer> list) {
		
		int baseTen = 10;
		int digitPlace = 1;
		int listSize = list.size();
		int key = 0;
		ArrayList<ArrayList<Integer> > buckets = new ArrayList<ArrayList<Integer> >(Collections.nCopies (baseTen, null));
		
		for(int i = 0; i < baseTen; i++) {
			for(int j = 0; j < listSize; j++) {
				key = getDigitPlace(list.get(j), digitPlace);
				if(buckets.get(key) == null) {
					buckets.add(key, new ArrayList<Integer>());
				}
				buckets.get(key).add(list.get(j));
			}
			
			int k = 0;

			for(int j = 0; j < baseTen; j++) {
				for(int x = 0; x < buckets.get(j).size(); x++) {
					list.set(k++, buckets.get(j).get(x)); // replacing list with updated elements as we go up in digit place
				}
			}
			
			for(int j = 0; j < baseTen; j++) {
				buckets.get(j).clear();
			}
			digitPlace = (digitPlace * 10);
		}
		
	}
	
	public static int getDigitPlace(int num, int digitPlace) {
		return ((num / digitPlace) % 10);
	}

}
