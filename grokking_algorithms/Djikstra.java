import java.util.*;

public class Djikstra {
    public static void main(String[] args) {
        Map<Character, Map<Character,Integer>> directedGraph1 = new HashMap<>();
        directedGraph1.put('A',Map.of('B',5,'C',2));
        directedGraph1.put('B',Map.of('D',4,'E',2));
        directedGraph1.put('C',Map.of('B',8,'E',7));
        directedGraph1.put('D',Map.of('E',6,'F',3));
        directedGraph1.put('E',Map.of('F',1));
        directedGraph1.put('F',Map.of());

        List<Character> path = calculateShortestPath(directedGraph1, 'A','F');
        System.out.println("Shortest path from A to F is " + path);

        Map<Character, Map<Character,Integer>> directedGraph2 = new HashMap<>();
        directedGraph2.put('Z',Map.of('B',10));
        directedGraph2.put('B',Map.of('D',20));
        directedGraph2.put('C',Map.of('B',1));
        directedGraph2.put('D',Map.of('C',1,'E',30));
        directedGraph2.put('E',Map.of());

        path = calculateShortestPath(directedGraph2,'Z','E');
        System.out.println("Shortest path from A to E is " + path);
    }

    private static List<Character> calculateShortestPath(Map<Character, Map<Character, Integer>> directedGraph,Character start, Character end) {
        Map<Character, Character> parents = new HashMap<>();
        Map<Character, Integer> weights = new HashMap<>();
        for (Character node : directedGraph.keySet()) {
            weights.put(node, Integer.MAX_VALUE);
        }
        weights.put(start, 0);
        Set<Character> visited = new HashSet<>();
        Character node = findSmallestNode(weights,visited);
        while(node!=null){
            int cost = weights.get(node);
            Map<Character,Integer> neighbours = directedGraph.getOrDefault(node,Map.of());
            for(Character neighbour : neighbours.keySet()){
                int newCost = cost + neighbours.get(neighbour);
                if(newCost < weights.get(neighbour)){
                    weights.put(neighbour,newCost);
                    parents.put(neighbour,node);
                }
            }
            visited.add(node);
            node = findSmallestNode(weights,visited);
        }

        List<Character> path = new ArrayList<>();
        Character key = end;
        path.add(key);
        while(parents.containsKey(key)){
            key = parents.get(key);
            path.addFirst(key);
        }
//        Collections.reverse(path);
//        return path;
//               //OR
//        return path.reversed();
        return path;
    }

    private static Character findSmallestNode(Map<Character, Integer> weights, Set<Character> visited) {
        Character smallest_node = null;
        int smallest_cost = Integer.MAX_VALUE;
        for(Character neighbour : weights.keySet()){
            int cost = weights.get(neighbour);
            if(cost < smallest_cost && !visited.contains(neighbour)){
                smallest_cost = cost;
                smallest_node = neighbour;
            }
        }
        return smallest_node;
    }

}
