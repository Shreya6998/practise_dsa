package Graph.TopoSort;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {

        // Test Case 1
        int V1 = 4;
        int[][] edges1 = {
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        };
        runTest(V1, edges1);

        // Test Case 2
        int V2 = 6;
        int[][] edges2 = {
                {5,2},
                {5,0},
                {4,0},
                {4,1},
                {2,3},
                {3,1}
        };
        runTest(V2, edges2);

        // Test Case 3
        int V3 = 3;
        int[][] edges3 = {
                {0,1},
                {1,2}
        };
        runTest(V3, edges3);

        // Test Case 4
        int V4 = 5;
        int[][] edges4 = {
                {0,1},
                {0,2},
                {1,3},
                {1,4},
                {3,4}
        };
        runTest(V4, edges4);

        // Test Case 5
        int V5 = 4;
        int[][] edges5 = {
                {0,1},
                {1,2},
                {2,3}
        };
        runTest(V5, edges5);
    }

    private static void runTest(int V, int[][] edges) {

        ArrayList<Integer> result = topoSort(V, edges);

        boolean valid = validateTopo(V, edges, result);

        System.out.println("Returned Order: " + result);
        System.out.println("Is Valid Topological Sort: " + valid);
        System.out.println("----------------------------------");
    }

    private static boolean validateTopo(int V, int[][] edges, ArrayList<Integer> order) {

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

    private static ArrayList<Integer> topoSort(int V, int[][] edges) {
        int[] indegree = new int[V];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }

        //Construct adj list & indegree array
        for(int[] edge:edges) {
            indegree[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> sorted = new ArrayList<>();

        //Push zero indegree edge to queue
        for(int i=0; i<V; i++) {
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        //BFS
        while(!queue.isEmpty()) {
            int edge = queue.remove();
            sorted.add(edge);
            List<Integer> neighbours = adjList.get(edge);
            for(int neighbour:neighbours) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }

        }

        // check if cycle exists
        if(sorted.size() != V)
            return new ArrayList<>();
        return sorted;
    }
}
