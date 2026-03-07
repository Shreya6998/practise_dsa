package SlidingWindow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxVowelsSubstring {

    public static void main(String[] args) {

        System.out.println(maxVowels("abciiidef", 3)); // 3
        System.out.println(maxVowels("aeiou", 2));     // 2
        System.out.println(maxVowels("leetcode", 3));  // 2
        System.out.println(maxVowels("rhythms", 4));   // 0
        System.out.println(maxVowels("tryhard", 4));   // 1
    }

    private static int maxVowels(String s, int k) {
        if(k > s.length()) return 0;
        Set<Character> vowels = new HashSet<>(List.of('a','e','i','o','u'));
        int sum=0;
        //Expand the initial window
        for(int i = 0; i<k; i++) {
            if(vowels.contains(s.charAt(i)))
                sum++;
        }
        int max = sum;

        //Slide the window
        for(int i=k; i<s.length(); i++) {
            if(vowels.contains(s.charAt(i-k))) //Shrink left boundary by 1
                sum--;

            if(vowels.contains(s.charAt(i))) //Expand right boundary by 1
                sum++;

            max = Math.max(max,sum);

            if(max==k) //Short circuit
                return k;
        }
        return max;
    }
}
