package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(lengthOfLIS(8, new int[]{10,9,2,5,3,7,101,18})); // 4
        System.out.println(lengthOfLIS(6, new int[]{0,1,0,3,2,3}));         // 4
        System.out.println(lengthOfLIS(5, new int[]{7,7,7,7,7}));           // 1
        System.out.println(lengthOfLIS(6, new int[]{4,10,4,3,8,9}));        // 3
        System.out.println(lengthOfLIS(1, new int[]{1}));                   // 1

        printLIS(new int[]{10,9,2,5,3,7,101,18});                               // [2, 3, 7, 18]
        printLIS(new int[]{0,1,0,3,2,3});                                       // [0, 1, 2, 3]
        printLIS(new int[]{7,7,7,7,7});                                         // [7]
        printLIS(new int[]{4,10,4,3,8,9});                                      // [3, 8, 9]
        printLIS(new int[]{1});                                                 // [1]
    }

    private static void printLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        List<Integer> tailsIndex = new ArrayList<>();
        int[] prev = new int[nums.length];
        Arrays.fill(prev,-1);
        for (int i=0; i<nums.length; i++) {
            if (tails.isEmpty() || (nums[i] > tails.getLast())) {
                tails.add(nums[i]);
                if(!tailsIndex.isEmpty())
                    prev[i] = tailsIndex.getLast();
                tailsIndex.add(i);
            } else {
                int index = Collections.binarySearch(tails, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                prev[i] = (index > 0) ? tailsIndex.get(index - 1) : -1;
                tails.set(index, nums[i]);
                tailsIndex.set(index, i);
            }
        }
        int lastIndex = tailsIndex.getLast();
        List<Integer> lis = new ArrayList<>();
        while(lastIndex != -1) {
            lis.add(nums[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        Collections.reverse(lis);
        System.out.println(lis);
    }

    // Greedy + Binary Search O(n log n) version
    private static int lengthOfLIS(int size, int[] nums) {
        if(size == 0) return 0;
        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            if (tails.isEmpty() || (num > tails.getLast())) {
                tails.add(num);
            } else {
                int index = Collections.binarySearch(tails, num);
                if (index < 0) {
                    index = -(index + 1);
                }
                tails.set(index, num);
            }
        }
        return tails.size();
    }

    // DP - O(n * n) version
    private static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 0; i<nums.length; i++) {
            for(int j=0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}
