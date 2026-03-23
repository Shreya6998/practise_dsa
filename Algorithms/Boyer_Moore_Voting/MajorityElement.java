package Boyer_Moore_Voting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

        test(new int[]{2,2,1,1,1,2,2}, 2);
        test(new int[]{3,3,4,2,4,4,2,4,4}, 4);
        test(new int[]{1}, 1);
        test(new int[]{5,5,5,2,2}, 5);
        test(new int[]{7,7,7,7,3,3,3}, 7);
        test(new int[]{1,1,7,7,3,3,3}, -1);

    }

    private static void test(int[] nums, int expected) {

        int result = majorityElement(nums);

        System.out.println("Input:    " + Arrays.toString(nums));
        System.out.println("Output:   " + result);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    //Time: O(n)
    //Space: O(1)
    //Boyer-Moore voting algorithm
    private static int majorityElement1(int[] nums) {
        int candidate=nums[0], vote=0;
        for (int num : nums) {
            if (vote == 0)
                candidate = num;

            if (num == candidate)
                vote++;
            else
                vote--;
        }
        vote = 0;
        for(int num:nums) {
            if(num==candidate)
                vote++;
        }
        return vote > nums.length/2 ? candidate:-1;
    }

    //Time: O(n)
    //Space: O(n)
    //Hashing approach
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> e:freq.entrySet()) {
            if(e.getValue() > nums.length/2)
                return e.getKey();
        }
        return -1;
    }
}
