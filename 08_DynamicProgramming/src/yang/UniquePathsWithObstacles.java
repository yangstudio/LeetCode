package yang;

import java.util.Arrays;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];


/*        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        //第一行每个元素只有一种路径，如果其中有障碍的话，就不能行走
        if (obstacleGrid[0][0] == 0) {
            for (int j = 0; j < n; j ++) {
                if (obstacleGrid[0][j] == 0) {
                    dp[j] = 1;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            //第一列每个元素只有一种路径，如果其中有障碍的话，就不能行走
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[j] = dp[j] + dp[j-1];
                } else {
                    dp[j] = 0;
                }
            }
        }
      return dp[n-1];*/
    }
}
