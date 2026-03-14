package Dijkstra;

import java.util.*;

public class LengthOfShortestPath {

    record Pair(Character node, Integer distance){}

    public static void main(String[] args) {

        Map<Character, Map<Character,Integer>> graph1 = new HashMap<>();

        graph1.put('A', Map.of('B',5,'C',2));
        graph1.put('B', Map.of('D',4,'E',2));
        graph1.put('C', Map.of('B',8,'E',7));
        graph1.put('D', Map.of('E',6,'F',3));
        graph1.put('E', Map.of('F',1));
        graph1.put('F', Map.of());

        runTest(graph1, 'A', 'F', 8);


        Map<Character, Map<Character,Integer>> graph2 = new HashMap<>();

        graph2.put('Z', Map.of('B',10));
        graph2.put('B', Map.of('D',20));
        graph2.put('C', Map.of('B',1));
        graph2.put('D', Map.of('C',1,'E',30));
        graph2.put('E', Map.of());

        runTest(graph2, 'Z', 'E', 60);



        Map<Character, Map<Character,Integer>> graph3 = new HashMap<>();

        graph3.put('A', Map.of('B',1,'C',4));
        graph3.put('B', Map.of('C',2,'D',5));
        graph3.put('C', Map.of('D',1));
        graph3.put('D', Map.of());

        runTest(graph3, 'A', 'D', 4);



        Map<Character, Map<Character,Integer>> graph4 = new HashMap<>();

        graph4.put('A', Map.of('B',3));
        graph4.put('B', Map.of());
        graph4.put('C', Map.of());

        runTest(graph4, 'A', 'C', Integer.MAX_VALUE); // unreachable
    }



    private static void runTest(Map<Character, Map<Character,Integer>> graph,
                                Character src,
                                Character dest,
                                int expected) {

        int result = shortestDistance(graph, src, dest);

        System.out.println(
                "Shortest distance from " + src + " to " + dest +
                        " = " + result +
                        " | Expected: " + expected
        );
    }



    private static int shortestDistance(Map<Character, Map<Character,Integer>> graph, Character src, Character dest) {
        Map<Character,Integer> distances = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        for(Character key:graph.keySet()) {
            distances.put(key,Integer.MAX_VALUE);
        }
        distances.put(src,0);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(curr.distance > distances.get(curr.node)) continue;
            if(curr.node == dest) break;
            Map<Character,Integer> neighbors = graph.get(curr.node);
            for(Map.Entry<Character,Integer> neighbor:neighbors.entrySet()) {
                int newDist = curr.distance + neighbor.getValue();
                if(newDist < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(),newDist);
                    pq.add(new Pair(neighbor.getKey(),newDist));
                }
            }
        }

        return distances.get(dest);
    }
}