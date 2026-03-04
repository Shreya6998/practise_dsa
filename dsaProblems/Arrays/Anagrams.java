package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

    private static final int MAX_SIZE = 26;

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> anagrams = anagrams(arr);
        System.out.println(anagrams);
        System.out.println(areAnagrams("kgees","geeks"));
    }

    private static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : arr) {
            String key = getHash(s.toLowerCase());
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static String getHash(String input) {
        StringBuilder hash = new StringBuilder();
        int[] freq = new int[MAX_SIZE];
        for(char c : input.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int j : freq) {
            hash.append(j);
            hash.append("*");
        }
        return hash.toString();
    }

    public static ArrayList<ArrayList<String>> anagrams1(String[] arr) {
        // code here
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : arr) {
            char[] word = s.toLowerCase().toCharArray();
            Arrays.sort(word);
            String key = String.valueOf(word);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static boolean areAnagrams(String s1, String s2) {
        // code here
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        for(int i=0;i<s1.length();i++) {
            counter1[s1.charAt(i) - 'a']++;
            counter2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(counter1, counter2);
    }

    public static boolean areAnagrams1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] counter = new int[26];
        for (char c : s1.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            if (--counter[c - 'a'] < 0) {
                return false;   // early exit
            }
        }
        return true;
    }
}
