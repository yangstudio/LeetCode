package yang;

import java.awt.image.BandedSampleModel;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
         boolean [][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                //为什么不用担心数组越界的问题：当要计算dp[i+1][j-1]时，j-i >= 2，i+1没有越界
                if (s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    //中心扩展法
    public int countSubstrings1(String s) {
        int nums = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {          //遍历回文中心点
            for(int j = 0; j <= 1; j++) {      //j=0,中心是一个点，j=1,中心是两个点
                int left = i;
                int right = i+j;
                while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    nums++;
                    left--;
                    right++;
                }
            }
        }
        return nums;
    }

    //中心扩展法
    public int countSubstrings2(String s) {
        int ans = 0;
        for (int center = 0; center < (s.length() << 1) - 1; center++) {
            int left = center >> 1;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
