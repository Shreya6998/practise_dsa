package Backtracking;

import java.util.*;

public class SubsetsII {

    static int[] nums;
    static List<List<Integer>> subsets;

    public static void main(String[] args) {

        // Normal case
        int[] nums1 = {1, 2, 2, 2};
        System.out.println("Test 1: " + subsets(nums1));

        // Smaller normal case
        int[] nums2 = {2, 2};
        System.out.println("Test 2: " + subsets(nums2));

        // Edge case: single element
        int[] nums3 = {0};
        System.out.println("Test 3: " + subsets(nums3));

        // Edge case: empty array
        int[] nums4 = {};
        System.out.println("Test 4: " + subsets(nums4));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<>();
        Arrays.sort(nums);
        SubsetsII.nums = nums;
        backtrackII(0, new ArrayList<>());
        return subsets;
    }

    // Brute Force - Generate everything, filter using hashset
    private static void backtrackBrute(List<Integer> subset, int i, Set<List<Integer>> resultSet) {
        if(i==nums.length) {
            resultSet.add(new ArrayList<>(subset));
            return;
        }
        //take nums[i]
        subset.add(nums[i]);
        backtrackBrute(subset, i+1, resultSet);
        //skip
        subset.removeLast();
        backtrackBrute(subset, i+1, resultSet);
    }

    private static void backtrackI(List<Integer> subset, int i) {
        if(i==nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        //take nums[i]
        subset.add(nums[i]);
        backtrackI(subset, i+1);
        //skip
        subset.removeLast();
        while( i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        backtrackI(subset, i+1);
    }

    private static void backtrackII(int i, List<Integer> subset) {
        subsets.add(new ArrayList<>(subset));
        for(int j = i; j < nums.length ; j++) {
            if(j > i && nums[j] == nums[j-1]) continue;
            subset.add(nums[j]);
            backtrackII(j + 1, subset);
            subset.removeLast();
        }
    }

}
