package Graph;

import java.util.*;

public class EventualSafeState {

    public static void main(String[] args) {

        int[][] graph1 = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(eventualSafeNodes(graph1));
        // Expected: [2,4,5,6]

        int[][] graph2 = {
                {1,2,3,4},
                {1,2},
                {3,4},
                {0,4},
                {}
        };
        System.out.println(eventualSafeNodes(graph2));
        // Expected: [4]
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        // number of nodes
        int numNodes = graph.length;

        // build rev adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numNodes; i++) adjList.add(new ArrayList<>());

        // build outdegree
        int[] outdegree = new int[numNodes];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> safeNode = new ArrayList<>();

        // fill outdegree & rev adj list
        // 0 -> [1,2,3]
        for(int i = 0; i< numNodes; i++) {
            outdegree[i] = graph[i].length;
            if(outdegree[i] == 0) {
                queue.add(i);
                safeNode.add(i);
            }
            for(int j : graph[i]) {
                adjList.get(j).add(i);
            }
        }

        //bfs
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            for(int i: adjList.get(curr)) {
                outdegree[i]--;
                if(outdegree[i] == 0) {
                    queue.add(i);
                    safeNode.add(i);
                }
            }
        }

        Collections.sort(safeNode);
        return safeNode;
    }
}

