package Graph.BFS;

import java.util.*;

public class ShortestDistanceGrid {

    record Position(int row, int col) {}

    public static void main(String[] args) {

        // Test Case 1: Simple path
        int[][] grid1 = {
                {1,1,1},
                {0,1,0},
                {1,1,1}
        };
        System.out.println("Test1 Expected: 4 -> " +
                shortestDistance(3,3,grid1,2,2));


        // Test Case 2: No possible path
        int[][] grid2 = {
                {1,0,1},
                {0,0,1},
                {1,1,1}
        };
        System.out.println("Test2 Expected: -1 -> " +
                shortestDistance(3,3,grid2,2,2));


        // Test Case 3: Start equals destination
        int[][] grid3 = {
                {1}
        };
        System.out.println("Test3 Expected: 0 -> " +
                shortestDistance(1,1,grid3,0,0));


        // Test Case 4: Start cell blocked
        int[][] grid4 = {
                {0,1},
                {1,1}
        };
        System.out.println("Test4 Expected: -1 -> " +
                shortestDistance(2,2,grid4,1,1));


        // Test Case 5: Larger grid
        int[][] grid5 = {
                {1,1,0,1},
                {1,1,1,1},
                {0,1,0,1},
                {1,1,1,1}
        };
        System.out.println("Test5 Expected: 6 -> " +
                shortestDistance(4,4,grid5,3,3));


        // Test Case 6: Destination unreachable
        int[][] grid6 = {
                {1,1,1},
                {1,0,0},
                {1,0,1}
        };
        System.out.println("Test6 Expected: -1 -> " +
                shortestDistance(3,3,grid6,2,2));
    }

    private static int shortestDistance(int N, int M, int[][] A, int X, int Y) {

        if (A[0][0] == 0) return -1;
        if (X == 0 && Y == 0) return 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0, 0));
        A[0][0] = 0; //Mark as visited

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position p = queue.remove();
                for (int[] dir : dirs) {
                    int row = p.row + dir[0];
                    int col = p.col + dir[1];
                    if (row >= 0 && col >= 0 && row < N && col < M
                            && A[row][col] == 1) {

                        if (row == X && col == Y)
                            return steps + 1;

                        queue.add(new Position(row, col));
                        A[row][col] = 0; // Mark as visited
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
