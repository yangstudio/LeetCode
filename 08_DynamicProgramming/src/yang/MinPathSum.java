package yang;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    //空间优化
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j],dp[j-1]) + grid[i][j];
            }
        }
        return dp[n-1];
    }

    public int minPathSum1(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
