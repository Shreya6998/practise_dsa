package Backtracking;

import java.util.*;

public class SubsetsI {

    static int[] nums;
    static List<List<Integer>> subsets;

    public static void main(String[] args) {

        // Normal case
        int[] nums1 = {1, 2, 3};
        System.out.println("Test 1: " + subsets(nums1));

        // Smaller normal case
        int[] nums2 = {1, 2};
        System.out.println("Test 2: " + subsets(nums2));

        // Edge case: single element
        int[] nums3 = {0};
        System.out.println("Test 3: " + subsets(nums3));

        // Edge case: empty array
        int[] nums4 = {};
        System.out.println("Test 4: " + subsets(nums4));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        SubsetsI.subsets = new ArrayList<>();
        SubsetsI.nums = nums;
//        formSubsets(new ArrayList<>(),0);
        formSubsetsI(0,new ArrayList<>());
        return subsets;
    }

    private static void formSubsets(List<Integer> subset, int index) {
        if(index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        formSubsets(subset,index+1);
        subset.removeLast();
        formSubsets(subset,index+1);
    }

    private static void formSubsetsI(int i, List<Integer> subset) {
        subsets.add(new ArrayList<>(subset));
        for(int j = i; j < nums.length ; j++) {
            subset.add(nums[j]);
            formSubsetsI(j + 1, subset);
            subset.removeLast();
        }
    }
}

