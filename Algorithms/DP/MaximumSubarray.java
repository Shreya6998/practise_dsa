package DP;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})));
        // Expected: [4, -1, 2, 1]

        System.out.println(Arrays.toString(maxSubArray(new int[]{1})));
        // Expected: [1]

        System.out.println(Arrays.toString(maxSubArray(new int[]{5,4,-1,7,8})));
        // Expected: [5, 4, -1, 7, 8]

        System.out.println(Arrays.toString(maxSubArray(new int[]{-1,-2,-3,-4})));
        // Expected: [-1]

        System.out.println(Arrays.toString(maxSubArray(new int[]{-2,1})));
        // Expected: [1]
    }

    private static int[] maxSubArray(int[] nums) {
        if(nums.length==0) return new int[0];
        int maxSum = nums[0], sum = nums[0];
        int tempStart = 0, start = 0, end = 0;
        for(int i = 1; i<nums.length; i++) {
            if (nums[i] > sum + nums[i]){
                tempStart = i;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if(sum > maxSum) {
                start = tempStart;
                end = i;
                maxSum = sum;
            }
        }
        return Arrays.copyOfRange(nums, start, end+1);
    }
}
