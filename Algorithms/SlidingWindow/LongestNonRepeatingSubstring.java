package SlidingWindow;

import java.util.*;

public class LongestNonRepeatingSubstring {

    public static void main(String[] args) {

        String input1 = "abcabc";
        String input2 = "aaaaaa";
        String input3 = "abcdabcef";

        System.out.println("Input: " + input1 +
                " | Output Length: " + longestUniqueSubstringLength(input1));

        System.out.println("Input: " + input2 +
                " | Output Length: " + longestUniqueSubstringLength(input2));

        System.out.println("Input: " + input3 +
                " | Output Length: " + longestUniqueSubstringLength(input3));
    }

    public static int longestUniqueSubstringLength(String s) {
        int max = 0;
        int[] freq = new int[26];
        for(int i = 0, j = 0; i<s.length(); i++) {
            //Increase right boundary till repetition found
            while(j < s.length() && freq[s.charAt(j)-'a'] < 1) {
                freq[s.charAt(j)-'a']++;
                j++;
            }
            max = Math.max(j-i, max);
            //Reset freq & length for new window
            freq[s.charAt(i) - 'a']--;
        }
        return max;
    }

    public static int longestUniqueSubstringLengthI(String s) {
        int max = 0;
        for(int i = 0; i<s.length(); i++) {
            int[] freq = new int[26];
            int length = 0;
            for(int j = i; j<s.length(); j++) {
                int pos = s.charAt(j) - 'a';
                if(freq[pos] >= 1)
                    break;

                freq[pos]++;
                length++;
            }
            max = Math.max(length, max);
        }
        return max;
    }
}
