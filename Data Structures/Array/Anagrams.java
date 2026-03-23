package Array;

import java.util.*;

public class Anagrams {

    private static final int MAX_SIZE = 26;

    public static void main(String[] args) {

        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        ArrayList<ArrayList<String>> anagrams = groupAnagrams(arr);
        System.out.println(anagrams);

        System.out.println(areAnagrams("kgees","geeks")); // true
        System.out.println(areAnagrams("listen","silent")); // true
        System.out.println(areAnagrams("rat","car")); // false
    }

    private static ArrayList<ArrayList<String>> groupAnagrams(String[] arr) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(String word:arr){
            String key = getHash(word);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    private static String getHash(String word) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[MAX_SIZE];
        for(char c: word.toCharArray()) {
            freq[c-'a']++;
        }
        for(int i: freq){
            sb.append('*').append(i);
        }
        return sb.toString();
    }

    private static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] freq = new int[MAX_SIZE];
        for(int i=0; i<s1.length(); i++) {
            freq[(int) s1.charAt(i) - 'a']++;
            freq[(int) s2.charAt(i) - 'a']--;
        }
        for(int i : freq) {
            if(i != 0)
                return false;
        }
        return true;
    }
}