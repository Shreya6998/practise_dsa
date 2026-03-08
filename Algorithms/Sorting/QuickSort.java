package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr1 = {10, 7, 8, 9, 1, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {3};
        int[] arr5 = {};

        quickSort(arr1, 0, arr1.length - 1);
        quickSort(arr2, 0, arr2.length - 1);
        quickSort(arr3, 0, arr3.length - 1);
        quickSort(arr4, 0, arr4.length - 1);
        quickSort(arr5, 0, arr5.length - 1);

        System.out.println(Arrays.toString(arr1)); // [1,5,7,8,9,10]
        System.out.println(Arrays.toString(arr2)); // [1,2,3,4,5]
        System.out.println(Arrays.toString(arr3)); // [1,2,3,4,5]
        System.out.println(Arrays.toString(arr4)); // [3]
        System.out.println(Arrays.toString(arr5)); // []
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int pivot = arr[low + (high - low) / 2];
        int i = low,j = high;
        while(i <= j) {
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;
            if(i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(arr,low,j);
        quickSort(arr,i,high);
    }
}
