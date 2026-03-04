package DP;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));        // 4
        System.out.println(rob(new int[]{2,7,9,3,1}));      // 12
        System.out.println(rob(new int[]{2,1,1,2}));        // 4
        System.out.println(rob(new int[]{5}));              // 5
    }

    private static int rob(int[] nums) {
        switch (nums.length) {
            case 0: return 0;
            case 1: return nums[0];
            case 2: return Math.max(nums[0],nums[1]);
        }
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++) {
            int result = Math.max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1 = result;
        }
        return prev1;
    }
}
