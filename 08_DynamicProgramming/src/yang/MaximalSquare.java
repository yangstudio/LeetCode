package yang;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {

    //空间优化
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int maxEdge = 0;

        for (int i = 0; i < m; i++) {
            int northwest = 0; //西北角位置
            for (int j = 0; j < n; j++) {
                int temp = dp[j+1];
                if (matrix[i][j] == '1') {
                    dp[j+1] = Math.min(Math.min(dp[j+1],dp[j]),northwest)+1;
                    maxEdge = Math.max(maxEdge,dp[j+1]);
                } else {
                    dp[j+1] = 0;
                }
                northwest = temp;
            }
        }
        return maxEdge*maxEdge;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxEdge = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                    maxEdge = Math.max(maxEdge,dp[i+1][j+1]);
                }
            }
        }
        return maxEdge*maxEdge;
    }
}
