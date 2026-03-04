package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.binarySearch;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;
        boolean result = twoSum(arr,target);
        System.out.println(result);
    }

    private static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            int complement = target - i;
            if (set.contains(complement)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    private static boolean twoSumSolve2(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = left + 1;
            } else{
                right = right - 1;
            }
        }
        return false;
    }


    public static boolean twoSumSolve1(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int complement = target - arr[i];
            int j = binarySearch(arr, i+1, arr.length-1, complement);
            if (j >= 0) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> twoSumNaive(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>(List.of(-1,-1));
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i == j)
                    continue;
                else if(arr[i]+arr[j] == target){
                    result.clear();
                    result.add(i);
                    result.add(j);
                    break;
                }

            }
            if (!result.equals(new ArrayList<>(List.of(-1, -1)))){
                break;
            }
        }
        return result;
    }
}
