import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>( List.of(3, 1, 6, 9, 18, 56, 47, 29, 38, 57, 10, 38, 49, 46, 98, 67, 28 ));
        System.out.println("Original Array: " + arr);
        boolean isAscending = new Random().nextBoolean();
        System.out.println("Is Ascending: " + isAscending);
        ArrayList<Integer> sortedArr = selectionSort(arr, isAscending);
        System.out.println("Sorted Array: " + sortedArr);
    }

    private static ArrayList<Integer> selectionSort(ArrayList<Integer> arr, boolean ascending) {
        ArrayList<Integer> sortedArr = new ArrayList<>();
        while (!arr.isEmpty()) {
            int index = findOrderedIndex(arr, ascending);
            sortedArr.add(arr.get(index));
            arr.remove(index);
        }
        return  sortedArr;
    }

    private static int findOrderedIndex(ArrayList<Integer> arr, boolean ascending) {
        int orderedIndex = 0;
        int num = arr.get(orderedIndex);
        for(int i = 1; i < arr.size(); i++) {
            if(ascending && arr.get(i) < num || !ascending && arr.get(i) > num) {
                num = arr.get(i);
                orderedIndex = i;
            }
        }
        return orderedIndex;
    }

}
