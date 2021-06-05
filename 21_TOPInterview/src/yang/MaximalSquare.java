package yang;

/**
 * @Description: 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * @Author: yangchao
 * @Date: 2021/03/27/8:33
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = Math.max(res,dp[0][j]);
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = Math.max(res,dp[i][0]);
            }
            for (int j = 1; j < n; j++) {
                dp[i][j] = 0;
                if (matrix[i][j] == '1') {
                    int temp = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.min(temp,dp[i-1][j-1]) + 1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
