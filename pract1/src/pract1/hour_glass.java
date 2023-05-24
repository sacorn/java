package pract1;

	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import java.util.ArrayList;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;

	class Result {

	    /*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

    public static int hourglassSum(List<List<Integer>> arr) {
        int rows = arr.size()-2;
        int colums = 0;
        int sum = 0;
        for(int i = 0; i < arr.get(0).size(); i++) {
            colums++;
        }
        colums = colums - 2;
        
        if(arr.size() < rows || arr.get(0).size() < colums) {
            return -1;
        }
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < colums; j++) {
                sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                + arr.get(i+1).get(j+1)
                + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}

public class hour_glass {
    public static void main(String[] args){
        List<Integer> a1 = new ArrayList<>();
        a1.add(-9);
        a1.add(-9);
        a1.add(-9);
        a1.add(1);
        a1.add(1);
        a1.add(1);
        
        List<Integer> a2 = new ArrayList<>();
        a2.add(0);
        a2.add(-9);
        a2.add(0);
        a2.add(4);
        a2.add(3);
        a2.add(2);
        
        List<Integer> a3 = new ArrayList<>();
        a3.add(-9);
        a3.add(-9);
        a3.add(-9);
        a3.add(1);
        a3.add(2);
        a3.add(3);
        
        List<Integer> a4 = new ArrayList<>();
        a4.add(0);
        a4.add(0);
        a4.add(8);
        a4.add(6);
        a4.add(6);
        a4.add(0);
        
        List<Integer> a5 = new ArrayList<>();
        a5.add(0);
        a5.add(0);
        a5.add(0);
        a5.add(-2);
        a5.add(0);
        a5.add(0);
        
        List<Integer> a6 = new ArrayList<>();
        a6.add(0);
        a6.add(0);
        a6.add(1);
        a6.add(2);
        a6.add(4);
        a6.add(0);
        
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);
        arr.add(a5);
        arr.add(a6);

        int result = Result.hourglassSum(arr);
        System.out.print(result);
  
    }
}


int count = 0;
int size = numbers.size();
for(int i = 0; i < size; i++) {
    for(int j = i; j < size; j++) {
        if((numbers.get(i) - numbers.get(j)) == k || (numbers.get(j) - numbers.get(i)) == k) {
            count++;
        }
    }
}
return count;
