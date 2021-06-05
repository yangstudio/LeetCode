package yang;

import java.util.Arrays;

/**
 * @Description: 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * @Author: yangchao
 * @Date: 2021/03/25/8:32
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //考虑空间优化
    public int uniquePathsII(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
