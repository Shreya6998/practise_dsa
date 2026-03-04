package DP;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1)); // 1
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(4)); // 5
        System.out.println(climbStairs(6)); // 13
    }

    private static int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2; i <= n; i++) {
            int result = prev1 + prev2;
            prev2 = prev1;
            prev1 = result;
        }
        return prev1;
    }
}
