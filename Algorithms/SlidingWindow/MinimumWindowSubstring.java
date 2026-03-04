package SlidingWindow;

import java.util.*;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        System.out.println("Test 1: " +
                minWindow("ADOBECODEBANC", "ABC"));   // expected BANC

        System.out.println("Test 2: " +
                minWindow("a", "a"));                 // expected a

        System.out.println("Test 3: " +
                minWindow("a", "aa"));                // expected ""

        System.out.println("Test 4: " +
                minWindow("AAABBC", "AABC"));         // expected AABBC
    }

    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        String minStr = null;
        //count char freq in t
        Map<Character,Integer> tFreq = new HashMap<>();
        Map<Character,Integer> sFreq = new HashMap<>();
        for(char c:t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c,0)+1);
        }
        int required = tFreq.size();
        int satisfied = 0;
        for(int i=0, j=0; j<s.length(); j++) {
            //Expand right till valid window found
            char c = s.charAt(j);
            sFreq.put(c, sFreq.getOrDefault(c,0)+1);
            if(tFreq.containsKey(c) && sFreq.get(c).intValue()==tFreq.get(c).intValue())
                satisfied++;
            //Shrink & record till invalid window appears
            while(satisfied == required) {
                //Update min
                if(minStr == null || j-i+1 < minStr.length())
                    minStr = s.substring(i,j+1);

                //Shrink
                c = s.charAt(i);
                sFreq.put(c, sFreq.get(c)-1);
                if(tFreq.containsKey(c) && sFreq.get(c) < tFreq.get(c)) {
                    satisfied--;
                }
                i++;
            }
        }
        return minStr==null ? "":minStr;
    }
}