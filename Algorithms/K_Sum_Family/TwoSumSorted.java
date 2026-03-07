package K_Sum_Family;

import java.util.Arrays;

public class TwoSumSorted {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));  // [0,1]
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4,6}, 6)));  // [1,3]
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));      // [0,2]
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)));      // [0,1]
    }

    private static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target)
                left++;
            else if(sum > target)
                right--;
            else
                return new int[]{left, right};
        }
        return new int[]{-1,-1};
    }
}
