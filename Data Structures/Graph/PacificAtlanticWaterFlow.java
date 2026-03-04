package Graph;

import java.util.*;

public class PacificAtlanticWaterFlow {

    record Position(int row, int col) {}

    static int[][] heights;

    static int[][] dirs = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public static void main(String[] args) {

        List<int[][]> testCases = new ArrayList<>();

        // 1️⃣ Single Cell
        testCases.add(new int[][]{
                {10}
        });

        // 2️⃣ Single Row
        testCases.add(new int[][]{
                {1, 2, 3, 4}
        });

        // 3️⃣ Single Column
        testCases.add(new int[][]{
                {1},
                {2},
                {3}
        });

        // 4️⃣ Flat Plateau
        testCases.add(new int[][]{
                {2, 2},
                {2, 2}
        });

        // 5️⃣ Increasing Toward Bottom Right
        testCases.add(new int[][]{
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        });

        // 6️⃣ Decreasing Toward Bottom Right
        testCases.add(new int[][]{
                {5, 4, 3},
                {4, 3, 2},
                {3, 2, 1}
        });

        // 7️⃣ Normal Case
        testCases.add(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        });

        // ▶ Run all test cases
        for (int t = 0; t < testCases.size(); t++) {
            System.out.println("===== Test Case " + (t + 1) + " =====");

            int[][] heights = testCases.get(t);

            printGrid(heights);

            List<List<Integer>> result = pacificAtlantic(heights);

            System.out.println("Result:");
            for (List<Integer> cell : result) {
                System.out.println(cell);
            }
            System.out.println();
        }
    }

    private static void printGrid(int[][] grid) {
        if (grid == null || grid.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0 || heights[0].length == 0) return Collections.emptyList();
        int rows = heights.length;
        int cols = heights[0].length;
        PacificAtlanticWaterFlow.heights = heights;
        Queue<Position> queue = new ArrayDeque<>();
        boolean[][] pacificReach = new boolean[rows][cols], atlanticReach = new boolean[rows][cols];
        // enqueue all pacific adjacent cells
        for(int j = 0; j< cols; j++) {
            int i = 0;
            queue.add(new Position(i,j));
            pacificReach[i][j] = true;
        }
        for(int i = 0; i< rows; i++) {
            int j = 0;
            queue.add(new Position(i,j));
            pacificReach[i][j] = true;
        }
        bfs(queue,pacificReach);

        queue.clear();
        // enqueue all atlantic adjacent cells
        for(int j = 0; j< cols; j++) {
            int i = rows-1;
            queue.add(new Position(i,j));
            atlanticReach[i][j] = true;
        }
        for(int i = 0; i< rows; i++) {
            int j = cols-1;
            queue.add(new Position(i,j));
            atlanticReach[i][j] = true;
        }
        bfs(queue,atlanticReach);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i< rows; i++) {
            for(int j = 0; j< cols; j++) {
                if(pacificReach[i][j] && atlanticReach[i][j])
                    output.add(List.of(i,j));
            }
        }

        return output;
    }

    private static void bfs(Queue<Position> queue, boolean[][] reach) {
        while(!queue.isEmpty()) {
            Position p = queue.remove();
            for(int[] dir:dirs) {
                int r = p.row + dir[0];
                int c = p.col + dir[1];
                if(r >= 0 && c >= 0 && r < heights.length
                        && c < heights[0].length && !reach[r][c]
                        && heights[r][c] >= heights[p.row][p.col]) {
                    reach[r][c] = true;
                    queue.add(new Position(r,c));
                }
            }
        }
    }
}

