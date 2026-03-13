package Array;

import java.util.*;

public class MoreThanNByK {

    private static int countOccurrence(int[] arr, int k) {
        int nk = arr.length/k;
        Map<Integer, Integer> freq = new HashMap<>();
        //Count occurrences
        for (int j : arr) {
            freq.put(j, freq.getOrDefault(j, 0) + 1);
        }

        int count = 0;
        //Count values
        for(Integer v:freq.values()) {
            if(v>nk) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] testArrays = {
                {3, 1, 2, 2, 1, 2, 3, 3},
                {1, 2, 3, 4},
                {1, 1, 1, 2, 2, 3, 3, 3},
                {4, 5, 6, 7, 8},
                {2, 2, 2, 2}
        };

        int[] kValues = {4, 3, 4, 2, 3};

        int[] expectedOutputs = {2, 0, 2, 0, 1};

        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Array: " + Arrays.toString(testArrays[i]));
            System.out.println("k = " + kValues[i]);
            System.out.println("Expected Output: " + expectedOutputs[i]);

            int result = countOccurrence(testArrays[i], kValues[i]);
            System.out.println("Your Output: " + result);
            System.out.println("----------------------------------");
        }
    }
}
