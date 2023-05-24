/**
 * Name: Salvador Cornejo
Email: sal.cornejo96@gmail.com
Assignment: insertionSort, bubbleSort, selectionSort, mergeSort, quickSort, countingSort, and radixSort.
Assignment Number: 04
Description: In this assignment we write sorting algorithms and we test them with text files filled with random numbers.

 */

package hw07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;



public class main {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		ArrayList<Integer> arr4 = new ArrayList<Integer>();
		ArrayList<Integer> arr5 = new ArrayList<Integer>();
		ArrayList<Integer> arr6 = new ArrayList<Integer>();
		
		ArrayList<Integer> arr7 = new ArrayList<Integer>();
		ArrayList<Integer> arr8 = new ArrayList<Integer>();
		ArrayList<Integer> arr9 = new ArrayList<Integer>();
		ArrayList<Integer> arr10 = new ArrayList<Integer>();
		ArrayList<Integer> arr11 = new ArrayList<Integer>();
		ArrayList<Integer> arr12 = new ArrayList<Integer>();
		ArrayList<Integer> arr13 = new ArrayList<Integer>();
		
		ArrayList<Integer> arr14 = new ArrayList<Integer>();
		ArrayList<Integer> arr15 = new ArrayList<Integer>();
		ArrayList<Integer> arr16 = new ArrayList<Integer>();
		ArrayList<Integer> arr17 = new ArrayList<Integer>();
		ArrayList<Integer> arr18 = new ArrayList<Integer>();
		ArrayList<Integer> arr19 = new ArrayList<Integer>();
		ArrayList<Integer> arr20 = new ArrayList<Integer>();
		
		ArrayList<Integer> arr21 = new ArrayList<Integer>();
		ArrayList<Integer> arr22 = new ArrayList<Integer>();
		ArrayList<Integer> arr23 = new ArrayList<Integer>();
		ArrayList<Integer> arr24 = new ArrayList<Integer>();
		ArrayList<Integer> arr25 = new ArrayList<Integer>();
		ArrayList<Integer> arr26 = new ArrayList<Integer>();
		ArrayList<Integer> arr27 = new ArrayList<Integer>();
		
		ArrayList<Integer> arr28 = new ArrayList<Integer>();
		ArrayList<Integer> arr29 = new ArrayList<Integer>();
		ArrayList<Integer> arr30 = new ArrayList<Integer>();
		ArrayList<Integer> arr31 = new ArrayList<Integer>();
		ArrayList<Integer> arr32 = new ArrayList<Integer>();
		ArrayList<Integer> arr33 = new ArrayList<Integer>();
		ArrayList<Integer> arr34 = new ArrayList<Integer>();
		
		
		
		int num = 0;
		Scanner scanner = new Scanner(new File("/Users/salvadorcornejo1/Downloads/50000.txt"));
	    while (scanner.hasNextInt()) { //for one of the 5 tests
	    	num = scanner.nextInt();
	        arr.add(num);
	        arr1.add(num);
	        arr2.add(num);
	        arr3.add(num);
	        arr4.add(num);
	        arr5.add(num);
	        arr6.add(num);
	    }
	    
	    Scanner scanner2 = new Scanner(new File("/Users/salvadorcornejo1/Downloads/100000.txt"));
	    while (scanner2.hasNextInt()) { //for one of the 5 tests
	    	num = scanner2.nextInt();
	        arr7.add(num);
	        arr8.add(num);
	        arr9.add(num);
	        arr10.add(num);
	        arr11.add(num);
	        arr12.add(num);
	        arr13.add(num);
	    }
	    
	    Scanner scanner3 = new Scanner(new File("/Users/salvadorcornejo1/Downloads/150000.txt"));
	    while (scanner3.hasNextInt()) { //for one of the 5 tests
	    	num = scanner3.nextInt();
	        arr14.add(num);
	        arr15.add(num);
	        arr16.add(num);
	        arr17.add(num);
	        arr18.add(num);
	        arr19.add(num);
	        arr20.add(num);
	    }
	    
	    Scanner scanner4 = new Scanner(new File("/Users/salvadorcornejo1/Downloads/200000.txt"));
	    while (scanner4.hasNextInt()) { //for one of the 5 tests
	    	num = scanner4.nextInt();
	        arr21.add(num);
	        arr22.add(num);
	        arr23.add(num);
	        arr24.add(num);
	        arr25.add(num);
	        arr26.add(num);
	        arr27.add(num);
	    }
	    
	    Scanner scanner5 = new Scanner(new File("/Users/salvadorcornejo1/Downloads/250000.txt"));
	    while (scanner5.hasNextInt()) { //for one of the 5 tests
	    	num = scanner5.nextInt();
	        arr28.add(num);
	        arr29.add(num);
	        arr30.add(num);
	        arr31.add(num);
	        arr32.add(num);
	        arr33.add(num);
	        arr34.add(num);
	    }
	    
	    
		
	    
	    System.out.println("Below is for 50000");
	    Instant start = Instant.now();
	    Sorting.insertionSort(arr);
	    Instant end = Instant.now();
	    System.out.println("Insertion sort: " + Duration.between(start, end));
	    
	    Instant start1 = Instant.now();
	    Sorting.bubbleSort(arr1);
	    Instant end1 = Instant.now();
	    System.out.println("Bubble sort: " + Duration.between(start1, end1));
	    
	    Instant start2 = Instant.now();
	    Sorting.selectionSort(arr2);
	    Instant end2 = Instant.now();
	    System.out.println("Selection sort: " + Duration.between(start2, end2));
		
	    Instant start3 = Instant.now();
	    Sorting.mergeSort(arr3);
	    Instant end3 = Instant.now();
	    System.out.println("Merge sort: " + Duration.between(start3, end3));
	    
	    Instant start4 = Instant.now();
	    Sorting.quickSort(arr4);
	    Instant end4 = Instant.now();
	    System.out.println("Quick sort: " + Duration.between(start4, end4));
	    
	    Instant start5 = Instant.now();
	    Sorting.countingSort(arr5);
	    Instant end5 = Instant.now();
	    System.out.println("counting sort: " + Duration.between(start5, end5));
	    
	    Instant start6 = Instant.now();
	    Sorting.radixSort(arr6);
	    Instant end6 = Instant.now();
	    System.out.println("radix sort: " + Duration.between(start6, end6));
		System.out.println("\n");
		
		
	    
	    System.out.println("Below is for 100000");
	    Instant start7 = Instant.now();
	    Sorting.insertionSort(arr7);
	    Instant end7 = Instant.now();
	    System.out.println("Insertion sort: " + Duration.between(start7, end7));
	    
	    Instant start8 = Instant.now();
	    Sorting.bubbleSort(arr8);
	    Instant end8 = Instant.now();
	    System.out.println("Bubble sort: " + Duration.between(start8, end8));
	    
	    Instant start9 = Instant.now();
	    Sorting.selectionSort(arr9);
	    Instant end9 = Instant.now();
	    System.out.println("Selection sort: " + Duration.between(start9, end9));
		
	    Instant start10 = Instant.now();
	    Sorting.mergeSort(arr10);
	    Instant end10 = Instant.now();
	    System.out.println("Merge sort: " + Duration.between(start10, end10));
	    
	    Instant start11 = Instant.now();
	    Sorting.quickSort(arr11);
	    Instant end11 = Instant.now();
	    System.out.println("Quick sort: " + Duration.between(start11, end11));
	    
	    Instant start12 = Instant.now();
	    Sorting.countingSort(arr12);
	    Instant end12 = Instant.now();
	    System.out.println("counting sort: " + Duration.between(start12, end12));
	    
	    Instant start13 = Instant.now();
	    Sorting.radixSort(arr13);
	    Instant end13 = Instant.now();
	    System.out.println("radix sort: " + Duration.between(start13, end13));
	    System.out.println("\n");
		
	    
	    
	    
	    System.out.println("Below is for 150000");
	    Instant start14 = Instant.now();
	    Sorting.insertionSort(arr14);
	    Instant end14 = Instant.now();
	    System.out.println("Insertion sort: " + Duration.between(start14, end14));
	    
	    Instant start15 = Instant.now();
	    Sorting.bubbleSort(arr15);
	    Instant end15 = Instant.now();
	    System.out.println("Bubble sort: " + Duration.between(start15, end15));
	    
	    Instant start16 = Instant.now();
	    Sorting.selectionSort(arr16);
	    Instant end16 = Instant.now();
	    System.out.println("Selection sort: " + Duration.between(start16, end16));
		
	    Instant start17 = Instant.now();
	    Sorting.mergeSort(arr17);
	    Instant end17 = Instant.now();
	    System.out.println("Merge sort: " + Duration.between(start17, end17));
		
	    Instant start18 = Instant.now();
	    Sorting.quickSort(arr18);
	    Instant end18 = Instant.now();
	    System.out.println("Quick sort: " + Duration.between(start18, end18));
		
	    Instant start19 = Instant.now();
	    Sorting.countingSort(arr19);
	    Instant end19 = Instant.now();
	    System.out.println("counting sort: " + Duration.between(start19, end19));
	    
	    Instant start20 = Instant.now();
	    Sorting.radixSort(arr20);
	    Instant end20 = Instant.now();
	    System.out.println("radix sort: " + Duration.between(start20, end20));
	    System.out.println("\n");
	    
	    
	    
	    System.out.println("Below is for 200000");
	    Instant start21 = Instant.now();
	    Sorting.insertionSort(arr21);
	    Instant end21 = Instant.now();
	    System.out.println("Insertion sort: " + Duration.between(start21, end21));
	    
	    Instant start22 = Instant.now();
	    Sorting.bubbleSort(arr22);
	    Instant end22 = Instant.now();
	    System.out.println("Bubble sort: " + Duration.between(start22, end22));
	    
	    Instant start23 = Instant.now();
	    Sorting.selectionSort(arr23);
	    Instant end23 = Instant.now();
	    System.out.println("Selection sort: " + Duration.between(start23, end23));
		
	    Instant start24 = Instant.now();
	    Sorting.mergeSort(arr24);
	    Instant end24 = Instant.now();
	    System.out.println("Merge sort: " + Duration.between(start24, end24));
		
	    Instant start25 = Instant.now();
	    Sorting.quickSort(arr25);
	    Instant end25 = Instant.now();
	    System.out.println("Quick sort: " + Duration.between(start25, end25));
		
	    Instant start26 = Instant.now();
	    Sorting.countingSort(arr26);
	    Instant end26 = Instant.now();
	    System.out.println("counting sort: " + Duration.between(start26, end26));
	    
	    Instant start27 = Instant.now();
	    Sorting.radixSort(arr27);
	    Instant end27 = Instant.now();
	    System.out.println("radix sort: " + Duration.between(start27, end27));
	    System.out.println("\n");
	    
	    
	    
	    System.out.println("Below is for 250000");
	    Instant start28 = Instant.now();
	    Sorting.insertionSort(arr28);
	    Instant end28 = Instant.now();
	    System.out.println("Insertion sort: " + Duration.between(start28, end28));
	    
	    Instant start29 = Instant.now();
	    Sorting.bubbleSort(arr29);
	    Instant end29 = Instant.now();
	    System.out.println("Bubble sort: " + Duration.between(start29, end29));
	    
	    Instant start30 = Instant.now();
	    Sorting.selectionSort(arr30);
	    Instant end30 = Instant.now();
	    System.out.println("Selection sort: " + Duration.between(start30, end30));
		
	    Instant start31 = Instant.now();
	    Sorting.mergeSort(arr31);
	    Instant end31 = Instant.now();
	    System.out.println("Merge sort: " + Duration.between(start31, end31));
		
	    Instant start32 = Instant.now();
	    Sorting.quickSort(arr32);
	    Instant end32 = Instant.now();
	    System.out.println("Quick sort: " + Duration.between(start32, end32));
		
	    Instant start33 = Instant.now();
	    Sorting.countingSort(arr33);
	    Instant end33 = Instant.now();
	    System.out.println("counting sort: " + Duration.between(start33, end33));
	    
	    Instant start34 = Instant.now();
	    Sorting.radixSort(arr34);
	    Instant end34 = Instant.now();
	    System.out.println("radix sort: " + Duration.between(start34, end34));
	    
		

	}

}
