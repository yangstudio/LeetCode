package yang;


import java.util.HashMap;

/**
 * @Description: 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 难点：状态转移方程怎么取？
 * @Author: yangchao
 * @Date: 2021/02/22/9:15
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;         //回文子串的最大长度
        int begin = 0;          //子串的起始位置

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++){
                if (s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j-i+1 > maxLen) {
                        //记录子串的长度和起始位置
                        maxLen = j-i+1;
                        begin = i;
                    }
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
