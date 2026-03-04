package Graph;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {

        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words1));
        // Expected: wertf

        String[] words2 = {"z","x"};
        System.out.println(alienOrder(words2));
        // Expected: zx

        String[] words3 = {"z","x","z"};
        System.out.println(alienOrder(words3));
        // Expected: ""

        String[] words4 = {"abc","ab"};
        System.out.println(alienOrder(words4));
        // Expected: ""   (invalid dictionary case)
    }

    private static String alienOrder(String[] words) {
        //Adj Map
        Map<Character,Set<Character>> adjMap = new HashMap<>();

        //Indegree
        Map<Character,Integer> indegree = new HashMap<>();

        //Initialise all characters
        for(String word:words) {
            for(Character ch:word.toCharArray())
                indegree.putIfAbsent(ch,0);
        }

        // Build graph from adjacent words
        for(int i=0; i<words.length-1; i++) {
            int j = i+1;
            int len = Math.min(words[i].length(),words[j].length());
            boolean foundMismatch = false;
            for(int k = 0; k<len;k++) {
                if(words[i].charAt(k)!=words[j].charAt(k)) {
                    // create edge
                    Set<Character> neighbours =
                            adjMap.computeIfAbsent(words[i].charAt(k), x -> new HashSet<>());

                    // Avoid duplicate edges
                    if (neighbours.add(words[j].charAt(k))) {
                        indegree.put(words[j].charAt(k), indegree.get(words[j].charAt(k)) + 1);
                    }
                    foundMismatch = true;
                    break;
                }
            }
            // Edge case: prefix check
            if (!foundMismatch && words[i].length() > words[j].length())
                return "";
        }

        //BFS
        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(Character ch: indegree.keySet()) {
            if(indegree.get(ch) == 0) {
                queue.add(ch);
            }
        }

        while(!queue.isEmpty()) {
            Character curr = queue.remove();
            sb.append(curr);
            for(Character ch: adjMap.getOrDefault(curr,Collections.emptySet())) {
                //reduce indegree
                indegree.put(ch,indegree.get(ch)-1);
                if (indegree.get(ch) == 0) {
                    queue.add(ch);
                }
            }
        }

        //Cycle check
        //return indegree.values().stream().allMatch(n -> n == 0)? sb.toString():"";
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}

