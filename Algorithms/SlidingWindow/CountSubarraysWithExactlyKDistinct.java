package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithExactlyKDistinct {

    public static void main(String[] args) {

        System.out.println("Test 1: " +
                countSubarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));   // expected 7

        System.out.println("Test 2: " +
                countSubarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));   // expected 3

        System.out.println("Test 3: " +
                countSubarraysWithKDistinct(new int[]{1,1,1,1}, 1));     // expected 10

        System.out.println("Test 4: " +
                countSubarraysWithKDistinct(new int[]{1,2,3}, 4));       // expected 0
    }

    private static int countSubarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums,k) - countAtMost(nums,k-1);
    }

    private static int countAtMost(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0;
        Map<Integer, Integer> distinct = new HashMap<>();
        for(int i=0,j=0; j<nums.length; j++) {
            distinct.compute(nums[j],(key, val) -> (val == null) ? 1 : val+1);
            while(distinct.size() > k) {
                int val = distinct.getOrDefault(nums[i],0) - 1;
                if(val == 0)
                    distinct.remove(nums[i]);
                else
                    distinct.put(nums[i],val);
                i++;
            }
            count += j - i + 1; //valid subarrays is equal to length of the window
        }
        return count;
    }
}
