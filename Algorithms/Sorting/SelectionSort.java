package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr1 = {64, 25, 12, 22, 11};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {3};
        int[] arr5 = {};

        selectionSort(arr1);
        selectionSort(arr2);
        selectionSort(arr3);
        selectionSort(arr4);
        selectionSort(arr5);

        System.out.println(Arrays.toString(arr1)); // [11, 12, 22, 25, 64]
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(arr3)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(arr4)); // [3]
        System.out.println(Arrays.toString(arr5)); // []
    }

    private static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for(int j=i+1;j<arr.length; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            //swap elements
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
