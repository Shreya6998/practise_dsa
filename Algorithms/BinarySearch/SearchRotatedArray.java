package BinarySearch;

import java.util.*;

public class SearchRotatedArray {

    public static void main(String[] args) {

        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(search(new int[]{1}, 0)); // -1
        System.out.println(search(new int[]{5,1,3}, 5)); // 0
        System.out.println(search(new int[]{5,1,3}, 3)); // 2
    }

    private static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            // left half sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    //find target on the left side
                    high = mid - 1;
                } else {
                    //find target on the right side
                    low = mid + 1;
                }
            } else { // right half sorted
                if (nums[mid] < target && target <= nums[high]) {
                    //find target on the left side
                    low = mid + 1;
                } else {
                    //find target on the right side
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
