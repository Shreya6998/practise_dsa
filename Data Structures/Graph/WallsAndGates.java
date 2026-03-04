package Graph;

import java.util.*;
public class WallsAndGates {

    static final int INF = 2147483647;
    record Position(int row, int col){}

    public static void main(String[] args) {

        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0,   -1, INF, INF}
        };

        System.out.println("Before:");
        printGrid(rooms);

        wallsAndGates(rooms);

        System.out.println("\nAfter:");
        printGrid(rooms);
    }


    public static void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        Queue<Position> queue = new ArrayDeque<>();
        // enqueue all gates
        for(int i=0; i<rooms.length;i++) {
            for(int j=0; j<rooms[0].length;j++) {
                if(rooms[i][j] == 0)
                    queue.add(new Position(i,j));
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        //BFS
        while(!queue.isEmpty()) {
            Position p = queue.remove();
            for(int[] dir:dirs) {
                int r = p.row + dir[0];
                int c = p.col + dir[1];
                if(r >= 0 && c >= 0 && r < rooms.length
                        && c < rooms[0].length && rooms[r][c] == INF) {
                    rooms[r][c] = rooms[p.row][p.col] + 1;
                    queue.add(new Position(r,c));
                }
            }
        }
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
