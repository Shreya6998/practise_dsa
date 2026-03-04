package DP;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));  // 3
        System.out.println(coinChange(new int[]{2}, 3));       // -1
        System.out.println(coinChange(new int[]{2,5,10}, 6));  // 3
        System.out.println(coinChange(new int[]{1}, 0));       // 0
    }

    private static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1; i<=amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];
    }
}