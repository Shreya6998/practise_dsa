package Array;

import java.util.* ;

public class SineWave {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2},
                {3, 4}
        };

        int[] result = wavePrint(arr, 2, 2);

        System.out.println("Sine Wave Traversal:");
        System.out.println(Arrays.toString(result));
    }

    private static int[] wavePrint(int[][] arr, int nRows, int mCols) {
        int[] output = new int[nRows * mCols];
        boolean isReverse = false;
        for(int i = 0; i<mCols; i++) {
            for(int j = 0; j<nRows; j++) {
                int index = (i * nRows) + j;
                if(isReverse) {
                    output[index] = arr[nRows - 1 - j][i];
                } else {
                    output[index] = arr[j][i];
                }
            }
            isReverse = !isReverse;
        }
        return output;
    }
}