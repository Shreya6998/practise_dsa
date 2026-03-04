package DP;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

        // Basic true case
        System.out.println(canPartition(new int[]{1, 5, 11, 5})); // true

        // Basic false case
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));  // false

        // Another false case
        System.out.println(canPartition(new int[]{2, 2, 3, 5}));  // false

        // True case
        System.out.println(canPartition(new int[]{3, 3, 3, 4, 5})); // true

        // Edge case: single element
        System.out.println(canPartition(new int[]{2})); // false

        // Edge case: two equal elements
        System.out.println(canPartition(new int[]{4, 4})); // true
    }

    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) {
            sum +=num;
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num:nums) {
            for(int i=target; i>=num; i--) {
                dp[i] = dp[i] || dp[i-num];
                if(dp[target]) return true;
            }
        }
        return dp[target];
    }
}
