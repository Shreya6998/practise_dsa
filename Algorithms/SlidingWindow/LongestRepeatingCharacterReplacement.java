package SlidingWindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        System.out.println("Test 1: " +
                longestRepeatingCharacterReplacement("ABAB", 2));      // expected 4

        System.out.println("Test 2: " +
                longestRepeatingCharacterReplacement("AABABBBA", 1));   // expected 4

        System.out.println("Test 3: " +
                longestRepeatingCharacterReplacement("AAAA", 2));      // expected 4

        System.out.println("Test 4: " +
                longestRepeatingCharacterReplacement("ABCDE", 1));     // expected 2
    }

    //Shrink window while (window length - most frequent count) > k
    private static int longestRepeatingCharacterReplacement(String s, int k) {
        int max = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for(int i=0,j=0; j<s.length(); j++) {

            //Expand right by 1
            int pos = s.charAt(j) - 'A';
            freq[pos]++;
            maxFreq = Math.max(maxFreq, freq[pos]);

            //Shrink left till valid
            while(i<s.length() && j-i+1-maxFreq>k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            //Record max
            max = Math.max(max,j-i+1);
        }
        return max;
    }

    //Expand window while (window length - most frequent count) <= k
    private static int longestRepeatingCharacterReplacementI(String s, int k) {
        int max = 0;
        int[] freq = new int[26];
        char mostFreq = s.charAt(0);
        for(int i=0,j=0; i<s.length(); i++) {
            //Expand right aggressively till last valid point
            while(j<s.length() && (j-i-freq[mostFreq - 'A'] < k || mostFreq == s.charAt(j))) {
                int pos = s.charAt(j) - 'A';
                freq[pos]++;
                if(freq[pos] > freq[mostFreq -'A']) {
                    mostFreq = s.charAt(j);
                }
                j++;
            }
            //Record max length
            max = Math.max(max,j-i);
            //Shrink left by 1
            freq[s.charAt(i) - 'A']--;
        }
        return max;
    }
}
