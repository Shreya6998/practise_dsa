package SlidingWindow;

import java.util.*;

public class LongestSubstringAtMostKDistinct {

    public static void main(String[] args) {

        System.out.println("Test 1: " +
                longestAtMostKDistinct("ecebba",3));       // expected 5 ("ecebb")

        System.out.println("Test 2: " +
                longestAtMostKDistinct("ccaabbb",2));    // expected 5 ("aabbb")

        System.out.println("Test 3: " +
                longestAtMostKDistinct("aaaa",2));       // expected 4

        System.out.println("Test 4: " +
                longestAtMostKDistinct("",2));           // expected 0
    }

    private static int longestAtMostKDistinct(String s, int k) {
        if(s.length() <= k) return s.length();
        int distinct = 0, max = 0;
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0,j=0; j < s.length(); j++) {
            //Expand right boundary by 1
            if (freq.containsKey(s.charAt(j))) {
                freq.put(s.charAt(j), freq.get(s.charAt(j)) + 1);
            } else {
                freq.put(s.charAt(j), 1);
                distinct++;
            }
            //Shrink left boundary till valid
            while(distinct > k) {
                int count = freq.get(s.charAt(i)) - 1;
                if (count == 0) {
                    freq.remove(s.charAt(i));
                    distinct--;
                } else {
                    freq.put(s.charAt(i), count);
                }
                i++;
            }

//          if(distinct==k) //Add This condition for getting longest with EXACT k distinct
              max = Math.max(max,j-i+1); // Record max length
        }
        return max;
    }
}
