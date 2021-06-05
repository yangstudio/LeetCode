package yang;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    //动态规划
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.length() == 1) return s;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int start = 0;

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start + maxLen);
    }


    //中心扩展法
    public String longestPalindrome1(String s) {
        int len = s.length();
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i+j;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > maxLen ) {
                        maxLen = right - left +1;
                        begin = left;
                    }
                    left--;
                    right++;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
}


