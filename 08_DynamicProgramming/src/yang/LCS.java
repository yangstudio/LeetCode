package yang;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 ||
            text2 == null || text2.length() == 0  ) return 0;
        int[] dp = new int[text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            int cur = 0;
            for (int j = 1; j <= text2.length(); j++) {
                int leftTop = cur;
                cur = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
            }
        }
      return dp[text2.length()];
    }
}
