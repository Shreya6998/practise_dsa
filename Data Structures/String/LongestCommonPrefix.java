package String;

import java.util.Arrays;

public class LongestCommonPrefix {

    // O(m*n) where m is length of shortest string, n is array length
    private static String findLongestCommonPrefixOptimal(String[] strs) {
        // find min length string
        int minLength = Integer.MAX_VALUE;
        for(String s: strs){ // O(n)
            if(s.length() < minLength) {
                minLength = s.length();
            }
        }
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < minLength; i++) { // O(m)
            boolean isMatch = true;
            char c = strs[0].charAt(i); // extract char from first string
            //Iterate & compare with remaining strings
            for(int j = 1; j < strs.length; j++) { // O(m * n)
                if(c != strs[j].charAt(i)) {
                    isMatch = false;
                    break;
                }
            }
            if (!isMatch)
                break;
            prefix.append(c);
        }
        return prefix.toString();
    }

    // O(m * n log n) where m is length of shortest string, n is array length
    private static String findLongestCommonPrefix(String[] strs) {
        // O(n log n * m)
        Arrays.sort(strs);
        int m;
        int n = strs.length;
        m = Math.min(strs[0].length(), strs[n - 1].length());
        StringBuilder prefix = new StringBuilder();

        // O(m)
        for(int i = 0; i < m; i++) {
            if(strs[0].charAt(i) != strs[n -1].charAt(i))
                break;
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }

    public static void main(String[] args){
        String[] strs = {"interview", "internet", "internal", "interval"};
        String prefix = findLongestCommonPrefix(strs);
        System.out.println(prefix);

        strs = new String[] {"dog", "danger", "car"};
        prefix = findLongestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
