package DP;

import java.util.Arrays;

public class CoinChangeII {

    public static void main(String[] args) {

        // Basic cases
        System.out.println(change(5, new int[]{1,2,5}));   // 4
        System.out.println(change(3, new int[]{2}));       // 0
        System.out.println(change(10, new int[]{10}));     // 1

        // Edge cases
        System.out.println(change(0, new int[]{1,2,5}));   // 1
        System.out.println(change(5, new int[]{}));        // 0
        System.out.println(change(1, new int[]{1}));       // 1

        // Slightly larger case
        System.out.println(change(7, new int[]{1,2,3}));   // 8
    }

    private static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins) {
            for(int i = coin; i<=amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}