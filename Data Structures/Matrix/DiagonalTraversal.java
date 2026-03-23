package Matrix;

import java.util.Arrays;

public class DiagonalTraversal {

    public static void main(String[] args) {

        test(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }, new int[]{1,2,4,7,5,3,6,8,9});


        test(new int[][]{
                {1,2},
                {3,4}
        }, new int[]{1,2,3,4});


        test(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        }, new int[]{1,2,5,9,6,3,4,7,10,13,14,11,8,12,15,16});


        test(new int[][]{
                {1,2,3,4}
        }, new int[]{1,2,3,4});


        test(new int[][]{
                {1},
                {2},
                {3},
                {4}
        }, new int[]{1,2,3,4});
    }


    private static void test(int[][] mat, int[] expected) {

        int[] result = matrixDiagonally(mat);

        System.out.println("Input:");
        printMatrix(mat);

        System.out.println("Output:   " + Arrays.toString(result));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println();
    }


    private static void printMatrix(int[][] mat) {
        for(int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }


    private static int[] matrixDiagonally(int[][] mat) {
        //Assuming at least 1 row and col exists
        int rows = mat.length;
        int cols = mat[0].length;
        int row = 0, col =0;
        int[] traversal = new int[rows * cols];
        int index = 0;
        while(index < (rows * cols)) {
            traversal[index++] = mat[row][col];

            if((row+col)%2 == 0) {
                //move top right if not boundary
                if (row > 0 && col + 1 < cols) {
                    row--;
                    col++;
                } else if (row == 0 && col + 1 < cols) {
                    col++; //move right
                } else if (col+1 == cols) {
                    row++; //move down
                }

            } else {
                //move bottom left if not boundary
                if(row + 1 < rows && col > 0) {
                    row++;
                    col--;
                } else if(col == 0 && row + 1 < rows) {
                    row++; //move bottom
                } else if(row + 1 == rows) {
                    col++; //move right
                }
            }
        }
        return traversal;
    }
}
