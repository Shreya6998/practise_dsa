package Hashing;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctElementsEveryRow {

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1,2,1,4,8},
                {3,7,8,5,1},
                {8,7,7,3,1},
                {8,1,2,7,9}
        };

        int[][] matrix2 = {
                {1,2,3},
                {2,3,4},
                {2,3,5}
        };

        System.out.println(countCommon(matrix1)); // 2
        System.out.println(countCommon(matrix2)); // 2
    }

    private static int countCommon(int[][] matrix) {
        Map<Integer,Integer> freq = new HashMap<>();
        int distinct = 0;
        for (int[] row : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int num : row) {
                if(set.add(num)) {
                    freq.put(num, freq.getOrDefault(num, 0) + 1);
                }
            }
        }
        for (int count : freq.values()) {
            if (count == matrix.length)
                distinct++;
        }
        return distinct;
    }
}
