import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 6, 9, 18, 56, 47, 29, 38, 57, 10, 38, 49, 46, 98, 67, 28};
        Random r = new Random();
        int target = r.nextBoolean()? arr[r.nextInt(arr.length)] : r.nextInt(100,150);
        System.out.println("Target: " + target);
        Arrays.sort(arr);
        int index = binarySearch(arr,target);
        System.out.println((index == -1)? "Not found" : "Found at index " + index);
        index = binarySearch(0, arr.length-1, arr,target);
        System.out.println((index == -1)? "Not found" : "Found at index " + index);
    }

    private static int binarySearch(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;

        while(low <= high) {
            int mid = (low + high)/2;

            if(sortedArr[mid] > target) {
                high = mid - 1;
            } else if(sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearch(int low, int high, int[] sortedArr, int target) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high)/2;
        if(sortedArr[mid] == target) {
            return mid;
        } else if(sortedArr[mid] > target) {
            return binarySearch(low,mid-1, sortedArr, target);
        } else {
            return binarySearch(mid+1,high, sortedArr, target);
        }
    }
}
