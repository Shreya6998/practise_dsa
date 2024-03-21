package dsaProblems;

import java.util.*;

public class ShuffleRandom {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        randomize (arr, n);
	}

	static void randomize(int[] arr, int n) {
		Random r = new Random();
		for(int i=n-1; i>0 ; i--) {
			int shuffle = r.nextInt(i+1);
			int temp = arr[shuffle];
			arr[shuffle] = arr[i];
			arr[i] = temp;
		}
		// Prints the random array
        System.out.println(Arrays.toString(arr));
		
	}

}
