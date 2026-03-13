package Graph.TopoSort;

import java.util.*;

public class DirectedGraphCycleDetection {

    public static void main(String[] args) {

        // Test Case 1: DAG (No cycle)
        int V1 = 4;
        int[][] edges1 = {
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        };
        runTest(V1, edges1, false);

        // Test Case 2: Graph with cycle
        int V2 = 4;
        int[][] edges2 = {
                {0,1},
                {1,2},
                {2,3},
                {3,1}
        };
        runTest(V2, edges2, true);

        // Test Case 3: Simple cycle
        int V3 = 3;
        int[][] edges3 = {
                {0,1},
                {1,2},
                {2,0}
        };
        runTest(V3, edges3, true);

        // Test Case 4: Larger DAG
        int V4 = 6;
        int[][] edges4 = {
                {5,2},
                {5,0},
                {4,0},
                {4,1},
                {2,3},
                {3,1}
        };
        runTest(V4, edges4, false);

        // Test Case 5: Self cycle
        int V5 = 3;
        int[][] edges5 = {
                {0,1},
                {1,2},
                {2,2}
        };
        runTest(V5, edges5, true);
    }

    private static void runTest(int V, int[][] edges, boolean expected) {

        boolean result = isCyclic(V, edges);

        System.out.println("Edges: " + Arrays.deepToString(edges));
        System.out.println("Cycle Detected: " + result);
        System.out.println("Expected: " + expected);
        System.out.println("----------------------------------");
    }

    private static boolean isCyclic(int V, int[][] edges) {
        int[] indegree = new int[V];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i< V; i++)
            adjList.add(new ArrayList<>());

        for(int[] edge:edges) {
            adjList.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> nodes = new ArrayList<>();

        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            nodes.add(node);
            for(int neighbour: adjList.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        return nodes.size() != V;
    }
}
