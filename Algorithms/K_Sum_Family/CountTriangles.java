package K_Sum_Family;

import java.util.Arrays;

public class CountTriangles {

    public static void main(String[] args) {
        int[][] testCases = {
                {4, 6, 3, 7},                       //Expected: 3
                {10, 21, 22, 100, 101, 200, 300},   //Expected: 6
                {2, 2, 3, 4},                       //Expected: 3
                {1, 1, 1, 1},                       //Expected: 4
                {5, 10, 12, 13, 15}                 //Expected: 9
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = countTriangles(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(testCases[i]));
            System.out.println("Number of triangles possible: " + result);
            System.out.println();
        }
    }

    private static int countTriangles(int[] arr) {
        int len = arr.length;
        if(len < 3) return 0;
        int count = 0;
        Arrays.sort(arr);
        for(int i = len -1; i>=2; i--) {
            int high = i-1;
            int low = 0;
            while(low < high) {
                if((arr[low]+arr[high]) > arr[i]) {
                    count += high-low;
                    high--;
                } else {
                    low++;
                }
            }
        }
        return count;
    }
}
