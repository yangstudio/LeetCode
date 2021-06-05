package yang;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquares {

    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n +1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j*j >= 0; j++){
                dp[i] = Math.min(dp[i-j*j] + 1,dp[i]);
            }
        }
        return dp[n];
    }
}
