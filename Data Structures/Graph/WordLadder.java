package Graph;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

        // ✅ Test Case 1 (classic)
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 =
                Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println("Result 1: " +
                ladderLength(beginWord1, endWord1, wordList1));


        // ❌ Test Case 2 (endWord missing)
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 =
                Arrays.asList("hot","dot","dog","lot","log");

        System.out.println("Result 2: " +
                ladderLength(beginWord2, endWord2, wordList2));


        // ✅ Test Case 3 (direct transformation)
        String beginWord3 = "a";
        String endWord3 = "c";
        List<String> wordList3 =
                Arrays.asList("a","b","c");

        System.out.println("Result 3: " +
                ladderLength(beginWord3, endWord3, wordList3));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int level = 1;

        //BFS
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0; k<size;k++) {
                String word = queue.remove();
                StringBuilder sb = new StringBuilder(word);
                for(int i = 0; i<word.length();i++) {
                    char original = sb.charAt(i);
                    for(int j=0; j<26 ; j++) {
                        char ch = (char) ('a' + j);
                        sb.setCharAt(i, ch);
                        String transformed = sb.toString();
                        if(!transformed.equals(word) && wordSet.contains(transformed)) {
                            if (Objects.equals(transformed, endWord)) {
                                return level+1;
                            }
                            queue.add(transformed);
                            wordSet.remove(transformed);
                        }
                    }
                    sb.setCharAt(i,original);
                }
            }
            level++;
        }
        return 0;
    }

    private static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if(!wordSet.contains(endWord)) return 0;

        //Build graph
        Map<String,Set<String>> adjMap = new HashMap<>();
        for(String word:wordSet) {
            for(int i = 0; i<word.length();i++) {
                StringBuilder sb = new StringBuilder(word);
                for(int j=0; j<26 ; j++) {
                    char ch = (char) ('a' + j);
                    sb.setCharAt(i, ch); // Modifies the StringBuilder
                    String transformed = sb.toString();      // Convert back to String
                    if(wordSet.contains(transformed) && !transformed.equals(word)) {
                        //create an edge
                        Set<String> neighbours = adjMap.computeIfAbsent(word,x -> new HashSet<>());
                        neighbours.add(transformed);
                    }
                }
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        wordSet.remove(beginWord);
        int level = 1;

        //BFS
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size;i++) {
                String curr = queue.remove();
                for (String neighbour : adjMap.getOrDefault(curr, Collections.emptySet())) {
                    if (Objects.equals(neighbour, endWord)) {
                        return level+1;
                    }
                    if (wordSet.contains(neighbour)) {
                        queue.add(neighbour);
                        wordSet.remove(neighbour);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

