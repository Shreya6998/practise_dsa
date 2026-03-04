package DP;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        System.out.println(lengthOfLCS("abcde", "ace"));   // 3
        System.out.println(lengthOfLCS("abc", "abc"));     // 3
        System.out.println(lengthOfLCS("abc", "def"));     // 0
        System.out.println(lengthOfLCS("aggtab", "gxtxayb")); // 4 (gtab)
    }

    private static int lengthOfLCS(String text1, String text2) {
        int rows = text1.length() + 1;
        int cols = text2.length() + 1;
        int[][] dp = new int[rows][cols];
        //no need to fill 0s in first row and col as default is 0

        for(int i = 1; i<rows;i++) {
            for (int j = 1; j < cols; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printLCS(dp, text1, text2);
        return dp[rows-1][cols-1];
    }

    private static void printLCS(int[][] dp, String text1, String text2) {
        StringBuilder sb = new StringBuilder();
        int i = text1.length();
        int j = text2.length();
        while(i>0 && j>0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("LCS: "+sb.reverse());
    }
}
