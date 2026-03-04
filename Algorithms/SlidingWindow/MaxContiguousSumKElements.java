package SlidingWindow;

import java.util.*;
public class MaxContiguousSumKElements {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 5};
        int k = 3;

        int result = maxSumSubarray(nums, k); // Expected 11
        System.out.println("Maximum sum of subarray of size " + k + " = " + result);
    }

    public static int maxSumSubarray(int[] arr, int k) {
        if(k>arr.length) return Integer.MIN_VALUE;

        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int maxSum = sum;
        for(int i=0; i < arr.length-k; i++) {
            sum = sum - arr[i]; //Shrink 1 from Left
            sum = sum + arr[i+k]; //Expand 1 to right
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }

    public static int maxSumSubarrayI(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<= arr.length-k; i++) {
            int sum = 0;
            for(int j=i; j<i+k; j++) {
                sum = sum + arr[j];
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}