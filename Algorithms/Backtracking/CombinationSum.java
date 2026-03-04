package Backtracking;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum obj = new CombinationSum();

        // -------- Test Case 1 : Normal case --------
        int[] arr1 = {2,3,6,7};
        int target1 = 7;
        System.out.println("Test 1:");
        System.out.println(obj.callCombinationSum(arr1, target1));
        // Expected style: [[2,2,3], [7]]

        // -------- Test Case 2 : Multiple reuse paths --------
        int[] arr2 = {2,3,5};
        int target2 = 8;
        System.out.println("\nTest 2:");
        System.out.println(obj.callCombinationSum(arr2, target2));

        // -------- Test Case 3 : No possible combination (edge) --------
        int[] arr3 = {4,5};
        int target3 = 3;
        System.out.println("\nTest 3:");
        System.out.println(obj.callCombinationSum(arr3, target3));

        // -------- Test Case 4 : Single element reuse --------
        int[] arr4 = {1};
        int target4 = 3;
        System.out.println("\nTest 4:");
        System.out.println(obj.callCombinationSum(arr4, target4));
    }

    private List<List<Integer>> callCombinationSum(int[] candidates, int target) {
        //Sort asc
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int i, int[] candidates, int target, List<Integer> combination, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if(i == candidates.length || candidates[i] > target)
            return;

        combination.add(candidates[i]);
        combinationSum(i, candidates, target-candidates[i], combination, result);
        combination.removeLast();
        combinationSum(i+1, candidates, target, combination, result);
    }
}


