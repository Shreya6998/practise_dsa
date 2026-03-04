package Array;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 5, 6, 0, 1, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{0, 0, 0, 0, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{1, 0, 0, 0, 3};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{0, 1, 0, 2, 0, 6};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{0, 0, 0, 0, 0};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{1, 3, 5, 6, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{0, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{1, 0};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

        arr = new int[]{0, 0, 1, 0};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroEnd(arr);
        System.out.println("After: " + Arrays.toString(arr));

    }

    private static void moveZeroEnd(int[] arr) {
        if(arr.length==0 || arr.length==1) {
            return;
        }
        int left = 0;
        int right = 1;
        int swap = 0;
        while(left < right && right < arr.length) {
            //swap zero & non-zero
            if(arr[left]==0 && arr[right]!=0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right++;
                swap++;
            }
            //move left to next zero
            else {
                if (arr[left] != 0) {
                    left++;
                }
                //move right to next non-zero
                if (arr[right] == 0) {
                    right++;
                }
            }
        }
        System.out.println("Swaps: "+swap);
    }

    private static void moveZeroEnd1(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int left = 0;
        int right = 0;
        int swap = 0;

        while (right < arr.length) {

            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                swap++;
            }
            right++;
        }
        System.out.println("Swaps: "+swap);
    }
}
