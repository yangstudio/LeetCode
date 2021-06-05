package yang;

/**
 * @Description: 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @Author: yangchao
 * @Date: 2021/04/14/15:56
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m; i++) {
            char ch1 = text1.charAt(i);
            for (int j = 1; j < n; j++) {
                char ch2 = text2.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
