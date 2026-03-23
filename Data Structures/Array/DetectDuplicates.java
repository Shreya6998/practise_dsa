package Array;

import java.util.*;

public class DetectDuplicates {
    public static List<Integer> detectDuplicates(int[] arr) {
        List<Integer> output = new ArrayList<>();
        Arrays.sort(arr); //O(n log n)
        for (int i=1;i<arr.length;i++) {
            if(arr[i] == arr[i-1]) {
                output.add(arr[i]);
                while (i < arr.length && arr[i] == arr[i - 1])
                    i++;
            }

        }
        return output;
    }

    public static List<Integer> detectDuplicates1(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()) {
            if(entry.getValue() > 1)
                output.add(entry.getKey());
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(detectDuplicates(arr));
        int[] arr1 = {1};
        System.out.println(detectDuplicates(arr1));
    }
}
