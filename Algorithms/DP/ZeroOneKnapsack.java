package DP;

import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) {

        int[] weights = {1, 3, 4, 5};
        int[] values  = {1, 4, 5, 7};
        int capacity = 7;

        System.out.println(knapsackOptimised(weights, values, capacity)); // 9

        System.out.println(knapsackOptimised(
                new int[]{2,3,4},
                new int[]{4,5,6},
                5)); // 9

        System.out.println(knapsackOptimised(
                new int[]{5,4,6,3},
                new int[]{10,40,30,50},
                10)); // 90
    }

    private static int knapsack(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length+1][capacity+1];
        // No need to fill 0s in first row and col as default is 0.
        for(int i = 1; i<=weights.length; i++) {
            for(int j = 1; j<=capacity; j++) {
                if(weights[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],values[i-1] + dp[i-1][j-weights[i-1]]);
            }
        }
        return dp[weights.length][capacity];
    }

    private static int knapsackOptimised(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity+1];
        // No need to fill 0s in first row and col as default is 0.
        for(int i = 0; i<weights.length; i++) {
            for(int j = capacity; j>=weights[i]; j--) {
                dp[j] = Math.max(dp[j],values[i]+dp[j-weights[i]]);
            }
        }
        return dp[capacity];
    }
}
