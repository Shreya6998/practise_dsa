package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    record Position(int row, int col){}

    public static void main(String[] args) {

        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(orangesRotting(grid1)); // Expected: 4

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        System.out.println(orangesRotting(grid2)); // Expected: -1

        int[][] grid3 = {
                {0,2}
        };
        System.out.println(orangesRotting(grid3)); // Expected: 0

        int[][] grid4 = {
                {1}
        };
        System.out.println(orangesRotting(grid4)); // Expected: -1
    }

    private static int orangesRotting(int[][] grid) {
        int fresh = 0, mins = 0;
        Queue<Position> queue = new ArrayDeque<>();

        // Count & queue oranges
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2)
                    queue.add(new Position(i,j));
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS
        while(!queue.isEmpty()) {
            int size = queue.size(); // wave size
            boolean isRotten = false;
            for(int i=0; i<size; i++) {
                Position p = queue.remove();
                // Check neighbours
                for(int[] dir:dirs) {
                    int row = p.row + dir[0];
                    int col = p.col + dir[1];
                    // convert fresh to rotten
                    // Enqueue rotten
                    if(row >= 0 && col >= 0 && row < grid.length
                            && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        queue.add(new Position(row,col));
                        isRotten = true;
                    }
                }
            }
            mins = isRotten? mins+1: mins;
        }
        return fresh > 0 ? -1 : mins;
    }
}

