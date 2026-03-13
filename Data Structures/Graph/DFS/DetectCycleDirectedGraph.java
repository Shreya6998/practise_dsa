package Graph.DFS;

import java.util.*;

public class DetectCycleDirectedGraph {

    public static void main(String[] args) {

        runTest(4, new int[][]{
                {0,1},
                {1,2},
                {2,3}
        }, false); // No cycle


        runTest(3, new int[][]{
                {0,1},
                {1,2},
                {2,0}
        }, true); // Cycle


        runTest(5, new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {3,1}
        }, true); // Cycle


        runTest(4, new int[][]{
                {0,1},
                {2,3}
        }, false); // Disconnected graph


        runTest(1, new int[][]{}, false); // Single node


        runTest(2, new int[][]{
                {0,1},
                {1,0}
        }, true); // Simple 2-node cycle
    }

    private static void runTest(int V, int[][] edges, boolean expected) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        System.out.println(
                "Expected: " + expected +
                        " | Result: " + detectCycle(V, adj)
        );
    }

    private static boolean detectCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];
        for(int i=0;i<V;i++) {
            if (!visited[i]) {
                if(dfs(i, adj, visited, inStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node,
                               List<List<Integer>> adj,
                               boolean[] visited,
                               boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;
        for(int neighbour:adj.get(node)) {
            if(inStack[neighbour])
                return true;
            if(!visited[neighbour]) {
                if(dfs(neighbour, adj, visited, inStack))
                    return true;
            }
        }
        inStack[node] = false;
        return false;
    }
}
