package Graph;

import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;

public class ZeroOneMatrix {

    record Position(int row, int col){}

    public static void main(String[] args) {

        int[][] mat1 = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        int[][] mat2 = {
                {1,1,1},
                {0,1,0},
                {1,1,1}
        };

        print(updateMatrix(mat1));
        print(updateMatrix(mat2));
    }

    private static int[][] updateMatrix(int[][] mat) {
        Queue<Position> queue = new ArrayDeque<>();
        for(int i = 0; i<mat.length; i++) {
            for(int j = 0; j<mat[0].length; j++) {
                //Enqueue if 0
                if(mat[i][j] == 0)
                    queue.add(new Position(i,j));
                //Mark 1 as unknown
                else
                    mat[i][j] = -1;
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            Position curr = queue.remove();
            // Update distances
            for (int[] dir : dirs) {
                int row = dir[0] + curr.row;
                int col = dir[1] + curr.col;
                if (row >= 0 && col >= 0 && row < mat.length
                        && col < mat[0].length && mat[row][col] == -1) {
                    // distance of neighbour = distance of current + 1
                    mat[row][col] = mat[curr.row][curr.col] + 1;
                    queue.add(new Position(row,col));
                }
            }
        }
        return mat;
    }

    // Helper to print 2D arrays nicely
    private static void print(int[][] grid) {
        for(int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}

