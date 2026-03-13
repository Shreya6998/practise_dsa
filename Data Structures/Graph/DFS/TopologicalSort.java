package Graph.DFS;

import java.util.*;
public class TopologicalSort {

    public static void main(String[] args) {

        runTest(4, new int[][]{
                {0,1},
                {1,2},
                {2,3}
        }, "Linear chain");
        // Expected: [0,1,2,3]

        runTest(4, new int[][]{
                {0,2},
                {1,2},
                {2,3}
        }, "Multiple valid orders");
        // Possible: [0,1,2,3] or [1,0,2,3]

        runTest(6, new int[][]{
                {0,1},
                {2,3},
                {4,5}
        }, "Disconnected graph");
        // Possible: [4,5,2,3,0,1] or any order respecting dependencies

        runTest(4, new int[][]{
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        }, "Diamond dependency");
        // Possible: [0,1,2,3] or [0,2,1,3]

        runTest(7, new int[][]{
                {0,1},
                {0,2},
                {1,3},
                {2,3},
                {3,4},
                {4,5},
                {4,6}
        }, "Larger DAG");
        // Expected: [0,2,1,3,4,6,5]

        runTest(5, new int[][]{
                {1,3},
                {2,3},
                {3,4}
        }, "Multiple sources");
        // Possible: [0,1,2,3,4] or [2,1,3,4,0]

        runTest(4, new int[][]{}, "No edges");
        // Any order valid: [0,1,2,3]

        runTest(6, new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {3,4},
                {4,5}
        }, "Deep dependency chain");
        // Expected: [0,1,2,3,4,5]
    }

    private static void runTest(int V, int[][] edges, String label) {
        List<Integer> result = topoSort(V, edges);
        boolean valid = validateTopo(V, edges, result);
        System.out.println("Test: " + label);
        System.out.println("Topological Order: " + result);
        System.out.println("Is Valid Topological Sort: " + valid);
        System.out.println();
    }

    private static boolean validateTopo(int V, int[][] edges, List<Integer> order) {

        if(order.size() != V) return false;

        int[] position = new int[V];

        for(int i = 0; i < V; i++) {
            position[order.get(i)] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(position[u] > position[v]) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++)
            adjList.add(new ArrayList<>());

        for(int[] edge:edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<V; i++) {
            if(!visited[i])
                dfs(i,stack,visited,adjList);
        }
        List<Integer> sorted = new ArrayList<>();
        while(!stack.isEmpty()) {
            sorted.add(stack.pop());
        }
        return sorted;
    }

    private static void dfs(int node, Deque<Integer> stack, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        for(int neighbour:adjList.get(node)) {
            if(!visited[neighbour])
                dfs(neighbour,stack,visited,adjList);
        }
        stack.push(node);
    }
}
