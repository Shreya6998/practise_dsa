import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(10, 92, 53, 84, 58, 69, 71, 86, 96, 101, 69, 71, 86, 96, 101));
        System.out.println("Original Array" + arr);
        ArrayList<Integer> sortedArr = quickSort(arr);
        System.out.println("Sorted Array" + sortedArr);
    }

    private static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if(arr.size() < 2){
            return arr;
        }
        int pivot = arr.size()/2;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        Integer pivotVal = arr.get(pivot);
        for (int i = 0; i < arr.size(); i++) {
            if (i == pivot) continue;
            if (arr.get(i) < pivotVal) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }
        ArrayList<Integer> sortedArr = quickSort(left);
        sortedArr.add(pivotVal);
        sortedArr.addAll(quickSort(right));
        return sortedArr;
    }
}
