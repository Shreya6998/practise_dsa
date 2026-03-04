package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumOfIslands {

    static class Position {
        int r, c;
        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid)); // Expected output: 3
    }

    private static int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        //Traverse the grid
        for(int i=0;i<grid.length; i++) {
            for(int j=0;j<grid[0].length; j++) {
                //Check if current cell is unvisited & is '1'
                if(grid[i][j] == '1') {
                    count++;
                    // Start BFS
                    bfs(grid,new Position(i,j));
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, Position pos) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(pos);
        grid[pos.r][pos.c] = '0'; // Mark as visited
        while(!queue.isEmpty()) {
            Position curr = queue.remove();
            int r = curr.r, c = curr.c;
            int[][] cords = {
                    {r-1,c},
                    {r+1,c},
                    {r,c-1},
                    {r,c+1}
            };
            for(int i=0; i<4; i++) {
                int row = cords[i][0];
                int col = cords[i][1];
                if(row >= 0 && row < grid.length
                        && col >= 0 && col < grid[0].length
                        && grid[row][col] == '1') {
                    grid[row][col] = '0';
                    queue.add(new Position(row,col));
                }
            }
        }
    }

}

