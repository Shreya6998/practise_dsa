package Dijkstra;

import java.util.*;

public class MinHeapDijkstra {

    public static void main(String[] args) {

        System.out.println("Test 1");

        int V1 = 4;
        int[][] edges1 = {
                {0,1,4},
                {0,2,1},
                {2,1,2},
                {1,3,1},
                {2,3,5}
        };

        int src1 = 0;

        System.out.println(Arrays.toString(dijkstra(V1, edges1, src1)));
        // Expected: [0,3,1,4]


        System.out.println("\nTest 2");

        int V2 = 5;
        int[][] edges2 = {
                {0,1,10},
                {0,4,5},
                {1,2,1},
                {4,1,3},
                {4,2,9},
                {4,3,2},
                {3,2,4}
        };

        int src2 = 0;

        System.out.println(Arrays.toString(dijkstra(V2, edges2, src2)));
        // Expected: [0,8,9,7,5]


        System.out.println("\nTest 3 (Disconnected)");

        int V3 = 4;
        int[][] edges3 = {
                {0,1,2},
                {1,2,3}
        };

        int src3 = 0;

        System.out.println(Arrays.toString(dijkstra(V3, edges3, src3)));
        // Expected: [0,2,5,INF]
    }

    private static int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        int[] distance = new int[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
            //Add both sides for undirected graphs
            adj.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }

        distance[src] = 0;
        pq.add(new int[]{src,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];
            if(dist > distance[node]) continue;
            List<int[]> neighbors = adj.get(node);
            for(int[] neighbor: neighbors) {
                int newDist = dist + neighbor[1];
                if(newDist < distance[neighbor[0]]) {
                    distance[neighbor[0]] = newDist;
                    pq.add(new int[]{neighbor[0], newDist});
                }
            }
        }

        return distance;
    }
}
