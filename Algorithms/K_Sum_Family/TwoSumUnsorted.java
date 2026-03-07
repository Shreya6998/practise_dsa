package K_Sum_Family;

import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsorted {

    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 3, 11, 15};
        int target = 6;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + ", " + result[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            int complement = target - nums[i];
            if(lookup.containsKey(complement)) {
                return new int[]{lookup.get(complement),i};
            } else {
                lookup.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}

