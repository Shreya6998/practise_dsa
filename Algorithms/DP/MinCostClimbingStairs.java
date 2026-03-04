package DP;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCost(new int[]{10,15,20}));          // 15
        System.out.println(minCost(new int[]{1,100,1,1,1,100,1,1,100,1})); // 6
        System.out.println(minCost(new int[]{0,0,0,0}));           // 0
        System.out.println(minCost(new int[]{5,10}));              // 5
    }

    private static int minCost(int[] cost) {
        if(cost.length == 0) return 0;
        int prev1 = 0, prev2 = 0;
        for(int i=2;i<=cost.length;i++) {
            int result = Math.min(prev1+cost[i-1], prev2+cost[i-2]);
            prev2 = prev1;
            prev1 = result;
        }
        return prev1;
    }
}